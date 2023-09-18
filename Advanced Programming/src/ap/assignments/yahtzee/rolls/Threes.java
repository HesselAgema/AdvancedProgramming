package ap.assignments.yahtzee.rolls;

import ap.assignments.yahtzee.CombinationChecker;

public class Threes implements Combination {

	final private static int NUMBER = 3;

	@Override
	public String getName() {
		return "Threes";
	}

	@Override
	public int getScore(int a, int b, int c, int d, int e) {
		int amount = CombinationChecker.getDupes(a, b, c, d, e, NUMBER);
		return amount*NUMBER;
	}
}
