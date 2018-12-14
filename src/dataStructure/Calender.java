package dataStructure;

import utility.Utility;

public class Calender 
{
	public static void main(String[] args) 
	{
		
		Utility u = new Utility();
		int month= Integer.parseInt(args[0]);
		int year= Integer.parseInt(args[1]);
		
		String calender[][]=u.getMonthCalender( month, year);
		int m = calender.length;
		int n = calender[0].length;
		u.print2DArray(calender, m, n);
	}
}
