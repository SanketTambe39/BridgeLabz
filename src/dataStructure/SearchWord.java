package dataStructure;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

import utility.Utility;

public class SearchWord 
{

	public static void main(String []args) throws IOException
	{
		
		File file= new File("wordlist.txt");
		Utility u= new Utility();
		Scanner sc= new Scanner(file);
		LinkedList<String> list= new LinkedList<String>();
		
		String str[]=sc.nextLine().split(" ");
		
		for(int i=0; i<str.length; i++)
		{
			list.add(str[i]);
		}
		while(true)
		{
			
			u.print("\n Enter a choice \n 1. Search a word \n "
					+ "2.Display List \n 3.Write in a file or exit \n Choice : ");
			int ch= u.getInt();
			switch(ch)
			{
			case 1: System.out.print("\n Enter a word that you want to search : ");
					String word = u.getString();
			
					int result=list.search(word);			
					if(result != -1)
					{
						System.out.println("\n\n The word is found at index "+result);
						list.remove(word);
					}
					else
					{
						System.out.println("\n\n The word is not found ");
						list.add(word);
					}
					break;
					
			case 2: System.out.println();
					list.display();
					System.out.println();
					break;
					
			case 3: list.writeList("wordlist.txt");
					sc.close();
					return;
			}
		
		
		
		}
		
	}
}
