package functional;
import utility.Utility;

/**
 * 
 * @author admin1
 */
public class Permutation 
{

	public static void main(String[] args)
	{
//		Get utilities
		Utility u= new Utility();
		
		u.print("\n Enter a string to permute : ");
		
		String str = u.getString();
		
		u.print("\n How do you want to permute a string \n Enter 1 for Recursion and 2 for iteration");
		
		int ch = u.getInt();
		
		if(ch==1)
		{
			u.permutationRecursion(str, 0, str.length());
		}
		else if(ch==2)
		{
			u.permutationIterative(str);
		}
		else
		{
			u.print("You Entered a wrong choice");
			
		}
	}

}
