package network;

public class Vertex implements Comparable<Vertex> {

	private final int key;
	private double rating;
	private EdgeList edges;
	private Vertex next;
	
	public Vertex(int k) {
		key = k;
		rating = 0;
		edges = new EdgeList(null);
	}
	
	public Vertex(int k, double r) {
		key = k;
		rating = r;
		edges = new EdgeList(null);
	}
	
	@Override
	public int compareTo(Vertex v) {
		if(key==v.getKey())
			return 0;
		
		return (int) (rating-v.getRating()*100);
	}
	
	public boolean addEdge(Vertex v, int l) {
		Edge newEdge = new Edge(v,l);
		return edges.addElement(newEdge);
	}
	
	public boolean addEdge(Edge newEdge) {
		return edges.addElement(newEdge);
	}
	
	public int getKey() {
		return key;
	}
	
	public void setRating(double r) {
		rating = r;
	}
	
	public double getRating() {
		return rating;
	}
	
	public void setNext(Vertex v) {
		next = v;
	}
	
	public Vertex getNext() {
		return next;
	}
	
	public String toString() {
		return key + ", " + "rating";
	}
}
