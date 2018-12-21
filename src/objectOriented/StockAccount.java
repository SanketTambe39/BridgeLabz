package objectOriented;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;

import utility.Utility;
//import com.sun.org.apache.bcel.internal.classfile.Node;

public class StockAccount extends StockReport
{
	private static File file;
	private static ObjectMapper mapper;
	private String userName;
	StockAccount(String fileName) throws JsonProcessingException, IOException
	{
		file=new File(fileName);
		mapper= new ObjectMapper();
		System.out.print("\n Enter UserName : ");
		Utility utility=new Utility();
		userName=utility.getString();
		
		createNewAccount(userName);
		System.out.println("\n Welcome ---"+userName+ "\n Your Account is successfully created");
	}
	
	
	public Stocks newShareEntry(String name, String symbol, int price)
	{
		return new Stocks(name, price, 0, symbol);
	}
	
	
	public void createNewAccount(String userName) throws JsonGenerationException, JsonMappingException, IOException
	{
		
		StockObject stockObject = new StockObject();
		ArrayList<Stocks> stocks=new ArrayList<Stocks>();
		StockList stockList=new StockList();
		
		stocks.add(newShareEntry("IBM", "@", 500));
		stocks.add(newShareEntry("GOOGLE", "G", 1000));
		stocks.add(newShareEntry("YAHOO", "Y", 750));
		stocks.add(newShareEntry("MICROSOFT", "M", 950));
		stocks.add(newShareEntry("AMAZON", "A", 940));
		
		stockList.setUserName(userName);
		stockList.setStocks(stocks);
		
		stockObject.setStockList(stockList);
		
		mapper.writeValue(file, stockObject);
	}
	
	double valueOf() throws IOException
	{
		JsonNode rootNode = mapper.readTree(file);
		JsonNode stockList = rootNode.path("stockList");
		JsonNode stocks = stockList.path("stocks");
		//System.out.println(totalValueOfStock(stocks));
		return totalValueOfStock(stocks);
	}
	
	void buy(int amount, String symbol) throws IOException
	{
		 
		StockObject stockObject = new StockObject();
		StockList stockList=new StockList();
		
		stockObject=mapper.readValue(file, StockObject.class);		
		
		stockList= stockObject.getStockList();
		
		ArrayList<Stocks> stocks=stockList.getStocks();
	      
		for(Stocks stock: stocks)
		{
			if(stock.getSymbol().equals(symbol))
			{
				int numOfShare=(int)(amount/stock.getPrice())+stock.getNumOfShare();
				stock.setNumOfShare(numOfShare);
				
			}
			
		}
		stockList.setStocks(stocks);
		stockObject.setStockList(stockList);
		mapper.writeValue(file, stockObject);
		  
	}
	
	
	void sell(int amount, String symbol) throws IOException
	{
		 
		StockObject stockObject = new StockObject();
		stockObject=mapper.readValue(file, StockObject.class);		
		StockList stockList= stockObject.getStockList();
		
		ArrayList<Stocks> stocks=stockList.getStocks();
	      
		for(Stocks stock: stocks)
		{
			if(stock.getSymbol().equals(symbol))
			{
				int numOfShare=stock.getNumOfShare()-(int)(amount/stock.getPrice());
				stock.setNumOfShare(numOfShare);
			}
			
		}
		stockList.setStocks(stocks);
		stockObject.setStockList(stockList);
		mapper.writeValue(file, stockObject);
	     
	}
	
	
	public void printReport(String fileName) throws JsonProcessingException, IOException
	{
		StockReport stock= new StockReport(fileName);
		stock.printStockDetails(userName);
	}
	
	
	public static void main(String[] args)
	{
	
		try 
		{
			
			Utility utility = new Utility();
			StockAccount stockAccount = new StockAccount("Stocks1.json");
			
			while(true)
			{
				System.out.println("\n *****************Stock Account***************");
				System.out.print("\n\t 1. Buy Shares \n\t "
								+ "2. Sell Shares \n\t 3. Print Report \n\t 4. Total Account Balance "
								+ "\n\t 5. Exit \n Enter Your choice :");
				
				int ch = utility.getInt();
				
				switch(ch)
				{
							
				case 1: System.out.print("\n Enter the amount : ");
						int amount=utility.getInt();
						System.out.print("\n Enter the symbol : ");
						String symbol= utility.getString();
				
						stockAccount.buy(amount, symbol);
						break;
						
				case 2: System.out.print("\n Enter the amount : ");
						amount=utility.getInt();
						System.out.print("\n Enter the symbol : ");
						symbol= utility.getString();
		
						stockAccount.sell(amount, symbol);
						break;
				
				case 3: stockAccount.printReport("Stocks1.json");
						break;
						
				case 4: double toatalBalance=stockAccount.valueOf();
						System.out.println("\n Total Account balance is : "+toatalBalance );
						break;
						
				case 5: return;
				}
			}
			
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}




