package Stock;

public class ShareList 
{

	private String name;
	private double price;
	private int numOfShare;
	private char symbol;
	
	public ShareList() {}

	public ShareList(String name, double price, int numOfShare, char symbol)
	{
		this.name=name;
		this.numOfShare=numOfShare;
		this.price=price;
		this.symbol=symbol;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNumOfShare() {
		return numOfShare;
	}
	public void setNumOfShare(int numOfShare) {
		this.numOfShare = numOfShare;
	}
	public char getSymbol() {
		return symbol;
	}
	public void setSymbol(char symbol) {
		this.symbol = symbol;
	}
	
	public String toString()
	{
		return "Name:"+name+"  Symbol:"+symbol+"  NumberOfShare:"+numOfShare+" Price:"+price;
	}
	
}
