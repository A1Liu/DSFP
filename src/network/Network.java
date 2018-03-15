package network;

import java.util.ArrayList;

public class Network<E extends Vertex> {

	ArrayList<Vertex> vertices;//maybe vertex class doesn't need id field
	int maxID;
	
	public Network(int size) {
		vertices = new ArrayList<Vertex>();
		maxID = 0;
	}
	
	public Network() {
		this(10);
	}
	
	/**
	 * adds another vertex
	 */
	public void addVertex() {
		addVertex(null);
	}
	
	/**
	 * adds another vertex
	 */
	public void addVertex(int id) {
		addVertex(null);
	}
	
	/**
	 * adds another vertex
	 */
	public void addVertex(String key) {}
	
	public void rmVertex(int v) {
		
	}
	
	public void rmVertex(String key) {
		
	}
	
	/**
	 * 
	 * @param v1 vertex sending edge
	 * @param v2 vertex receiving edge
	 * @param l length of edge
	 * @return whether successful
	 */
	public boolean addEdge(int v1, int v2, int l) {
		return true;
	}
	
	public boolean rmEdge(int v1, int v2) {
		return true;
	}
	
	public int countVertices() {
		return vertices.size();
	}
	
	public int countEdges() {
		return 0;
	}
	
	public ArrayList<Vertex> getVertices() {
		return null;
	}
	
	public String getEdges() {
		return null;
	}
	
	public String vertexToString() {
		return null;
	}
	
	public String toString() {
		return null;
	}
	
	public int getMaxID() {
		return maxID;
	}
	
}

class Vertex implements Comparable<Vertex> {

	private final int id;
	private EdgeList edges;
	private Vertex next;
	
	Vertex() {
		this(0);
	}
	
	Vertex(int i) {
		id = i;
		edges = new EdgeList();
	}
	
	@Override
	public int compareTo(Vertex v) {
		return countEdges()-v.countEdges();
	}

	public EdgeList getEdges() {
		return edges;
	}
	
	public int countEdges() {
		return edges.countElements();
	}
	
	boolean addEdge(Vertex v, int l) {
		Edge newEdge = new Edge(v,l);
		return edges.addElement(newEdge);
	}
	
	/**
	 * adds an edge
	 * @param newEdge edge to be added
	 * @return whether edge was successfully added
	 */
	boolean addEdge(Edge newEdge) {
		return edges.addElement(newEdge);
	}
	
	/**
	 * This method returns the closest possible match to the given vertex
	 * @param e edge to find
	 * @return the edge with the same destination as e, or null if there is none.
	 */
	Edge findEdge(Edge e) {
		if (edges.getFront() == null)
			return null;
		
		if(edges.getFront().getData().equals(e))
			return edges.getFront().getData();
		
		ListNode<Edge> current = edges.findPrevious(e).getNext();
		
		if(current == null)
			return null;
		else return current.getData();
	}
	
	/**
	 * removes all edges from the vertex
	 */
	void rmAllEdges() {
		edges.setFront(null);
	}
	
	/**
	 * moves an edge -- THIS METHOD IS NOT VERY GOOD RIGHT NOW AVOID IF POSSIBLE
	 * @param e1 edge to remove
	 * @param e2 edge to add
	 * @return whether successful in both operations
	 */
	boolean setEdge(Edge e1, Edge e2) {
		return edges.remElement(e1) && edges.addElement(e2);
	}
	
	/**
	 * removes the edge with the same destination as input edge
	 * @param e edge to remove
	 * @return whether the edge was present in the vertex to begin with
	 */
	boolean rmEdge(Edge e) {
		return edges.remElement(e);
	}
	
	/**
	 * sets the next vertex in the map bin
	 * @param v the next vertex
	 */
	void setNext(Vertex v) {
		next = v;
	}
	
	/**
	 * getter for next vertex in map bin
	 * @return next vertex
	 */
	public Vertex getNext() {
		return next;
	}
	
	/**
	 * getter for user/auto generated label
	 * @return string form of label
	 */
	public String getLabel() {
		return "" + id;
	}
	
	/**
	 * toString for vertices
	 * @return identifier for vertex and all edges of vertex
	 */
	public String toString() {
		
		try {
			int label = Integer.parseInt(getLabel());
			return "V" + label + ": " + edges.toString();
		} catch (NumberFormatException e) {
			String label = "'" + getLabel() + "'";
			return "V" + label + ": " + edges.toString();
		}
	}
}

