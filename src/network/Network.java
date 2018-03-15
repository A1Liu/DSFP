package network;

public class Network {

	public Network() {
		
	}
	
}

class Vertex implements Comparable<Vertex> {

	private int id;
	private EdgeList edges;
	private Vertex next;
	
	Vertex() {
		edges = new EdgeList();
	}
	
	Vertex(int i) {
		this();
		id = i;
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
		return getLabel() + ": " + edges.toString();
	}
}

