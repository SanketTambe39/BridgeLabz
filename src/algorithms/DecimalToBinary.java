package algorithms;

import utility.Utility;

public class DecimalToBinary 
{

	public static void main(String[] args)
	{
		
		Utility u = new Utility();
		
		u.print("\n Enter A Number : ");
		int num = u.getInt();
		
		int temp[]=Utility.toBinary(num);
	
		u.print("\n binary number of num: "+num+" is : ");
		
		for(int i=temp.length-1; i>=0; i--)
		{
			
			u.print(""+temp[i]);
			if(i%4==0)
			{
				u.print(" ");
			}
		}

	}

}
