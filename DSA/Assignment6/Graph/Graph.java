package Graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * 
 * @author Jitendra Chandwani
 *
 */
class Graph implements GraphInterface {
	int vertices;
	LinkedList<Edge> adjacencylist[];
	boolean visited[];
	int[] dist;

	/**
	 * getAdjacentList - adjacent List 
	 * @return - adjacent list
	 */
	public LinkedList<Edge>[] getAdjacentList() {
		return adjacencylist;
	}

	/**
	 * Graph Constructor - initialize object
	 * @param vertices
	 */
	@SuppressWarnings("unchecked")
	Graph(int vertices) {
		this.vertices = vertices;
		visited = new boolean[vertices];
		adjacencylist = new LinkedList[vertices];
		dist = new int[vertices];
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
		try{
		for (int i = 0; i < edgeList.length; i++) {
			for (int j = 0; j < adjacencylist[i].size(); j++) {
				Edge edge = edgeList[i].get(j);
				System.out.println("Edge-" + (++number) + " source: "
						+ edge.getSource() + " destination: "
						+ edge.getDestination() + " weight: "
						+ edge.getWeight());
			}
		}
		}catch(Exception e){
			e.getStackTrace();
		}
	}

	/**
	 * printGraphSpanning - print the spanning graph
	 * @param edgeList
	 */
	private void printGraphSpanning(LinkedList<Edge> edgeList[]) {
		int number = 0;
		try{
			for (int i = 0; i < edgeList.length - 1; i++) {
				Edge edge = edgeList[i].get(0);
				System.out.println("Edge-" + (++number) + " source: "
						+ edge.getSource() + " destination: "
						+ edge.getDestination() + " weight: " + edge.getWeight());
			}
		}catch(Exception e){
			e.getStackTrace();
		}
		
	}

	/**
	 * (non-Javadoc)
	 * @see Graph.GraphInterface#minimumSpanningTree()
	 * minimumSpanningTree - find spanning tree the shortest path to traverse
	 * all the graph node
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void minimumSpanningTree() {
		try{
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
		}catch(Exception e){
			e.getStackTrace();
		}
	}

	
	/**
	 * find - find whether vertex is not in self loop or loop
	 * @param parent
	 * @param vertex
	 * @return vertex or parent vertex
	 */
	private int find(int[] parent, int vertex) {
		int returnValue = vertex;
		// until an element is reached whose parent is itself
		if (parent[vertex] != vertex) {
			returnValue = find(parent, parent[vertex]);
		}
		return returnValue;
	}

	/**
	 * union - combine the vertex
	 * @param parent
	 * @param x
	 * @param y
	 */
	private void union(int[] parent, int x, int y) {
		int x_set_parent = find(parent, x);
		int y_set_parent = find(parent, y);
		// make x as parent of y
		parent[y_set_parent] = x_set_parent;
	}

	/**
	 * DFSUtil - Recursive function for DFS
	 * @param vertices
	 * @param visited
	 */
	private void DFSUtil(int vertices, boolean visited[]) {
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

	/**
	 * DFS - The function to do DFS traversal. It uses recursive DFSUtil()
	 * @param source
	 * @return - boolean array of visited list
	 */
	private boolean[] DFS(int source) {
		boolean visited[] = new boolean[vertices];
		// Call the recursive helper function to print DFS traversal
		// starting from all vertices one by one
		for (int i = source; i < vertices; ++i)
			if (visited[i] == false) {
				DFSUtil(i, visited);
			}
		return visited;
	}

	/**
	 * (non-Javadoc)
	 * @see Graph.GraphInterface#isConnected()
	 * Check whether graph is connected or not
	 * @return - boolean array of visited vertex
	 */
	@Override
	public boolean isConnected() {
		boolean returnValue = true;
		boolean isConnected[] = DFS(0);
		try{
			for (boolean value : isConnected) {
				if (value == false) {
					returnValue = false;
					break;
				}
			}
		}catch(Exception e){
			e.getStackTrace();
		}
			
		return returnValue;
	}

	/**
	 * (non-Javadoc)
	 * @see Graph.GraphInterface#reachable(int)
	 * check whether source is reachable to which vertex
	 * @param source - source of the graph
	 */
	@Override
	public void reachable(int source) {
		DFS(source);
	}

	/**
	 * Dijkstra - shortest distance algorith
	 * @param source
	 */
	void Dijkstra(int source) {
		boolean visited[] = new boolean[vertices];
		visited[source] = true;
		ArrayList<Integer> shortestpath = new ArrayList<Integer>();
		ArrayList<Edge> shortestpathEdge = new ArrayList<Edge>();
		for (int source1 = 0; source1 < vertices; source1++) {
			Iterator<Edge> i = adjacencylist[source1].listIterator();

			while (i.hasNext()) {
				Edge edge = i.next();
				shortestpath.add(edge.getDestination());
				shortestpathEdge.add(edge);
			}
			int minimumValue = getMinimumValue(shortestpath,shortestpathEdge);
		}
		System.out.println("Path");
		for (int i = 0; i < shortestpath.size(); i++) {
//			System.out.println(shortestpath.get(i) + "-->");
		}

	}

	/**
	 * getMinimumValue - get minimum weight of edge
	 * @param shortestpath
	 * @param shortestpathEdge
	 * @return minimum vertex Value
	 */
	private int getMinimumValue(ArrayList<Integer> shortestpath,ArrayList<Edge> shortestpathEdge) {
		int minimum = 100000;
		for(int i=0;i<shortestpath.size();i++){			
			if (shortestpath.get(i) < minimum) {
				minimum = shortestpath.get(i);
				
			}
		}
		return minimum;
	}

	/**
	 * (non-Javadoc)
	 * @see Graph.GraphInterface#shortestPath(int)
	 * find the shortest path from source to destination
	 * @param source - source
	 */
	@Override
	public void shortestPath(int source) {
		Dijkstra(source);
	}
}
