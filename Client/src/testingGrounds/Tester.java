package testingGrounds;

import network.NodeNetwork;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NodeNetwork<Integer> albert = new NodeNetwork<Integer>();
		albert.addVertex("hello");
		albert.addVertex("hi");
		albert.addVertex("boi");
		albert.addVertex("spoopy");
		albert.addVertex("poop");
		albert.addEdge("hello", "hi",3);

		String x = albert.keys().toString();
		System.out.println(x);
	}

}
