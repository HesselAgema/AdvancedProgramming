package maumau;

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
	public boolean playable(PlayingCard lastCard) {
		if(lastCard instanceof FrenchCards) {
			FrenchCards fCard = (FrenchCards) lastCard;
			if(card.suit.toString().equals(((FrenchCards) lastCard).getSuit())) {
				
			}
		}
		
		return false;
	}

	public String getSuit() {
		return card.suit.toString();
	}
	
	public String getRank() {
		return card.rank.toString();
	}

}
