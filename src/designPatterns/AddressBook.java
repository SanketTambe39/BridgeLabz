package designPatterns;




public interface AddressBook {

	
	//public void addAddress(ObjectMapper mapper, AddressEntry newEntry);
	//public void runCommand(String command);
	
	public void addAddress();
	
	public void removeAddress(String firstName, String lastName);
	
	public void editAddress(String firstName, String lastName);
	
	public void sortByZip();
	
	public void sortByName();
	
	public void displayBook();

	void runCommand(String command, SubjectAddressBook subject);
	

	
}
