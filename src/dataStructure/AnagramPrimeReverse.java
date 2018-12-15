package dataStructure;

import utility.Utility;

public class AnagramPrimeReverse 
{

	public static void main(String[] args) 
	{
		
		Utility u= new Utility();
		Stack<Integer> stk= new Stack<Integer>();
		int []anagram= u.getAnagramPrime(1000);
		//u.printArray(anagram);
		for(int i=0; i<anagram.length; i++)
		{
			if(anagram[i]!=0)
			{
				stk.push(anagram[i]);
			}
		}
		int count= stk.top;
		for(int i=0; i<=count-1; i=i+2)
		{
			System.out.println(stk.pop()+" "+stk.pop());
		}

	}

}
