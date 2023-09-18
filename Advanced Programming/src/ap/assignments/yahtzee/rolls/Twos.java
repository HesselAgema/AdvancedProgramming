package ap.assignments.yahtzee.rolls;

import ap.assignments.yahtzee.CombinationChecker;

public class Twos implements Combination {
	
	final private static int NUMBER = 2;

	@Override
	public String getName() {
		return "Twos";
	}

	@Override
	public int getScore(int a, int b, int c, int d, int e) {
		int amount = CombinationChecker.getDupes(a, b, c, d, e, NUMBER);
		return amount*NUMBER;
	}
}
