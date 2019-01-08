package designPatterns;

import java.io.IOException;
import java.util.List;

public class ReadAddressesUsingFacade 
{

	public static void main(String[] args) throws IOException 
	{
	
		BookReader reader= new FacadeAddressReader();
		/*List<String> addressBook=reader.readAddressBook();
		
		addressBook.forEach((String entry)->System.out.println(entry));*/
		reader.readAddressBook().forEach(System.out::println);
	}
	
}
