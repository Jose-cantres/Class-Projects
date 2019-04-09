//Name: Jose Cantres

import java.util.Scanner;

public class Dice {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String fNumber;										  //Variable used for user input.
		String sNumber;										  //Variable used for second user input.
		int r = (int)(Math.random()*6) + 1;                   //Creating the first die ranging from numbers 1-6 called r.
		int r2 = (int)(Math.random()*6) + 1;				  //Creating the second die ranging from numbers 1-6 called r2.
		int sum;											  //Creating a variable to use later in the program to add the sum of the two dies previously created.
		
		System.out.println("Welcome to the dice program! Click on any key to begin rolling the dice and getting your sum!"); //Prints the start of the program.
		fNumber = in.nextLine();							  //User input - moves to the next line.
		System.out.println("The first die comes up " + r);    //Prints the first roll.
		sNumber = in.nextLine();							  //Second user input - moves to the next line.
		System.out.println("The second die comes up " + r2);  //Prints the second roll.
		sum = r + r2;										  //Adds the two sums of the dies rolled.
		System.out.println("\nYour total roll is " + sum);    //Prints the sum of the dies rolled.
	}

}
