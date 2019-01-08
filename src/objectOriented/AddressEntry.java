package objectOriented;

import java.util.ArrayList;

public class AddressEntry 
{

	private String firstName;
	private String lastName;
	private ArrayList<Address> address;
	private String contact[];
	
	public AddressEntry() {}
	public AddressEntry(String firstName, String lastName, ArrayList<Address> address, String contact[])
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
	
	public void setAddress(ArrayList<Address> address) 
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
	public ArrayList<Address> getAddress()
	{
		return address;
	}
	public String[] getContact()
	{
		return contact;
	}
	
	public String toString()
	{
		return " Name : "+firstName+" "+lastName+" Address : "+address.get(0).getLocality()
				+", "+address.get(0).getCity()+", "+address.get(0).getState()+", "+address.get(0).getZip()
				+" Contacts : "+contact[0];
	}
}
