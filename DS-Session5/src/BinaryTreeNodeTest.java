import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.junit.Test;

public class BinaryTreeNodeTest {
	public static class BinaryTreeNode<E> {
		public E value;
		public BinaryTreeNode left;
		public BinaryTreeNode right;

		@JsonCreator
		public BinaryTreeNode(@JsonProperty("value") final E value) {
			this.value = value;
		}

		ArrayList<E> preOrder() {
			final ArrayList<E> result = new ArrayList<>();
			if (this.value == null) {
				return result;
			}
			preOrder(this, result);
			return result;
		}

		private static <E> void preOrder(BinaryTreeNode<E> root,
				ArrayList<E> result) {
			if (root == null)
				return;

			result.add(root.value);
			if (root.left != null)
				preOrder(root.left, result);
			if (root.right != null)
				preOrder(root.right, result);
		}
	}

	@Test
	public void binaryTreeNodeTest() throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		FileInputStream file=new FileInputStream("C:\\Users\\User23\\workspace\\DS-Session5\\src\\Dictionary.json");
		final BinaryTreeNode<Integer> intTree = objectMapper.readValue(file,
				new TypeReference<BinaryTreeNode<Integer>>() {
				});
		final List<Integer> listExpected = Arrays.asList(2, 1, 10, 5);
		System.out.println(file);
		System.out.println(intTree.preOrder());
		assertEquals(listExpected, intTree.preOrder());
	}
}