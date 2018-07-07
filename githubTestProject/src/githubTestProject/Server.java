package githubTestProject;

import java.net.*;
//import java.io.*;

public class Server {
	//fields
	private DatagramPacket receivePacket;
	private DatagramSocket sendAndReceiveSocket;
	private boolean complete;
	
	
	//constructor
	public Server(){
		//creates a socket for sending and receiving packets
		complete = false;
		while(!complete){
			try{
				//create datagram socket using prot 5000
				complete =true; //used in the while loop
				sendAndReceiveSocket = new DatagramSocket(5000);
			}catch(SocketException se){
				complete = false;
			}
		}
	}//end constructor
	
	
	
	public boolean receiveAndPrintPackage(){
		complete = false; //starts with complete false
		
		//create a datagram packet to hold the information of received datagram packets
		
		
		return complete;
	}
	
	
}
