package designPatterns;

public class ShoppingCartClient {
	
	
	public static void main(String[] args) {
	
		
		ShoppingCartClient client= new ShoppingCartClient();
		
		Item []items= {new Book("25468", "C-Programming", 85), new Book("58742", "Core JAVA", 95), new Book("65425", "Python-CookBook", 125),
				new Fruit("Apple", 65, 2), new Fruit("Oranges", 45, 3), new Fruit("Mango", 55, 5)};

		int total= client.calculatePrice(items);
		
		System.out.println("\n Total Amount : "+total+"Rs");
		
	}
	

	private int calculatePrice(Item[] items) {
		
		ShoppingCartVistor visitor= new ShoppingCartVisitorImpl();
		int sum =0;
		
		for(Item item: items)
		{
			sum = sum + item.accept(visitor);
		}
		
		return sum;
	}
}
