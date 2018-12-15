package dataStructure;

import utility.Utility;

public class AnagramPrime2D 
{

	public static void main(String[] args)
	{
		
		Utility u =new Utility();
		
		System.out.println("\nThe anagrams primes in 2D array is : \n");
		
		int anagram2D[][] = u.getAnagram2DPrime(1000);
		
		u.print2DArray(anagram2D);
	}

}
