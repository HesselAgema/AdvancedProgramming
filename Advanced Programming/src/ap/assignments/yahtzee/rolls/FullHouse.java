package ap.assignments.yahtzee.rolls;

public class FullHouse implements Combination {

	@Override
	public String getName() {
		return "Full House";
	}

	@Override
	public int getScore(int a, int b, int c, int d, int e) {
		if(a==b && b==c && d==e || a==b && c==d && d==e) {
			return 25;
		}else {
			return 0;
		}
	}
}
