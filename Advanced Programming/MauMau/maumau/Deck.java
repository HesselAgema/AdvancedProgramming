package maumau;

import java.util.ArrayList;

import maumau.FrenchCards.Rank;
import maumau.FrenchCards.Suit;

public class Deck  {

	
	
	
	public void createDeck(ArrayList<PlayingCard> cards) {

		PlayingCard card;
		cards = new ArrayList<PlayingCard>(Suit.values().length * Rank.values().length);
		for(Suit suit : Suit.values()) {
			for(Rank rank : Rank.values()) {
				//System.out.println(""+suit +"\t"+ "" + rank);
				card = new FrenchCards(suit,rank);
				cards.add(card);
			}
		}
		
		// adding 3 jokers
		for(int i = 0; i < 3; i++) {
			card = new JokerCard();
			cards.add(card);
		}
	}

}
