package objectOriented;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import utility.Utility;

public class InventoryManager 
{

	
	public static void main(String[] args) 
	{
	
		File file= Utility.getFile("Inventory.json");
		
		Utility utility= new Utility();
		
		ObjectMapper mapper= new ObjectMapper();
		
		try {
			
			JsonNode rootnode= mapper.readTree(file);
			
			System.out.print("\n Enter which inventory details u did have ? : ");
		    
		    String inventoryProduct = utility.getString().toLowerCase();
		    
		    JsonNode inventory= rootnode.path(inventoryProduct);
		    
		    //System.out.println(inventory);
		    System.out.println("\n The details of "+inventoryProduct+" is : \n");
		    
		    for(JsonNode node: inventory)
		    {
		    	System.out.print("*****************************************");
		    	System.out.println("\n Json String : \n "+ node);
		    	System.out.print("-----------------------------------------");
		    	String name = node.path("name").asText();
		    	int price = node.path("price").asInt();
		    	int weight = node.path("weight").asInt();
		    	
		    	System.out.println("\n Name : "+name+"\n Price : "+price+"Rs \n "
		    			+ "Weight : "+weight+"kg \n Total Amount : "+(weight*price)+"Rs");
		    	System.out.println("*****************************************\n");
		    }
		
		} 
		catch (IOException e) {
			
			e.printStackTrace();
		
		}				
		
		
	}
	
}
