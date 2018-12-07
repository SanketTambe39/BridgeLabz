package functional;
import utility.Utility;

public class Distance 
{

	public static void main(String[] args)
	{
		Utility u= new Utility();
		
		u.eucledianDistance(Integer.parseInt(args[0]), Integer.parseInt(args[1]));

	}

}
