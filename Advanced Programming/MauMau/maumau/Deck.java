package maumau;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

import maumau.FrenchCards.Rank;
import maumau.FrenchCards.Suit;

public class Deck  {

	private ArrayList<PlayingCard> cards;
	public ArrayList<PlayingCard> hand;

	
	
	public void createDeck() {

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
	
	public void shuffleDeck() {
		Collections.shuffle(cards, ThreadLocalRandom.current());
	}
	
	public ArrayList<PlayingCard> dealToPlayers(int amountOfPlayers) {
		
		hand = new ArrayList<PlayingCard>();

		for(int i = 0; i < 7; i++) {
			hand.add(cards.get(i * amountOfPlayers));
		}
		removeCardsFromDeck(amountOfPlayers, cards);
		return hand;
	}
	
	private static void removeCardsFromDeck(int amountOfPlayers, ArrayList<PlayingCard> cards) {

		int cardsToBeRemoved = amountOfPlayers * 7;
		for(int i = 0; i < cardsToBeRemoved; i ++) {
			cards.remove(0);
			// keep removing index 0 since ArrayList shifts its elements when removing something.
		}
	}
	
	public void printDeck(ArrayList<PlayingCard> cards) {
		System.out.println("Size of deck : "+ cards.size());

		for(int i = 0 ; i < cards.size(); i++) {
			PlayingCard currentCard = cards.get(i);
			if(currentCard instanceof FrenchCards) {
				FrenchCards fCard = (FrenchCards) currentCard;
				System.out.printf("%s \t %s \n", fCard.getSuit(), fCard.getRank());
			}
			else {
				System.out.println("JOKER");
			}
		}
		
	}
	
	public ArrayList<PlayingCard> getCards() {
        return cards;
    }

    public ArrayList<PlayingCard> getHand() {
        return hand;
    }
    
    public PlayingCard getFirstCard() {
		return cards.get(0);
	}

}
