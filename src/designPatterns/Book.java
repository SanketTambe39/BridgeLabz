package designPatterns;

public class Book implements Item{

	
	private String isbn;
	private String name;
	private int price;
	
	public Book(String isbn, String name, int price) {
		
		this.name=name;
		this.isbn=isbn;
		this.price=price;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getISBN()
	{
		return isbn;
	}
	
	public int getPrice()
	{
		return this.price;
	}
	
	@Override
	public int accept(ShoppingCartVistor visitor) {
		
		return visitor.visit(this);
	}

}
