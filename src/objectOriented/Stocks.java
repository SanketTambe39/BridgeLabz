package objectOriented;

public class Stocks
{
	private String name;
	private int price;
	private int numOfShare;
	private String symbol;
	
	public Stocks(){};
	public Stocks(String name, int price, int numOfShare, String symbol)
	{
		this.name =name;
		this.price=price;
		this.numOfShare=numOfShare;
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
	public int getPrice()
	{
		return this.price;
	}
	public void setNumOfShare(int number)
	{
		this.numOfShare=number;
	}
	public int getNumOfShare()
	{
		return this.numOfShare;
	}
	public void setSymbol(String symbol)
	{
		this.symbol=symbol;
	}
	public String getSymbol()
	{
		return this.symbol;
	}
	
	/*public String toString()
	{
		String jsonString="[\"name\":"+name+"\"price\": "+price+
							"\"numOfShare\":"+numOfShare+"\"symbol\":"+symbol+"}";
		
		return jsonString;
	}*/
}