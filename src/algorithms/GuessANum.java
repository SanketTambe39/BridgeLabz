package algorithms;

import utility.Utility;

public class GuessANum 
{

	public static void main(String[] args) 
	{
		Utility u = new Utility();
		int low=0;
		int high= Integer.parseInt(args[0]);
		
		u.guessANum(low, high);

	}

}
