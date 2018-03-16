package network;

public class LinkedList<E extends Comparable<E>> {

	private ListNode<E> front;
	
	/**
	 * constructor for list with 1 element
	 * @param e first element of list
	 */
	public LinkedList(E e) {
		front = new ListNode<E>(e);
	}
	
	/**
	 * default constructor for empty list
	 */
	public LinkedList() {
		front = null;
	}
	
	/**
	 * gets the first element of the list
	 * @return the reference to the first node in the list
	 */
	public ListNode<E> getFront() {
		return front;
	}
	
	/**
	 * setter for the first element of the list
	 * @param e the new first element
	 */
	public void setFront(ListNode<E> e) {
		front = e;
	}
	
	/**
	 * 
	 * @param e the number we need to add or remove
	 * @return the position of that number, or null if it isn't in there
	 */
	public ListNode<E> insertTo(E e) {
		ListNode<E> current = front;
		while(current.getNext() != null && current.getNext().compareTo(e)==-1) {
			current = current.getNext();
		}
		return current;
	}

	/**
	 * adds the element e if it's not already in the list
	 * @param e the element that we want to add
	 * @return a 0 if successful, a 2 if unsuccessful
	 */
	public boolean addElement(E e) {
		ListNode<E> insert = new ListNode<E>(e);

		if(front == null){
			front = insert;
		} else if (front.getData().compareTo(e) == 1) {
			insert.setNext(front);
			front = insert;
		} else if (front.getData().equals(e)) {
			return false;
		} else {
			ListNode<E> previous = insertTo(e);
			try {
			if(previous.getNext().getData().equals(e)) {
				return false;
			} else {
				insert.setNext(previous.getNext());
				previous.setNext(insert);
			}
			} catch (NullPointerException a) {
				insert.setNext(previous.getNext());
				previous.setNext(insert);
			}
		}
		return true;
	}
	
	/**
	 * removes the element e if it's in the list
	 * @param e the element we want to remove
	 * @return a 0 if successful, a 3 if unsuccessful
	 */
	public boolean remElement(E e) {
		try {
			if (e.equals(front.getData())) {
				front = front.getNext();
			} else {
				ListNode<E> previous = findPrevious(e);
				if(previous.getNext() != null)
					previous.setNext(previous.getNext().getNext());
				else return false;
			}
		} catch (NullPointerException a) {
			return false;
		}
			return true;
	}
	
	/**
	 * finds the node in the list that points to the element e
	 * @param e element that we're looking for
	 * @return the reference to the node that points to the node containing e
	 */
	public ListNode<E> findPrevious(E e) {
		ListNode<E> current = front;
		while(current.getNext() != null && !current.getNext().getData().equals(e)) {
			current = current.getNext();
		}
		return current;
	}
	
	/**
	 * finds the amount of nodes in the list
	 * @return amount of nodes in the list
	 */
	public int countElements() {
		ListNode<E> current = front;
		int counter = 0;
		while(current != null) {
			current = current.getNext();
			counter++;
		}
		return counter;
	}
	
	/**
	 * returns the contents of the list in string form
	 */
	public String toString() {
		ListNode<E> current = front;
		String output = "[";
		if(current != null) {
		while(current.getNext() != null) {
			output = output + current.toString() + "; ";
			current = current.getNext();
		}
		output = output + current.toString();
		} else {
			output = output + "Empty List";
		}
		return output + "]";
	}
}

/* --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 */

class ListNode<E extends Comparable<E>> implements Comparable<E> {
	 
	private E data;
    private ListNode<E> next;

    /**
     * constructor for a single, unconnected node
     * @param d object to put in the node
     */
    public ListNode(E e) {
		this(e, null);
	}

    /**|
     *  constructor for node that references another node
     * @param d object to be put in the node
     * @param n reference to next node
     * @param p reference to previous node
     */
    public ListNode(E e, ListNode<E> n) {
    	data = e;
    	next = n;
    }
		    
    /**
     * getter for the data in the node
     * @return the data in the node
     */
    public E getData() {
        return data;
    }

    /**
     * getter for the reference to the next node
     * @return the reference to the next node
     */
    public ListNode<E> getNext() {
    	return next;
    }

    /**
     * setter for the data in the node
     * @param ob data to be put in the node
     */
    public void setData(E e) {
        data = e;
    }
    
    /**
     * setter for the reference to the next node
     * @param n reference to the next node
     */
    public void setNext(ListNode<E> n) {
    	next = n;
    }
    
    /**
     * 
     * @param i number to compare node to
     * @return returns 1 if node is bigger, returns -1 if node is smaller, returns 0 if they're the same.
     */
    @Override
    public int compareTo(E e) {
    	return data.compareTo(e);
    }
    
    /**
     * @return the data in the node as a string
     */
    public String toString() {
    	return data.toString();
    }
}
