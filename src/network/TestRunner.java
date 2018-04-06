package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static util.IOUtil.writeFile;

/**
 * This class is the test harness for methods in the network package.
 * 
 * @author Alyer
 *
 */
public class TestRunner {

	public static void main(String[] args) throws IOException, IllegalArgumentException, InterruptedException {
		
		RatingsGraph graph = new RatingsGraph();
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String edge = "";
		String outPath = "out/Iterations.csv";
		String path = "lib/Network.csv";
		path = "C:/Users/Alyer/Desktop/Network.csv";
		
		while (!edge.equals("foo")) {
			edge = input.readLine();
			graph.loadEdge(edge);
			System.out.println(graph.keys());
			
			writeFile(outPath,graph.updateCSV(10));
		}
		
		
		
		
		
		
	}

}
