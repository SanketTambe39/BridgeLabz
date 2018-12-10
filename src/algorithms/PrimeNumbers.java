package algorithms;

import utility.Utility;

public class PrimeNumbers 
{

	public static void main(String[] args) 
	{
		Utility u = new Utility();
		
		u.print("Enter the range of number do you have : ");
		int n= u.getInt();
		
		int arr[]=u.getPrime(n);
		
		for(int i=0; i<arr.length; i++)
		{
			if(arr[i]>0)
			{
				u.print(" "+arr[i]);
			}
		}

	}

}
