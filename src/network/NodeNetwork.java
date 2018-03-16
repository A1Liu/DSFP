package network;

public class NodeNetwork<E> extends Network<String,Node<E>> {
	
	public void addVertex() {
		
	}
	
}

/* --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 * --------------------------------------------------------------------------------------------------------------------------------------------------
 */

class Node<E> extends Vertex {
	
	private E data;
	
	Node(E e) {
		data = e;
	}
	
	@Override
	public String getLabel() {
		return "Node";
	}
	
	public E getData() {
		return data;
	}
}
