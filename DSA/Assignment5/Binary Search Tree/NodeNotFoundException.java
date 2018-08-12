/**
 * NodeNotFoundException -  Exception Class
 * @author Jitendra
 *
 */
public class NodeNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	/**
	 * NodeNotFoundException
	 * @param msg -  exception message
	 */
	public NodeNotFoundException(String msg) {
		System.out.println(msg);
	}
}
