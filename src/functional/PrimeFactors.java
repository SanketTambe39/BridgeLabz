package functional;

import utility.Utility;

public class PrimeFactors 
{

	public static void main(String[] args)
	{
		
		Utility u= new Utility();
		
		System.out.print("Enter a number : ");
		int n= u.getInt();
		
		u.factors(n);

	}

}
