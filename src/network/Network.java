package network;

import java.util.ArrayList;

public class Network<E extends Vertex> {

	ArrayList<E> vertices = new ArrayList<E>();//maybe vertex class doesn't need id field
	
	public Network() {
		
	}
	
	/**
	 * adds another vertex
	 * @return whether successful
	 */
	public void addVertex() {
		
	}
	
	public void rmVertex(int v) {
		
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
	
	public String getVertices() {
		return null;
	}
	
	public String getEdges() {
		return null;
	}
	
	public String toString() {
		return null;
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
	
	boolean addEdge(Edge newEdge) {
		return edges.addElement(newEdge);
	}
	
	boolean rmAllEdges() {
		edges.setFront(null);
		return true;
	}
	
	boolean setEdge(Edge e1, Edge e2) {
		return edges.remElement(e1) && edges.addElement(e2);
	}
	
	boolean rmEdge(Edge e) {
		return edges.remElement(e);
	}
	
	void setNext(Vertex v) {
		next = v;
	}
	
	public Vertex getNext() {
		return next;
	}
	
	public String getLabel() {
		return "" + id;
	}
	
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

