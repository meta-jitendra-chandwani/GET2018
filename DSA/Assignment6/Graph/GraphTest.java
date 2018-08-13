package Graph;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class GraphTest {
	private LinkedList<Edge> edgeList[];

	/**
	 * Initialize the object of Graph class
	 */
	@Before
	public void Initial() {
		int vertices = 6;
		Graph graph = new Graph(vertices);
		graph.addEdge(0, 1, 4);
		graph.addEdge(0, 2, 3);
		graph.addEdge(1, 2, 1);
		graph.addEdge(1, 3, 2);
		graph.addEdge(2, 3, 4);
		graph.addEdge(3, 4, 2);
		graph.addEdge(4, 5, 6);
		edgeList = graph.getAdjacentList();
	}

}