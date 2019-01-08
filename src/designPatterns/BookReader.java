package designPatterns;

import java.io.IOException;
import java.util.List;

public interface BookReader 
{

	public List<String> readAddressBook() throws IOException;
	
}
