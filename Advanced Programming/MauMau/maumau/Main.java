package maumau;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

import maumau.FrenchCards.Rank;
import maumau.FrenchCards.Suit;

public class Main {

	
	private static ArrayList<PlayingCard> cards;
	private static ArrayList<PlayingCard> hand;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		createDeck();
		shuffleDeck();
		//printDeck(cards);
		System.out.println("Size of deck : "+ cards.size());
		System.out.println("dealing to players");
		dealToPlayers(3);
		System.out.println("Size of deck : "+ cards.size());

		//printDeck(cards);

		System.out.println("printing hand");
		printDeck(hand);
		
		PlayingCard startCard = getFirstCard();
		
		

		boolean ableToMove = AbleToMove(startCard);
		System.out.println(ableToMove);
		
		
		
		
		
		//cards = new ArrayList<PlayingCard>();
		if(startCard instanceof FrenchCards) {
			FrenchCards fStartCard = (FrenchCards) startCard;
			System.out.printf("First card is : %s \t %s", fStartCard.getSuit(), fStartCard.getRank());
		}else {
			System.out.println("JOKER is the first card!!!");
		}
		

	}

	private static boolean AbleToMove(PlayingCard startCard) {

		if (startCard instanceof JokerCard) {
			return true;
		} else {
			FrenchCards fStartCard = (FrenchCards) startCard;
			
//			for(PlayingCard card : hand) {
//				
//			}
			
			// loop over hand cards.
			for (int i = 0; i < hand.size(); i++) {
				// check if its a french card
				if (hand.get(i) instanceof FrenchCards) {
					FrenchCards card = (FrenchCards) hand.get(i);
					
					boolean normalVsNormal = checkNormalVsNormalCard(fStartCard, card);
					if(normalVsNormal) {
						return true;
					}

				}
				else {
					// card is a joker and we can return true
					//System.out.println("Joker!");
					return true;
				}
			}
			// if all iterations over hand loop were unsuccesfull we return false;
			return false;
		}

		
		
		
	}

	private static boolean checkNormalVsNormalCard(FrenchCards fStartCard, FrenchCards card) {

		//System.out.println(card.getSuit() + "\t" + card.getRank());
		
		//  check if suit are the same. 
		if(fStartCard.getSuit().equals(card.getSuit())) {
			if(fStartCard.getRank().equals(Rank.JACK) || card.getRank().equals(Rank.JACK)) {
				// one of the two cards is a jack. and they are both of the same Suit. so not allowed
				return false;
			}else {
				// both are not jacks. so card can be played on starting card which has the same suit.
				return true;
			}
			
		}else if(fStartCard.getRank().equals(card.getRank())) {
			// if cards are the same rank, they can be played on each other so we return true;
			return true;
		}else if(fStartCard.getRank().equals(Rank.JACK) && (!(fStartCard.getSuit().equals(card.getSuit())))) {
			// if starting card is a jack, and our card is not the suit of the jack, we return true;
			return true;
		}
		
		
		return false;
		
		
	}

	private static void dealToPlayers(int amountOfPlayers) {
		
		hand = new ArrayList<PlayingCard>();

		for(int i = 0; i < 7; i++) {
			hand.add(cards.get(i * amountOfPlayers));
			
			
		}
		removeCardsFromDeck(amountOfPlayers);
		
	}

	private static void removeCardsFromDeck(int amountOfPlayers) {

		int cardsToBeRemoved = amountOfPlayers * 7;
		for(int i = 0; i < cardsToBeRemoved; i ++) {
			cards.remove(0);
		}
	}

	private static PlayingCard getFirstCard() {
		return cards.get(0);
	}

	private static void shuffleDeck() {
		Collections.shuffle(cards, ThreadLocalRandom.current());
	}

	private static void printDeck(ArrayList<PlayingCard> cards) {
		
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

	private static void createDeck() {

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
//		for(int i = 0; i < 3; i++) {
//			card = new JokerCard();
//			cards.add(card);
//		}
		
		
		// ff random kaart maken
		//PlayingCard lastCard = new FrenchCards(Suit.CLUBS, Rank.ACE);
		//cards.add(card);
		
		
		//PlayingCard beginKaart = null;
		//card.playable(beginKaart);
		
	}

}
