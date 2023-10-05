package maumau;

import maumau.FrenchCards.Rank;

public class FrenchCards implements PlayingCard {

	Card card;
	
	enum Suit{
		HEARTS,
		SPADES,
		CLUBS,
		DIAMONDS
	}
	enum Rank{
		TWO,
		THREE,
		FOUR,
		FIVE,
		SIX,
		SEVEN,
		EIGHT,
		NINE,
		TEN,
		JACK,
		QUEEN,
		KING,
		ACE
	}
	
	
	private class Card {
		Suit suit;
		Rank rank;

		public Card(Suit suit, Rank rank) {
			this.suit = suit;
			this.rank = rank;
		}
	}
	
	public FrenchCards(Suit suit, Rank rank) {	
		card = new Card(suit,rank);
	}
	
	@Override
	public boolean playable(PlayingCard cardOnDeck) {

		if (cardOnDeck instanceof JokerCard) {
			return true;
		} else {
			FrenchCards kaartOpSpel = (FrenchCards) cardOnDeck;

			// check if suit are the same.
			if (kaartOpSpel.getSuit().equals(card.suit.toString())) {
				if (kaartOpSpel.getRank().equals(Rank.JACK) || card.rank.toString().equals(Rank.JACK)) {
					// one of the two cards is a jack. and they are both of the same Suit. so not
					// allowed
					return false;
				} else {
					// both are not jacks. so card can be played on starting card which has the same
					// suit.
					return true;
				}

			} else if (kaartOpSpel.getRank().equals(card.rank.toString())) {
				// if cards are the same rank, they can be played on each other so we return
				// true;
				return true;
			} else if (kaartOpSpel.getRank().equals(Rank.JACK)
					&& (!(kaartOpSpel.getSuit().equals(card.suit.toString())))) {
				// if starting card is a jack, and our card is not the suit of the jack, we
				// return true;
				return true;
			} else if (card.rank.toString().equals(Rank.JACK)
					&& (!(kaartOpSpel.getSuit().equals(card.suit.toString())))) {
				// if card in hand is a jack and not of the same suit. we can play it
				return true;

			}

			return false;

		}

	}

	public String getSuit() {
		return card.suit.toString();
	}
	
	public String getRank() {
		return card.rank.toString();
	}

}
