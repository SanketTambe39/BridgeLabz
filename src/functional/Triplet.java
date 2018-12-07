package functional;
import utility.Utility;

public class Triplet 
{

	public static void main(String[] args)
	{
		
		Utility u= new Utility();
		
		u.print("Enter the value of N : ");
		
		int n=u.getInt();
		
		if(n>2)
		{
			u.triplet(n);
		}
		else
		{
			u.print("The size is not enough");
			
		}

	}

}
