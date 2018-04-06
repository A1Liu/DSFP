package network;

import java.io.IOException;
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
		
		String path = "lib/Network.csv";
		String outPath = "out/Iterations.csv";
		path = "C:/Users/Alyer/Desktop/Network.csv";
		graph.loadNetwork(path);
		
		writeFile(outPath,graph.updateCSV(10));
	}

}
