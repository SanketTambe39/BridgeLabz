package algorithms;

import utility.Utility;

public class Binary
{

	public static void main(String[] args) 
	{
		
		Utility u = new Utility();
		
		
		
		
		u.print("\n Enter A Number : ");
		int num = u.getInt();
		int binary[] = Utility.toBinary(num); ;
		
		while(true)
		{
			u.print("\n 1. Convert Decimal to Binary \n 2. Swap a Nibble "
					+ "\n 3. Get Resultant number "
					+ "\n Enter A choice : ");
			int ch = u.getInt();
			switch(ch)
			{
			
			case 1: u.print("\n binary number of num: "+num+" is : ");
					u.printArrayRev(binary);
					break;
					
			case 2: u.print("\n The Binary number before the swaping nibble is :");
					u.printArrayRev(binary);
					binary = u.swapNibble(binary);
					u.print("\n The Binary number after the swaping nibble is :");
					u.printArrayRev(binary);
					break;
					
			case 3: u.print("\n The resultant binary numbers power of 2 is : \n");
					u.printArrayRev(binary);
					int num1 = u.toDecimal(binary);
					u.print("\n The decimal number is "+num1);
					break;
					
			default: return;
			}
		
		}
		
		
	}
		
}
