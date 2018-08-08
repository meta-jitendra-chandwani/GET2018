package Command;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class VirtualCommandPrompt {

	private Directory currentDirectory;
	private Directory rootDirectory;

	VirtualCommandPrompt() {
		Directory root = new Directory("root", null, "R:\\");
		this.rootDirectory = root;
		this.currentDirectory = this.rootDirectory;
	}

	class VCPException extends Exception {

		private static final long serialVersionUID = 1L;

		VCPException() {
			super();
		}
	}

	public void start() {
		boolean run = true;
		while (run) {
			int len = 0;
			try {
				Scanner input = new Scanner(System.in);
				System.out.print(this.currentDirectory.getDirectoryPath()
						+ "> ");
				String tokens[] = input.nextLine().split(" ");
				Command command = Command.valueOf(tokens[0]);
				switch (command) {
				case root:
					this.currentDirectory = this.rootDirectory;
					break;
				case mkdir:
					if (tokens.length == 1) {
						throw new Exception();
					}
					this.makeDirectory(tokens);
					break;
				case ls:
					this.listOfDirectory();
					break;
				case cd:
					this.changeDirectory(tokens);
					break;
				case bk:
					this.backDirectory();
					break;
				case tree:
					this.directoryStructure(tokens);
					break;
				case find:
					if (tokens.length != 2) {
						throw new VCPException();
					}
					this.showAllDirectory(this.currentDirectory, tokens[1]);
					break;
				case exit:
					System.out.println("VCP is closed !");
					run = false;
					break;
				default:
					break;
				}
			} catch (IllegalArgumentException e) {
				if (len != 0) {
					System.out.println("command does not exist");
				}
			} catch (VCPException e) {
				System.out.println("The syntax of the command is incorrect.");
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public void makeDirectory(String directoryNames[]) {
		for (int i = 1; i < directoryNames.length; i++) {
			if (this.findDirectory(directoryNames[i]) != null) {
				System.out.println("A subdirectory or file "
						+ directoryNames[i] + " already exists.");
			} else {
				Directory dir = new Directory(directoryNames[i],
						this.currentDirectory,
						this.currentDirectory.getDirectoryPath()
								+ directoryNames[i] + "\\");
				this.currentDirectory.addDirectory(dir);
			}
		}
	}

	public void listOfDirectory() {
		try {
			if (this.currentDirectory.getSubDirList().size() == 0) {
				throw new VCPException();
			}
			SimpleDateFormat sdf = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss.SSS a");
			for (Directory dir : this.currentDirectory.getSubDirList()) {
				System.out.println(sdf.format(dir.getDirectoryCreationTime())
						+ "  " + dir.getDirName());
			}
			System.out.println("       "
					+ this.currentDirectory.getSubDirList().size()
					+ " Folder(s)");
		} catch (VCPException e) {
			System.out.println("No subfolders or files exist");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Directory findDirectory(String dirName) {
		for (Directory dir : this.currentDirectory.getSubDirList()) {
			if (dirName.equals(dir.getDirName())) {
				return dir;
			}
		}
		return null;
	}

	public void changeDirectory(String tokens[]) {

		try {
			if (tokens.length == 1) {
				throw new VCPException();
			}
			Directory dir = this.findDirectory(tokens[1]);
			if (tokens.length > 2 || dir == null) {
				throw new VCPException();
			}
			this.currentDirectory = dir;
		} catch (VCPException e) {
			System.out.println("The system cannot find the path specified.");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void backDirectory() {
		try {
			if (this.currentDirectory.equals(this.rootDirectory)) {
				throw new VCPException();
			}
			this.currentDirectory = this.currentDirectory.getParentDirectory();
		} catch (VCPException e) {
			System.out.print("");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void printDirStructure(Directory currentDir, String hepen,
			String slash) {
		for (Directory dir : currentDir.getSubDirList()) {
			System.out.println(slash + hepen + dir.getDirName());
			this.printDirStructure(dir, hepen, "     " + slash);
		}
	}

	public void directoryStructure(String tokens[]) {
		try {
			if (tokens.length > 2) {
				throw new VCPException();
			}
			if (tokens.length == 2) {
				Directory dir = this.findDirectory(tokens[1]);
				if (dir == null) {
					throw new VCPException();
				}
				this.printDirStructure(dir, "\u2500", "\u251C");
			} else {
				this.printDirStructure(this.currentDirectory, "\u2500",
						"\u251C");
			}
		} catch (VCPException e) {
			System.out.println("Invalid path! \n No subfolders exist.");
		}
	}

	public void showAllDirectory(Directory currentDirectory, String dirName) {
		Pattern pattern = Pattern.compile(dirName);
		for (Directory directory : currentDirectory.getSubDirList()) {
			Matcher matcher = pattern.matcher(directory.getDirName());
			if (matcher.find()) {
				System.out.println("..\\"
						+ directory.getParentDirectory().getDirName() + "\\"
						+ directory.getDirName());
			}
			showAllDirectory(directory, dirName);
		}
	}
}
