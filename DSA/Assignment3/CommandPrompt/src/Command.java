import java.util.ArrayList;
import java.util.Scanner;

public class Command {
	static ArrayList<Object> directoryList = new ArrayList<Object>();
	static ArrayList<Object> folderList = new ArrayList<Object>();
	static Directory directory = new Directory();

	static void commandExecutor(String command, String argument) {
		switch (command) {
		case "mkdir":
			makeDirectory(argument);
//			System.out.println("Mkdir is executed");
			break;
		case "cd":
			changeDirectory(argument);
//			System.out.println("cd is executed");
			break;
		case "bk":
			back();
			break;
		case "ls":
			break;
		case "find":
			break;
		case "tree":
			break;
		case "exit":
			System.exit(0);
			break;
		}
	}

	private static boolean isCommandCorrect(String commandEntered) {
		boolean commandCorrect = false;
		for (CommandEnum command : CommandEnum.values()) {
			if (command.toString().equals(commandEntered)) {
				commandCorrect = true;
				break;
			}
		}
		return commandCorrect;
	}

	static void back() {
//		Directory dire = new Directory("");
		int i = 1;
		while (directoryList.size()-1 > i) {
//			dire.printDirectoryPath();
			directory.setParentDirectory((String)directoryList.get(i-1));
			directory.setDirectoryPath((String)directoryList.get(i-1));
			i++;
		}
		if(directoryList.size()==1){
			
		}
		directory.printDirectoryPath();
	}

	static void changeDirectory(String directoryName) {
		boolean flag = false;
		if (!folderList.isEmpty()) {
			for (Object name : folderList) {
				if (name.equals(directoryName)) {
					directory.setParentDirectory(directoryName);
					directory.setDirectoryPath(directoryName);

					flag = true;
					break;
				}
			}
		}
		if (!flag) {
			System.out.println("directory doesn't exists");
		}
		directory.printDirectoryPath();
	}

	static void makeDirectory(String directoryName) {
		if (directoryName != null) {
			if (!folderList.isEmpty()) {
				for (Object name : folderList) {
					if (!name.equals(directoryName)) {
						folderList.add(directoryName);
						directoryList.add(folderList);
						System.out.println(directoryList.get(0));
						break;
					} else {
						System.out.println("directory already exists");
					}
				}
			} else {
				folderList.add(directoryName);
				directoryList.add(folderList);
				System.out.println(directoryList.get(0));

			}
		} else {
			System.out.println("The syntax of the command is incorrect");
		}
		directory.printDirectoryPath();
		
		
	}

	public static void main(String[] arg) {
		directory.printDirectoryPath();
		Scanner sc = new Scanner(System.in);
		String inputSeparator[];
		do {
			String input = sc.nextLine();
			inputSeparator = input.split(" ");
			String command = inputSeparator[0];
			String argument = null;
			if (isCommandCorrect(command)) {
				if (inputSeparator.length > 1) {
					argument = inputSeparator[1];
					commandExecutor(command, argument);
				} else {
					commandExecutor(command, argument);
				}
			} else {
				System.out.println("command does not exist");
				directory.printDirectoryPath();
			}
			
		} while (inputSeparator[0] != "exit");

		sc.close();

	}
}
