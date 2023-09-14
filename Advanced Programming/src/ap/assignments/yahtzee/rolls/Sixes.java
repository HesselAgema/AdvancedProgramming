package ap.assignments.yahtzee.rolls;

import ap.assignments.yahtzee.CombinationChecker;

public class Sixes implements Combination {

	// final static since we dont have to change this number anymore, and its just
	// for this class.
	final static int number = 6;

	// private because we only want to be able to acces this checker in this class

	@Override
	public String getName() {
		return "Sixes";
	}

	@Override
	public int getScore(int a, int b, int c, int d, int e) {
		int amount = CombinationChecker.getDupes(a, b, c, d, e, number);
		return amount*number;
	}
}
