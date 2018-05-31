//Programmer: Malcolm Milton
//ShellSortTest
//The main class for testing the shellSort method
//Date: 9/25/15

import java.util.Arrays; //Need to import to print an array easily
import java.util.Random; //For generating random numbers
import java.util.Scanner; //For getting input from the user

public class ShellSortTest {

	public static void main(String[] args) {
		
		ShellSort sort = new ShellSort(); //Makes new instance of ShellSort class 
		Scanner reader = new Scanner(System.in); //Makes new instance of Scanner class for user input
		
		System.out.println("Please choose a seed for random numbers:"); 
		Random seed = new Random(reader.nextInt()); //Variable for getting seed for randomization
		
		System.out.println("\nPlease choose gap sequence formula");
		System.out.println("Enter 0 for: (3^k–1)/2");
		System.out.println("Enter 1 for:  4^k+3·2^(k-1)+1");
		int formula = reader.nextInt(); //Variable for passing in the formula that the user wants to use into the method
		
		System.out.println("\nWhat should the size of the array be?");
		int item[] = new int[reader.nextInt()]; //Makes new array that will be the size of the user's input
		
		System.out.println("\nWhat could the smallest number in the array be?");
		int smallest = reader.nextInt(); //User input for what the smallest number in array should be
		System.out.println("What could the largest number in the array be?");
		int largest = reader.nextInt() - smallest; //Subtracts the smallest number so a number from 0 to (largest-smallest) will be generated 
		
		for(int x=0; x<item.length; x++) //Starts at 0, loops to the last index in array
			item[x] = seed.nextInt(largest) + smallest; //Generates a number from 0 to (largest-smallest) then adds smallest to make it in the range of smallest to largest
		
		reader.close(); //Closes the user input
		System.out.println("\nUnsorted: " + Arrays.toString(item)); //Prints out the array before sorting
		int[] info = sort.shellSort(item, formula); //Calls the method to sort the array using the specified formula
		System.out.println("Sorted: " + Arrays.toString(item)); //Prints the array after sorting
		System.out.println("Comparisons: " + info[0] + "\nCopies: " + info[1]); //Prints the amount of copies and comparisons
	}

}