package functional;

import utility.Utility;

public class StopWatch 
{

	public static void main(String[] args) 
	{
		Utility u= new Utility();
		long start=0, stop =0, elapsed=0; 
		int flag=0;
		while(true) 
		{	
			u.print("\n Enter the operation : \n 1.Start \n 2. Stop \n 3.Exit");
			int ch =u.getInt();
			
			switch(ch) 
			{
				
			case 1: flag=1;
					start = u.timer(ch);
					u.print("\n Start time is : "+start);
					break;
					
			case 2: if(flag == 0)
					{
						u.println("\n You doesn't start stopwatch yet");
					}
					else
					{
						stop = u.timer(ch);
						elapsed= stop-start;
						u.print("\n The stopwatch is Stopped......!"
								+ "\n The Elapsed time is : "+elapsed);
					}
					break;
					
			case 3:return;
			}
		}		
	}
}

























