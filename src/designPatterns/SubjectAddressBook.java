package designPatterns;



public interface SubjectAddressBook 
{

	public void register(ObserverAddressBook observer);
	
	public void unregister(ObserverAddressBook observer);
	
	public void notifyObservers(String message);
	
	public Object getUpdate(ObserverAddressBook observer);

	//void register(ObserverAddressBook observer, SubjectAddressBook subject);
	
}
