package Command;

import java.util.Date;
import java.util.List;
import java.util.LinkedList;

public class Directory {

	private String dirName;
	private Date Time;
	private Directory parentDirectory;
	private String directoryPath;
	private List<Directory> subDirectory;
	
	
	Directory(String dirName, Directory parentDirectory, String directoryPath){
		this.dirName = dirName;
		this.Time = new Date();
		this.parentDirectory = parentDirectory;
		this.directoryPath = directoryPath;
		this.subDirectory = new LinkedList<Directory>();
	}
	
	
	public void addDirectory(Directory dir) {
		this.subDirectory.add(dir);
	}
	
	
	public String getDirName() {
		return this.dirName;
	}
	
	
	public Date getDirectoryCreationTime() {
		return this.Time;
	}
	
	
	public Directory getParentDirectory() {
		return this.parentDirectory;
	}
	
	
	public String getDirectoryPath() {
		return this.directoryPath;
	}
	
	
	public List<Directory> getSubDirList(){
		return this.subDirectory;
	}
}
