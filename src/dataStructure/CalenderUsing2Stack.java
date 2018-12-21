package dataStructure;


import utility.Utility;

public class CalenderUsing2Stack
{

	public static void main(String[] args)
	{
		Stack<String> stack1= new Stack<String>();
		Stack<String> stack2= new Stack<String>();
		Utility u= new Utility();
	
		u.print("\n Enter the month and year \n Month : ");
		int month= u.getInt();
		
		u.print(" Year : ");
		int year= u.getInt();
		
		String calender[][] = u.getMonthCalender(month, year);
		
		//u.print2DArray(calender);
		//1996u.print(""+calender[0].length);
		for(int i=0; i<calender.length; i++)
		{
			for(int j=0; j<calender[0].length;j++)
			{
				stack1.push(calender[i][j]);
				
			}
		}
		
		for(int i=0; i<stack1.sizeof(); i++)
		{
			String popElememnt=stack1.pop();
			
			stack2.push(popElememnt);
		}
		
		//u.print(""+stack2.sizeof());
		
		int count=0;
		for(int i=1; i<stack2.sizeof(); i++)
		{
			String popElememnt=stack2.pop();
			if(count<7)
			{
				System.out.print(popElememnt);
				count++;
			}
			else
			{
				count=0;
				System.out.println();
			}
		}
		//u.print(""+stack2.top);
		//stack2.display2();

	}

}
