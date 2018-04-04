package network;

import static util.IOUtil.readFile;
import static util.IOUtil.isNumber;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

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