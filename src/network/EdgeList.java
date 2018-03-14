package network;

public class EdgeList extends LinkedList<Edge> {
	
	public EdgeList(Edge e) {
		setFront(new ListNode<Edge>(e));
	}
	
	/**
	 * adds the element e if it's not already in the list
	 * @param e the element that we want to add
	 * @return a 0 if successful, a 2 if unsuccessful
	 */
	@Override
	public boolean addElement(Edge e) {
		
		if(findElement(e) != null)
			return false;
		
		ListNode<Edge> insert = new ListNode<Edge>(e);
		
		try {
			insert.setNext(getFront().getNext());
			setFront(insert);
		} catch (NullPointerException n) {
			setFront(insert);
		}
		return true;
		
	}
	
	/**
	 * finds the node in the list that contains e
	 * @param e element that we're looking for
	 * @return the reference to the node that contains e
	 */
	@Override
	public ListNode<Edge> findElement(Edge e) {
		ListNode<Edge> current = getFront();
		while(current.getNext() != null && current.getNext().compareTo(e)!=0 && current.getNext().getData() != e) {
			current = current.getNext();
		}
		return current.getNext();
	}
	
}
