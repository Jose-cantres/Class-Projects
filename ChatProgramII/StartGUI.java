/*
 * Jose Cantres
 * Professor Fakhouri
 * CMP 420 Mon & Wed 11-2:40
 * 4/12/19
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.net.DatagramPacket;
import java.net.InetAddress;

public class StartGUI extends JFrame implements ActionListener {
	// The start button
	private JButton startButton;
	// The Broadcast checkbox
	private JCheckBox broadcastBox;
	// JTextArea for the chat
	static JTextArea chat;
	// The port number field
	static JTextField tPortNumber;
	// The ip address field
	static JTextField tIpAddress;
	// The name field
	static JTextField tName;
	// StoringTable
	static HashMap<String, ChatGUI> storingTable = new HashMap<>();
	// Array list to store ips
	static ArrayList<String> ipList = new ArrayList<String>();
	static HashMap<String, ChatGUI> storingBroadCastTable = new HashMap<>();
	// Broadcast is false;
	static boolean broadcast = false;
	//Name
	private String name;
	private static boolean noBroadcast = false;
	private final String bIP ="255.255.255.255";

	public StartGUI() {
		ChatGUI.mySocket = new Socket(64000, Socket.SocketType.Broadcast);
		// Title for the program
		setTitle("Jose's Chat Program");
		JPanel north = new JPanel();
		
		//Add name field
		north.add(new JLabel("Name: "));
		tName = new JTextField("jose");
		north.add(tName);
				
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
		
		//Add the broadcast checkbox button
		broadcastBox = new JCheckBox("Broadcast");
		broadcastBox.addActionListener(this);
		north.add(broadcastBox);
		add(north, BorderLayout.WEST);
		
		
		// To start the chat with Start Button
		startButton = new JButton("Start");
		startButton.addActionListener(this);
		north.add(startButton);
		add(north, BorderLayout.NORTH);

		// The chat room
		JPanel center = new JPanel(new GridLayout(1, 1));
		add(center);
		setSize(600, 100);
		setVisible(true);
	}

	// append message to text areas and set the position
	void chatRoom(String str) {
		chat.append(str);
		chat.setCaretPosition(chat.getText().length() - 1);
	}

	// start when the start button is clicked/enabled
	public void actionPerformed(ActionEvent e) {
		if (broadcastBox.isSelected()){
			broadcast = true;
			setVisible(false);
			String theName = tName.getText();
			String message = "????? " + theName + " ##### jose";
			if (!theName.isEmpty()) {
				
				try {
					ChatGUI.mySocket.send(message, InetAddress.getByName(bIP), 64000);
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				
				tName.setText("");
	  }
  }
}
