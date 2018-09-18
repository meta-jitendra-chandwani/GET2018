import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * JsonParser Class - parse value from Json
 * @author Jitendra
 */
public class JsonParser {
	DictionaryTree dictionaryTree = new DictionaryTree();
	static ArrayList<Pair> list = new ArrayList<Pair>();

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public JsonParser(String path) throws FileNotFoundException, IOException,
			ParseException, NodeNotFoundException {

		JSONArray array = (JSONArray) new JSONParser().parse(new FileReader(
				path));
		Iterator iterator = array.iterator();
		Iterator<Map.Entry> mapObjectKeyValue;
		while (iterator.hasNext()) {
			mapObjectKeyValue = ((Map) iterator.next()).entrySet().iterator();
			while (mapObjectKeyValue.hasNext()) {
				Map.Entry value = mapObjectKeyValue.next();
				Map.Entry key = mapObjectKeyValue.next();
				Pair pair = new Pair(
						Integer.parseInt(key.getValue().toString()), value
								.getValue().toString());
				list.add(pair);
				dictionaryTree.add(pair);
			}
		}
	}

	/**
	 * delete node from tree
	 * @param key - key of node
	 * @param value - value of node
	 * @return - number of node left after deletion
	 * @throws NodeNotFoundException
	 */
	public int deleteFromTree(int key, String value) throws NodeNotFoundException {
		Pair pair1 = new Pair(key, value);
		int value1 = dictionaryTree.delete(pair1);
		return value1;
	}

	/**
	 * find value of key
	 * @param key
	 * @return value of key
	 */
	public String findValueOfKey(int key) {
		return dictionaryTree.getValue(key);
	}

	/**
	 * sortNode - Sort in ascending order
	 * @return sorted list of pair
	 */
	public void sortNode() {
		int i = 0;
		while (i < list.size()) {
			System.out.println(dictionaryTree.sortedKeyValue().get(i).getKey()
					+ " " + dictionaryTree.sortedKeyValue().get(i).getValue());
			i++;
		}
	}

	/**
	 * sortNodeWithBoundaryCondition - sort according to boundary condition
	 * @param key1 - boundary condition 1
	 * @param key2 - boundary condition 2
	 * @return list of sorted pair according to boundary condition
	 */
	public void sortNodeWithBoundaryCondition(int key1, int key2) {
		int i = 0;
		while (i < 3) {
			System.out.println(dictionaryTree.sortedKeyValuePair(key1, key2).get(i).getKey()
					+ " " + dictionaryTree.sortedKeyValuePair(key1, key2).get(i).getValue());
			i++;
		}
	}

	/**
	 * nodeList - Node List
	 * @return list of node
	 */
	public static ArrayList<Pair> nodeList() {
		return list;
	}
}