package network;

class Edge implements Comparable<Edge> {

	private Vertex destination;
	private int length;
	
	Edge(Vertex v, int l) {
		destination = v;
		length = l;
	}
	
	@Override
	public int compareTo(Edge e) {
		return this.getLength()-e.getLength();
	}
	
	@Override
	public boolean equals(Object o) {
		
		if(!(o instanceof Edge))
			return false;
		
		if(this.destination == ((Edge) o).getDestination())
			return true;
		
		return false;
	}
	
	public int getLength() {
		return length;
	}
	
	void setLength(int l) {
		length = l;
	}
	
	public Vertex getDestination() {
		return destination;
	}
	
	void setDestination(Vertex d) {
		destination = d;
	}
	
	public String toString() {
		return "(V" + destination.getKey() + ", " + length + ")";
	}
	
}
