package maumau;


public class FrenchCards implements PlayingCard {

	PlayMauMau playMauMau;
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
			
			if (kaartOpSpel.getSuit().equals(card.suit)) {
				if (kaartOpSpel.getRank().equals(Rank.JACK)) {
					// one of the two cards is a jack. and they are both of the same Suit. so not
					// allowed
					return false;
				} else {
					// both are not jacks. so card can be played on starting card which has the same
					// suit.
					return true;
				}

			} else if (kaartOpSpel.getRank().equals(card.rank)) {
				// if cards are the same rank, they can be played on each other so we return
				// true;
				return true;
			} else if (!(kaartOpSpel.getRank().equals(card.rank) && kaartOpSpel.getSuit().equals(card.suit))) {
					// als en rank en suit anders is, check dan hieronder of kaartOpSpel een Jack is.
					if(kaartOpSpel.getRank().equals(Rank.JACK) && !(kaartOpSpel.getSuit().equals(card.suit))) {
						return true;
					}else {
						return false;
					}
			//	A playing card must not be playable on a card with a different rank and suit.
			//	○ but must be playable on a Jack of a different suit.

			} 
//			else if (card.rank.toString().equals(Rank.JACK)
//					&& (!(kaartOpSpel.getSuit().equals(card.suit.toString())))) {
//				// if card in hand is a jack and not of the same suit. we can play it
//				return true;
//
//			}

			return false;

		}

	}

	public Suit getSuit() {
		return card.suit;
	}
	
	public Rank getRank() {
		return card.rank;
	}

	@Override
	public boolean canMoveAgain() {
		
		Rank rank = card.rank;
		Suit suit = card.suit;
//		System.out.println(suit);
//		System.out.println(rank);
		if(rank.equals(Rank.SEVEN)) {
			// if rank is a 7, we can move again
			return true;
		}else if(rank.equals(Rank.KING)){
			// if rank is a king, we can move again
			return true;
		}else if(rank.equals(Rank.EIGHT) && playMauMau.NUM_PLAYERS == 2) {
			// if rank is an 8, and game is with 2 players, the player can move again since we skip the 2nd player's turn.
			return true;
		}
		
		// TODO Auto-generated method stub
		return false;
	}

}
