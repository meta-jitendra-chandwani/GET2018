import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;

public class DictionaryTestCases {

	private String PATH_JSON_DICTIONARY;
	private JsonParser jsonParser;

	/**
	 * Initialize the object of JsonParser
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ParseException
	 * @throws NodeNotFoundException
	 */
	@Before
	public void initialize() throws FileNotFoundException, IOException,
			ParseException, NodeNotFoundException {
		PATH_JSON_DICTIONARY = "C:\\Users\\Jitendra\\Desktop\\Eclipse Workspace\\Dictionary\\src\\Dictionary.json";
		jsonParser = new JsonParser(PATH_JSON_DICTIONARY);
	}

	/**
	 * Check the functionality of deletedFromTree function
	 * @throws NodeNotFoundException
	 */
	@Test
	public void deletedFromTreeTest() throws NodeNotFoundException {
		int value = jsonParser.deleteFromTree(8, "C");
		assertEquals(value, 6);
	}

	/**
	 * Check the functionality of findValueOfKey function
	 */
	@Test
	public void findValueOfKeyTest() {
		assertEquals(jsonParser.findValueOfKey(55).toString(), "DC");
	}

}
