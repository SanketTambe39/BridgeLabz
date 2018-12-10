package algorithms;

import utility.Utility;

public class MergeSort 
{

	public static void main(String[] args) 
	{
		Utility u = new Utility();
		
		u.print("\n Enter the number of elements you want to insert");
		int n= u.getInt();
		
		u.print("\n Enter Elements :");
		int arr[]= u.readArray(n);
		
		u.print("\n Unorted Array is :");
		u.printArray(arr);
		
		u.mergeSort(arr, 0, arr.length-1);
		
		u.print("\n Sorted Array is :");
		u.printArray(arr);

	}

}
