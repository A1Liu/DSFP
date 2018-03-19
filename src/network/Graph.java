package network;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class Graph extends Network<Character,Vertex<Character>>{

	/**
	 * Graphs have a maximum size of 95 vertices. Each vertex is labeled with a character and contains its own label and the edges coming from it.
	 */
	public Graph() {
		super((char) 48);
	}
	
	@Override
	public boolean addVertex() {
		if (getDefaultID() > 127) {
			return false;
		}
		
		
		if (addVertex((char) getDefaultID())) {
			return true;
		}
		
		int x = 48;
		while (!addVertex(x) && x<=127) {
			x++;
		}
		return true;
	}

	@Override
	public boolean addVertex(Character t) {
		if (getDefaultID()>127 || (t.toString().charAt(0) < 48))
			return false;
		Vertex<Character> v = new Vertex<Character>(t);
		return addVertex(t,v);
	}
	
	public boolean addVertex(char c) {
		Character i = (char) c;
		return addVertex(i);
	}
	
	/**
	 * add a vertex of specific index
	 * @param t the integer key of the vertex
	 * @return whether operation was successful
	 */
	public boolean addVertex(int id) {
		Character i = (char) (id+48);
		return addVertex(i);
	}
	
	/**
	 * removes a vertex with identifier id
	 * @param id identifier integer of vertex
	 * @return whether successful
	 */
	public boolean rmVertex(int id) {
		Character i = (char) id;
		return rmVertex(i);
	}
	
	/**
	 * returns the vertex of a certain id
	 * @param id identifier integer of the vertex
	 * @return vertex matching id
	 */
	public Vertex<Character> getVertex(int id) {
		Character i = (char) id;
		return getVertex(i);
	}
	
	/**
	 * adds edge of specified length from a vertex to another vertex
	 * @param v1 vertex sending edge
	 * @param v2 vertex receiving edge
	 * @param l length of edge
	 * @return whether successful
	 */
	public boolean addEdge(int v1, int v2, int l) {
		Character c1 = (char) v1;
		Character c2 = (char) v2;
		return addEdge(c1, c2, l);
	}
	
	/**
	 * adds edge of length 1 from a vertex to another vertex
	 * @param v1 vertex sending edge
	 * @param v2 vertex receiving edge
	 * @return whether successful
	 */
	public boolean addEdge(int v1, int v2) {
		Character c1 = (char) v1;
		Character c2 = (char) v2;
		return addEdge(c1, c2, 1);
	}
	
	/**
	 * removes an edge from vertex v1 to vertex v2
	 * @param v1 vertex edge is coming from
	 * @param v2 vertex edge is going to
	 * @return whether successfully removed
	 */
	public boolean rmEdge(int v1, int v2) {
		Character c1 = (char) v1;
		Character c2 = (char) v2;
		return rmEdge(c1, c2);
	}
	
	/**
	 * removes all edges from vertex v1
	 * @param v1 vertex to clear
	 */
	public boolean rmEdge(int v) {
		Character c1 = (char) v;
		return rmEdge(c1);
	}

	@Override
	protected void incrementID() {
		setDefaultID((char) (getDefaultID().toString().charAt(0)+1));
	}
}

class DirectedGraph extends Graph {
	
	public DirectedGraph() {
	}
	
}

class Web extends UndirectedGraph {
	
	public Web() {
	}
	
	@Override
	public boolean addEdge(Character v1, Character v2) {
		return super.addEdge(v1, v2) && super.addEdge(v2, v1);
	}
	
	@Override
	public boolean addEdge(Character v1, Character v2, int l) {
		return super.addEdge(v1, v2) && super.addEdge(v2, v1);
	}
}

class UndirectedGraph extends Graph {
	
	public UndirectedGraph() {
	}
	
	@Override
	public boolean addEdge(Character v1, Character v2, int l) {
		return super.addEdge(v1, v2, l) && super.addEdge(v2, v1, l);
	}
	
	@Override
	public boolean rmVertex(Character id) {
		return this.rmEdge(id) && super.rmVertex(id);
	}
	
	@Override
	public boolean rmEdge(Character v1, Character v2) {
		boolean b = super.rmEdge(v1, v2);
		return super.rmEdge(v2, v1) || b;
	}
	
	@Override
	public boolean rmEdge(Character v) {
		Vertex<Character> toDelete = getVertex(v);
		
		if (toDelete == null)
			return false;
		
		EdgeList edges = toDelete.getEdges();
		ListNode<Edge> current = edges.getFront();
		
		while(current != null) {
			current.getData().getDestination().rmEdge(toDelete);
			current=current.getNext();
		}
		
		super.rmEdge(v);
		
		return true;
	}
	
	@Override
	public int countEdges() {
		int count = 0;
		ArrayList<Vertex<Character>> vertexList = listVertices();
		for (int x = 0;x<size();x++) {
			count+=vertexList.get(x).countEdges();
		}
		return count/2;
	}
	
	/**
	 * Uses a Breadth-First Iterator instead of a standard list of edges
	 */
	@Override
	public ArrayList<EdgePair> listEdges() {

		if (size() == 0)
			return null;
		
		//creating necessary containers
		Hashtable<Character, Character> reached = new Hashtable<Character,Character>();
		ArrayList<Character> queue = new ArrayList<Character>();
		ArrayList<EdgePair> edgeList = new ArrayList<EdgePair>();
		Enumeration<Character> vertexList = enumVertices();
		ArrayList<Edge> currentEdges;
		Character currentNeighbor;
		Character start = getVertex(vertexList.nextElement()).getLabel();
		
		while (reached.size()<size()) {
			//start at a vertex
			if (!reached.contains(start)) {
				queue.add(start);
				while (queue.size() > 0) {
					currentEdges = getVertex(queue.get(0)).getEdges().toArrayList();//list of edges
					for (int x = 0; x<currentEdges.size();x++) {
						currentNeighbor = (Character) currentEdges.get(x).getDestination().getLabel(); //neighbor we're looking at
						if (!reached.contains(currentNeighbor)) {
							edgeList.add(new EdgePair(getVertex(queue.get(0)),currentEdges.get(x)));//if the neighbor hasn't been reached, add the edge
							if (!queue.contains(currentNeighbor))
								queue.add(currentNeighbor);//only add the neighbor to the queue if it wasn't reached and isn't already in the queue
						}	
					}
					reached.put(queue.get(0), queue.get(0));
					queue.remove(0);
				}
			}
			if (vertexList.hasMoreElements())
				start = vertexList.nextElement();
		}
		return edgeList;
	}

}