package network;

import java.util.ArrayList;

public class EdgeList extends LinkedList<Edge> {
	
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
