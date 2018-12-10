package algorithms;

import utility.Utility;

public class TemperatureConversion {

	public static void main(String[] args) 
	{
		Utility u = new Utility();
		
		u.print("\n Enter Temperature in __ F(Fahrenheit) or __ C(Celsius) : ");
		
		double temp= u.getDouble();
		String ch = u.getString();
		
		temp = u.temperatureConversion(temp, ch);
		if(ch.equals("F"))
		{
			u.print("\n The Tempearture Conversion from Fahrenheit to "
					+ "Celsius is : "+temp+"C");
		}
		else
		{
			u.print("\n The Tempearture Conversion from Celsius to "
					+ "Fahrenheit is : "+temp+"F");
		}
	}

}
