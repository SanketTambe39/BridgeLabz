package designPatterns;

public class AddressBookObservers implements ObserverAddressBook {

	private static SubjectAddressBook subject; 
	private static String name;
	
	public AddressBookObservers(String name) {

		this.name=name;
	}
	
	@Override
	public void setSubject(SubjectAddressBook subject) {
		
		this.subject=subject;
		
	}

	@Override
	public void update(String message) {
		
		
		if(message == null)
		{
			System.out.print("\n "+name+":: No new message");
		}
		else 
		{
		
			System.out.println("\n "+name+":: Consuming message::"+message);
	
		}
	}
	
	public String getName()
	{
		return this.name;
	}

}
