package Graph;

import java.util.LinkedList;

public class Main {
	public static void main(String[] args) {
		LinkedList<Edge> edgeList[];
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

		graph.minimumSpanningTree();
		
		System.out.println("Following is Depth First Traversal");
		 
        System.out.println(graph.isConnected());
        
        System.out.println("Reachable from 3: ");
        graph.reachable(3);
        
        graph.Dijkstra(0);

	}
}
