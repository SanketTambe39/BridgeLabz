package dataStructure;

import utility.Utility;

public class Week 
{
	
	public void WeekDay(int month, int year)
	{
		
		Utility u= new Utility();
		
		String[][] calender= u.getMonthCalender(month, year);
		
		Queue<String> weekDays= new Queue<String>();
		
		int week= calender.length;
		int days= calender[0].length;
		
		for(int i=0; i<week; i++)
		{
			for(int j=0; j<days; j++)
			{
				weekDays.enque(calender[i][j]);
			}
		}
		
		weekDays.display2();
	}
	
	public static void main(String[] args) 
	{
	
		Week w=new Week();
		Utility u =new Utility();
		
		u.print("\n Enter the month and year \n Month : ");
		int month= u.getInt();
		
		u.print("\n Year : ");
		int year= u.getInt();
		
		w.WeekDay(month, year);
	}
		
}
