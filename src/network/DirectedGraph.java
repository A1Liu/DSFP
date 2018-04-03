package network;

import static util.IOUtil.readFile;
import static util.IOUtil.isNumber;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

class DirectedGraph extends Graph {
	
	
	
	public DirectedGraph() {
		
		}
	
}

/**
 * need to make new vertex object that holds values, otherwise this will become complicated quickly
 * @author liu_albert
 *
 */
class RatingsGraph extends Graph {
	
	private Hashtable<Character,Double> values;
	
	public RatingsGraph() {
		values = new Hashtable<Character,Double>();
	}
	
	public void update() {
		ArrayList<Character> names = this.keys();
		ArrayList<Double> newValues = new ArrayList<Double>();
		
		for (int x = 0; x< names.size(); x++) {
			
		}
	}
	
	private Double updateVertex(Character t) {
		
		EdgeList edges = this.getVertex(t).getEdges();
		
		return null;
	}
	
	@Override
	public boolean addVertex(Character t) {
		
		if (super.addVertex(t) && addEdge(t,t,1)) {
			values.put(t, 1.0);
			return true;
		} 
		return false;
	}
	
	/**
	 * loads egdges into the network
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
		
		if (edge.length < 3)
			return;
		
		if(edge[0].length()==1 || isNumber(edge[0])) {
			if (edge[1].length()==1 || isNumber(edge[1])) {
				int id1;
				int id2;
				
				if(getVertex(edge[0].charAt(0))==null && getVertex(Integer.parseInt((edge[0]))) == null) {
					if (isNumber(edge[0])) {
						id1 = Integer.parseInt(edge[0]);
						addVertex(id1);
						addEdge(id1,id1,1);
					} else {
						id1 = edge[0].charAt(0)-48;
						addVertex(id1);
						addEdge(id1,id1,1);
					}
				} else {
					if (isNumber(edge[0])) {
						id1 = Integer.parseInt(edge[0]);
					} else {
						id1 = edge[0].charAt(0)-48;
					}
				}
				
				if(getVertex(edge[1].charAt(0))==null && getVertex(Integer.parseInt((edge[1]))) == null) {
					if (isNumber(edge[1])) {
						id2 = Integer.parseInt(edge[1]);
						addVertex(id2);
						addEdge(id2,id2,1);
					} else {
						id2 = edge[1].charAt(0)-48;
						addVertex(id2);
						addEdge(id2,id2,1);
					}
				} else {
					if (isNumber(edge[0])) {
						id2 = Integer.parseInt(edge[0]);
					} else {
						id2 = edge[0].charAt(0)-48;
					}
				}
				
				if (isNumber(edge[2]))
					addEdge(id1,id2,Integer.parseInt(edge[2]));
				else
					addEdge(id1,id2,1);
			}
		}
	}
	
	@Override
	public void incrementID() {
		return;
	}
}