package designPatterns;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Employee 
{

	private List<String> empList; 
	
	Employee()
	{
		empList= new ArrayList<String>(); 
	}
	
	Employee(List<String> empList)
	{
		this.empList=empList; 
	}
	
	
	public List<String> getEmployees()
	{
		return empList;
	}
	
	public void loadData() throws FileNotFoundException
	{
		File file= new File("data.txt");
		Scanner sc=new Scanner(file);
		
		
			String[] employees=sc.nextLine().split(" ");
			
			for(String string: employees)
			{
				empList.add(string);
			}
		sc.close();
	}
	
	public Object clone()
	{
		List<String> temp= new ArrayList<String>();
		
		for(String employe: empList)
		{
			temp.add(employe);
		}
		return new Employee(temp);
	}
	
	
}
