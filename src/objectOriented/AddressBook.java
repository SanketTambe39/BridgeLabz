package objectOriented;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;

import utility.Utility;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import designPatterns.SubjectAddressBook;

import java.util.ArrayList;

//import dataStructure.LinkedList;

import java.util.LinkedList;
import java.util.List;

public class AddressBook {

	
	private static ObjectMapper mapper;
	private static File file;
	private List<AddressEntry> addressEntry;
	
	public AddressBook() {}
	
	public AddressBook(String fileName)
	{
		mapper= new ObjectMapper();
		file= new File(fileName);
		addressEntry=new LinkedList<AddressEntry>();
	}
	 
	public void addNewEntry() throws JsonParseException, JsonMappingException, IOException
	{
		Utility utility=new Utility();
		AddressEntry oldBook[]=mapper.readValue(file, AddressEntry[].class);
		addressEntry.clear();
		for(AddressEntry book: oldBook)
		{
			addressEntry.add(book);
		}
			
		System.out.print("\n Enter the details : \n First Name : ");
		String firstName=utility.getLine();  
		
		System.out.print(" Last Name : ");
		String lastName=utility.getLine();
		
		System.out.println("\n Enter Address :");
		System.out.print(" Locality :");
		String locality=utility.getLine();
		
		System.out.print(" City : ");
		String city=utility.getLine();
		
		System.out.print(" State : ");
		String state= utility.getLine();
		
		System.out.print(" ZipCode: ");
		String zip= utility.getLine();
		
		System.out.println("\n Enter Contact : ");
		String contact= utility.getLine();
		String contacts[]= contact.split(" ");
		
		
		Address newAddress= new Address(locality, city, state, zip);
		ArrayList<Address> addressList=new ArrayList<Address>();
		addressList.add(newAddress);
		AddressEntry newEntry = new AddressEntry(firstName, lastName, addressList, contacts);
		addressEntry.add(newEntry);
		
		try {
			
			mapper.writeValue(file, addressEntry);
		
		} catch (IOException e) {
		
			e.printStackTrace();
		
		}
	}
	
	public void removeEntry(String firstName, String lastName) throws JsonParseException, JsonMappingException, IOException
	{
		AddressEntry oldBook[]=mapper.readValue(file, AddressEntry[].class);
		addressEntry.clear();
		for(AddressEntry book: oldBook)
		{
			if(book.getFirstName().equals(firstName) && book.getLastName().equals(lastName))
			{
				continue;
			}
			addressEntry.add(book);
		}
		
		mapper.writeValue(file, addressEntry);
	}
	
	public void edit(String firstName, String lastName) throws JsonParseException, JsonMappingException, IOException
	{
	
		addressEntry.clear();
		AddressEntry oldBook[]= mapper.readValue(file, AddressEntry[].class);
		Utility utility= new Utility();
		for(AddressEntry book: oldBook)
		{
			if(book.getFirstName().equals(firstName) && book.getLastName().equals(lastName))
			{
				System.out.print("\n Enter what field you want to edit(address/contact) : ");
				String field=utility.getString();
				
				if(field.equals("address"))
				{
					System.out.println("\n Enter Address : ");
					System.out.print("\n Locality : \b");
					String locality=utility.getLine();
					locality=utility.getLine();
					System.out.print("\b\n City : ");
					String city=utility.getString();
					
					System.out.print("\b\n State : ");
					String state= utility.getString();
					
					System.out.print("\n ZipCode: ");
					String zip= utility.getString();
					
					Address address = new Address(locality, city, state, zip);
					ArrayList<Address> addressList=new ArrayList<Address>();
					addressList.add(address);
					book.setAddress(addressList);
					
				}
				else if(field.equals("contact"))
				{
					System.out.print("\n Enter contact number : ");
					String contact= utility.getLine();
					contact= utility.getLine();
					String contacts[]= contact.split(" ");
					
					book.setContact(contacts);
				}
				
			}
			addressEntry.add(book);
		}
		
		mapper.writeValue(file, addressEntry);
	}
	
	
	public void sortByName() throws JsonParseException, JsonMappingException, IOException
	{
		AddressEntry oldBook[]= mapper.readValue(file, AddressEntry[].class);
		addressEntry.clear();
		for(int i=0; i<oldBook.length-1; i++)
		{
			for(int j=i+1; j<oldBook.length; j++)
			{
				String str1=oldBook[i].getFirstName()+oldBook[i].getLastName();
				String str2=oldBook[j].getFirstName()+oldBook[j].getLastName();
				
				if(str1.compareTo(str2)>0)
				{
					AddressEntry temp;
					temp=oldBook[i];
					oldBook[i]=oldBook[j];
					oldBook[j]=temp;
				}
			}
			
		}
		for(AddressEntry book: oldBook)
		{
			addressEntry.add(book);
		}
		
		mapper.writeValue(file, addressEntry);
		
	}
	
	public void sortByZip() throws JsonParseException, JsonMappingException, IOException
	{
		AddressEntry oldBook[]= mapper.readValue(file, AddressEntry[].class);
		addressEntry.clear();
		for(int i=0; i<oldBook.length-1; i++)
		{
			for(int j=i+1; j<oldBook.length; j++)
			{
				String str1=oldBook[i].getAddress().get(0).getZip();
				String str2=oldBook[j].getAddress().get(0).getZip();
				
				if(str1.compareTo(str2)>0)
				{
					AddressEntry temp;
					temp=oldBook[i];
					oldBook[i]=oldBook[j];
					oldBook[j]=temp;
				}
			}
			
		}
		for(AddressEntry book: oldBook)
		{
			addressEntry.add(book);
		}
		
		mapper.writeValue(file, addressEntry);
		
	}
	
	public void displayBook()
	{
		try {
			AddressEntry oldBook[]= mapper.readValue(file, AddressEntry[].class);
			
			for(AddressEntry book: oldBook)
			{
				System.out.println("\n Name : "+book.getFirstName()+" "+book.getLastName());
				System.out.println(" Address : "+book.getAddress().toString());
				System.out.print(" Contact : ");
				for(String contact: book.getContact())
				{
					System.out.println(contact+", ");
					
				}
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException 
	{
		
		AddressBook newBook= new AddressBook("AddressBook.json");	
		Utility utility= new Utility();
		
		while(true)
		{
			System.out.print("\n ************Menu************** \n\t 1.Add Address \n \t "
							+ "2.Remove Address \n\t 3.Sort By Name \n\t 4.Sort By Zip \n\t"
							+ " 5.Edit Address \n\t 6.Close \n Enter Your Choice  :  ");
			int ch= utility.getInt();
			String firstName,lastName;
			switch(ch)
			{
			
			case 1: newBook.addNewEntry();
					newBook.displayBook();
					break;
					
			case 2: System.out.print("\n Enter Firstname and Lastname to find records \n FirstName : "); 
					firstName=utility.getString();
					
					System.out.println("\n LastName : ");
					lastName=utility.getString();
					newBook.removeEntry(firstName, lastName);
					newBook.displayBook();
					break;
					
			case 3: newBook.sortByName();
					newBook.displayBook();
					break;
					
			case 4: newBook.sortByZip();
					newBook.displayBook();
					break;
					
			case 5: System.out.print("\n Enter Firstname and Lastname to find records \n FirstName : "); 
					firstName=utility.getString();
			
					System.out.println("\n LastName : ");
					lastName=utility.getString();
				
					newBook.edit(firstName, lastName);		
					newBook.displayBook();
					break;
					
			case 6: return;
			
			}
		}
		
	}

}
