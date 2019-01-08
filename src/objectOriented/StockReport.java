package objectOriented;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import objectOrinted.UserStocks;
import utility.Utility;

public class StockReport 
{

	protected ObjectMapper mapper;
	protected File file;
	protected LinkedList<UserStocks> userStockList;
	protected LinkedList<ShareList> shareList;
	protected static Utility utility;
	
	
	
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
			
			Date date= new Date();
			System.out.print("\n Enter Company Name : ");
			String name=utility.getLine();
			
			System.out.print("\n Enter Share Symbol : ");
			char symbol=utility.getLine().charAt(0);
			
			System.out.print("\n Current no. of shares available : ");
			int numOfShare=utility.getInt();
			
			System.out.print("\n Enter price per Shares : ");
			double price=utility.getDouble();
			
			ShareList newShare=new ShareList(name, price, numOfShare, symbol, date.toLocaleString());
			
			shareList.add(newShare);
			
			mapper.writeValue(companyShareFile, shareList);
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		
	}
	
	public void displayReport(String userName) throws JsonParseException, JsonMappingException, IOException
	{
		UserStocks users[]=mapper.readValue(new File("StockReport.json"), UserStocks[].class);
		userStockList.clear();
		for(UserStocks user: users)
		{
			userStockList.add(user);
		}
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
				}
			}
		}
	}
	
	public double valueOf(String userName)
	{
		double sum=0;
		for(UserStocks user: userStockList)
		{
			if(user.getUserName().equals(userName))
			{
				for(ShareList share: user.getShareList())
				{
					double total=share.getNumOfShare()*share.getPrice();
					sum = sum + total;
				}
			}
		}
		return sum;
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
			displayReport(userName);
			System.out.println(" Total Balance of User shares is: "+valueOf(userName)+"$");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		} 
		
	}
	
	
	public static void main(String[] args) 
	{
	
		StockReport newStock = new StockReport("StockReport.json");
		
		//newStock.addCompanyShares();
		newStock.getStockReport();
	}
}
