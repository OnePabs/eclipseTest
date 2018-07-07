package githubTestProject;

import java.net.*;
import java.io.*;

public class Client implements ClientInterface{
	
	//fields
	DatagramPacket sendPacket; 
	DatagramPacket receivePacket;
	DatagramSocket sendAndReceiveSocket;
	byte[] packetbytes = new byte[512];
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
	 
	
	public byte[] formatSendMessage(String message){
		//formats a send data message to be sent by the client using lab specifications
		//parameters: String representing the message
		//output: a 512 byte array which has the send specifications as stated in the lab
		
		byte[] formatedMessage = new byte[512];
		byte[] byteMessage = message.getBytes();
		byte[] mode = "octet".getBytes();
		int endIndex = 0; //points to the place where the next byte is to be written to
		
		//initialize the first two bytes
		formatedMessage[endIndex++] = 0;
		formatedMessage[endIndex++] = 1;
		
		
		//get the message into the formatedMessage
		for(int i=0; i< message.length();i++){
			formatedMessage[endIndex++] =  byteMessage[i];
		}
		
		formatedMessage[endIndex++] = 0; //insert a zero
		
		//insert the mode
		for(int i=0;i<mode.length;i++){
			formatedMessage[endIndex++] = mode[i];
		}
		
		formatedMessage[endIndex++] = 0;//insert zero byte
		
		return formatedMessage;
	}
	
	public byte[] formatReadMessage(String message){
		//formats a send data message to be sent by the client using lab specifications
		//parameters: String representing the message
		//output: a 512 byte array which has the send specifications as stated in the lab
		
		byte[] formatedMessage = new byte[512];
		byte[] byteMessage = message.getBytes();
		byte[] mode = "octet".getBytes();
		int endIndex = 0; //points to the place where the next byte is to be written to
		
		//initialize the first two bytes
		formatedMessage[endIndex++] = 0;
		formatedMessage[endIndex++] = 2;
		
		
		//get the message into the formatedMessage
		for(int i=0; i< message.length();i++){
			formatedMessage[endIndex++] =  byteMessage[i];
		}
		
		formatedMessage[endIndex++] = 0; //insert a zero
		
		//insert the mode
		for(int i=0;i<mode.length;i++){
			formatedMessage[endIndex++] = mode[i];
		}
		
		formatedMessage[endIndex++] = 0;//insert zero byte
		
		return formatedMessage;
	}
}
