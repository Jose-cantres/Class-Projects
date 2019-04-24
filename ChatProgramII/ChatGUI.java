/*
 * Jose Cantres
 * Professor Fakhouri
 * CMP 420 Mon & Wed 11-2:40
 * 4/12/19
 */
import javax.swing.*;
import java.awt.*;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.DatagramPacket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.io.PrintStream;

public class ChatGUI extends JFrame implements ActionListener {

	static JLabel label;
	// message field
	static JTextField messageField;
	// Ip Field and port Field
	static JTextField ipField;
	static JTextField portField;
	// Send Button
	static JButton send;
	// Exit Button
	static JButton exit;
	// Chat Area
	static JTextArea chatArea;
	// Send button boolean
	static boolean sendEnabled;
	// the default port number
	static int port;
	private String host;
	private DatagramSocket socket;
	private InetAddress ip;
	static Socket mySocket;
	private String myName = "Jose";

	// Constructor connection receiving a socket number
	ChatGUI(Socket mySocket, String host, int port) {
		try {
			this.ip = InetAddress.getByName(host);
		} catch (UnknownHostException ex) {
			ex.printStackTrace();
			System.exit(-1);
		}
		setTitle("IP Address: " + host + "Port: " + port);

		this.port = port;
		this.host = host;

		JPanel northPanel = new JPanel(new GridLayout(3, 1));
		// The IP and the port number
		JPanel ipPort = new JPanel(new GridLayout(1, 5, 1, 3));
		// the two JTextField with default value for server address and port number
		ipField = new JTextField(host);
		portField = new JTextField("" + port);
		portField.setHorizontalAlignment(SwingConstants.RIGHT);

		ipPort.add(new JLabel("Server Address:  "));
		ipPort.add(ipField);
		ipPort.add(new JLabel("Port Number:  "));
		ipPort.add(portField);
		ipPort.add(new JLabel(""));
		northPanel.add(ipPort);

		messageField = new JTextField("");
		messageField.setBackground(Color.WHITE);
		northPanel.add(messageField);
		add(northPanel, BorderLayout.NORTH);

		// The chat room
		chatArea = new JTextArea("Welcome!\n", 80, 80);
		JPanel centerPanel = new JPanel(new GridLayout(1, 1));
		centerPanel.add(new JScrollPane(chatArea));
		chatArea.setEditable(false);
		add(centerPanel, BorderLayout.CENTER);

		// Send and Exit Button w/action listeners
		send = new JButton("Send");
		send.addActionListener(this);
		exit = new JButton("Exit");
		exit.addActionListener(this);
		exit.setEnabled(true);

		JPanel southPanel = new JPanel();
		southPanel.add(send);
		southPanel.add(exit);
		add(southPanel, BorderLayout.SOUTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
		setVisible(true);
		messageField.requestFocus();

	}

	void newWindow() {
		JPanel northPanel = new JPanel(new GridLayout(3, 1));

		// the server name and the port number
		JPanel ipAddrPort = new JPanel(new GridLayout(1, 5, 1, 3));
		ipField = new JTextField(host);
		portField = new JTextField("" + port);
		portField.setHorizontalAlignment(SwingConstants.RIGHT);

		// IP Address and Port Field
		ipAddrPort.add(new JLabel("IP Address:  "));
		ipAddrPort.add(ipField);
		ipAddrPort.add(new JLabel("Port Number:  "));
		ipAddrPort.add(portField);
		ipAddrPort.add(new JLabel(""));

		// add IP and port field to the GUI
		northPanel.add(ipAddrPort);

		messageField = new JTextField("");
		messageField.setBackground(Color.WHITE);
		northPanel.add(messageField);
		add(northPanel, BorderLayout.NORTH);

		// The chat room panel
		chatArea = new JTextArea("Welcome to the Chat room\n", 80, 80);
		JPanel centerPanel = new JPanel(new GridLayout(1, 1));
		centerPanel.add(new JScrollPane(chatArea));
		chatArea.setEditable(false);
		add(centerPanel, BorderLayout.CENTER);

		// The 2 buttons
		send = new JButton("Send");
		send.addActionListener(this);
		exit = new JButton("Exit");
		exit.addActionListener(this);
		exit.setEnabled(true);

		JPanel southPanel = new JPanel();
		southPanel.add(send);
		southPanel.add(exit);
		add(southPanel, BorderLayout.SOUTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 600);
		setVisible(true);
		messageField.requestFocus();
	}

	// append text in the chat area
	void append(String str) {
		chatArea.append(str);
		chatArea.setCaretPosition(chatArea.getText().length() - 1);
	}
	
	public static void receiveDataBroadCast() {
			DatagramPacket inPacket = null;

			do {

				try {
					inPacket = mySocket.receive();

					if (inPacket != null) {

						String message = new String(inPacket.getData());
						String ip = inPacket.getAddress().getHostAddress();
						ChatGUI chat = null;

						String[] space = message.split(" ");

						if (message.contains("?????") && space[1].equalsIgnoreCase("jose")) {
							chat = new ChatGUI(mySocket, ip, 64000);
							chat.setTitle("Name: " + space[3] + " IP Address: " + ip);
							mySocket.send("##### " + space[1] + " ##### " + mySocket.getAddress().getHostAddress(), inPacket.getAddress(), 64000);
							StartGUI.storingBroadCastTable.put(ip, chat);
							chat.setVisible(true);

						} else if(message.contains("##### " + ip)) {
							chat = new ChatGUI(mySocket, ip, 64000);
							chatArea.append("Person Of Interest: " + message + "\n");
							chat = StartGUI.storingBroadCastTable.put(ip, chat);
							chat.setVisible(true);
						}
					
						if (StartGUI.storingBroadCastTable.containsKey(ip)) {
							chat = StartGUI.storingBroadCastTable.get(ip);
							chatArea.append("Person Of Interest: " + message + "\n");
							chat.setVisible(true);
						}

					}
				} catch (Exception ex) {
				}
			} while (true);
		}

	// If buttons are clicked
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();

		// If exit button is clicked
		if (o == exit) {
			// Close socket
			mySocket.close();
			// Exit the program
			System.exit(-1);
			return;
		}
		// If send button is Enabled/clicked
		if (send.isEnabled()) {
			System.out.println("Send Button was pressed");
			System.out.println("My Address = " + mySocket.getAddress().getHostAddress());

			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
				System.exit(-1);
			}
			System.out.println("Just Woke UP!!");

			// If send button is clicked
			if ((o == send)) {
				mySocket.send(messageField.getText(), ip, Integer.parseInt(StartGUI.tPortNumber.getText()));
				chatArea.append(myName + ": " + messageField.getText() + "\n");
				messageField.requestFocusInWindow();
			}
			else {
				//do nothing
		}
	}
		String server = ipField.getText().trim();
		if (server.length() == 0)
			return;
		String portNumber = portField.getText().trim();
		if (portNumber.length() == 0)
			return;
		try {
			port = Integer.parseInt(portNumber);
		} catch (Exception ex) {
			return;
		}
		messageField.setText("");
		// disable the IP textfield
		ipField.setEditable(false);
		// disable the port textfield
		portField.setEditable(false);
	}
}
