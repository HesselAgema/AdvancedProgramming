package ap.assignments.yahtzee.rolls;

import ap.assignments.yahtzee.CombinationChecker;

public class Ones implements Combination {

	// final static since we dont have to change this number anymore, and its just
	// for this class.
	final private static int NUMBER = 1;

	@Override
	public String getName() {
		return "Ones";
	}

	@Override
	public int getScore(int a, int b, int c, int d, int e) {
		int amount = CombinationChecker.getDupes(a, b, c, d, e, NUMBER);
		return amount * NUMBER;
	}
}
