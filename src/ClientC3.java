package src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientC3 {
	public static void recieveDataPacket(String host, int port) {
		try {
			Socket socket = new Socket(host, port);
			System.out.println("Server is connected " + socket.getLocalSocketAddress().toString());
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			int dataPacket = bufferedReader.read();
			System.out.println("DataPacket recieved " + dataPacket);
			socket.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		recieveDataPacket("localhost", 7002);
	}
}
