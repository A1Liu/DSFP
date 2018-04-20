package testingGrounds;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ExampleClient {
    public static void main( String[] args ) {
        String server = "127.0.0.1";//can be localhost or ip address

        System.out.println( "Loading contents of URL: " + server );

        try {
            // Connect to the server
            Socket socket = new Socket( server, 1100 );

            // Create input and output streams to read from and write to the server
            PrintStream out = new PrintStream( socket.getOutputStream() );
            BufferedReader in = new BufferedReader( new InputStreamReader( socket.getInputStream() ) );

            BufferedReader consoleLine;
            boolean on = true;
            String userIn;
            while (on) {
            	consoleLine = new BufferedReader (new InputStreamReader(System.in) );
            	userIn = consoleLine.readLine();
            	if (userIn.equals("stop")) {
            		on = false;
            	} else {
            		out.println(userIn);
            		String line = in.readLine();
                    while( line != null) {
                        System.out.println( line );
                        line = in.readLine();
                    }
            	}
            	if(!on) {
            		in.close();
            		out.close();
            		socket.close();
            	}
            }
        } catch( Exception e ) {
            e.printStackTrace();
        }
    }
}
