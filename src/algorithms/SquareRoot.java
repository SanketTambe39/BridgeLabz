package algorithms;

import utility.Utility;

public class SquareRoot
{

	public static void main(String[] args)
	{
		
		Utility u = new Utility();
		
		System.out.print("\n Enter a Number for finding square root : ");
		int c= u.getInt();
		
		double sqrt=Utility.sqrt(c);
		
		System.out.println("\n The Square root of "+c+" is :"+sqrt);
	}

}
