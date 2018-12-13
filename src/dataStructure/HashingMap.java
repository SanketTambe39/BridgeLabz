package dataStructure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import utility.Utility;

public class HashingMap 
{
	
	public static void main(String[] args) throws FileNotFoundException
	{		
		
		HashingFunction<Integer> h1= new HashingFunction<Integer>();
		
		File file=new File("numList.txt");
		
		Scanner sc = new Scanner(file);
		
		Utility u =new Utility();
		
		String str[]=sc.nextLine().split(" ");
	
		sc.close();
		Integer arr[] =new Integer[str.length];
		
		for(int i=0; i<str.length; i++)
		{
			arr[i]=Integer.parseInt(str[i]);
		}
		
		h1.createEmptySlot();
		
		h1.hashFunction(arr);

		while(true)
		{
			System.out.print("\n *****************\n 1. Search \n 2. Push \n "
					+ "3. Pop \n 4. Display \n 5. Exit \n Enter a choice : ");
		
			int ch = u.getInt();
			int ele;
			switch(ch)
			{
			
			case 1: System.out.println("\n Enter an element to search in hash map : ");
					ele = u.getInt();
					h1.search(ele);
					break;
					
			case 2: System.out.println("\n Enter an element to push in hash map : ");
					ele = u.getInt();
					h1.push(ele);
					break;
					
			case 3: System.out.println("\n Enter an element to pop in hash map : ");
					ele = u.getInt();
					h1.pop(ele);
					break;
					
			case 4: h1.display();
					break;
					
			case 5: return;
			}
		
		}
		
	}


}
