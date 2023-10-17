package maumau;

public interface PlayingCard {

	
	boolean playable(PlayingCard lastCard);
	
	boolean canMoveAgain(int numPlayers);
	
	//public String getSuit();
	
	//public String getRank();
	
}
