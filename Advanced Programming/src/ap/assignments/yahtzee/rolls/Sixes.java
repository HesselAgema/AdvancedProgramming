package ap.assignments.yahtzee.rolls;

import ap.assignments.yahtzee.CombinationChecker;

public class Sixes implements Combination {

	final static int NUMBER = 6;

	@Override
	public String getName() {
		return "Sixes";
	}

	@Override
	public int getScore(int a, int b, int c, int d, int e) {
		int amount = CombinationChecker.getDupes(a, b, c, d, e, NUMBER);
		return amount*NUMBER;
	}
}
