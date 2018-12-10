package algorithms;
import utility.Utility;

public class VendingMachine
{

	public static void main(String[] args) 
	{
		
		Utility u = new Utility();
		
		u.print("\n Enter the change in rupees that you want : ");
		int change= u.getInt();
		
		u.vendingMachine2(change);

	}

}
