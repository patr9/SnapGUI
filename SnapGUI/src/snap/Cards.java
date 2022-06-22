package snap;

import java.util.ArrayList;
import java.util.Collections;

class Card
{
	//Variables
	private String suit;
	private String rank;
	private String img;
	
	//Constructor
	public Card(String suit, String rank, String img)
	{
		setSuit(suit);
		setRank(rank);
		setImg(img);
	}
		
	//Getter functions
	public String getSuit()
	{
		return suit;
	}
	
	public String getRank()
	{
		return rank;
	}
		
	//Setter functions
	public void setSuit(String suit)
	{
		this.suit = suit;
	}
		
	public void setRank(String rank)
	{
		this.rank = rank;
	}
	
	public String getImg()
	{
		return img;
	}
	
	public void setImg(String img)
	{
		this.img = img;
	}
	
	//Makes it easy to print the card values
	public String toString()
	{
		return (rank+" of "+suit+ ". Img: "+img);
	}
		
	//Creates a randomised deck
	public static ArrayList<Card> createDeck()
	{
		//Variables
		String[] suits = {"club", "diamond", "heart", "spade"};
		String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "j", "q", "k", "a"};
		ArrayList<Card> cards = new ArrayList<Card>();
			
		//Creates a deck of 52 unique cards
		for(int i = 0; i < suits.length; i++)
		{
			for( int j = 0; j < ranks.length; j++)
			{
				String temp = ("C:\\Users\\u\\Pictures\\cards\\"+ranks[j]+suits[i]+".png");
				cards.add(new Card(suits[i],ranks[j],temp));
			}
		}
				
		//Randomises the deck
		Collections.shuffle(cards);
		return cards;
	}
}