package maumau;

public class JokerCard implements PlayingCard {

	
	public JokerCard() {
		
	}
	
	@Override
	public boolean playable(PlayingCard kaartOpSpel) {
		return true;
	}

	@Override
	public boolean canMoveAgain() {
		return true;
	}
	
}
