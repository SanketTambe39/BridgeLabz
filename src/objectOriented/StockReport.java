package objectOriented;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import utility.Utility;

public class StockReport {

	private File file;
	private JsonNode rootNode;
	private ObjectMapper mapper;

	StockReport(){};
	
	StockReport(String fileName) throws JsonProcessingException, IOException {
		file = new File(fileName);

		mapper = new ObjectMapper();

		rootNode = mapper.readTree(file);
	}

	double totalValueOfStock(JsonNode Stocks) {
		double totalValueOfStock = 0;

		for (JsonNode tempNode : Stocks) {
			int price = tempNode.path("price").asInt();
			int numOfShare = tempNode.path("numOfShare").asInt();
			totalValueOfStock = totalValueOfStock + (price * numOfShare);
		}

		return totalValueOfStock;
	}

	void printStockDetails(String nameOfStockUser) throws JsonProcessingException, IOException {
		
		JsonNode userAccount = rootNode.path("stockList");
		String userName = userAccount.path("userName").textValue();
		
		if(userName.equals(nameOfStockUser))
		{
			JsonNode stocks= userAccount.path("stocks");
			
			for (JsonNode tempNode : stocks) 
			{

				String name = tempNode.path("name").asText();
				int price = tempNode.path("price").asInt();
				int numOfShare = tempNode.path("numOfShare").asInt();
				String symbol = tempNode.path("symbol").asText();
				
				System.out.println( "\n Name            : " + name +
									"\n Symbol          : \'"+symbol+ 
									"\'\n No.Of Shares    : " + numOfShare + 
									"\n Price           : " + price + "$"+
									"\n Total price     : " + (price * numOfShare) + "$");

			}

			System.out.println("\n Total stocks price : " + totalValueOfStock(stocks) + "$");
			
		}
		else
		{
			System.out.println("\n User Not Found.........!!!!!!!!!");
		}

	}

	public static void main(String[] args) throws IOException {

		Utility utility = new Utility();

		try {

			StockReport stock = new StockReport("Stocks1.json");
			System.out.print("\n Enter the name of stock account user : ");

			String nameOfStockUser = utility.getString();

			try {
				stock.printStockDetails(nameOfStockUser);

			} catch (Exception e) {
				System.out.println("\n User not exist");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}

}

/*
 * class Stocklist { private Stocks stock;
 * 
 * public Stocklist(Stocks stock) { this.stock = stock; }
 * 
 * public void setStock(Stocks stock) { this.stock = stock; }
 * 
 * public Stocks getStock() { return stock; }
 * 
 * }
 * 
 * class Stocks {
 * 
 * private String name; private int nOfShares; private int price;
 * 
 * public Stocks(String name, int nOfShares, int price) { this.name = name;
 * this.nOfShares = nOfShares; this.price = price; }
 * 
 * public String getName() { return name; }
 * 
 * public int getNOfShares() { return nOfShares; }
 * 
 * public int getPrice() { return price; }
 * 
 * public void setName(String name) { this.name = name; }
 * 
 * public void setNOfShares(int nOfShares) { this.nOfShares = nOfShares; }
 * 
 * public void setPrice(int price) { this.price = price; }
 * 
 * public String to_String() { String str = "\"Stock\": " + "{" + "\"name\":" +
 * name + ", \"nOfShares\" :" + nOfShares + "\"Price :\"" + price + "}"; return
 * str; } }
 */