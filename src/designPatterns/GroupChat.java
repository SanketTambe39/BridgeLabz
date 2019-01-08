package designPatterns;

import utility.Utility;

public class GroupChat {

	
	public static void main(String[] args) {
	
		
		ChatMediator chatMediator=new ChatMediatorImpl();
		Utility utility= new Utility();
		
		User user1= new UserImpl(chatMediator, "Akshay");
		User user2= new UserImpl(chatMediator, "Swapnil");
		User user3= new UserImpl(chatMediator, "Kartik");
		User user4= new UserImpl(chatMediator, "Krishna");
		User user5= new UserImpl(chatMediator, "Ajay");

		String message= utility.getLine();
		
		chatMediator.addUser(user1);
		chatMediator.addUser(user2);
		chatMediator.addUser(user3);
		chatMediator.addUser(user4);
		chatMediator.addUser(user5);
		
		user1.send(message);
		
		
	}
		
		
	
}
