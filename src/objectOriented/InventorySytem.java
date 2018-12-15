package objectOriented;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class InventorySytem 
{

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException 
	{
		ObjectMapper mapper= new ObjectMapper();
		
	    File file= new File("Inventory.json");
	    
	    
	      //System.out.println(jsonString);
	      
	      
	}

}

class Inventory
{
	private String name;
	   private int age;
	   public Student()
	   {
		   
	   }
	   public String getName() {
	      return name;
	   }
	   public void setName(String name) {
	      this.name = name;
	   }
	   public int getAge() {
	      return age;
	   }
	   public void setAge(int age) {
	      this.age = age;
	   }
	   public String toString(){
	      return "Student [ name: "+name+", age: "+ age+ " ]";
	   }

}