package functional;
import utility.Utility;

public class Gambler 
{ 

	    public static void main(String[] args)
	    {
	        
	    	Utility u= new Utility();
			
	    	System.out.println("Enter Stake : ");
	    	int stake = u.getInt();
	    	
	    	System.out.println("Enter Goal : ");
	    	int goal=  u.getInt();
	    	
	    	System.out.println("Enter number of trials : ");
	    	int n=  u.getInt();
	    	
	    	u.gambler(stake, goal, n);
	    	           
	    	
	    }

}




