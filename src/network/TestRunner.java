package network;


public class TestRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestRunner a = new TestRunner();
		
		NodeNetwork<Integer> albert = new NodeNetwork<Integer>();
		albert.addVertex("hello");
		albert.addVertex("hi");
		albert.addVertex("boi");
		albert.addVertex("spoopy");
		albert.addVertex("poop");
		albert.addEdge("hello", "hi");
		albert.addEdge("hello", "boi");
		
		String x;
		x = albert.listVertices().toString();
		x = albert.toList().toString();
		x = "" + albert.getVertex("hello").countEdges();
		x = albert.cytoScape();
		System.out.println(x);
		
		
		
		a.test(1);
	}
	
	public TestRunner() {
		
	}
	
	public void test(Integer i) {
		
	}

}
