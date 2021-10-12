import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class ClientBai1 {
	public static void main(String args[]) throws Exception{
		
		DatagramSocket clientSocket = new DatagramSocket(6789);
		
		InetAddress IPAddress = InetAddress.getByName("localhost");
		
		while(true) {
			byte[] sendData = new byte[1024];
			byte[] receiveData = new byte[2048];
			
			BufferedReader inFormUser = new BufferedReader(new InputStreamReader(System.in));
			String sentence = inFormUser.readLine();
			
			sendData = sentence.getBytes();
			
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
			clientSocket.send(sendPacket);
			
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			clientSocket.send(receivePacket);
			
			String modified_Sentence = new String(receivePacket.getData());
			System.out.println("FROM SERVER: " + modified_Sentence);
			
			if(sentence.compareTo("quit") == 0)
				break;
		}
		
		clientSocket.close();
	}
}

