package functional;

import utility.Utility;

public class LeapYear 
{

	public static void main(String []args)
	{
		Utility u= new Utility();
		
		System.out.print("Enter a year : ");
	    int year = u.getInt();
		
	    if(u.isLeapYear(year))
	    {
	    	System.out.println("\n The year you entered is a leap year");
	    }
	    else 
	    {
	    	System.out.println(" The year you entered is not a leap year");
	    }
	    
	}
}
