package objectOriented;

import java.util.Arrays;

public class Player extends DeckOfCards 
{

	public String[][] sortCards(String playerCards[][])
	{
		String[] cards = getCards();
		int ranks[]=new int[9];
		for(String[] player:playerCards)
		{
			int j=0;
			for(String card: player)
			{
				for(int i=0; i<cards.length; i++)
				{
					if(card.equals(cards[i]))
					{
						ranks[j++]=i;
					}
				}
			}
			
			Arrays.sort(ranks);
			
			for(int k=0; k<ranks.length; k++)
			{
				player[k]=cards[ranks[k]];
			}
		}
		return playerCards;
	}
	public static void main(String[] args) 
	{
		
		Player player=new Player();
		player.getCards();
		player.shuffleCards();
		String playerCards[][]=player.distribute(4, 9);
		
		playerCards=player.sortCards(playerCards);
		
		player.displayCards(playerCards);
	}

}
