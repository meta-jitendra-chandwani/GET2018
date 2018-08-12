package Graph;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<Edge> edgeList;
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
		System.out.println("List of Edge");
		graph.printGraph(edgeList);

		System.out.println("Spanning Tree");
		graph.minimumSpanningTree();

	}
}
