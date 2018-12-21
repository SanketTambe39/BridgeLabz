package functional;
import utility.Utility;

public class ReplaceUserName 
{

	public static void main(String[] args) 
	{
		Utility u = new Utility();
		
		
		System.out.print("\n Enter the Username : ");
		
		
		boolean flag=true;
		while(flag)
		{		
			String str = u.getString();
			
			if(str.length()>3)
			{
				u.replaceString("Hello <<UserName>>, How are you? ", str);
				flag=false;
			} 
			else
			{
				System.out.println("\n Enter the string again : ");
				flag=true;
			}
		}
		
	}
	
}
