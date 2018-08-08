
public class Directory {
String rootDiretory="R:\\";
private String parentDirectory="";
private String directoryPath;
	
	public Directory(String value) {
		this.parentDirectory=value;
		this.directoryPath=value;
	}
	public Directory() {
		rootDiretory="R:\\";
	}
	String getParentDirectory(){
		return parentDirectory;
	}
	void setParentDirectory(String parentDirectory){
		this.parentDirectory+=parentDirectory+"\\";
	}
	
	String getDirectoryPath(){
		return directoryPath;
	}
	
	void setDirectoryPath(String parentDirectory){
		this.directoryPath=this.rootDiretory+getParentDirectory()+">";
	}
	
	public void printDirectoryPath(){
		setDirectoryPath(parentDirectory);
		System.out.print(getDirectoryPath());
	}

		
}
