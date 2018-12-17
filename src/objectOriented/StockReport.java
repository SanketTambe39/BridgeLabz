package objectOriented;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class StockReport {

	public static void main(String[] args) throws IOException {

		ObjectMapper mapper = new ObjectMapper();

		try {
		
			File file = new File("Stocks.json");
			JsonNode node = mapper.readTree(file);
			JsonNode Stocks=node.path("Stocks");
			
			int sum=0;
			for(JsonNode tempNode:Stocks)
			{
				String name= tempNode.path("name").asText();
				int price= tempNode.path("price").asInt();
				int nOfShare= tempNode.path("nOfShare").asInt();
				
				System.out.println("\n Name : "+name+"\n No. Of Shares : "+nOfShare+"\n Price : "
						+ "Rs"+price+"\n Total Stock price : "+(price*nOfShare)+"Rs");
				sum = sum + (price*nOfShare);
			}
			 System.out.println("\n Total stocks price : "+sum+"Rs");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

		
	}

}

/*class Stocklist {
	private Stocks stock;

	public Stocklist(Stocks stock) {
		this.stock = stock;
	}

	public void setStock(Stocks stock) {
		this.stock = stock;
	}

	public Stocks getStock() {
		return stock;
	}

}

class Stocks {

	private String name;
	private int nOfShares;
	private int price;

	public Stocks(String name, int nOfShares, int price) {
		this.name = name;
		this.nOfShares = nOfShares;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getNOfShares() {
		return nOfShares;
	}

	public int getPrice() {
		return price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNOfShares(int nOfShares) {
		this.nOfShares = nOfShares;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String to_String() {
		String str = "\"Stock\": " + "{" + "\"name\":" + name + ", \"nOfShares\" :" + nOfShares + "\"Price :\"" + price
				+ "}";
		return str;
	}
}
*/