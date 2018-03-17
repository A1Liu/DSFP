package network;

public class NodeNetwork<E> extends Network<String,Node<E>> {
	
	
	public NodeNetwork() {
		
	}
	
	@Override
	public void addVertex() {
		addVertex("N"+getDefaultID());
	}

	@Override
	public boolean addVertex(String key) {
		return this.addNode(key, null);
	}
	
	public boolean addNode(String key, E e) {
		Node<E> newNode = new Node<E>(key,e);
		return addVertex(key, newNode);
	}
}

/* --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 */

class Node<E> extends Vertex<String> {
	
	private E data;
	
	Node(String label, E e) {
		super(label);
		data = e;
	}
	
	Node(E e) {
		this(null,e);
	}
	
	/**
	 * getter for data
	 * @return data
	 */
	public E getData() {
		return data;
	}
	
	/**
	 * checks if the node is empty
	 * @return whether the node is empty
	 */
	public boolean isEmpty() {
		return data==null;
	}
}
