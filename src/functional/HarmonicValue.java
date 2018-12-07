package functional;

import utility.Utility;

public class HarmonicValue {

	public static void main(String[] args)
	{
		Utility u= new Utility();
	    int n = u.getInt();
	    
	    if(n<=0)
	    {
	    	u.harmonicValue(n);
	    }
	    else
	    	System.out.println("The number you entered is not valid");

	}

}
