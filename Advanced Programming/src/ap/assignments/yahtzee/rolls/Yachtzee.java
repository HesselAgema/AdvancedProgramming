package ap.assignments.yahtzee.rolls;

public class Yachtzee implements Combination {

	@Override
	public String getName() {
		return "Yachtzee";
	}
	
	@Override
	public int getScore(int a, int b, int c, int d, int e) {
		if(a == b && b == c && c == d && d == e) {
			return 50;
		}
		return 0;
	}
	
	
}
