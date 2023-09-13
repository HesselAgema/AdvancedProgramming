package ap.assignments.yahtzee.rolls;

public class ThreeOfAKind implements Combination {

	
	@Override
	public String getName() {
		return "Three of a kind";
	}
	
	@Override
	public int getScore(int a, int b, int c, int d, int e) {
		if(a==b && b==c || b==c && c==d || c==d && d==e) {
			return a+b+c+d+e;
		}
		return 0;
	}
	
	
}
