package algorithms;

import utility.Utility;

public class checkPrimeAnagram {

	public static void main(String[] args) 
	{
		
		Utility u = new Utility();
		
		u.print("Enter the range in that you want to find anagrams and palindromes: ");
		int n = u.getInt();
		
		u.print("Prime numbers which are anagrams are : ");
		u.getAnagramPrime(n);
		
		u.print("Prime numbers which are palindromes are : \n");
		u.getPalPrime(n);
		
	}

}
