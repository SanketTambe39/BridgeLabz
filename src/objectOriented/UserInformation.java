package objectOriented;

//import java.util.ArrayList;

//import dataStructure.LinkedList;

//import dataStructure.LinkedList;

public class UserInformation 
{
	private Customers []customers;
	
	public UserInformation() {}
	public UserInformation(Customers[] customers)
	{
		this.customers=customers;
	}
	
	public void setCustomers(Customers[] customers)
	{
		this.customers=customers;
	}
	public Customers[] getCustomers()
	{
		return customers;
	}
}

class Customers
{

	private String userName;
	private CompanyShares stockList[];
	
	public Customers() {}
	public Customers(String userName, CompanyShares stockList[])
	{
		this.userName=userName;
		this.stockList=stockList;
	}
	
	public String getUserName()
	{
		return this.userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public CompanyShares[] getStockList()
	{
		return stockList;
	}
	public void setStockList(CompanyShares stockList[])
	{
		this.stockList=stockList;
	}
	
}

class CompanyShares
{
	
	private String name;
	private String symbol;
	private double price;
	private int numOfShares;
	public CompanyShares() {}
	public CompanyShares(String name, String symbol, double price, int numOfShares)
	{
		this.name = name;
		this.numOfShares=numOfShares;
		this.price=price;
		this.symbol=symbol;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
	public void setPrice(int price)
	{
		this.price = price;
	}
	public double getPrice()
	{
		return this.price;
	}
	public void setNumOfShares(int number)
	{
		this.numOfShares=number;
	}
	public int getNumOfShares()
	{
		return this.numOfShares;
	}
	public void setSymbol(String symbol)
	{
		this.symbol=symbol;
	}
	public String getSymbol()
	{
		return this.symbol;
	}
	
	
}