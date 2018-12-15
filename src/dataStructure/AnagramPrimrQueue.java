package dataStructure;

import utility.Utility;

public class AnagramPrimrQueue 
{

	public static void main(String[] args)
	{
		
		Utility u= new Utility();
		Queue<Integer> que= new Queue<Integer>();
		
		int []anagram= u.getAnagramPrime(1000);
		
		for(int i=0; i<anagram.length; i++)
		{
			if(anagram[i]!=0)
			{
				que.enque(anagram[i]);
			}
		}
		int count= que.sizeOf();
		
		for(int i=0; i<count-1; i=i+2)
		{
			System.out.println(que.deque()+" "+que.deque());
		}

	}

}
