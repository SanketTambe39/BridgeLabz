package functional;

import utility.Utility;

public class CouponNumber 
{

	public static void main(String[] args) 
	{
		
		Utility u= new Utility();
		
		System.out.print("Enter the muber of coupons you have to generate : ");
		
		int n= u.getInt();
		u.couponNumber(n);

	}

}
