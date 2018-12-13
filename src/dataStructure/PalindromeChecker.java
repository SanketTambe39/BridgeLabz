package dataStructure;

import utility.Utility;

public class PalindromeChecker 
{

	public static void main(String[] args) 
	{
		
		Deque<Character> que= new Deque<Character>();
		
		Utility u= new Utility();
		
		u.print("\n Enter A String : ");
		String str= u.getString();
		
		for(int i=0; i<str.length(); i++)
		{
			
			que.addFront(str.charAt(i));	
		}
		boolean flag = false;
		
		for(int i=0; i<str.length(); i++)
		{
			
			if(str.charAt(i)==que.getFront())
			{
				que.removeFront();
				flag = true;
			}
			else
			{
				flag=false;
				break;
			}
				
		}
		if(flag==true)
		{
			u.print("\n The String is palindrome");
		}
		else
		{
			u.print("\n The String is not palindrome");
		}
	}			

}
