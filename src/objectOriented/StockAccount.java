package objectOriented;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import objectOrinted.UserStocks;
import utility.Utility;

public class StockAccount extends StockReport {
	private ObjectMapper mapper;
	private File file;
	private LinkedList<UserStocks> userStockList;
	private LinkedList<ShareList> shareList;
	private static Utility utility;
	public StockAccount() {
	}

	public StockAccount(String fileName) {
		file = new File(fileName);
		mapper = new ObjectMapper();
		utility = new Utility();
		shareList = new LinkedList<ShareList>();
		userStockList = new LinkedList<UserStocks>();
		// createNewUser();
	}

	public void createNewUser() {
		UserStocks newUser = new UserStocks();
		try {
			UserStocks users[] = mapper.readValue(file, UserStocks[].class);
			userStockList.clear();
			for (UserStocks user : users) {
				userStockList.add(user);
			}
			System.out.print("\n Enter Username : ");
			String name = utility.getLine();

			newUser.setUserName(name);
			newUser.setShareList(shareList);
			userStockList.add(newUser);

			mapper.writeValue(file, userStockList);
			// return userStockList;

		} catch (IOException e1) {
			e1.printStackTrace();
		}
		// return userStockList;
	}

	public void updateNumOfCompanyShares(int numOfShare, String symbol) {

		try {
			ShareList shares[] = mapper.readValue(new File("CompanyShares.json"), ShareList[].class);

			shareList.clear();

			for (ShareList share : shares) {
				if (symbol.equals(share.getSymbol() + "")) {
					numOfShare = share.getNumOfShare() - numOfShare;
					share.setNumOfShare(numOfShare);
				}
				shareList.add(share);
			}
			mapper.writeValue(new File("CompanyShares.json"), shareList);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void addShareToUserList(String symbol, int amount, String userName)throws IOException {
		UserStocks users[] = mapper.readValue(file, UserStocks[].class);
		ShareList shares[] = mapper.readValue(new File("CompanyShares.json"), ShareList[].class);

		userStockList.clear();

		for (UserStocks user : users) {
			userStockList.add(user);
		}

		for (UserStocks user : userStockList) {
			if (user.getUserName().equals(userName)) {
				for (ShareList share : shares) {

					if (symbol.equals(share.getSymbol() + "")) {
						int numOfShare = (int) (amount / share.getPrice());
						updateNumOfCompanyShares(numOfShare, symbol);
						LinkedList<ShareList> userShares = user.getShareList();

						userShares.add(share);
						user.setShareList(userShares);
						user.getShareList().getLast().setNumOfShare(numOfShare);

					}
				}

			}
		}
		mapper.writeValue(new File("CompanyShares.json"), shareList);
		mapper.writeValue(file, users);
	}

	public void buy(int amount, String symbol) {

		try {
			UserStocks users[] = mapper.readValue(file, UserStocks[].class);
			userStockList.clear();

			System.out.print("\n Enter Username for buying shares : ");
			String userName = utility.getLine();

			for (UserStocks user : users)	
			{
				userStockList.add(user);
			}
			boolean flag = false;
			for (UserStocks user : userStockList) {
				if (user.getUserName().equals(userName)) {

					for (ShareList share : user.getShareList()) {

						if (symbol.equals(share.getSymbol() + "")) {
							int numOfShare = (int) (amount / share.getPrice());
							share.setNumOfShare(numOfShare + share.getNumOfShare());
							updateNumOfCompanyShares(numOfShare, symbol);
							flag = true;
						}

					}

				}

			}
			if (!flag) {
				addShareToUserList(symbol, amount, userName);
			}

			mapper.writeValue(file, userStockList);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void sell(int amount, String symbol) throws JsonParseException, JsonMappingException, IOException
	{
		
		UserStocks users[] = mapper.readValue(file, UserStocks[].class);
		userStockList.clear();

		System.out.print("\n Enter Username for selling shares : ");
		String userName = utility.getLine();

		for (UserStocks user : users) {
			userStockList.add(user);
		}
		boolean flag = false;
		for (UserStocks user : userStockList) {
			if (user.getUserName().equals(userName)) {

				for (ShareList share : user.getShareList()) {

					int numOfShare = (int) (amount / share.getPrice());
					if (symbol.equals(share.getSymbol() + "") && share.getNumOfShare()>=numOfShare) {
						
						share.setNumOfShare(share.getNumOfShare()-numOfShare);
						updateNumOfCompanyShares(-numOfShare, symbol);
						flag = true;
					}

				}

			}

		}
		if(!flag)
		{
			System.out.println("There is not much share that you had needed...");
		}
		mapper.writeValue(file, userStockList);
		
	}
	
	
	public double valueOf(String userName)
	{
		StockReport newReport= new StockReport("StockReport.json");
		return newReport.valueOf(userName);
	}
	
	public void displayStockReport()
	{
		StockReport newReport= new StockReport("StockReport.json");
		newReport.getStockReport();
	}
	
	
	public static void main(String[] args)  
	{

		StockAccount account = new StockAccount("StockReport.json");
		
		while(true)
		{
			System.out.println("\n *****************Stock Account******************"
							+ " \n 1. Create New Account "
							+ " \n 2. Buy Shares"
							+ " \n 3. Sell Shares"
							+ " \n 4. Display Report"
							+ " \n 5. Get total account balance"
							+ " \n 6. Close"
							+ " \n Enter your Choice.............. : ");
	
			int choice= Integer.parseInt(utility.getLine());
			
			switch(choice)
			{
			case 1: account.createNewUser();
					break;
					
			case 2: System.out.print(" \n Enter the share Symbol that you want to purchase"); 
					String symbol=utility.getLine();
					
					System.out.print(" \n Enter the amount that you had : ");
					int amount = Integer.parseInt(utility.getLine());
					
					account.buy(amount, symbol);
					break;
					
			case 3: System.out.print(" \n Enter the share Symbol that you want to purchase"); 
					symbol=utility.getLine();
			
					System.out.print(" \n Enter the amount that you had : ");
					amount = Integer.parseInt(utility.getLine());
			
					try 
					{
						account.sell(amount, symbol);
					}
					catch (IOException e)
					{
						e.printStackTrace();
					}
					break;
					
			case 4: System.out.print("\n Enter Username for get report : ");
					String userName=utility.getLine();
					try 
					{
						account.displayReport(userName);
					}
					catch (IOException e) 
					{
						e.printStackTrace();
					}
					break;

			case 5: System.out.print("\n Enter Username for get report : ");
					userName=utility.getLine();
					System.out.print("\n Total account balance : "+account.valueOf(userName));
					break;
					
			case 6: System.out.println("\n -----------------Program is terminated-----------");
					return;
			}
		}
		
	}

}
