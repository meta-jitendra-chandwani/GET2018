package Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Graph implements GraphInterface {
	int vertices;
	ArrayList<Edge> adjacencylist = new ArrayList<Edge>();

	public ArrayList<Edge> getAdjacentList() {
		return adjacencylist;
	}

	Graph(int vertices) {
		this.vertices = vertices;
	}

	public void addEdge(int source, int destination, int weight) {
		Edge edge = new Edge(source, destination, weight);
		adjacencylist.add(source, edge);
	}

	public void printGraph(ArrayList<Edge> edgeList) {
		for (int i = 0; i < edgeList.size(); i++) {
			Edge edge = edgeList.get(i);
			System.out.println("Edge-" + i + " source: " + edge.getSource()
					+ " destination: " + edge.getDestination() + " weight: "
					+ edge.getWeight());
		}
	}

	public void minimumSpanningTree() {
		PriorityQueue<Edge> pq = new PriorityQueue<>(adjacencylist.size(),
				Comparator.comparingInt(o -> o.getWeight()));

		// add all the edges to priority queue, //sort the edges on weights
		for (int i = 0; i < adjacencylist.size(); i++) {
			pq.add(adjacencylist.get(i));
		}
		// create a parent []
		int[] parent = new int[vertices];
		for (int i = 0; i < vertices; i++) {
			parent[i] = i;
		}
		ArrayList<Edge> mst = new ArrayList<>();

		// process vertices - 1 edges
		int index = 0;
		while (index < vertices - 1) {
			Edge edge = pq.remove();
			// check if adding this edge creates a cycle
			int x_set = find(parent, edge.getSource());
			int y_set = find(parent, edge.getDestination());

			if (x_set == y_set) {
				// ignore, will create cycle
			} else {
				// add it to our final result
				mst.add(edge);
				index++;
				union(parent, x_set, y_set);
			}
		}
		// print MST
		System.out.println("Minimum Spanning Tree: ");
		printGraph(mst);
	}

	public int find(int[] parent, int vertex) {
		// chain of parent pointers from x upwards through the tree
		// until an element is reached whose parent is itself
		if (parent[vertex] != vertex)
			return find(parent, parent[vertex]);
		;
		return vertex;
	}

	public void union(int[] parent, int x, int y) {
		int x_set_parent = find(parent, x);
		int y_set_parent = find(parent, y);
		// make x as parent of y
		parent[y_set_parent] = x_set_parent;
	}

	@Override
	public boolean isConnected() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean reachable() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void shortestPath() {
		// TODO Auto-generated method stub

	}
}
