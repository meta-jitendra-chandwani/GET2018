/**
 * AssignmentPOJO - For set and get the value of numberOfRowUpdated
 * @author Jitendra Chandwani
 *
 */
public class AssignmentPOJO {
	private int numberOfChild;
	private String Parent;

	public AssignmentPOJO(String Parent,int numberOfChild) {
		this.numberOfChild=numberOfChild;
		this.Parent=Parent;
	}

	public int getNumberOfChild() {
		return numberOfChild;
	}

	public String getParent() {
		return Parent;
	}
	
}
