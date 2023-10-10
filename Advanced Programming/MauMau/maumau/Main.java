package maumau;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

import maumau.FrenchCards.Rank;
import maumau.FrenchCards.Suit;

public class Main {

	
	private static ArrayList<PlayingCard> cards;
	private static ArrayList<PlayingCard> hand;
	public final static int NUM_PLAYERS = 2;    // als ik hem static maak kan die alleen worden aangeroepen als ik een instance van Main class maak.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numSims = 100000;
		int numberOfSucces = 0;
		for(int i = 0 ; i < numSims ; i++) {
			createDeck();
			//System.out.println("Size of deck : "+ cards.size());

			shuffleDeck();
			//printDeck(cards);
			//System.out.println("dealing to players");
			dealToPlayers(NUM_PLAYERS);
			//System.out.println("Size of deck : "+ cards.size());


			//printDeck(hand);
			
			PlayingCard startCard = getFirstCard();

			boolean ableToMove = AbleToMove(startCard);
			if(ableToMove) {
				numberOfSucces++;
			}
		}
		
		//System.out.println(numberOfSucces);
		double percentCannot = (numSims - numberOfSucces);
		System.out.printf("%.3f percent \n", (percentCannot/numSims)*100);
		
		

		
		// complete deel
		ArrayList<PlayingCard> currentSequence = new ArrayList<PlayingCard>();
		ArrayList<PlayingCard> longestSequence = new ArrayList<PlayingCard>();

		ArrayList<PlayingCard> cardsPlayed = new ArrayList<PlayingCard>();

		printFirstCard(getFirstCard());
		printDeck(hand);
		numCardsCanPlay(getFirstCard(), currentSequence, longestSequence,  cardsPlayed);
		System.out.println(longestSequence.size() + 1);
		
		

	}

	private static void numCardsCanPlay(PlayingCard startCard, ArrayList<PlayingCard> currentSequence, ArrayList<PlayingCard> longestSequence, ArrayList<PlayingCard> cardsPlayed) {

		//printDeck(hand);
		if(cardsPlayed.size() > 7) {
			return;
		}
		
		if(currentSequence.size() > longestSequence.size()) {
			longestSequence.clear();
			longestSequence.addAll(currentSequence);

			//System.out.println("currentSequence has been made the longest. with length : " + longestSequence.size());
		}
		
		for(int i = 0 ; i < hand.size(); i++) {
			PlayingCard currentCard = hand.get(i);
			if(currentCard.playable(startCard) && (!(cardsPlayed.contains(currentCard)))) {
				// als we current kaart kunnen opleggen, voeg aan cardsPlayed toe en begin te onderzoeken.
				cardsPlayed.add(currentCard);
				currentSequence.add(currentCard);

				if(currentCard.canMoveAgain()) {
					numCardsCanPlay(currentCard, currentSequence, longestSequence, cardsPlayed);
					//after we run this and it came to error, we remove current card from sequence en we go to the next card in hand from for loop.
					currentSequence.remove(currentCard);
				}
				
				// als we niet kunnen moven na deze kaart, dan halen we deze kaart eraf
				cardsPlayed.remove(currentCard);
			}else {
				// als card niet playable is
				//cardsPlayed.add(currentCard);
			}
		}
	}

	

	private static void printFirstCard(PlayingCard startCard) {
		if(startCard instanceof FrenchCards) {
			FrenchCards fStartCard = (FrenchCards) startCard;
			System.out.printf("First card is : %s \t %s\n", fStartCard.getSuit(), fStartCard.getRank());
		}else {
			System.out.println("JOKER is the first card!!!");
		}		
	}

	private static boolean AbleToMove(PlayingCard startCard) {
			
			// loop over hand cards.
			for (int i = 0; i < hand.size(); i++) {
				//System.out.println("iterating over card : "+ i);
				// check if its a french card
				if(hand.get(i).playable(startCard)) {
					return true;
				}	
			}
			// if all iterations over hand loop were unsuccesfull we return false;
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
			// keep removing index 0 since ArrayList shofts its elements when removing something.
		}
	}

	private static PlayingCard getFirstCard() {
		return cards.get(0);
	}

	private static void shuffleDeck() {
		Collections.shuffle(cards, ThreadLocalRandom.current());
	}

	private static void printDeck(ArrayList<PlayingCard> cards) {
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
		for(int i = 0; i < 3; i++) {
			card = new JokerCard();
			cards.add(card);
		}
	}

}
