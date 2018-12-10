package algorithms;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import utility.Utility;

public class SearchAWord 
{

	public static void main(String[] args) throws IOException
	{
		
		File file=new File("/home/admin1/Desktop/Aksh/BridgeLabz/src/algorithms/wordList.txt");
		Scanner sc = new Scanner(file);
		Utility u =new Utility();
		
		String []wordList = sc.nextLine().split(", ");
	
		Arrays.sort(wordList);
		u.println("");
		u.printArray(wordList);
		
		u.print("\n\n Enter A string to Search : ");
		String word= u.getString();
		
		if(Utility.binarySearch(word, wordList)==true)
		{
			u.print("\n The "+word+" is here.....!");
		}
		else
		{
			u.print("\n The "+word+" is not found !!!!");
		}
		sc.close();
	}

}
