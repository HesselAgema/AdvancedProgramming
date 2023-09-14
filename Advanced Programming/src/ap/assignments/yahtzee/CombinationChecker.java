package ap.assignments.yahtzee;

import ap.assignments.yahtzee.rolls.Chance;
import ap.assignments.yahtzee.rolls.Combination;
import ap.assignments.yahtzee.rolls.Fives;
import ap.assignments.yahtzee.rolls.FourOfAKind;
import ap.assignments.yahtzee.rolls.Fours;
import ap.assignments.yahtzee.rolls.FullHouse;
import ap.assignments.yahtzee.rolls.LargeStraight;
import ap.assignments.yahtzee.rolls.Ones;
import ap.assignments.yahtzee.rolls.Sixes;
import ap.assignments.yahtzee.rolls.SmallStraight;
import ap.assignments.yahtzee.rolls.ThreeOfAKind;
import ap.assignments.yahtzee.rolls.Threes;
import ap.assignments.yahtzee.rolls.Twos;
import ap.assignments.yahtzee.rolls.Yachtzee;

public class CombinationChecker {
    private final Combination[] upperSection;
    private final Combination[] lowerSection;

    public CombinationChecker() {
        upperSection = new Combination[]{new Ones(), new Twos(), new Threes(), new Fours(), new Fives(), new Sixes()};
        
        // initialize array of combination objects. each item in the array such as "ThreeOfAKind" is an instance of a class
        // that implements the combination interface. We are pre-loading this array with objects that contain different scores.
        // 
        lowerSection = new Combination[]{new ThreeOfAKind(), new FourOfAKind(), new FullHouse(), new SmallStraight(), new LargeStraight(), new Yachtzee(), new Chance() };
    }

//    public Combination findUpper(int a, int b, int c, int d, int e) throws Exception {
//        // Your code goes here
//    }

    public Combination findLower(int a, int b, int c, int d, int e) throws Exception {
    	
    	int highest = 0;
    	int highestIndex = 0;
    	for(int i = 0 ; i < upperSection.length; i++) {
    		int score = upperSection[i].getScore(a, b, c, d, e);
    		if(score > highest) {
    			highest = score;
    			highestIndex = i;
    		}
    	}

    	System.out.printf("%s is the highest with score %d\n", upperSection[highestIndex].getName(), highest);
    	return upperSection[highestIndex];
    
    	
        // Your code goes here
    }
    
	public Combination findUpper(int a, int b, int c, int d, int e) throws Exception {

		int highest = 0;
		int highestIndex = 0;
		for (int i = 0; i < lowerSection.length; i++) {
			int score = lowerSection[i].getScore(a, b, c, d, e);
			if (score > highest) {
				highest = score;
				highestIndex = i;
			}
		}

		System.out.printf("%s is the highest with score %d\n", lowerSection[highestIndex].getName(), highest);
		return lowerSection[highestIndex];

		// Your code goes here
	}
 
 public static int getDupes(int a, int b, int c, int d, int e, int number) {
	 
	 int counter = 0;
	 int [] numbers = {a,b,c,d,e};
	 for(int i = 0; i < numbers.length; i++) {
		 if(numbers[i] == number) {
			 counter++;
		 }
	 }
	 
	 return counter;
 }
}
