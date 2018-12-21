package objectOriented;


public class StockObject
{

	private StockList stockList;
	public StockObject() {}
	public StockObject(StockList stockList) 
	{
		this.stockList=stockList;
	}
	public void setStockList(StockList stockList)
	{
		this.stockList=stockList;
	}
	public StockList getStockList()
	{
		return this.stockList;
	}
}
