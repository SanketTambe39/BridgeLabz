package designPatterns;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import objectOriented.Address;
import objectOriented.Contact;
import utility.Utility;

public class AddressBookImpl implements AddressBook, Serializable, SubjectAddressBook {

	private static final long serialVersionUID = -1719350302462196932L;
	private ObjectMapper mapper;
	private static List<AddressEntry> book;
	private List<ObserverAddressBook> observers;
	private Utility utility;
	private boolean changed;

	/*private AddressBookImpl() {

		System.out.println("\n ******************Welcome to Address Book******************");
		this.mapper = new ObjectMapper();
		this.book = new ArrayList<AddressEntry>();
		this.utility = new Utility();
		this.observers = new ArrayList<ObserverAddressBook>();
		this.changed = false;
	}
*/
	private AddressBookImpl(List<AddressEntry> book) {
		System.out.println("\n ******************Welcome to Address Book******************");
		this.mapper = new ObjectMapper();
		this.utility = new Utility();
		this.observers = new ArrayList<ObserverAddressBook>();
		this.changed = false;
		this.book = book;
	}

	private static class SingltonHelper {
		public static final AddressBookImpl newBook = new AddressBookImpl(new ArrayList<AddressEntry>());
	}

	public static AddressBookImpl getInstance() {
		return SingltonHelper.newBook;
	}

	protected Object readResolve() {
		return getInstance();
	}

	public List<ObserverAddressBook> getObserver()
	{
		return this.observers;
	}
	public List<Address> getAddressDetails() {
		List<Address> addresses = new ArrayList<>();

		String key = "Yes";

		while (key.equalsIgnoreCase("Yes")) {
			System.out.println("\n ******Enter Address*******");

			System.out.print("\n Locality : ");
			String locality = utility.getLine();

			System.out.print(" City : ");
			String city = utility.getLine();

			System.out.print(" State : ");
			String state = utility.getLine();

			System.out.print(" Zip : ");
			String zip = utility.getLine();

			Address address = new Address(locality, city, state, zip);

			addresses.add(address);

			System.out.print("\n Do you want to add another address (Yes/no):");
			key = utility.getLine();
		}
		return addresses;
	}

	public List<Contact> getContactDetails() {
		String key = "no";
		List<Contact> contacts = new ArrayList<Contact>();
		System.out.println("\n ******Enter Contacts*********");
		do {

			System.out.print("\n Contact : ");
			String tempContact = utility.getLine();

			Contact contact = new Contact(tempContact);

			contacts.add(contact);

			System.out.print("\n Do you want to add another contact (Yes/no):");
			key = utility.getLine();

		} while (key.equalsIgnoreCase("Yes"));

		return contacts;
	}

	@Override
	public void addAddress() {

		String firstName;
		String lastName;

		System.out.print("\n ******Enter Details******** " + "\n\n First Name : ");

		firstName = utility.getLine();

		System.out.print(" Last Name : ");
		lastName = utility.getLine();

		List<Address> addresses = getAddressDetails();

		List<Contact> contacts = getContactDetails();

		AddressEntry newEntry = new AddressEntry(firstName, lastName, addresses, contacts);
		changed = true;

		book.add(newEntry);

		saveData(book);

	}

	public void saveData(List<AddressEntry> book) {
		try {
			mapper.writeValue(new File("newAddressBook.json"), book);
		} catch (IOException e) {
			e.printStackTrace();
		}
		notifyObservers("AddressBook :: The book is updated");
	}

	@Override
	public void removeAddress(String firstName, String lastName) {

		try {
			loadAddressBook();
			AddressEntry newEntry = book.stream().filter(entry -> entry.getFirstName().equalsIgnoreCase(firstName)
					&& entry.getLastName().equalsIgnoreCase(lastName)).findFirst().get();
			
			this.changed = true;
			
			notifyObservers(" Address is removed ");
			book.remove(newEntry);
			saveData(book);
		}
		catch (Exception e) {
			System.out.println("\n No Records found ");
		}

	}

	@Override
	public void editAddress(String firstName, String lastName) {

		try {
			loadAddressBook();
			AddressEntry newEntry = book.stream()
					.filter(entry -> entry.getFirstName().equals(firstName) && entry.getLastName().equals(lastName))
					.findFirst().get();
			List<Address> addresses = newEntry.getAddresses();

			System.out.print("\n Remove(rm) or Add(add) a new address : ");
			String command = utility.getLine();

			if ("rm".equalsIgnoreCase(command)) {
				System.out.print("\n Enter zip to remove address : ");
				String zip = utility.getLine();

				Address entry = addresses.stream().filter(address -> address.getZip().equals(zip)).findFirst().get();
				addresses.remove(entry);
				this.changed = true;

			}
			if ("add".equalsIgnoreCase(command)) {
				List<Address> address = getAddressDetails();

				address.forEach(entry -> addresses.add(entry));

				this.changed = true;
			}

			saveData(book);
		} catch (Exception e) {
			System.out.println("\n No records Found ");
		}
	}

