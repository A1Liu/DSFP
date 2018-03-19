package network;

import java.util.ArrayList;

class EdgeList extends LinkedList<Edge> {
	
	EdgeList(Edge e) {
		setFront(new ListNode<Edge>(e));
	}
	
	EdgeList() {
		setFront(null);
	}
	
	EdgeList(ArrayList<Edge> a) {
		for(int x = 0; x < a.size(); x++) {
			addElement(a.get(x));
		}
	}
	
	EdgeList(Edge[] a) {
		for(int x = 0; x < a.length; x++) {
			addElement(a[x]);
		}
	}
	
	/**
	 * adds the element e if it's not already in the list
	 * @param e the element that we want to add
	 * @return a 0 if successful, a 2 if unsuccessful
	 */
	@Override
	public boolean addElement(Edge e) {
		
		if (e.getDestination() == null)
			return false;
		
		ListNode<Edge> insert = new ListNode<Edge>(e);
		
		if(getFront() == null) {
			setFront(insert);
			return true;
		}
		
		if(findPrevious(e).getNext() != null || getFront().getData().equals(e))
			return false;
		
		insert.setNext(getFront());
		setFront(insert);
		return true;
	}
}

/* --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 */

class Edge implements Comparable<Edge> {

	private Point destination;
	private int length;
	
	Edge(Point v, int l) {
		destination = v;
		length = Math.abs(l);
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
		length = Math.abs(l);
	}
	
	public Point getDestination() {
		return destination;
	}
	
	void setDestination(Point d) {
		destination = d;
	}
	
	@Override
	public String toString() {
		try {
			int label = Integer.parseInt(destination.getLabel().toString());
			return "(V" + label + ", " + length + ")";
		} catch (NumberFormatException e) {
			String label = "'" + destination.getLabel() + "'";
			return "(V" + label + ", " + length + ")";
		}
	}
	
}

/* --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 */

class EdgePair extends Edge {
	
	private final Point source;
	
	public EdgePair(Point p1, Point p2) {
		this(p1,p2,1);
	}
	
	public EdgePair(Point p1, Point p2, int l) {
		super(p2,l);
		source = p1;
	}
	
	public EdgePair(Point p, Edge e) {
		this(p,e.getDestination(),e.getLength());
	}
	
	/**
	 * getter for source point
	 * @return source
	 */
	public Point getSource() {
		return source;
	}
	
	@Override
	public boolean equals(Object o) {
		if (!(o instanceof EdgePair))
			return false;
	
		if(((EdgePair) o).getDestination() == getDestination() && ((EdgePair) o).getSource() == getSource())
			return true;
		
		return false;
	
	}
	
	/**
	 * toString, also a line in the csv
	 */
	public String toString() {
		return (getLength() == 0)
				? source.getLabel().toString() + "," + getDestination().getLabel().toString()
				: source.getLabel().toString() + "," + getDestination().getLabel().toString() + "," + getLength() + "\n";
	}
}

