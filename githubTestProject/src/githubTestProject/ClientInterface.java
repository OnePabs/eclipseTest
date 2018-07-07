package githubTestProject;

//import java.net.*;
//import java.io.*;

public interface ClientInterface {
	
	//sendDatagramToLocalHost
	//sends a datagram with the string as data to the same computer it is running
	//using port 5000
	//parameter: String data used as the data to be transmitted
	//returns true if the sending was correct
	//returns false if it could not send the message
	public boolean sendDatagramToLocalHost(String data);
	
}
