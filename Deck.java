import java.util.ArrayList;
import java.util.Random;



public class Deck {
	 ArrayList<Card> cards;
		private ArrayList<Card> usedCard;
		public int nUsed;
		public Deck(int nDeck){
			usedCard=new ArrayList<Card>();
			cards=new ArrayList<Card>();
			int suit , rank ;
			for(int i = 0 ; i < nDeck ; i ++)
			{
				for(suit = 1 ; suit < 5 ; suit++)
				{
					for(rank = 1 ; rank < 14 ; rank ++)
					{
						Card card=new Card(suit,rank);
						cards.add(card);
					}
				}
			}
			shuffle();
		}
		public void printDeck(){
			for(int i = 0 ; count < cards.size() ; i ++)
			{
				Card card = cards.get(i);
				card.printCard();
			}
		}
		public void shuffle(){
			Random shuf = new Random(); 
			nUsed = 0;
		     while(usedCard.size()!=0)
		     {
		        Card replace;
		        replace = usedCard.get(0);
		        usedCard.remove(0);
		        cards.add(replace);
		     }
			for(int i = 0 ; i < cards.size(); i++)
			{
				   Card temporary;
				int a = shuf.nextInt(cards.size());
				temporary = cards.get(i);
				cards.set(i, cards.get(a));
			    cards.set(a, temporary);
			 }		   
		}
		public Card getOneCard(){
			if(
				cards.size()!= 0){
				nUsed = nUsed + 1;
			    Card card = cards.get(0);
			    usedCard.add(card);
			    cards.remove(0);
			    return card;
			}
			else{
				shuffle();
				getOneCard();
			}
			return null;	    
		}
		public ArrayList<Card> getAllCards(){
			return cards;
		}
}
