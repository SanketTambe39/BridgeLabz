package functional;
import utility.Utility;

public class WindChill 
{

	public static void main(String[] args)
	{
		
		Utility u= new Utility();
		double t= Double.parseDouble(args[0]);
		double v= Double.parseDouble(args[1]);
		
		u.windChill(t, v);

	}

}
