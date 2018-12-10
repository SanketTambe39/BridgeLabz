package algorithms;

import utility.Utility;

public class MonthlyPayment 
{

	public static void main(String[] args) 
	{
		
		Utility u =new Utility();
		
		int P= Integer.parseInt(args[0]);
		int Y= Integer.parseInt(args[1]);
		float R= Float.parseFloat(args[2]);
		
		
		double payment =Utility.monthlyPayment(P, Y, R);
		u.print("\n The Payment of the given details is : "+ payment+"Rs");
		
	}

}
