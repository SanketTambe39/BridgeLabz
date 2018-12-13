package dataStructure;

import utility.Utility;

public class BalancedParanthesis 
{

	public static void main(String[] args) 
	{
		
		Stack<Character> stk= new Stack<Character>();
		Utility u =new Utility();
		
		u.print("\n Enter an expression for check balanced paranthesis : ");
		String expr = u.getString();
		int n= expr.length(), i=0;
		int count = 0;
		
		while(i<n)
		{
			char ch = expr.charAt(i);
			
			switch(ch)
			{
			
			case '(': 	stk.push('(');
						count++;
						break;
						
			case ')': 	stk.pop();
						count--;
						break;
			}
			i++;
			
		}
		stk.display();
		if(count==0)
		{
			u.print("\n The expression has balanced paranthesis");
		}
		else
		{
			u.print("\n The expression has not balanced paranthesis");
		}

	}

}
