package ap.assignments.yahtzee.rolls;

public class FourOfAKind implements Combination {

	
	@Override
	public String getName() {
		return "Four of a kind";
	}
	
	@Override
	public int getScore(int a, int b, int c, int d, int e) {
		if(a==b && b==c && c==d || b==c && c==d && d==e) {
			return a+b+c+d+e;
		}
		return 0;
	}
}
