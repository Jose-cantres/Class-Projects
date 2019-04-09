//Jose Cantres
import java.util.Scanner;
public class DecimalToBinary {
	static int decimal;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Welcome to the Decimal To Binary program. Please enter a decimal to convert to a Binary.");
		decimal = in.nextInt();                      //User input
		int binary[] = new int [15];				 //Array of the binary numbers needed to be printed out
		int theStart = 0;							 //The start of the array
		while (decimal > 0) {						 
		binary[theStart] = decimal%2;				//The start of the array will be the remainder of the first number.
		theStart++;									//Increase the start of the array to the next element in the array which would be 1 then 2 and so on.
		decimal = decimal/2;						//Formula to divide the number by 2.
	}
		for (int b = theStart-1; b >= 0; b--)       //Loop to make the numbers from right to left
		System.out.print(binary[b]);                //Print out the array of binary numbers which are the remainders of the numbers divided by 2 from bottom to top or right to left.
}
}
