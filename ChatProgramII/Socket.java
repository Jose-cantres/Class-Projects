/*
 * Jose Cantres
 * Professor Fakhouri
 * CMP 420 Mon & Wed 11-2:40
 * 4/12/19
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
//import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

public class Socket {

	public static enum SocketType {
		Broadcast, NoBroadcast
	};

	static InetAddress address;
	static int portNumber;
	static DatagramSocket mySocket;
	private Thread receiveThread;
	private static boolean receiveThreadIsRunning = true;
	private static ConcurrentLinkedQueue<DatagramPacket> messageQueue = new ConcurrentLinkedQueue<DatagramPacket>();

	public Socket(int portNumber, SocketType socketType) {

		this.portNumber = portNumber;

		try {
			this.address = InetAddress.getLocalHost();
		} catch (UnknownHostException uhe) {
			uhe.printStackTrace();
			System.exit(-1);
		}

		try {
			switch (socketType) {
			case Broadcast:
				this.mySocket = new DatagramSocket(portNumber);
				break;
			case NoBroadcast:
				this.mySocket = new DatagramSocket(portNumber, address);
				break;
			}
		} catch (SocketException se) {
			se.printStackTrace();
			System.exit(-1);
		}

		receiveThread = new Thread(new Runnable() {
			public void run() {
				receiveThread();
			}
		});
		receiveThread.setName("Receive Thread For Port = " + this.portNumber);
		receiveThread.start();
	}

	public static void receiveThread() {

		try {
			mySocket.setSoTimeout(50);
		} catch (SocketException se) {
			se.printStackTrace();
			System.exit(-1);
		}

		do {
			DatagramPacket inPacket = null;

			byte[] inBuffer = new byte[1024];
			for (int i = 0; i < inBuffer.length; i++) {
				inBuffer[i] = ' ';
			}

			inPacket = new DatagramPacket(inBuffer, inBuffer.length);

			try {
				mySocket.receive(inPacket);
				messageQueue.add(inPacket);
			} catch (SocketTimeoutException ste) {
				// nothing to do here
			} catch (IOException ioe) {
				ioe.printStackTrace();
				System.exit(-1);
			}

		} while (receiveThreadIsRunning);
		System.out.println("ReceiveThread is exiting");
	}

	private void stopReceiveThread() {
		this.receiveThreadIsRunning = false;
	}

	public static void send(String message, InetAddress destinationAddress, int destinationPort) {

		byte[] outBuffer;
		outBuffer = message.getBytes();

		DatagramPacket sendPacket = new DatagramPacket(outBuffer, outBuffer.length, destinationAddress,
				destinationPort);

		try {
			mySocket.send(sendPacket);
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.exit(-1);
		}
	}

	public static DatagramPacket receive() {
		return messageQueue.poll();
	}

	public static InetAddress getAddress() {
		return address;
	}

	public int getPortNumber() {
		return portNumber;
	}

	public void close() {
		stopReceiveThread();
		try {
			TimeUnit.MILLISECONDS.sleep(100);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
			System.exit(-1);
		}
		mySocket.close();
	}

}
