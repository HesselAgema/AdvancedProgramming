package maumau;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import maumau.FrenchCards.Rank;
import maumau.FrenchCards.Suit;

public class PlayMauMauTest {

	

	@Test
	void playSameSuitDifferentRank() {
		PlayingCard Hearts_Two = new FrenchCards(Suit.HEARTS, Rank.TWO);
		PlayingCard Hearts_Ten = new FrenchCards(Suit.HEARTS, Rank.TEN);
		
		assertTrue(Hearts_Two.playable(Hearts_Ten));

	}
	
	@Test
	void playSameSuitDifferentRankButJack() {
		PlayingCard Hearts_Two = new FrenchCards(Suit.HEARTS, Rank.TWO);
		PlayingCard Hearts_Jack = new FrenchCards(Suit.HEARTS, Rank.JACK);
		
		assertFalse(Hearts_Two.playable(Hearts_Jack));

	}
	
	@Test
	void playSameRank() {
		PlayingCard Spades_Five = new FrenchCards(Suit.SPADES, Rank.FIVE);
		PlayingCard Diamonds_Five = new FrenchCards(Suit.DIAMONDS, Rank.FIVE);
		
		assertTrue(Spades_Five.playable(Diamonds_Five));
	}
	
	@Test
	void playDifferentRankDifferentSuit() {
		PlayingCard Spades_Five = new FrenchCards(Suit.SPADES, Rank.FIVE);
		PlayingCard Diamonds_Ten = new FrenchCards(Suit.DIAMONDS, Rank.TEN);
		
		assertFalse(Spades_Five.playable(Diamonds_Ten));
	}
	
	@Test
	void playDifferentRankDifferentSuitOnJack() {
		PlayingCard Spades_Five = new FrenchCards(Suit.SPADES, Rank.FIVE);
		PlayingCard Diamonds_Jack = new FrenchCards(Suit.DIAMONDS, Rank.JACK);
		
		assertTrue(Spades_Five.playable(Diamonds_Jack));
	}
	
	@Test
	void playJackOnDifferentSuit() {
		PlayingCard Diamonds_Jack = new FrenchCards(Suit.DIAMONDS, Rank.JACK);
		PlayingCard Spades_Five = new FrenchCards(Suit.SPADES, Rank.FIVE);

		assertFalse(Diamonds_Jack.playable(Spades_Five));
	}
	
	@Test
	void playJackOnSameSuit() {
		PlayingCard Diamonds_Jack = new FrenchCards(Suit.DIAMONDS, Rank.JACK);
		PlayingCard Diamonds_Five = new FrenchCards(Suit.DIAMONDS, Rank.FIVE);

		assertTrue(Diamonds_Jack.playable(Diamonds_Five));
	}
	
	@Test
	void playBothJacks() {
	    PlayingCard Hearts_Jack = new FrenchCards(Suit.HEARTS, Rank.JACK);
	    PlayingCard Spades_Jack = new FrenchCards(Suit.SPADES, Rank.JACK);
	    assertTrue(Hearts_Jack.playable(Spades_Jack));  
	}
	
	@Test
	void playCardOnJoker() {
	    PlayingCard Hearts_Jack = new FrenchCards(Suit.HEARTS, Rank.JACK);
	    PlayingCard Joker = new JokerCard();
	    
	    assertTrue(Hearts_Jack.playable(Joker));
	}

	
		
	
	@Test
	void testCanMoveAgain() {
		
	}
	
	
}
