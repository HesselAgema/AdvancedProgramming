package ap.assignments.yahtzee.rolls;

import ap.assignments.yahtzee.CombinationChecker;

public class Ones implements Combination {

	// final static since we dont have to change this number anymore, and its just for this class.
	final static int number = 1;
	
	// private because we only want to be able to acces this checker in this class
	@Override
	public String getName() {
		return "Ones";
	}
	
	@Override
	// public because we call a method from another package.
	public int getScore(int a, int b, int c, int d, int e) {
		int amount = CombinationChecker.getDupes(a, b, c, d, e, number);
		return amount*number;
	}
}
