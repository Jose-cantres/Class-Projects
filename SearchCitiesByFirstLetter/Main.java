//Name: Jose Cantres

import java.util.Scanner;

public class Main {
  
  public static void main (String[] args) {
    
    Scanner in = new Scanner(System.in);
    
    String[] cities = {"Airmont", "Albany", "Albion", "Alden", "Allegany", "Altamont", "Amsterdam", "Amityville", "Carmel", "Catskill", "Cairo", "Camillus", "Canandaigua", "Canton", "Oswego", "Oceanside", "Ogden", "Ogdensburg", "Olean", "Oneida"};
    
    System.out.println("Cities in the United States starting with the letters a, o and c\n");
    
    String letter, terminate;
    
    for (int i = 0; i < cities.length; i++) {
      
      System.out.println(cities[i]);
      
    }
    
    System.out.println("\nDo you want to display cities that start only with a specific letter of" + " a," + " o," + " or c? " + "Press any key to continue.");
    
   String any = in.nextLine();
    
     while (true) {  
    System.out.print("\nPress the " + "'a', " + "'o' " + "or 'c' key to get the list starting with the first letter of the cities or Press 't' to terminate program: ");
    letter = in.nextLine();
    
    if(letter.equalsIgnoreCase ("a")) 
    {
      int x = 0;
      System.out.println("Airmont");
      do {
         x++;
         System.out.println(cities[x]);
      } while (x < 7);
    x=0;
    }
     
    else if (letter.equalsIgnoreCase("c")) 
    {
      
    for (int y = 8; y < 14; y++) {
      System.out.println(cities[y]);
      
      }
    }
    else if (letter.equalsIgnoreCase("o")) 
    
    {
      
      int z = 13;
      
      while (z < 19 ) {
        z++;
        System.out.println(cities[z]);
      }
    }
  else if (!letter.equalsIgnoreCase("T")) {
    System.out.println("\nInvalid Entry! Please type 'a', 'o' or 'c' for cities starting with these letters or 't' if you would like to terminate the program!\n");
  }
  if (letter.equalsIgnoreCase("T")) {
    System.out.println("\n Program terminated. Thank you for using this program.");
    break;
  }
  }
}
}
