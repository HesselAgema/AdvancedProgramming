package maumau;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import maumau.FrenchCards.Rank;
import maumau.FrenchCards.Suit;

public class PlayMauMau implements Runnable {

//	static Deck deckHandler = new Deck();
	
	//private static ArrayList<PlayingCard> cards;
	//private static ArrayList<PlayingCard> hand;
	public final static int NUM_PLAYERS = 1;   
	private static int NUMBER_OF_GAMES = 10000000;
	private static int NUMBER_OF_THREADS = 4;
	private static int gamesPerThread = NUMBER_OF_GAMES/NUMBER_OF_THREADS;
	private static int gamesPerThread2 = 5000000;

	
	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int THREE = 3;
	private static final int FOUR = 4;
	private static final int FIVE = 5;
	private static final int SIX = 6;
	private static final int SEVEN = 7;


	
	Map<Integer, Integer> results = new HashMap<Integer, Integer>();  
	

//	public static void main(String[] args) {
//		simGame(100000);
//	}
	
	@Override
	public
	void run() {
		results.put(0, 0);
		results.put(1, 0);
		results.put(2, 0);
		results.put(3, 0);
		results.put(4, 0);
		results.put(5, 0);
		results.put(6, 0);
		results.put(7, 0);
		
		simGame(gamesPerThread2);
		
		printResults();
		
	}
	
	
	private void printResults() {
		
		double percentOne = (double) results.get(1)/gamesPerThread2;
		System.out.printf(" %.3f \n ", percentOne);
		System.out.printf("%d cards could be laid %.3f percent of the time\n", 0, ((double) results.get(0)/gamesPerThread2)*100);
		System.out.printf("%d cards could be laid %.3f percent of the time\n", 1, ((double) results.get(1)/gamesPerThread2)*100);
		System.out.printf("%d cards could be laid %.3f percent of the time\n", 2, ((double) results.get(2)/gamesPerThread2)*100);
		System.out.printf("%d cards could be laid %.3f percent of the time\n", 3, ((double) results.get(3)/gamesPerThread2)*100);
		System.out.printf("%d cards could be laid %.3f percent of the time\n", 4, ((double) results.get(4)/gamesPerThread2)*100);
		System.out.printf("%d cards could be laid %.3f percent of the time\n", 5, ((double) results.get(5)/gamesPerThread2)*100);
		System.out.printf("%d cards could be laid %.3f percent of the time\n", 6, ((double) results.get(6)/gamesPerThread2)*100);
		System.out.printf("%d cards could be laid %.6f percent of the time\n", 7, ((double) results.get(7)/gamesPerThread2)*100);

}


	public void simGame(int numOfGames) {
		System.out.printf("Simulating %d games!\n", numOfGames);
		Deck deckHandler = new Deck();
		ArrayList<PlayingCard> hand = new ArrayList<PlayingCard>();
		// TODO Auto-generated method stub
		int numSims = numOfGames;
		int numberOfSucces = 0;
		for(int i = 0 ; i < numSims ; i++) {
			deckHandler.createDeck();

			deckHandler.shuffleDeck();
			hand = deckHandler.dealToPlayers(NUM_PLAYERS);


			//cards = deckHandler.getCards();

			PlayingCard startCard = deckHandler.getFirstCard();

			//hand = deckHandler.getHand();
			//deckHandler.printDeck(hand);

			boolean ableToMove = AbleToMove(startCard, hand);
			if(ableToMove) {
				numberOfSucces++;
			}
			
			
			
			
			
			int num = numCardsCanPlay(startCard,hand);
			//System.out.println(num);
			
			
			if(num == ONE) {
				results.replace(ONE, results.get(ONE) + 1);
			}else if(num == TWO) {
				results.replace(TWO, results.get(TWO) + 1);
			}else if(num == THREE) {
				results.replace(THREE, results.get(THREE) + 1);
			}else if(num == FOUR) {
				results.replace(FOUR, results.get(FOUR) + 1);
			}else if(num == FIVE) {
				results.replace(FIVE, results.get(FIVE) + 1);
			}else if(num == SIX) {
				results.replace(SIX, results.get(SIX) + 1);
			}else if(num == SEVEN) {
				results.replace(SEVEN, results.get(SEVEN) + 1);
			}else if(num == 0) {
				results.replace(0, results.get(0) + 1);
			}

			
		}
		
		//System.out.println(numberOfSucces);
		double percentCannot = (numSims - numberOfSucces);
		System.out.printf("%.3f percent \n", (percentCannot/numSims)*100);
		
		
		// complete deel
		

		//printFirstCard(deckHandler.getFirstCard());
		//deckHandler.printDeck(hand);
				
//		int value = results.get(1);
//		System.out.println("Value is!!! "+value);
//		printChances(num);
//		System.out.println(num);
		
	}
	



	private static boolean AbleToMove(PlayingCard startCard, ArrayList<PlayingCard> hand) {
		
		PlayingCard testCard = new FrenchCards(Suit.CLUBS, Rank.ACE);
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

	

	
	
	private static int numCardsCanPlay(PlayingCard startCard, ArrayList<PlayingCard> hand) {
		
		int num= 0;
		int highestNum = 0;
		for(int i = 0 ; i < hand.size(); i++) {
			if(hand.get(i).playable(startCard)) {
				//num++;
				num = 1;
				if(hand.get(i).canMoveAgain()) {
					PlayingCard newStartCard = hand.get(i);
					ArrayList<PlayingCard> newHand = new ArrayList<>(hand);
					
					//ArrayList<PlayingCard> newHand = (ArrayList<PlayingCard>) hand.clone();
					newHand.remove(i);
					num += numCardsCanPlay(newStartCard, newHand);
				} // if was playable on startCard but cant move again. Update possible highestNumber.
				if(num > highestNum) {
					highestNum = num;
				}
			}
			
		}
		return highestNum;
	}
	
	private static void printFirstCard(PlayingCard startCard) {
		if(startCard instanceof FrenchCards) {
			FrenchCards fStartCard = (FrenchCards) startCard;
			System.out.printf("First card is : %s \t %s\n", fStartCard.getSuit(), fStartCard.getRank());
		}else {
			System.out.println("JOKER is the first card!!!");
		}		
	}




	
}
