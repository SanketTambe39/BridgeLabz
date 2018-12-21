package objectOriented;

import java.util.Random;

public class DeckOfCards 
{

	private String []suits= {"Heart","Club","Diamond","Spade"};
	private String []ranks= {"2","3","4","5","6","7","8","9","10","Jack","Queen","King","Ace"};
	private static String []cards=new String[52];
	
	
	public String[] getCards()
	{
		int i=0;
		for(String suit:suits)
		{
			for(String card:ranks)
			{
				cards[i++]=suit+card;
			}
		}
		return cards;
	}
	
	public void shuffleCards()
	{
		Random rd=new Random();
		for(int i=0; i<cards.length; i++)
		{
			int index=rd.nextInt(52);
			String temp=cards[index];
			cards[index]=cards[i];
			cards[i]=temp;
		}
	}
	
	public String[][] distribute(int numberOfPlayers, int numOfCards)
	{
		String playersCards[][]= new String[numberOfPlayers][numOfCards];
		
		for(int i=0, k=0; i<numberOfPlayers; i++)
		{
			for(int j=0; j<numOfCards; j++)
			{
					playersCards[i][j]=cards[k++];
			}
		}
		return playersCards;
	}
	
	public void displayCards(String[][]playerCards)
	{
		int i=0;
		for(String[] playerCard: playerCards)
		{
			System.out.println("Player "+(++i)+" cards :");
			
			for(String card: playerCard)
			{
				System.out.print(card+" ");
			}
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args) 
	{
	
		DeckOfCards deck=new DeckOfCards();
		
		deck.getCards();
		deck.shuffleCards();
		
		//utility.printArray(cards);
		
		System.out.println();
		
		String playerCards[][]=deck.distribute(4, 9);
		
		deck.displayCards(playerCards);
	}
}
