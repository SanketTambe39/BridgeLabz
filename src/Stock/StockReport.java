package Stock;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import utility.Utility;

public class StockReport 
{

	private ObjectMapper mapper;
	private File file;
	private LinkedList<UserStocks> userStockList;
	private LinkedList<ShareList> shareList;
	private static Utility utility;
	
	
	
	public StockReport() {}
	public StockReport(String fileName)
	{
		mapper=new ObjectMapper();
		file=new File(fileName);
		utility= new Utility();
		userStockList= new LinkedList<UserStocks>();
		shareList= new LinkedList<ShareList>();
	}
	
	
	public void addCompanyShares()
	{
		
		File companyShareFile= new File("CompanyShares.json");
		
		try 
		{
			ShareList shareListArray[]=mapper.readValue(companyShareFile, ShareList[].class);
			shareList.clear();
			for(ShareList share: shareListArray)
			{
				shareList.add(share);
			}
			
			System.out.print("\n Enter Company Name : ");
			String name=utility.getLine();
			
			System.out.print("\n Enter Share Symbol : ");
			char symbol=utility.getLine().charAt(0);
			
			System.out.print("\n Current no. of shares available : ");
			int numOfShare=utility.getInt();
			
			System.out.print("\n Enter price per Shares : ");
			double price=utility.getDouble();
			
			ShareList newShare=new ShareList(name, price, numOfShare, symbol);
			
			shareList.add(newShare);
			
			mapper.writeValue(companyShareFile, shareList);
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		
	}
	
	public void getStockReport()
	{
		
		try 
		{
			UserStocks users[]=mapper.readValue(file, UserStocks[].class);
			userStockList.clear();
			for(UserStocks user: users)
			{
				userStockList.add(user);
			}
			
			System.out.print("\n Enter username to get their StockReport : ");
			String userName=utility.getLine();
			double sum=0;
			
			for(UserStocks user: userStockList)
			{
				if(user.getUserName().equals(userName))
				{
					
					System.out.println("\n "+userName+" stock report : \n");
					System.out.println("---------------------------------------");
					
					for(ShareList share: user.getShareList())
					{
						System.out.println(" "+share.toString());
						double total=share.getNumOfShare()*share.getPrice();
						System.out.println(" Total share price : "+total+"$");
						System.out.println("---------------------------------------");
						sum = sum + total;
					}
				}
			}
			System.out.println(" Total Balance of User shares is: "+sum+"$");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		
	}
	public static void main(String[] args) 
	{
	
		StockReport newStock = new StockReport("StockReport.json");
		newStock.getStockReport();
	}
}
