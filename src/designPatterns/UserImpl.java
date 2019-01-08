package designPatterns;

public class UserImpl extends User{

	public UserImpl(ChatMediator chatMediator, String name) {
		
		super(chatMediator, name);
	}

	@Override
	public void send(String message) {
		
		System.out.println(this.name+" sending message : "+message);
		
		chatMediator.sendMessage(message, this);
		
	}

	@Override
	public void recieve(String message) {
		
		System.out.println(this.name+" recieved message : "+message);
	}

}
