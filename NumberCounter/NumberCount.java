//Name: Jose Cantres
import java.util.Scanner;

public class NumberCount implements NumberCountInterface {
	Scanner in = new Scanner(System.in);
private int numbers[] = new int[100];
private int reader;

NumberCount () {                                      //Default Constructor
	
}
NumberCount (int numbers[], int reader) {			  //Constructor
	this.numbers = numbers;
	this.reader = reader;
}
	@Override
	public void enterNumbers() {
		int start = 0;
		System.out.println("Thank you for using the NumberCount program. When you are done entering integers enter 0 to find out how many times the number occurs.");
		System.out.print("Enter the integers between 1 and 100: ");      //Prints this out
		do {
		reader = in.nextInt();                  // Input from user
		numbers[start] = reader;                // First index will be the number that the user inputs
			start++;                            // Goes up one index and stores the next number that the user inputs
	} while (reader != 0);
}

	@Override
	public void displayAll() {
		for (int a = 0; a < numbers.length; a++) {
			   int number = 0;
			   int storage = 0;
			if ((number > numbers[a] || (number < numbers[a])) && (numbers[a] > 0 || numbers[a] < 0)) {
			    number = numbers[a];
			 
			    // Searches for new terms and it looks at the first term until the end of the array.
			    for (int b = a; b < numbers.length; b++) {
			     if (number == numbers[b]) {
			    	 storage++;
			      numbers[b] = 0; 
			     	}
			    }
			    System.out.println(number + " occurs: " + storage + " times"); //Prints out the numbers and how many times they occur.
			}
		}
	}
}
	
