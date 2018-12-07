package functional;
import utility.Utility;

public class ReplaceUserName 
{

	public static void main(String[] args) 
	{
		Utility u = new Utility();
		
		
		System.out.print("\n Enter the Username : ");
		
		String str = u.getString();
		
		u.replaceString("Hello <<UserName>>, How are you? ", str);
		    
		
	}
	
}
