/*
 * Jose Cantres
 * 4/2/19
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.net.DatagramPacket;

public class StartGUI extends JFrame implements ActionListener {
	// The start button
	private JButton startButton;
	// JTextArea for the chat
	static JTextArea chat;
	// The port number field
	static JTextField tPortNumber;
	// The ip address field
	static JTextField tIpAddress;
	// StoringTable
	static HashMap<String, ChatGUI> storingTable = new HashMap<>();
	// Array list to store ips
	private ArrayList<String> ipList = new ArrayList<String>();

	public StartGUI() {
		ChatGUI.mySocket = new Socket(64000, Socket.SocketType.NoBroadcast);
		// Title for the program
		setTitle("Jose's Chat Program");
		JPanel north = new JPanel();

		// IP Address Label
		north.add(new JLabel("Ip Address: "));

		// Add the field for IP Address
		tIpAddress = new JTextField("192.168.1.1");
		north.add(tIpAddress);

		// Add Port Label
		north.add(new JLabel("Port: "));

		// Add field for the Port
		tPortNumber = new JTextField("64000");
		north.add(tPortNumber);

		// To start the chat with Start Button
		startButton = new JButton("Start");
		startButton.addActionListener(this);
		north.add(startButton);
		add(north, BorderLayout.NORTH);

		// The chat room
		JPanel center = new JPanel(new GridLayout(1, 1));
		add(center);
		setSize(350, 100);
		setVisible(true);
	}

	StartGUI(int port, String ipAddress) {

	}

	// append message to text areas and set the position
	void chatRoom(String str) {
		chat.append(str);
		chat.setCaretPosition(chat.getText().length() - 1);
	}

	// start when the start button is clicked/enabled
	public void actionPerformed(ActionEvent e) {
		int port;
		if (startButton.isEnabled()) {
			try {
				String address = tIpAddress.getText();
				if (!ipList.contains(address)) {
					port = Integer.parseInt(tPortNumber.getText().trim());
					ipList.add(address);
					System.out.println("Ip Address not found! Let's add it to the list...IP added!");

					// Create the new ChatGUI window.
					enterScreen(ChatGUI.mySocket, address, port);
					// Fields should not be changed
					ChatGUI.ipField.setEditable(false);
					ChatGUI.portField.setEditable(false);
					ChatGUI.messageField.addActionListener(this);
					ChatGUI.messageField.setText("");
				} else {
					System.out
							.println("Ip Address found so you can't create a new window to chat if it's already open!");
				}
			} catch (Exception ex) {
				System.out.println("Exception Occured");
			}
		}
	}

	// Create window after start
	private void enterScreen(Socket mySocket, String address, int port) {
		new ChatGUI(mySocket, address, port);
	}
}
