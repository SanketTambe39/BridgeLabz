package designPatterns;

public class ShoppingCartVisitorImpl implements ShoppingCartVistor{

	@Override
	public int visit(Book book) {
		int cost=0;
		
		if(book.getPrice()>50)
		{
			cost=(int) (book.getPrice()-(0.5*book.getPrice()));
		}
		else
		{
			cost=book.getPrice();
		}
		
		System.out.println("\n Book ISBN : "+book.getISBN()+" Name :  "+book.getName()
						  +" Cost : "+cost);
		
		return cost;
	}

	@Override
	public int visit(Fruit fruit) {

		int cost = (int) (fruit.getPricePerKg()*fruit.getWeight());
	
		System.out.println("\n Fruit Name :  "+fruit.getName()+" Weight : "+fruit.getWeight()
		  				  +" Cost : "+cost);
		return cost;
	}

}
