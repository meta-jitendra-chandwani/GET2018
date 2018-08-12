import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

public class Main {
	public static void main(String arg[]) throws FileNotFoundException,
			IOException, ParseException, NodeNotFoundException {
		String PATH_JSON_DICTIONARY = "C:\\Users\\Jitendra\\Desktop\\Eclipse Workspace\\Dictionary\\src\\Dictionary.json";
		JsonParser jsonParser=new JsonParser(PATH_JSON_DICTIONARY);
		System.out.println(jsonParser.deleteFromTree(8,"C"));
		System.out.println(jsonParser.findValueOfKey(55));
		System.out.println("Sorted List");
		jsonParser.sortNode();
		System.out.println("Sorted List with boundary condition");
		jsonParser.sortNodeWithBoundaryCondition(7, 49);
	}
}