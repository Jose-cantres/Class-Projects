//Jose Cantres
import java.util.Scanner;
public class BinaryToDecimal {
	
public static void main(String[] args) {
	int binary;
	int decimal = 0; 
	int theStart = 0; 									// The start of the powers	

Scanner in = new Scanner(System.in);
System.out.println("Welcome to the Binary to Decimal program. Please enter a binary (0 to 1 only numbers) to convert to a decimal");
binary = in.nextInt(); 									// User input

	while(binary != 0) {
	decimal += ((binary%10) * Math.pow(2, theStart));   //decimal variable will change based on formula of 1 * 2 ^ (theStart which is 0) which will add to the original decimal variable as it loops.
	binary = binary/10;
	theStart++;											//add to the variable of theStart increasing it from 0 to 1 and so on thus changing the formula 2 lines above.
}
System.out.println(decimal);                            //prints the total number of the decimal variable after loop is finished
	}

}
