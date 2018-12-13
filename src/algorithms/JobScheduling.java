package algorithms;

import utility.Utility;

public class JobScheduling
{

	public static void main(String[] args) 
	{
		
		Utility u = new Utility();
		
		u.print("\n Enter the number of jobs have to be completed : ");
		int n=u.getInt();
		
		Jobs jobs[]=new Jobs[n];
		
		System.out.println("\n Enetr The Jobs Deadline(in Hours) and Time to complete(in min):");
		
		for(int i=1; i<=n; i++)
    	{
			jobs[i-1] = new Jobs();
    		System.out.print(" Job "+i+" Deadline : ");
    		int deadLine = u.getInt();
    		
    		System.out.println(" Job "+i+" Time to Complete : ");
    		int completionTime = u.getInt();
    		
    		jobs[i-1].setData(deadLine, completionTime, i);
    	}
		
		u.jobScheduler(jobs);

	}

}
