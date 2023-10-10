package maumau;

public interface PlayingCard {

	
	boolean playable(PlayingCard lastCard);
	
	boolean canMoveAgain();
	
	//public String getSuit();
	
	//public String getRank();
	
}
