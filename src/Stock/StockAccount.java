package Stock;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;


import com.fasterxml.jackson.databind.ObjectMapper;

import utility.Utility;

public class StockAccount extends StockReport
{
	private ObjectMapper mapper;
	private File file;
	private LinkedList<UserStocks> userStockList;
	private LinkedList<ShareList> shareList;
	private Utility utility;
	
	public StockAccount() {}
	
	public StockAccount(String fileName) 
	{
		file=new File(fileName);
		mapper=new ObjectMapper();
		utility=new Utility();
		shareList=new LinkedList<ShareList>();
		userStockList=new LinkedList<UserStocks>();
		//createNewUser();
	}
	public void createNewUser()
	{
		UserStocks newUser= new UserStocks();
	
		try 
		{
			UserStocks users[]=mapper.readValue(file, UserStocks[].class);
			userStockList.clear();
			for(UserStocks user: users)
			{
				userStockList.add(user);
			}
			System.out.print("\n Enter Username : ");
			String name=utility.getLine();
			
			newUser.setUserName(name);
			newUser.setShareList(shareList);
			userStockList.add(newUser);
			
			mapper.writeValue(file, userStockList);
			//return userStockList;
			
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		//return userStockList;
	}
	
	public void buy(int amount, String symbol)
	{
		
		try 
		{
			UserStocks users[] = mapper.readValue(file, UserStocks[].class);
			
			ShareList shares[]=mapper.readValue(new File("CompanyShares.json"), ShareList[].class);
			
			userStockList.clear();
			shareList.clear();
			
			System.out.print("\n Enter Username for buying shares : ");
			String userName= utility.getLine();
			
			for(ShareList share: shares)
			{
				shareList.add(share);
			}
			for(UserStocks user: users)
			{
				userStockList.add(user);
			}
			
			for(UserStocks user: userStockList)
			{
				if(user.getUserName().equals(userName))
				{
					boolean flag=false;
					for(ShareList share: user.getShareList())
					{
						
						if(symbol.equals(share.getSymbol()+""))
						{
							int numOfShare= (int) (amount/share.getPrice());
							share.setNumOfShare(numOfShare+share.getNumOfShare());
							flag=true;
						}
						
					}
					if(!flag)
					{
						
						for(ShareList share: shareList)
						{
							if(symbol.equals(share.getSymbol()+""))
							{
								int numOfShare= share.getNumOfShare()-(int) (amount/share.getPrice());
								share.setNumOfShare(numOfShare);
								System.out.println(share.getNumOfShare());
								user.getShareList().add(share);
							}	
						}
						mapper.writeValue(new File("CompanyShares.json"), shareList);
						for(ShareList share: user.getShareList())
						{
							
							if(symbol.equals(share.getSymbol()+""))
							{
								int numOfShare= (int) (amount/share.getPrice());
								share.setNumOfShare(numOfShare+share.getNumOfShare());
							}
							
						}
					}
					
				}
			}
			/*for(UserStocks user: users)
			{
				if(user.getUserName().equals(userName))
				{
					for(ShareList share: user.getShareList())
					{
						if(symbol.equals(share.getSymbol()))
						{
							
							for(ShareList shareInList: shareList)
							{
								int numOfShare=(int) (shareInList.getNumOfShare()-(amount/shareInList.getPrice()));
								if(symbol.equals(shareInList.getSymbol()+"") && numOfShare>=0)
								{
									shareInList.setNumOfShare(numOfShare);
								}
							}
							int numOfShare=(int) (share.getNumOfShare()+(amount/share.getPrice()));
							share.setNumOfShare(numOfShare);
						}
					}
				}*/
			//userStockList.add(user);
			
			
			mapper.writeValue(file, userStockList);
			
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args) 
	{
	
		StockAccount newAccount=new StockAccount("StockReport.json");
		newAccount.buy(5000, "M");
	}

}
