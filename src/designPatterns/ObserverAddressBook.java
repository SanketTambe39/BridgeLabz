package designPatterns;

public interface ObserverAddressBook {

	
	public void setSubject(SubjectAddressBook subject);
	
	public String getName();
	//public void update(String message);

	public void update(String message);
	
}
