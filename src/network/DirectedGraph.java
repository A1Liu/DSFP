package network;

class DirectedGraph extends Graph<Vertex<Integer>> {
	
	
	
	DirectedGraph() {
		
		}
	
	@Override
	public boolean addVertex(Integer t) {
		Vertex<Integer> v = new Vertex<Integer>(t);
		return addVertex(t,v);
	}
	
}