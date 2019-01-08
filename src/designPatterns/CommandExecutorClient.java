package designPatterns;

import utility.Utility;

public class CommandExecutorClient 
{

	public static void main(String[] args) throws Exception 
	{
	
		Utility utility= new Utility();
		System.out.println("\n Enter UserName and PassWord ");
		System.out.print("\n UserName : ");
		String userName= utility.getLine();
		
		System.out.print("\n Password : ");
		String passWord= utility.getLine();
		
		CommandExecutor executor=new CommandExecutorProxy(userName, passWord);
		
		System.out.println("\n Enter Command : ");
		System.out.print("$ ");
		String cmd= utility.getLine();
		executor.runCommand(cmd);
	}
	
}
