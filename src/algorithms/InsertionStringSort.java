package algorithms;

import utility.Utility;

public class InsertionStringSort 
{

	public static void main(String[] args) 
	{
		
		Utility u =new Utility();
		//u.print("hi...............");
		u.print("Enter Words for an array\n\n");
		String line = u.getLine();
		String wordList[]= line.split(" ");
		u.print("\nUnsorted List is \n");
		u.printArray(wordList);
		//u.print("hi...............");
		wordList=Utility.insertionSort(wordList);
		u.print("\n \nSorted List is \n");
		u.printArray(wordList);

	}

}
