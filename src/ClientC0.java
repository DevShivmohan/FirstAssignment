package src;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ClientC0 {
	private static Scanner scanner = new Scanner(System.in);

	// connecting to server
	public static void connect(String host, int port) {
		try {
			Socket socket = new Socket(host, port);
			System.out.println("Server is connected " + socket.getLocalSocketAddress().toString());
			initCommunication(socket);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}

	public static void initCommunication(Socket socket) {
		try {
			if (socket.isConnected()) {
				System.out.println("Enter some input numeric value range 0 to 9");
				String inputNumber = scanner.nextLine();
				if (Pattern.matches("[0-9]+", inputNumber) && inputNumber.length() == 1) {
					// preparing to send data
					PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
					printWriter.write(Integer.parseInt(inputNumber));
					printWriter.flush();
					printWriter.close();
					System.out.println("Data sent successfully!");
					initCommunication(socket);
				} else {
					// if value are not acceptable
					System.err.println("Please enter value with given range");
					initCommunication(socket);
				}
			} else {
				socket.close();
				connect("localhost", 6999);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		connect("localhost", 6999);
	}
}
