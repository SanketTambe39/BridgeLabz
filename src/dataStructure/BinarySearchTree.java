package dataStructure;

import utility.Utility;

public class BinarySearchTree<T> 
{

	
	public static void main(String[] args)
	{
		
		
		Utility u= new Utility();
		
		u.print("\n Enter number of the nodes");
		
		//String str[]=u.getLine().split(" ");
		
		int n = u.getInt();
		
		int cn = u.factorial(2*n)/(u.factorial(n+1)*u.factorial(n));
		
		cn=cn%(int)(Math.pow(10, 8)+7);
		u.print("\n The Number of binary search trees created by using the nodes is : "+cn);

	}

}
