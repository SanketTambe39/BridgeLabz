package algorithms;

import utility.Utility;

public class Anagram 
{

	public static void main(String[] args) 
	{

		Utility u= new Utility();
		
		u.print("Enter Two strings");
		
		String str1=u.getLine();
		String str2=u.getLine();
		
		boolean status =u.isAnagram(str1, str2);
		if(status==true)
		{
			u.print("the strings are anagram");
		}
		else
		{
			u.print("the strings are not anagram");
		}

	}

}
