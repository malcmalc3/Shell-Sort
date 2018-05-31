//Programmer: Malcolm Milton
//ShellSort
//The class and method for sorting an array by shell sort
//Date: 9/25/15

import java.util.ArrayList; //ArrayList will be used to keep track of the gaps

public class ShellSort {
	
	int[] shellSort(int items[], int gapSequenceFormula)
	{
		ArrayList<Integer> gaps = new ArrayList<>(); //Creates an ArrayList called gaps
		
		int gapNumber = 0; //Variable that will add a gap size to the ArrayList gaps
		int k = 1; //Variable that increments to give different gap sizes
		if(gapSequenceFormula == 0) //If the user wants to use the equation (3^k - 1)/2, k>=1
		{	
			while(gapNumber <= items.length/3) //Executes loop if the gap size is 1/3rd or less than the length of the array
			{
				gapNumber = ((int)(Math.pow(3, k)-1)/2); //The current gap size is calculated using k
				gaps.add(gapNumber); //Adds the current gap size to the ArrayList gaps
				k++; //Increments k for the next gap size
			}
			gaps.remove(k-2); //The last gap size is not needed, and k will be 2 bigger than last index after loop
		}
		else //If the user wants to use the equation 4^k + 3 * 2^(k-1) + 1, prefixed with 1, k>=1
		{
			gaps.add(1);
			while(gapNumber <= items.length/3) //Executes loop if the gap size is 1/3rd or less than the length of the array
			{
				gapNumber = ((int)Math.pow(4, k) + 3 * (int)Math.pow(2, k-1) + 1); //The current gap size is calculated using k
				gaps.add(gapNumber); //Adds the current gap size to the ArrayList gaps
				k++; //Increments k for the next gap size
			}
			gaps.remove(k-1); //The last gap size is not needed, and k will be 1 bigger than last index after loop
		}
		
		int comparisons = 0; //Variable for keeping track of the number of comparisons
		int copies = 0; //Variable for keeping track of the number of copies
		for(int j=gaps.size()-1; j>=0; j--) //Starts at the largest gap size (last index in gaps) and loops down to the smallest
	    {
			int gap = gaps.get(j); //Variable for the current gap size, uses j to get it from ArrayList gaps
			for(int g=0; g<gap; g++) //Starts at zero and loops to the gap size to split the array into groups
			{
				for(int x=g+gap; x < items.length; x+=gap) //Starts at the second number in the group, increments by the gap size
				{
					boolean found = false; //Variable that is true when the right place for the current number is found
					int temp = items[x]; //Temporary variable for the current number in the array to be sorted 
					int i = x; //Variable used for accessing only the numbers in the group
					copies++; //A variable was changed to a new value
					while(i>=0 && !found) //Loops until the current number is now the first in the group or it's in the right place
					{
						if(i-gap >= 0 && temp < items[i-gap]) //If i isn't the first number in the group and the current number is less than the number to the left
						{
							items[i] = items[i-gap]; //Moves the number that's bigger than the current number to the right
							comparisons++; //There was a comparison in the if statement condition
							copies++; //There was one copy made inside the if statement
						}
						else //If the right place for the number is found
						{
							items[i] = temp; //The index of i is the right spot for the current number
							copies++; //There was a copy made in the statement above
							comparisons++; //There was still a comparison made to make the condition false
							found = true; //True because the correct place is found for the current number
						}
						i-=gap; //Decrements to the next left number in the group
					}
				}
			}
		}
		int[] info = {comparisons, copies}; //Makes new array called info and adds the variables comparisons and copies to it
		return info; //Returns the array to the main program for printing purposes
	}
}
