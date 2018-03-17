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
	
	public Point getDestination() {
		return destination;
	}
	
	void setDestination(Point d) {
		destination = d;
	}
	
	@Override
	public String toString() {
		try {
			int label = Integer.parseInt(destination.getLabel());
			return "(V" + label + ", " + length + ")";
		} catch (NumberFormatException e) {
			String label = "'" + destination.getLabel() + "'";
			return "(V" + label + ", " + length + ")";
		}
	}
	
}

