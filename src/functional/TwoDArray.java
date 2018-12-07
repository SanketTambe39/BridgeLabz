package functional;
import utility.Utility;
//import java.io.PrintWriter;
 

public class TwoDArray 
{

	public static void main(String[] args)
	{
		//PrintWriter writer= new PrintWriter(System.out, true);
		Utility u= new Utility();
		
		u.println("Enter rows and columns i.e m*n : ");
		//writer.print();
		
		int m=u.getInt(), n= u.getInt();
		
		u.println("Enter the choice what type of 2D array you want : ");
		u.println("1. Integer Array \n 2. Float Array \n 3. Boolean Array");
		
		int ch= u.getInt();
		
		switch(ch)
		{
		
		case 1: int arr[][] = u.read2DArrayInt(m, n);
				u.print2DArray(arr, m, n);
				break;
				
		case 2: float arr1[][] = u.read2DArrayFloat(m, n);
				u.print2DArray(arr1, m, n);		
				break;
				
		case 3: boolean arr2[][] = u.read2DArrayBoolean(m, n);
				u.print2DArray(arr2, m, n);		
				break;
				
		default: u.print("You Entered a wrong choice");
		
		}
		
		
		
	}
	

}
