package functional;
import utility.Utility;

public class FlipCoin 
{

	public static void main(String []args)
	{
		Utility u= new Utility();
	    
		System.out.print("Enter the no. of time coins have to be flip : \n");
		int n= u.getInt();
		u.flipCoin(n);
	    
	}
	
}
