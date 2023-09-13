package ap.assignments.yahtzee.rolls;

public class Chance implements Combination {

	@Override
	public String getName() {
		return "Chance";
	}
	
	@Override
	public int getScore(int a, int b, int c, int d, int e) {
		return a+b+c+d+e;
	}
}
