package network;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public abstract class Network<T extends Object,E extends Vertex> {

	private Enumeration<String> keys;
	private Hashtable<T, Vertex> vertices;//I want this hashtable to use a key that is the same as the keytype of the vertex object
	
	public Network() {
		vertices = new Hashtable<T, Vertex>();
	}
	
	/**
	 * adds another vertex
	 */
	public void addVertex() {}
	
	/**
	 * default way to add a vertex
	 * @param e vertex to add
	 */
	public void addVertex(T t, E e) {
		vertices.put(t,e);
	}
	
	/**
	 * removes a vertex with id i
	 * @param id identifier integer of vertex
	 * @return whether successful
	 */
	public boolean rmVertex(T id) {
		return vertices.remove(id)!=null;
	}
	
	/**
	 * returns the vertex of a certain id
	 * @param id identifier integer of the vertex
	 * @return vertex matching id
	 */
	public Vertex getVertex(T id) {
		return vertices.get(id);
	}
	
	/**
	 * adds edge from a vertex to another vertex
	 * @param v1 vertex sending edge
	 * @param v2 vertex receiving edge
	 * @param l length of edge
	 * @return whether successful
	 */
	public boolean addEdge(T v1, T v2, int l) {
		return vertices.get(v1).addEdge(vertices.get(v2), l);
	}
	
	/**
	 * removes an edge from vertex v1 to vertex v2
	 * @param v1 vertex edge is coming from
	 * @param v2 vertex edge is going to
	 * @return whether successfully removed
	 */
	public boolean rmEdge(T v1, T v2) {
		return vertices.get(v1).rmEdge(vertices.get(v2));
	}
	
	/**
	 * finds amount of vertices
	 * @return count of vertices
	 */
	public int countVertices() {
		return vertices.size();
	}
	
	/**
	 * finds amount of edges in the network
	 * @return returns amount of edges
	 */
	public int countEdges() {
		return 0;
	}
	
	/**
	 * toString for all edges in network
	 * @return a cytoscape-formatted csv string
	 */
	public String listEdges() {
		return null;
	}
	
	/**
	 * toString for all the names of all the vertices
	 * @return a String of all vertex names (keys)
	 */
	public String listVertices() {
		return null;
	}
	
	public String toString() {
		return null;
	}
}


class Vertex implements Comparable<Vertex> {

	private EdgeList edges;
	
	Vertex() {
		edges = new EdgeList();
	}
	
	@Override
	public int compareTo(Vertex v) {
		return countEdges()-v.countEdges();
	}

	/**
	 * gets a list of the edges
	 * @return EdgeList of edges
	 */
	public EdgeList getEdges() {
		return edges;
	}
	
	/**
	 * counts edges
	 * @return amount of edges coming from vertex
	 */
	public int countEdges() {
		return edges.countElements();
	}
	
	/**
	 * adds an edge
	 * @param v vertex to point edge to
	 * @param l length of edge
	 * @return whether edge was successfully added
	 */
	boolean addEdge(Vertex v, int l) {
		Edge newEdge = new Edge(v,l);
		return addEdge(newEdge);
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
	 * This method returns the closest possible match to the given vertex
	 * @param v destination of edge to find
	 * @return the edge with destination v, or null if there is none.
	 */
	Edge findEdge(Vertex v) {
		Edge e = new Edge(v,0);
		return findEdge(e);
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
	 * removes the edge with destination of input edge
	 * @param v destination of edge to remove
	 * @return whether the edge was present in the vertex to begin with
	 */
	boolean rmEdge(Vertex v) {
		Edge e = new Edge(v,0);
		return rmEdge(e);
	}
	
	/**
	 * getter for user/auto generated label
	 * @return string form of label
	 */
	public String getLabel() {
		return "V";
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

