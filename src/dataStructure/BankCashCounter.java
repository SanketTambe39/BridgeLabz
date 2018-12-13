package dataStructure;

import utility.Utility;
import java.util.Random;

public class BankCashCounter 
{

	public static void main(String[] args)
	{
		 
		Queue<String> cashCounter = new Queue<String>();
		
		Utility u=new Utility();
		
		Random rd= new Random();
		
		System.out.print("\n Enter the initial bank balance : ");
		int initialAmount=u.getInt();
		int i=1;
		while(true)
		{
			int n=rd.nextInt(10);
			if(n==0)
			{
				n=n+2;
			}
			for( ; i<n ; i++)
			{
				cashCounter.enque(" "+i);	
			}
			
			if(cashCounter.isEmpty())
			{
				System.out.println("\n Cash counter is empty........!!!!!!!!!");
				System.out.print("\n Remaining Bank Balance : "+initialAmount);
				return;
			}
			
			System.out.print("\n 1. Withdraw \n 2. Deposit \n Select the transcation : ");
			int ch= u.getInt();
			
			if(ch==1)
			{
				System.out.print("\n Enter the amount to withdraw : ");
				int amount=u.getInt();
				
				if(initialAmount>= amount)
				{
					initialAmount = initialAmount -amount ;
					
					System.out.print("\n Remaining Bank Balance : "+initialAmount);
					cashCounter.deque();
					cashCounter.display();
				}
				else
				{
					System.out.println("\n There is not sufficient amount.........!!!");
					System.out.print("\n Remaining Bank Balance : "+initialAmount);
				}
				
			}
			else if(ch==2)
			{
				System.out.print("\n Enter the amount to Deposit : ");
				initialAmount = initialAmount + u.getInt();
				
				System.out.print("\n Remaining Bank Balance : "+initialAmount);
				cashCounter.deque();
				cashCounter.display();
			}
			
			if(cashCounter.isEmpty())
			{
				System.out.println("\n Cash counter is empty........!!!!!!!!!");
				System.out.print("\n Remaining Bank Balance : "+initialAmount);
				return;
			}
			if(initialAmount <= 0)
			{
				System.out.print("\n Sorry..!! There is no amount remaining ");
				return;
			}
			
		}
		
	}

}
