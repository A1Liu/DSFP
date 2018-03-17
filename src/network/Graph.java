package network;

import java.util.ArrayList;

public class Graph extends Network<Character,Vertex<Character>>{

	private String type = "Graph";
	
	public Graph() {
		
	}
	
	public static Graph createGraph(String type) {
		
		switch(type.toLowerCase()) {
		case "directedgraph":
			return new DirectedGraph();
		case "undirectedgraph":
			return new UndirectedGraph();
		case "Web":
			return new Web();
		default:
			return new Graph();
		
		}
		
	}
	
	public void setType(String t) {
		type = t;
	}
	
	public String getType() {
		return type;
	}
	
	@Override
	public void addVertex() {
		addVertex((char) getDefaultID());
	}

	@Override
	public boolean addVertex(Character t) {
		if (getDefaultID()>127)
			return false;
		Vertex<Character> v = new Vertex<Character>(t);
		return addVertex(t,v);
	}
	
	/**
	 * add a vertex of specific index
	 * @param t the integer key of the vertex
	 * @return whether operation was successful
	 */
	public boolean addVertex(int id) {
		Character i = (char) id;
		return addVertex(i);
	}
	
	/**
	 * removes a vertex with identifier id
	 * @param id identifier integer of vertex
	 * @return whether successful
	 */
	public boolean rmVertex(int id) {
		Character i = (char) id;
		return rmVertex(i);
	}
	
	/**
	 * returns the vertex of a certain id
	 * @param id identifier integer of the vertex
	 * @return vertex matching id
	 */
	public Vertex<Character> getVertex(int id) {
		Character i = (char) id;
		return getVertex(i);
	}
	
	/**
	 * adds edge of specified length from a vertex to another vertex
	 * @param v1 vertex sending edge
	 * @param v2 vertex receiving edge
	 * @param l length of edge
	 * @return whether successful
	 */
	public boolean addEdge(int v1, int v2, int l) {
		Character c1 = (char) v1;
		Character c2 = (char) v2;
		return addEdge(c1, c2, l);
	}
	
	/**
	 * adds edge of length 1 from a vertex to another vertex
	 * @param v1 vertex sending edge
	 * @param v2 vertex receiving edge
	 * @return whether successful
	 */
	public boolean addEdge(int v1, int v2) {
		Character c1 = (char) v1;
		Character c2 = (char) v2;
		return addEdge(c1, c2, 1);
	}
	
	/**
	 * removes an edge from vertex v1 to vertex v2
	 * @param v1 vertex edge is coming from
	 * @param v2 vertex edge is going to
	 * @return whether successfully removed
	 */
	public boolean rmEdge(int v1, int v2) {
		Character c1 = (char) v1;
		Character c2 = (char) v2;
		return rmEdge(c1, c2);
	}
	
	/**
	 * removes all edges from vertex v1
	 * @param v1 vertex to clear
	 */
	public boolean rmEdge(int v) {
		Character c1 = (char) v;
		return rmEdge(c1);
	}
}

class DirectedGraph extends Graph {
	
	public DirectedGraph() {
		setType("Directed Graph");
	}
	
}

class Web extends UndirectedGraph {
	
	public Web() {
		setType("Web");
	}
	
	@Override
	public boolean addEdge(Character v1, Character v2) {
		return super.addEdge(v1, v2) && super.addEdge(v2, v1);
	}
	
	@Override
	public boolean addEdge(Character v1, Character v2, int l) {
		return super.addEdge(v1, v2) && super.addEdge(v2, v1);
	}
}

class UndirectedGraph extends Graph {
	
	public UndirectedGraph() {
		setType("Undirected Graph");
	}
	
	@Override
	public boolean addEdge(Character v1, Character v2, int l) {
		return super.addEdge(v1, v2, l) && super.addEdge(v2, v1, l);
	}
	
	@Override
	public boolean rmVertex(Character id) {
		return this.rmEdge(id) && super.rmVertex(id);
	}
	
	@Override
	public boolean rmEdge(Character v1, Character v2) {
		boolean b = super.rmEdge(v1, v2);
		return super.rmEdge(v2, v1) || b;
	}
	
	@Override
	public boolean rmEdge(Character v) {
		Vertex<Character> toDelete = getVertex(v);
		
		if (toDelete == null)
			return false;
		
		EdgeList edges = toDelete.getEdges();
		ListNode<Edge> current = edges.getFront();
		
		while(current != null) {
			current.getData().getDestination().rmEdge(toDelete);
			current=current.getNext();
		}
		
		super.rmEdge(v);
		
		return true;
	}
	
	@Override
	public ArrayList<EdgePair> toList() {
		//Need to use breadth-first iterator
	}
	
	@Override
	public int countEdges() {
		int count = 0;
		ArrayList<Vertex<Character>> vertexList = listVertices();
		for (int x = 0;x<size();x++) {
			count+=vertexList.get(x).countEdges();
		}
		return count/2;
	}
}