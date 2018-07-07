package githubTestProject;

import java.net.*;
import java.io.*;

public class Client implements ClientInterface{
	
	//fields
	DatagramPacket sendPacket; 
	DatagramPacket receivePacket;
	DatagramSocket sendAndReceiveSocket;
	boolean complete = false;
	
	public Client(){
		//initializing the socket to be used
		while(!complete){
			try{
				complete = true;
				sendAndReceiveSocket = new DatagramSocket();
			}catch(SocketException se){
				complete = false;
			}
		}
	}//end of constructor
	
	
	
	
	public boolean sendDatagramToLocalHost(String data){
		
		byte[] message = data.getBytes();	//get the data in an array of bytes
		
		complete = true;	//set compete as true, then if something goes wrong it will be set as false
		
		//try to create the package to be sent
		try{
			sendPacket = new DatagramPacket(message, message.length, InetAddress.getLocalHost(),5000);
		}catch(UnknownHostException se){
			complete = false;
		}
		
		//try to send the package with the data
		try{
			sendAndReceiveSocket.send(sendPacket);
		}catch(IOException e){
			complete = false;
		}
		
		return complete;
	}
	 
	
}
