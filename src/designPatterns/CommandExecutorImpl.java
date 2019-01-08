package designPatterns;

public class CommandExecutorImpl implements CommandExecutor 
{

	@Override
	public void runCommand(String cmd) throws Exception 
	{
		Runtime.getRuntime().exec(cmd);
		System.out.println("'"+cmd+"' Command Executed");
	}
	
}
