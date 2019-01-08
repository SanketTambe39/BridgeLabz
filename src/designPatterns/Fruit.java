package designPatterns;

public class Fruit implements Item {
	
		private int price;
		private double weight;
		private String name;
		
		public Fruit(String name, int price, double weight) {
			
			this.name=name;
			this.price=price;
			this.weight=weight;
		}
		
		public String getName()
		{
			return this.name;
		}
		
		public int getPricePerKg()
		{
			return this.price;
		}
		
		public double getWeight()
		{
			return weight;
		}
		
		@Override
		public int accept(ShoppingCartVistor visitor) {
			
			return visitor.visit(this);
		}

}
