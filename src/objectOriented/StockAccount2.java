package objectOriented;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import utility.Utility;
import dataStructure.LinkedList;
//import jdk.internal.module.ModuleLoaderMap.Mapper;

public class StockAccount2 
{

	private static ObjectMapper mapper;
	private static File file;
	private LinkedList<CompanyShares> stockList=new LinkedList<CompanyShares>();
	private LinkedList<Customers> user = new LinkedList<Customers>();
	private Customers customer;
	private UserInformation userInfo=new UserInformation();
	
	StockAccount2()
	{}
	StockAccount2(String fileName) throws JsonGenerationException, JsonMappingException, IOException
	{
		addCompanyShares("IBM", "@", 500, 110);
		addCompanyShares("Nifty", "N", 800, 150);
		file= new File(fileName);
		mapper = new ObjectMapper();
		createAccount();
	}
	
	public void createAccount() throws IOException
	{
		Utility utility= new Utility();
		
		System.out.println("Enter UserName : ");
		
		String userName= utility.getString();
		
		CompanyShares share[]=new CompanyShares[stockList.size()+1];
		for(int i=0; i<=stockList.size(); i++)
		{
			share[i]=stockList.getNode(i);
			
		}

		customer= new Customers(userName, share);
		user=userInfo.getCustomers();
		user.add(customer);
		
		Customers cust[]=new Customers[user.size()+1];
		
		for(int i=0; i<=user.size(); i++)
		{
			cust[i]=user.getNode(i);
			System.out.println(cust[i].getUserName());
		}
		
		userInfo.setCustomers(cust);
		mapper.writeValue(file, userInfo);
	}
	
	public void addCompanyShares(String name, String symbol, double price, int numOfShares)
	{
		CompanyShares companyShare=new CompanyShares(name, symbol, price, numOfShares);
		stockList.insert(companyShare,0);
	}
	public void removeCompanyShares(String name)
	{
		for(int i=0; i<stockList.size(); i++)
		{
			if(stockList.getNode(i).equals(name))
			{
				stockList.remove(stockList.getNode(i));
			}
		}
	}
	/*public void buy(int amount, String symbol)
	{
		
		
	}
	*/
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException 
	{
	
		
		StockAccount2 newAccount= new StockAccount2("StockList.json");
		StockAccount2 newAccount2= new StockAccount2("StockList.json");
	}
	
}
