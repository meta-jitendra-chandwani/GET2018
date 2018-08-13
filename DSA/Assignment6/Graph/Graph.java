package Graph;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

class Graph implements GraphInterface {
	int vertices;
	LinkedList<Edge> adjacencylist[];
	boolean visited[];

	public LinkedList<Edge>[] getAdjacentList() {
		return adjacencylist;
	}

	/**
	 * Graph Constructor -  initialize object
	 * @param vertices
	 */
	@SuppressWarnings("unchecked")
	Graph(int vertices) {
		this.vertices = vertices;
		visited = new boolean[vertices];
		adjacencylist = new LinkedList[vertices];
		for (int i = 0; i < vertices; ++i) {
			adjacencylist[i] = new LinkedList();
		}
	}

	/**
	 * addEdge - add edge between source and destination
	 * @param source - source node
	 * @param destination - destination node
	 * @param weight - weight of node
	 */
	public void addEdge(int source, int destination, int weight) {
		Edge edge = new Edge(source, destination, weight);
		adjacencylist[source].add(edge);
	}

	/**
	 * printGraph - print the graph
	 * @param edgeList
	 */
	public void printGraph(LinkedList<Edge> edgeList[]) {
		int number = 0;
		for (int i = 0; i < edgeList.length; i++) {
			for (int j = 0; j < adjacencylist[i].size(); j++) {
				Edge edge = edgeList[i].get(j);
				System.out.println("Edge-" + (++number) + " source: "
						+ edge.getSource() + " destination: "
						+ edge.getDestination() + " weight: "
						+ edge.getWeight());
			}
		}
	}

	/**
	 * printGraphSpanning - print the spanning graph
	 * @param edgeList
	 */
	public void printGraphSpanning(LinkedList<Edge> edgeList[]) {
		int number = 0;
		for (int i = 0; i < edgeList.length - 1; i++) {
			Edge edge = edgeList[i].get(0);
			System.out.println("Edge-" + (++number) + " source: "
					+ edge.getSource() + " destination: "
					+ edge.getDestination() + " weight: " + edge.getWeight());
		}
	}

	/**
	 * minimumSpanningTree - find spanning tree
	 * the shortest path to traverse all the graph node
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void minimumSpanningTree() {
		PriorityQueue<Edge> pq = new PriorityQueue<>(adjacencylist.length,
				Comparator.comparingInt(o -> o.getWeight()));

		// add all the edges to priority queue, //sort the edges on weights
		for (int i = 0; i < adjacencylist.length; i++) {
			for (int j = 0; j < adjacencylist[i].size(); j++) {
				pq.add(adjacencylist[i].get(j));
			}
		}
		// create a parent []
		int[] parent = new int[vertices];
		for (int i = 0; i < vertices; i++) {
			parent[i] = i;
		}
		LinkedList<Edge> mst[] = new LinkedList[vertices];
		for (int i = 0; i < vertices; ++i) {
			mst[i] = new LinkedList();
		}
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
				mst[index].add(edge);
				index++;
				union(parent, x_set, y_set);
			}
		}
		// print MST
		System.out.println("Minimum Spanning Tree: ");
		printGraphSpanning(mst);
	}

	public int find(int[] parent, int vertex) {
		int returnValue = vertex;
		// until an element is reached whose parent is itself
		if (parent[vertex] != vertex) {
			returnValue = find(parent, parent[vertex]);
		}
		return returnValue;
	}

	public void union(int[] parent, int x, int y) {
		int x_set_parent = find(parent, x);
		int y_set_parent = find(parent, y);
		// make x as parent of y
		parent[y_set_parent] = x_set_parent;
	}

	void DFSUtil(int vertices, boolean visited[]) {
		// Mark the current node as visited and print it
		visited[vertices] = true;
		System.out.print(vertices + " ");

		// Recur for all the vertices adjacent to this vertex
		Iterator<Edge> i = adjacencylist[vertices].listIterator();
		while (i.hasNext()) {
			Edge n = i.next();
			int source = n.getSource();
			if (!visited[source])
				DFSUtil(source, visited);
		}
	}

	// The function to do DFS traversal. It uses recursive DFSUtil()
	boolean[] DFS(int a) {
		boolean visited[] = new boolean[vertices];
		// Call the recursive helper function to print DFS traversal
		// starting from all vertices one by one
		for (int i = a; i < vertices; ++i)
			if (visited[i] == false) {
				DFSUtil(i, visited);
			}
		return visited;
	}

	@Override
	public boolean isConnected() {
		boolean returnValue = true;
		boolean isConnected[] = DFS(0);
		for (boolean value : isConnected) {
			if (value == false) {
				returnValue = false;
				break;
			}
		}
		return returnValue;
	}

	@Override
	public void reachable(int a) {
		DFS(a);
	}

	@Override
	public void shortestPath() {
		// TODO Auto-generated method stub

	}
}
