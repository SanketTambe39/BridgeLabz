package designPatterns;

import java.util.ArrayList;
import java.util.List;

public class ChatMediatorImpl implements ChatMediator{

	
	private List<User> users;
	
	
	public ChatMediatorImpl() {

		users=new ArrayList<User>();
	}
	
	@Override
	public void sendMessage(String message, User user) {
		
		this.users.forEach(userEntry->userEntry.recieve(message));

	}

	@Override
	public void addUser(User user) {
		
		this.users.add(user);
	}

}
