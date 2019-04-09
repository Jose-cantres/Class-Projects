//Name: Jose Cantres
public class Driver {

	public static void main(String args[]) {

		Driver.startApplication();

	}

	public static void startApplication() {

		NumberCount app = new NumberCount();
		app.enterNumbers();
		app.displayAll();

	}

}
