import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
class EchoServer {


	public static void main(String args[]) throws Exception {
		DatagramSocket d = new DatagramSocket(9090);
		byte[] recieved  = new byte[1024];

    while(true) {
		  DatagramPacket dp = new DatagramPacket(recieved, recieved.length); // Constructs a DatagramPacket for receiving packets of length length.
		  d.receive(dp);
		  InetAddress ipAddress = dp.getAddress();
		  String message = new String(dp.getData());
		  System.out.println(ipAddress + " " + message);
      int clientPort = dp.getPort();
      byte[] sendBuffer = message.getBytes();
      InetAddress clientAddress = dp.getAddress();
      DatagramPacket dp1 = new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress, clientPort);
      d.send(dp1);
    }
	}

}
