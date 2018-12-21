package objectOriented;

import java.util.ArrayList;

public class StockList
{
	
	private String userName;
	private ArrayList<Stocks> stocks=new ArrayList<Stocks>();
	
	public StockList() {}
	
	public StockList(String userName, ArrayList<Stocks> stocks)
	{
		this.userName=userName;
		this.stocks=stocks;
	}
	public void setUserName(String userName)
	{
		this.userName= userName;
	}
	public String getUserName()
	{
		return this.userName;
	}
	public void setStocks(ArrayList<Stocks> stocks)
	{
		this.stocks=stocks;
	}
	public ArrayList<Stocks> getStocks()
	{
		return this.stocks;
	}
	

}
