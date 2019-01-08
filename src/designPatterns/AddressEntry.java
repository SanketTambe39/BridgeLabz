package designPatterns;

import java.util.List;

import objectOriented.Address;
import objectOriented.Contact;

public class AddressEntry {

	private String firstName;
	private String lastName;
	private List<Address> addresses;
	private List<Contact> contacts;
	
	public AddressEntry() {}
	
	public AddressEntry(String firstName, String lastName, List<Address> addresses, List<Contact> contacts)
	{
		this.firstName=firstName;
		this.lastName=lastName;
		this.addresses=addresses;
		this.contacts= contacts;
		
	}
	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @return the addresses
	 */
	public List<Address> getAddresses() {
		return addresses;
	}
	/**
	 * @return the contacts
	 */
	public List<Contact> getContacts() {
		return contacts;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @param addresses the addresses to set
	 */
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	/**
	 * @param contacts the contacts to set
	 */
	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}
	
	
	public String toString()
	{
		String str = "\n Name : "+firstName+" "+lastName+"\n";
		for(Address address: addresses)
		{
			str= str+" "+address.toString();
		}
		for(Contact contact: contacts)
		{
			str= str+" "+contact.getContact();
		}
		
		return str;
	}
	
}
