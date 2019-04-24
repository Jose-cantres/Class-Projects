/*
 * Jose Cantres
 * Professor Fakhouri
 * CMP 420 Mon & Wed 11-2:40
 * 4/12/19
 */
public class Driver {

	public static void main(String[] arg) {
		StartGUI server = new StartGUI();
		do {
			ChatGUI.receiveDataBroadCast();
		} while (true);
	} 
}
