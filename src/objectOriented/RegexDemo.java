package objectOriented;
import java.util.Date;
import java.util.regex.*;


import utility.Utility;


public class RegexDemo {

	public static void main(String[] args)
	{
		
		Utility utility= new Utility();
		String message= " Hello <<name>>, \n"
						+ " We have your full name as <<full name>> in our system.\n"
						+ " Your contact number is 91-xxxxxxxxxx."
						+ " Please,let us know in case of any clarification.\n"
						+ " Thank you....\n"
						+ " BridgeLabz \n"
						+ " DD/MM/YYYY.";

		Date date= new Date();
		
		System.out.println(message);
		
		System.out.println("\n Enter User Information : ");
		System.out.print("\n FullName : ");
		
		String fullName= utility.getLine();
		String name = fullName.split(" ")[0];
		System.out.println(" Contact No.: ");
		String contactNumber= utility.getString();
		String todayDate= date.getDate()+"/"+date.getMonth()+"/"+date.getYear();
		
		
		String regularExpression[]= {"<<name>>","<<full name>>","x{10}","DD/MM/YYYY"};
		String replacement[]= {name, fullName, contactNumber, todayDate};
		int i=0;
		for(String regex: regularExpression)
		{
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher= pattern.matcher(message);
			message=matcher.replaceAll(replacement[i++]);
		
		}
		System.out.println(message);

	}

}