	public void editContact(String firstName, String lastName) {
		try {

			loadAddressBook();
			AddressEntry newEntry = book.stream()
					.filter(entry -> entry.getFirstName().equals(firstName) && entry.getLastName().equals(lastName))
					.findFirst()
					.get();

			List<Contact> contacts = newEntry.getContacts();

			System.out.print("\n Remove(rm) or Add(add) a new contact : ");

			String command = utility.getLine();

			if ("rm".equalsIgnoreCase(command)) {
				System.out.print("\n Enter contact to remove contact : ");
				String contactNo = utility.getLine();

				Contact entry = contacts
						.stream()
						.filter(contact -> contact.getContact().equals(contactNo))
						.findFirst()
						.get();
				
				contacts.remove(entry);
				this.changed = true;

			}
			if ("add".equalsIgnoreCase(command)) {
				List<Contact> newContact = getContactDetails();

				newContact.forEach(entry -> contacts.add(entry));
				this.changed = true;

			}
			saveData(book);
		} catch (Exception e) {
			System.out.println("\n No records Found ");
		}

	}

	public void edit() {
		
		System.out.print("\n Enter what you want to edit address/ contact : ");
		String field = utility.getLine();

		System.out.print("\n Enter FirstName and LastName :");
		
		System.out.print(" FirstName : ");
		String firstName = utility.getLine();

		System.out.print(" LastName : ");
		String lastName = utility.getLine();
		
		if ("Contact".equalsIgnoreCase(field)) {
		
			editContact(firstName, lastName);
		
		}else if (field.equalsIgnoreCase("address")) {
		
			editAddress(firstName, lastName);
		
		} else {
		
			System.out.print("\n You entered wrong choice");
		
		}
	}

	@Override
	public void sortByZip() {

	}

	@Override
	public void sortByName() {
		// TODO Auto-generated method stub

	}

	@Override
	public void displayBook() {

		loadAddressBook();

		book.forEach(System.out::println);

	}

	public List<AddressEntry> loadAddressBook() {

		try {
			book.clear();
			AddressEntry[] oldBook = mapper.readValue(new File("newAddressBook.json"), AddressEntry[].class);

			for (AddressEntry entry : oldBook) {
				book.add(entry);
			}
			this.changed = true;
			notifyObservers("Book loaded from database");
			return book;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Object clone() {
		List<AddressEntry> tempBook = new ArrayList<AddressEntry>();

		book.forEach(tempBook::add);

		return new AddressBookImpl(tempBook);
	}

	/*public static void main(String[] args) {

		AddressBookImpl book = new AddressBookImpl(book);
		book.displayBook();

	}*/

	public void register(ObserverAddressBook obj) {
		
		Object MUTEX= new Object(); 
		if(obj == null) throw new NullPointerException("Null Observer");
		synchronized (MUTEX) {
		if(!observers.contains(obj)) observers.add(obj);
		}
		notifyObservers("New User Registered");
		}
	//@Override
	/*public void register(ObserverAddressBook observer, SubjectAddressBook subject) {
		
		if (observer == null)
			throw new NullPointerException("Null Observer");
		
		//this.observers.forEach(observer1-> System.out.println(observer1.getName()));
		this.register(observer);
		
		observer.update("New Observer Successfully created");
		//
		this.changed = true;
		notifyObservers(" New Observer Registered");
		
	}*/

	@Override
	public void unregister(ObserverAddressBook observer) {

		observers.remove(observer);
		this.changed = true;
		notifyObservers("\n Observer unregistered");
	}

	@Override
	public void notifyObservers(String message) {

		List<ObserverAddressBook> observersLocal = null;

		if (!changed) {
			return;
		}
		observersLocal = new ArrayList<>(this.observers);
		this.changed = false;

		for (ObserverAddressBook obj : observersLocal) {
			obj.update(message);
		}
	}

	@Override
	public Object getUpdate(ObserverAddressBook observer) {

		return this.observers;

	}

	@Override
	public void runCommand(String command, SubjectAddressBook subject) {

		switch (command) {

		case "rm":
			System.out.println("\n Enter FirstName and LastName : ");

			System.out.print(" FirstName : ");
			String firstName = utility.getLine();

			System.out.print(" LastName : ");
			String lastName = utility.getLine();

			removeAddress(firstName, lastName);
			break;

		case "add":
			addAddress();
			break;
			
		case "edit":
			edit();
			break;
			
		case "display":
			displayBook();
			break;
			
		/*case "register":
			System.out.print("\n Enter Observer name : ");
			String name= utility.getLine();
			
			ObserverAddressBook newObserver= new AddressBookObservers(name);
			register(newObserver, subject);
			
			break;
			
		case "unregister":
			System.out.print("\n Enter name of the observer : ");
			name= utility.getLine();
			try 
			{
				ObserverAddressBook tempOberver=observers
						.stream()
						.filter(observer-> observer
								.getName()
								.equals(name))
						.findFirst()
						.get();
				
				unregister(tempOberver);
			}
			catch(Exception e)
			{
				System.out.println("\n Records not found");
			}
			
			break;
*/			
		default: System.out.println("\n Oops You Entered wrong command");
			
		}
	}

}
