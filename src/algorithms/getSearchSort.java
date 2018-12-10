package algorithms;

import utility.Utility;

public class getSearchSort 
{

	public static void main(String[] args) 
	{
		
		Utility u = new Utility();
		long start=0, stop=0, elapsed;
		
		int arr[] = {8,4,9,12,54,87,1,2,0,4,78,89,44,65,10};
		String strArr[]= {"John", "Mady", "Aish", "Swap", "Kapil", "Bablu"};
		
		u.println("Integer Array : ");
		u.printArray(arr);
		
		u.println("\n\nString Array : ");
		u.printArray(strArr);
		
		u.print("\n\n Enter Operation to be performed on array : "
				+ "\n 1.BubbleSort on Integer Array"
				+ "\n 2.BubbleSort on String Array"
				+ "\n 3.InsertionSort on Integer Array"
				+ "\n 4.InsertionSort on String Array"
				+ "\n 5.BinarySearch on Integer Array"
				+ "\n 6.BinarySearch on String Array");
		
		int ch= u.getInt();
		
		switch(ch)
		{
		
		case 1: start = u.timer(1);
				arr=Utility.bubbleSort(arr);
				stop = u.timer(2);
				u.printArray(arr);
				u.print("\n The time taken by algorithm is : "+((stop-start)/100)+"s");
				break;
				
		case 2: start = u.timer(1);
				strArr=Utility.bubbleSort(strArr);
				stop = u.timer(2);
				u.printArray(strArr);
				u.print("\n The time taken by algorithm is : "+((stop-start)/100)+"s");
				break;
				
		case 3: start = u.timer(1);
				Utility.insertionSort(arr);
				stop = u.timer(2);
				u.printArray(arr);
				elapsed = stop-start;
				u.print("\n The time taken by algorithm is : "+elapsed/100+"s");
				break;
				
		case 4: start = u.timer(1);
				Utility.insertionSort(strArr);
				stop = u.timer(2);
				u.printArray(strArr);
				elapsed=stop-start;
				u.print("\n The time taken by algorithm is : "+elapsed/100+"s");
				break;
				
		case 5: start = u.timer(1);
				u.print("\n Enter an element to search : ");
				int searchEle = u.getInt();
				
				if((Utility.binarySearch(searchEle, arr)))
				{
					u.print("\n The Element is found");
				}
				else
				{
					u.print("\n The Element is not found");
				}
				stop = u.timer(2);
				u.print("\n The time taken by algorithm is : "+((stop-start)/100)+"s");
				break;
				
		case 6: start = u.timer(1);
				u.print("\n Enter an element to search : ");
				String searchStr = u.getString();
				//Utility.binarySearch(searchStr, strArr);
				
				if((Utility.binarySearch(searchStr, strArr)))
				{
					u.print("\n The Element is found");
				}
				else
				{
					u.print("\n The Element is not found");
				}
				stop = u.timer(2);
				u.print("\n The time taken by algorithm is : "+((stop-start)/100)+"s");
				break;
				
		default : u.print("You Entered a wrong choice \n");
		
		}

	}

}
