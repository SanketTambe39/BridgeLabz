package dataStructure;

import utility.Utility;

public class PrimeInRange 
{

	public static void main(String[] args)
	{
		
		Utility u= new Utility();
		
		int prime[][]=u.getPrime2D(1000);
		
		u.print2DArray(prime);

	}

}
