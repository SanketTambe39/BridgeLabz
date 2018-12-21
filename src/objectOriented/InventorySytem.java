package objectOriented;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import utility.Utility;

public class InventorySytem 
{

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException 
	{
		
		Utility u= new Utility();
		
		ObjectMapper mapper= new ObjectMapper();
		
	    File file= new File("Inventory.json");
	    
	    JsonNode rootNode= mapper.readTree(file);
	    
	    System.out.print("\n Enter which inventory details u did have ? : ");
	    
	    String product = u.getString().toLowerCase();
	    
	    JsonNode inventory = rootNode.path(product);
	    
	    System.out.println("\n "+product+" : ");
	    int sum=0;
	    
	    for(JsonNode node: inventory)
	    {
	    	String name = node.path("name").asText();
	    	int price = node.path("price").asInt();
	    	int weight = node.path("weight").asInt();
	    	
	    	System.out.println("\n Name : "+name+"\n Price : "+price+"Rs \n "
	    			+ "Weight : "+weight+"kg \n Total Amount : "+(weight*price)+"Rs");
	    
	    	sum=sum+(weight*price);
	    }
	    System.out.println("\n Total bill for "+product+" : "+sum+"Rs");
	   
	}

}

/*class Inventory
{
	private String name;
	   private int price;
	   private int weight;
	   
	   public String getName() {
	      return name;
	   }
	   public void setName(String name) {
	      this.name = name;
	   }
	   public int getPrice() {
	      return price;
	   }
	   public void setPrice(int price) {
	      this.price = price;
	   }
	   public int getWeight() {
		      return weight;
		   }
		   public void setWeight(int weight) {
		      this.weight = weight;
		   }
	   public String toString(){
	      return "Student [ name: "+name+", price: "+price+ ", weight: "+weight+"]";
	   }

}*/