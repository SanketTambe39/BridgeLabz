package designPatterns;

import utility.Utility;

public class AddressBookClients
{
	

	public static void main(String[] args) {
		
		
		Utility utility= new Utility();		
		AddressBookImpl newBook= AddressBookImpl.getInstance();
		
		System.out.println("\n ****************Address Book Login*****************");
		
		System.out.print("\n Username : ");
		String userName=utility.getLine();
		
		System.out.print("\n Password : ");
		String passwd= utility.getLine();
		
		System.out.println("\n ***********************************************************");
		System.out.println("\n Commands to be enter : (\"rm\", \"add\", \"display\", "
				 + "\"edit\")");
		System.out.println("\n ***********************************************************");
		
		while(true)
		{
			System.out.print("\n Enter Command : ");
			String command= utility.getLine();
			
			if(userName.equals("Akshay") && passwd.equals("aksh37"))
			{
				if("exit".equalsIgnoreCase(command))
					return;
				newBook.runCommand(command, newBook);
			}
			else
			{
				if("exit".equalsIgnoreCase(command))
					return;
				if("rm".equals(command) || "register".equals(command) || "unregister".equals(command))
				{
					System.out.println("\n This commands not allowed to non admin user");
				}
				else
				{
					newBook.runCommand(command, newBook);
				}
				
			}
			
		}
	}
	
}
