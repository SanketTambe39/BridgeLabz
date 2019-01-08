
package designPatterns;

import utility.Utility;

/**
 * @author admin1
 *
 */

public class ComputerFactory
{
	
	public Computer getComputer(String type, String ram, String hdd, String cpu)
	{
		if("PC".equalsIgnoreCase(type))
		{
			return new PC(ram, hdd, cpu);
		}
		else if("Laptop".equalsIgnoreCase(type))
		{
			return new Laptop(ram, hdd, cpu);
		}
		else if("Server".equalsIgnoreCase(type))
		{
			return new Server(ram, hdd, cpu);
		}
		else
		{
			return null;
		}
	}
	
	public static void main(String[] args) 
	{
	
		Utility utility= new Utility();
		
		System.out.print("\n Enter Computer Details : \n Type : ");
		String type=utility.getLine();
		
		System.out.print(" RAM : ");
		String ram= utility.getLine();
		
		System.out.print(" Hard Disk : ");
		String hdd= utility.getLine();
		
		System.out.print(" CPU : ");
		String cpu= utility.getLine();
		
		Computer newComputer= new ComputerFactory().getComputer(type, ram, hdd, cpu);
				
		System.out.print("\n Factory "+type+" config : "+newComputer);
	}

}


abstract class Computer
{

	public abstract String getRAM();
	public abstract String getHDD();
	public abstract String getCPU();
	
	public  String toString()
	{
		return "RAM : "+getRAM()+"  Hard Disk : "+getHDD()+"  CPU : "+getCPU();
	}
	
}

class PC extends Computer
{

	private String ram;
	private String hdd;
	private String cpu;
	
	public PC(String ram, String hdd, String cpu)
	{
		this.ram=ram;
		this.hdd=hdd;
		this.cpu=cpu;
	}
	
	@Override
	public String getRAM() 
	{	
		return this.ram;
	}

	@Override
	public String getHDD() 
	{		
		return this.hdd;
	}

	@Override
	public String getCPU() 
	{
		return this.cpu;
	}
	
}


class Server extends Computer
{

	private String ram;
	private String hdd;
	private String cpu;
	
	public Server(String ram, String hdd, String cpu)
	{
		this.ram=ram;
		this.hdd=hdd;
		this.cpu=cpu;
	}
	
	@Override
	public String getRAM() 
	{	
		return this.ram;
	}

	@Override
	public String getHDD() 
	{		
		return this.hdd;
	}

	@Override
	public String getCPU() 
	{
		return this.cpu;
	}
	
}

class Laptop extends Computer
{

	private String ram;
	private String hdd;
	private String cpu;
	
	public Laptop(String ram, String hdd, String cpu)
	{
		this.ram=ram;
		this.hdd=hdd;
		this.cpu=cpu;
	}
	
	@Override
	public String getRAM() 
	{	
		return this.ram;
	}

	@Override
	public String getHDD() 
	{		
		return this.hdd;
	}

	@Override
	public String getCPU() 
	{
		return this.cpu;
	}
	
}


