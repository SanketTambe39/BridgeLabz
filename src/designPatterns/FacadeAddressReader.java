package designPatterns;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import objectOriented.AddressEntry;

public class FacadeAddressReader implements BookReader
{

	@Override
	public List<String> readAddressBook() 
	{
	
		ObjectMapper mapper= new ObjectMapper();
		File file = new File("AddressBook.json");
		
		AddressEntry[] entries;
		try 
		{
			entries = mapper.readValue(file, AddressEntry[].class);
			List<String> addressEntry= new ArrayList<String>();
			
			for(AddressEntry entry: entries)
			{
				addressEntry.add(entry.toString());
			}
			
			return addressEntry;
			
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return null;
		
	}

	
	
}
