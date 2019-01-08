package designPatterns;

import java.io.FileNotFoundException;
import java.util.List;

public class PrototypePattern 
{

	public static void main(String[] args) throws FileNotFoundException 
	{
	
		Employee newEmployee1= new Employee();
		
		newEmployee1.loadData();
		
		Employee newEmployee2= (Employee) newEmployee1.clone();
		
		Employee newEmployee3= (Employee) newEmployee1.clone();

		List<String> employeeList1= newEmployee1.getEmployees();
		List<String> employeeList2= newEmployee2.getEmployees();
		List<String> employeeList3= newEmployee3.getEmployees();
		
		employeeList2.add("kartik");
		employeeList3.remove("akshay");
		
		System.out.print("Object 1 content : ");
		employeeList1.forEach((String str)->System.out.print(str+" "));
		System.out.println();
		
		System.out.print("Object 2 content : ");
		employeeList2.forEach((String str)->System.out.print(str+" "));
		System.out.println();
		
		System.out.print("Object 3 content : ");
		employeeList3.forEach((String str)->System.out.print(str+" "));
		
		
	}
	
}
