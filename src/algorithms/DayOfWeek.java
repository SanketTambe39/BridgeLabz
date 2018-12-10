package algorithms;

import utility.Utility;

public class DayOfWeek 
{

	public static void main(String[] args) 
	{
		Utility u = new Utility();
		
		int dd = Integer.parseInt(args[0]);
		int mm = Integer.parseInt(args[1]);
		int yy = Integer.parseInt(args[2]);
		
		String []day= {"Sunday","Monday", "Tuesday", "Wedensday","Thursday", "Friday", "Saturday"};
		
		int dayOfDate = Utility.dayOfWeek( dd, mm, yy);
		
		u.println("\n The date "+dd+"/"+mm+"/"+yy+" is : "+day[dayOfDate]);

	}

}
