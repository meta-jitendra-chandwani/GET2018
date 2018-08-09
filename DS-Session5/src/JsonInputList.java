import java.util.List;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonInputList {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<KeyValuePair> takeInput(String path)
			throws FileNotFoundException, IOException, ParseException {
		List<KeyValuePair> list = new ArrayList<KeyValuePair>();

		JSONArray array = (JSONArray) new JSONParser().parse(new FileReader(
				path));

		Iterator itr2 = array.iterator();
		Iterator<Map.Entry> itr1;

		while (itr2.hasNext()) {
			itr1 = ((Map) itr2.next()).entrySet().iterator();
			while (itr1.hasNext()) {
				Map.Entry pair1 = itr1.next();
				Map.Entry pair2 = itr1.next();

				list.add(new KeyValuePair(Integer.parseInt(pair2.getValue()
						.toString()), pair1.getValue().toString()));
			}
		}

		return list;
	}

	public static void main(String arg[]) {
		List<KeyValuePair> list = new ArrayList<KeyValuePair>();
		JsonInputList jsonInputList = new JsonInputList();
		final String PATH_JSON_FILE="C:\\Users\\User23\\workspace\\DS-Session5\\src\\Dictionary.json"; 
		try {
			list = jsonInputList.takeInput(PATH_JSON_FILE);
			System.out.println(list);
			
		BinaryTreeNode node=new BinaryTreeNode(list);
		node.createTree();
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}