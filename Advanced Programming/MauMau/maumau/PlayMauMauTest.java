package maumau;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import maumau.FrenchCards.Rank;
import maumau.FrenchCards.Suit;

public class PlayMauMauTest {

	
	@Test
	void testPlayable() {
		
		PlayingCard Hearts_Jack = new FrenchCards(Suit.HEARTS, Rank.JACK);
		PlayingCard Hearts_Ace = new FrenchCards(Suit.HEARTS, Rank.ACE);
			
		// test if certain suit can be played on certain suit
		// hearts on hearts.
		assertTrue(Hearts_Jack.playable(Hearts_Ace));
		
		// but 2 cannot be played on 1, since card1 is then a jack with the same suit. 
		assertFalse(Hearts_Ace.playable(Hearts_Jack));
		
//		PlayingCard Diamonds_Jack = new FrenchCards(Suit.DIAMONDS, Rank.JACK);
//		assertTrue(Hearts_Ace.playable(Diamonds_Jack));
	}
	
	@Test
	void playDifferentRankSameSuit() {
		PlayingCard Hearts_Ten = new FrenchCards(Suit.HEARTS, Rank.TEN);
		PlayingCard Hearts_Two = new FrenchCards(Suit.HEARTS, Rank.TWO);
		
		assertTrue(Hearts_Ten.playable(Hearts_Two));
	}
	
	@Test
	void playJackDifferentRankSameSuit() {
		PlayingCard Hearts_Jack = new FrenchCards(Suit.HEARTS, Rank.JACK);
		PlayingCard Hearts_Two = new FrenchCards(Suit.HEARTS, Rank.TWO);
		
		assertFalse(Hearts_Two.playable(Hearts_Jack));
		// suit is same so cant be played on jack of same suit.	
	}
	
	@Test
	void testSameRankOnRank() {
		PlayingCard Hearts_Ten = new FrenchCards(Suit.HEARTS, Rank.TEN);
		PlayingCard Diamonds_Ten = new FrenchCards(Suit.DIAMONDS, Rank.TEN);
		
		assertTrue(Hearts_Ten.playable(Diamonds_Ten));
		
	}
	
	@Test
	void playCardOfBothDifferentRankAndSuit() {
		PlayingCard Hearts_Jack = new FrenchCards(Suit.HEARTS, Rank.TEN);
		PlayingCard Diamonds_Nine = new FrenchCards(Suit.DIAMONDS, Rank.NINE);
		// check if card with different rank and suit can be played on another card.
		assertFalse(Hearts_Jack.playable(Diamonds_Nine));
	}
	
	
	
	
	
	
	
	@Test
	void testCardOnJoker() {
		PlayingCard Joker = new JokerCard();
		PlayingCard Hearts_Two = new FrenchCards(Suit.HEARTS, Rank.TWO);
		
		assertTrue(Hearts_Two.playable(Joker));
		
	}
	
	
	
	@Test
	void playableJackDifferentSuit() {
		
		PlayingCard Hearts_Ten = new FrenchCards(Suit.HEARTS, Rank.TEN);
		PlayingCard Diamonds_Jack = new FrenchCards(Suit.DIAMONDS, Rank.JACK);
		
		// check if card with different rank and suit can be played on a jack of a different suit
		assertTrue(Hearts_Ten.playable(Diamonds_Jack));
		//must be true;
		
	}
	
	
	@Test
	void playDifferentRankAndSuit() {
		PlayingCard Hearts_Ten = new FrenchCards(Suit.HEARTS, Rank.TEN);
		PlayingCard Spades_Two = new FrenchCards(Suit.SPADES, Rank.TWO);
		
		assertFalse(Hearts_Ten.playable(Spades_Two));
	}
	
	
	@Test 
	void jackDifferentSuit() {
		PlayingCard Hearts_Jack = new FrenchCards(Suit.HEARTS, Rank.JACK);
		PlayingCard Diamonds_Jack = new FrenchCards(Suit.DIAMONDS, Rank.JACK);

		assertTrue(Hearts_Jack.playable(Diamonds_Jack));
	}
	
	
	
	
	@Test
	void testCanMoveAgain() {
		
	}
	
	
}
