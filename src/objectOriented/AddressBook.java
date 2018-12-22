package objectOriented;

public class AddressBook 
{

	private String firstName;
	private String lastName;
	private Address address;
	private String contact[];
	
	public AddressBook() {}
	public AddressBook(String firstName, String lastName, Address address, String contact[])
	{
		this.firstName=firstName;
		this.lastName= lastName;
		this.address=address;
		this.contact=contact;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName=firstName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName=lastName;
	}
	
	public void setAddress(Address address) 
	{
		this.address=address;
	}
	public void setContact(String []contact)
	{
		this.contact=contact;
	}
	
	public String getFirstName()
	{
		return this.firstName;
	}
	public String getLastName()
	{
		return lastName;
	}
	public Address getAddress()
	{
		return address;
	}
	public String[] getContact()
	{
		return contact;
	}
}
