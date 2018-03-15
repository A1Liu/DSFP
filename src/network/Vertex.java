package network;

class Vertex implements Comparable<Vertex> {

	private final int key;
	private EdgeList edges;
	private Vertex next;
	
	Vertex(int k) {
		key = k;
		edges = new EdgeList();
	}
	
	@Override
	public int compareTo(Vertex v) {
		return countEdges()-v.countEdges();
	}
	
	int countEdges() {
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
	
	public int getKey() {
		return key;
	}
	
	void setNext(Vertex v) {
		next = v;
	}
	
	public Vertex getNext() {
		return next;
	}
	
	public String toString() {
		return "V " + key + ": " + edges.toString();
	}
}
