import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;

public class ServerBai1 {
	
	public static String Bai1(String[] so, String[]chu, String str) {
		for(int i=0;i<so.length;i++) {
			if(str.equalsIgnoreCase(so[i]))
				return chu[i];
		}
		return "khong co so nguyen to nay";
	}
	
	public static void main(String args[])throws Exception{
		String so[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		String chu[] = {"khong", "mot", "hai", "ba", "bon", "nam", "sau", "bay", "tam", "chin"};

		DatagramSocket serverSocket = new DatagramSocket(9876);
		
		while(true) {
			byte[] receiveData = new byte[1024];
			byte[] sendData = new byte[2048];
			
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			serverSocket.receive(receivePacket);
			
			String sentence = new String(receivePacket.getData(), receivePacket.getOffset(), receivePacket.getLength());
			System.out.print(sentence);
			
			InetAddress IPAddress = receivePacket.getAddress();
			
			int port = receivePacket.getPort();
			
			String sentence_to_client = Bai1(so, chu, sentence)+ " (server accpeted!)";
			
			sendData = sentence_to_client.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);

			serverSocket.send(sendPacket); 	
		}
		
	}
}
