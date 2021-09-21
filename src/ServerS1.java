package src;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerS1 {
	private static ServerSocket serverSocket;
	private static Socket socket;

	private static int filterNumber(int num) {
		if (("" + num).length() == 2)
			return Integer.parseInt("" + ("" + num).charAt(1));
		else
			return num;
	}

	public static void connectionRequestFromC0(int port) {
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.setSoTimeout(60000); // waiting to client 30 seconds
			System.out.println("Waiting for Client request...");
			socket = serverSocket.accept();
			System.out.println("Client C0 is connected " + socket.getLocalSocketAddress().toString());
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			int receiveNumber = bufferedReader.read();
			System.out.println("Recieved by Server " + receiveNumber);
			sendClientC1(filterNumber(receiveNumber + 1));
			sendClientC2(filterNumber(receiveNumber + 2));
			sendClientC3(filterNumber(receiveNumber + 3));
			sendClientC4(filterNumber(receiveNumber + 4));
			sendClientC5(filterNumber(receiveNumber + 5));
			serverSocket.close();
			socket.close();
			connectionRequestFromC0(port);
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println(e.getMessage());
//			connectionRequestFromC0(6999);
		}
	}

	public static void main(String[] args) {
		connectionRequestFromC0(6999);
	}

	// client c1 requests
	public static void sendClientC1(int data) {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					ServerSocket serverSocket = new ServerSocket(7000);
					serverSocket.setSoTimeout(30000);
					System.out.println("Wait for client C1...");
					Socket socket = serverSocket.accept();
					System.out.println("Client C1 is connected " + socket.getLocalSocketAddress().toString());
					PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
					printWriter.write(data);
					printWriter.flush();
					printWriter.close();
					System.out.println("Data packet sent to Client C1 " + socket.getLocalSocketAddress().toString());
				} catch (Exception e) {
					// TODO: handle exception
					System.err.println(e.getMessage());
				}
			}
		});
		thread.start();
	}

	// client c2 requests
	public static void sendClientC2(int data) {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					ServerSocket serverSocket = new ServerSocket(7001);
					serverSocket.setSoTimeout(30000);
					System.out.println("Wait for client C2...");
					Socket socket = serverSocket.accept();
					System.out.println("Client C2 is connected " + socket.getLocalSocketAddress().toString());
					PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
					printWriter.write(data);
					printWriter.flush();
					printWriter.close();
					System.out.println("Data packet sent to Client C2 " + socket.getLocalSocketAddress().toString());
				} catch (Exception e) {
					// TODO: handle exception
					System.err.println(e.getMessage());
				}
			}
		});
		thread.start();
	}

	// client c3 requests
	public static void sendClientC3(int data) {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					ServerSocket serverSocket = new ServerSocket(7002);
					serverSocket.setSoTimeout(30000);
					System.out.println("Wait for client C3...");
					Socket socket = serverSocket.accept();
					System.out.println("Client C3 is connected " + socket.getLocalSocketAddress().toString());
					PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
					printWriter.write(data);
					printWriter.flush();
					printWriter.close();
					System.out.println("Data packet sent to Client C3 " + socket.getLocalSocketAddress().toString());
				} catch (Exception e) {
					// TODO: handle exception
					System.err.println(e.getMessage());
				}
			}
		});
		thread.start();
	}

	// client c4 requests
	public static void sendClientC4(int data) {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					ServerSocket serverSocket = new ServerSocket(7003);
					serverSocket.setSoTimeout(30000);
					System.out.println("Wait for client C4...");
					Socket socket = serverSocket.accept();
					System.out.println("Client C4 is connected " + socket.getLocalSocketAddress().toString());
					PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
					printWriter.write(data);
					printWriter.flush();
					printWriter.close();
					System.out.println("Data packet sent to Client C4 " + socket.getLocalSocketAddress().toString());
				} catch (Exception e) {
					// TODO: handle exception
					System.err.println(e.getMessage());
				}
			}
		});
		thread.start();
	}

	// client c5 requests
	public static void sendClientC5(int data) {
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					ServerSocket serverSocket = new ServerSocket(7004);
					serverSocket.setSoTimeout(30000);
					System.out.println("Wait for client C5...");
					Socket socket = serverSocket.accept();
					System.out.println("Client C5 is connected " + socket.getLocalSocketAddress().toString());
					PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
					printWriter.write(data);
					printWriter.flush();
					printWriter.close();
					System.out.println("Data packet sent to Client C5 " + socket.getLocalSocketAddress().toString());
				} catch (Exception e) {
					// TODO: handle exception
					System.err.println(e.getMessage());
				}
			}
		});
		thread.start();
	}
}
