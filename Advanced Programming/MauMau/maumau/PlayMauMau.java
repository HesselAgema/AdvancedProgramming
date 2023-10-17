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
	public static int NUM_PLAYERS;   
	private static int NUMBER_OF_GAMES = 10000000;
	private static int NUMBER_OF_THREADS = 4;
	private static int gamesPerThread = NUMBER_OF_GAMES/NUMBER_OF_THREADS;
	private static int gamesPerThread2 = 5000000;
	private int gamesPerThread3;

	
	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final int THREE = 3;
	private static final int FOUR = 4;
	private static final int FIVE = 5;
	private static final int SIX = 6;
	private static final int SEVEN = 7;


	
	int [] results = new int[7];
	

//	public static void main(String[] args) {
//		simGame(100000);
//	}
	
	public PlayMauMau(int i, int numberOfPlayers) {
		gamesPerThread3 = i;
		NUM_PLAYERS = numberOfPlayers;
	}


	@Override
	public
	void run() {
		
		simGame(gamesPerThread3, NUM_PLAYERS);
		
		//printResults();
		
		for(int i = 0 ; i < results.length; i++) {
			double num = ((double)results[i]/gamesPerThread3)*100;
			System.out.printf("%d cards could be played %.4f percent of the time\n ",i,num);
		}
		
	}
	
	
	private void printResults() {
		
		
}
	
	


	public void simGame(int numOfGames, int numPlayers) {
		System.out.printf("Simulating %d games!\n", numOfGames);
		Deck deckHandler = new Deck();
		ArrayList<PlayingCard> hand = new ArrayList<PlayingCard>();
		// TODO Auto-generated method stub
		int numSims = numOfGames;
		int numberOfSucces = 0;
		for(int i = 0 ; i < numSims ; i++) {
			deckHandler.createDeck();

			deckHandler.shuffleDeck();
			hand = deckHandler.dealToPlayers(numPlayers);

			PlayingCard startCard = deckHandler.getFirstCard();
			
			
			int num = numCardsCanPlay(startCard,hand, numPlayers);		
			
			for(int j = 0 ; j < results.length; j++) {
				if(num == j) {
					results[j] = results[j] +1;
				}
			}

			
		}	
		
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

	

	
	
	private static int numCardsCanPlay(PlayingCard startCard, ArrayList<PlayingCard> hand, int numPlayers) {
		
		int num= 0;
		int highestNum = 0;
		for(int i = 0 ; i < hand.size(); i++) {
			if(hand.get(i).playable(startCard)) {
				//num++;
				num = 1;
				if(hand.get(i).canMoveAgain(numPlayers)) {
					PlayingCard newStartCard = hand.get(i);
					ArrayList<PlayingCard> newHand = new ArrayList<>(hand);
					
					//ArrayList<PlayingCard> newHand = (ArrayList<PlayingCard>) hand.clone();
					newHand.remove(i);
					num += numCardsCanPlay(newStartCard, newHand, numPlayers);
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
	
	public int[] getResults() {
		return results;
	}




	
}
