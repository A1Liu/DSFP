package network;

class DirectedGraph extends Graph<Vertex<Character>> {
	
	
	
	public DirectedGraph() {
		
		}
	
	@Override
	public boolean addVertex(Character t) {
		if (getDefaultID()>127 || (t.toString().charAt(0) < 48))
			return false;
		Vertex<Character> v = new Vertex<Character>(t);
		return addVertex(t,v);
	}
	
}