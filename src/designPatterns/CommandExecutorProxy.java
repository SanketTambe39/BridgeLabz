package designPatterns;

public class CommandExecutorProxy implements CommandExecutor
{

	private CommandExecutor executor;
	private boolean isAdmin;
	
	
	public CommandExecutorProxy(String userName, String passWord) 
	{
		
		if(userName.equalsIgnoreCase("Akshay") && passWord.equalsIgnoreCase("aksh37"))
		{
			isAdmin=true;
			executor=new CommandExecutorImpl();
		}	
		
	}
	@Override
	public void runCommand(String cmd) throws Exception 
	{
	
		if(isAdmin)
		{
			executor.runCommand(cmd);
		}
		else
		{
			if(cmd.trim().equals("rm"))
			{
				throw new Exception("rm command is not allowed for non admin users");
			}
			else
			{
				executor.runCommand(cmd);
			}
		}
		
	}	

}
