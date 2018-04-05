package network;

public class NodeNetwork<E> extends Network<String,Node<E>> {
	
	
	public NodeNetwork() {
		super("0");
	}
	
	@Override
	public boolean addVertex() {
		return addVertex("N"+getDefaultID());
	}

	@Override
	public boolean addVertex(String key) {
		return this.addNode(key, null);
	}
	
	/**
	 * Add a node
	 * @param key the key value for the node
	 * @param e the data the nodes in the network hold
	 * @return true if a node was successfully created
	 */
	public boolean addNode(String key, E e) {
		Node<E> newNode = new Node<E>(key,e);
		return addVertex(key, newNode);
	}

	@Override
	protected void incrementID() {
		// TODO Auto-generated method stub
		
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
	E getData() {
		return data;
	}
	
	/**
	 * checks if the node is empty
	 * @return whether the node is empty
	 */
	boolean isEmpty() {
		return data==null;
	}
}