package ap.assignments.yahtzee;

import ap.assignments.yahtzee.rolls.Chance;
import ap.assignments.yahtzee.rolls.Combination;
import ap.assignments.yahtzee.rolls.FourOfAKind;
import ap.assignments.yahtzee.rolls.FullHouse;
import ap.assignments.yahtzee.rolls.LargeStraight;
import ap.assignments.yahtzee.rolls.SmallStraight;
import ap.assignments.yahtzee.rolls.ThreeOfAKind;
import ap.assignments.yahtzee.rolls.Yachtzee;

public class CombinationChecker {
    private final Combination[] upperSection;
    private final Combination[] lowerSection;

    public CombinationChecker() {
        upperSection = new Combination[]{};
        
        // initialize array of combination objects. each item in the array such as "ThreeOfAKind" is an instance of a class
        // that implements the combination interface. We are pre-loading this array with objects that contain different scores.
        // 
        lowerSection = new Combination[]{new ThreeOfAKind(), new FourOfAKind(), new FullHouse(), new SmallStraight(), new LargeStraight(), new Yachtzee(), new Chance() };
    }

//    public Combination findUpper(int a, int b, int c, int d, int e) throws Exception {
//        // Your code goes here
//    }

    public Combination findLower(int a, int b, int c, int d, int e) throws Exception {
    	
    	Combination temp = new ThreeOfAKind();
    	for(int i =0 ; i < lowerSection.length; i++) {
    		Combination comb = lowerSection[i];
    		int score = comb.getScore(a, b, c, d, e);
    		String temp2 = comb.getName();
    		// heb nu dat die alle scores gaan bekijken. 
    		System.out.printf(": %s",  temp2);
    		System.out.printf("= %d\n", score);
    	}

    	return temp;
    
    	
        // Your code goes here
    }
}
