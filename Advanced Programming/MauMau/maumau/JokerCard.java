package maumau;

public class JokerCard implements PlayingCard {

	
	public JokerCard() {
		
	}
	
	@Override
	public boolean playable(PlayingCard kaartOpSpel) {
		return true;
	}
	
}
