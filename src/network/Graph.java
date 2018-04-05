package network;

import static util.IOUtil.isNumber;
import static util.IOUtil.readFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public abstract class Graph<T extends Vertex<Integer>> extends Network<Integer,T>{

	/**
	 * 
	 */
	protected Graph() {
		super(0);
	}
	
	@Override
	public boolean addVertex() {
		if (addVertex(getDefaultID())) {
			return true;
		}
		int x = 0;
		while (!addVertex(x)) {
			x++;
		}
		return true;
	}

	@Override
	protected void incrementID() {
		setDefaultID(getDefaultID() + 1);
	}
	
	/**
	 * loads edges into the network
	 * @param document the name of the document to add from
	 * @throws IOException if the document doesn't exist
	 */
	public void loadNetwork(String document) throws IOException {
		ArrayList<String> input = readFile(document);
		String[] line;
		for (int x = 0; x< input.size(); x++) {
			line = input.get(x).split(",");
			loadEdge(line);
		}
	}
	
	/**
	 * loads an edge into the network given an array of strings
	 * @param edge the array of strings to input
	 */
	private void loadEdge(String[] edge) {
		
		if (edge.length < 3) {return;}
		
		for (int x = 0; x < 3; x++) {
			if (!isNumber(edge[x])) {return;}
		}

		int id1 = Integer.parseInt(edge[0]);
		int id2 = Integer.parseInt(edge[1]);
		
		if (getVertex(Integer.parseInt((edge[0]))) == null) {
			addVertex(id1);
		}
		if (getVertex(Integer.parseInt((edge[1]))) == null) {
			addVertex(id2);
		}	
		addEdge(id1,id2,Integer.parseInt(edge[2]));
 	}
}

class Web extends UndirectedGraph {
	
	Web() {
	}
	
	@Override
	public boolean addEdge(Integer v1, Integer v2, int l) {
		return super.addEdge(v1, v2);
	}
}

class UndirectedGraph extends Graph<Vertex<Integer>> {
	
	UndirectedGraph() {
	
	}
	
	@Override
	public boolean addVertex(Integer t) {
		Vertex<Integer> v = new Vertex<Integer>(t);
		return addVertex(t,v);
	}
	
	@Override
	public boolean addEdge(Integer v1, Integer v2) {
		return super.addEdge(v1, v2) && super.addEdge(v2, v1);
	}
	
	@Override
	public boolean addEdge(Integer v1, Integer v2, int l) {
		return super.addEdge(v1, v2, l) && super.addEdge(v2, v1, l);
	}
	
	@Override
	public boolean rmVertex(Integer id) {
		return this.rmEdge(id) && super.rmVertex(id);
	}
	
	@Override
	public boolean rmEdge(Integer v1, Integer v2) {
		boolean b = super.rmEdge(v1, v2);
		return super.rmEdge(v2, v1) || b;
	}
	
	@Override
	public boolean rmEdge(Integer v) {
		Vertex<Integer> toDelete = getVertex(v);
		
		if (toDelete == null)
			return false;
		
		EdgeList edges = toDelete.getEdges();
		
		for (int x = 0; x < edges.size(); x++) {
			edges.get(x).getDestination().rmEdge(toDelete);
		}
		super.rmEdge(v);
		
		return true;
	}
	
	@Override
	public int countEdges() {
		int count = 0;
		ArrayList<Vertex<Integer>> vertexList = listVertices();
		for (int x = 0;x<size();x++) {
			count+=vertexList.get(x).countEdges();
		}
		return count/2;
	}
	
	@Override
	public ArrayList<EdgePair> listEdges() {

		if (size() == 0)
			return null;
		
		//creating necessary containers
		Hashtable<Integer, Boolean> reached = new Hashtable<Integer,Boolean>();
		ArrayList<Integer> queue = new ArrayList<Integer>();
		ArrayList<EdgePair> edgeList = new ArrayList<EdgePair>();
		Enumeration<Integer> vertexList = enumVertices();
		ArrayList<Edge> currentEdges;
		Integer currentNeighbor;
		Integer start = getVertex(vertexList.nextElement()).getLabel();
		
		while (reached.size()<size()) {
			//start at a vertex
			if (!reached.containsKey(start)) {
				queue.add(start);
				while (queue.size() > 0) {
					currentEdges = getVertex(queue.get(0)).getEdges();//list of edges
					for (int x = 0; x<currentEdges.size();x++) {
						currentNeighbor = (Integer) currentEdges.get(x).getDestination().getLabel(); //neighbor we're looking at
						if (!reached.containsKey(currentNeighbor)) {
							edgeList.add(new EdgePair(getVertex(queue.get(0)),currentEdges.get(x)));//if the neighbor hasn't been reached, add the edge
							if (!queue.contains(currentNeighbor))
								queue.add(currentNeighbor);//only add the neighbor to the queue if it wasn't reached and isn't already in the queue
						}	
					}
					reached.put(queue.get(0), true);
					queue.remove(0);
				}
			}
			if (vertexList.hasMoreElements())
				start = vertexList.nextElement();
		}
		return edgeList;
	}
}