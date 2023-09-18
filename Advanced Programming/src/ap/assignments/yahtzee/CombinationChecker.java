package ap.assignments.yahtzee;

import java.util.Scanner;

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
		upperSection = new Combination[] { new Ones(), new Twos(), new Threes(), new Fours(), new Fives(),
				new Sixes() };

		// initialize array of combination objects. each item in the array such as
		// "ThreeOfAKind" is an instance of a class
		// that implements the combination interface. We are pre-loading this array with
		// objects that contain different scores.
		//
		lowerSection = new Combination[] { new ThreeOfAKind(), new FourOfAKind(), new FullHouse(), new SmallStraight(),
				new LargeStraight(), new Yachtzee(), new Chance() };
	}


	public Combination findUpper(int a, int b, int c, int d, int e) throws Exception {

		int highest = 0;
		int highestIndex = 0;
		for (int i = 0; i < upperSection.length; i++) {
			int score = upperSection[i].getScore(a, b, c, d, e);
			if (score > highest) {
				highest = score;
				highestIndex = i;
			}
		}
		return upperSection[highestIndex];
	}
	

	public Combination findLower(int a, int b, int c, int d, int e) throws Exception {

		int highest = 0;
		int highestIndex = 0;
		for (int i = 0; i < lowerSection.length; i++) {
			int score = lowerSection[i].getScore(a, b, c, d, e);
			if (score > highest) {
				highest = score;
				highestIndex = i;
			}
		}

		
		int threeOfAKindScore = lowerSection[0].getScore(a, b, c, d, e);
		int fourOfAKindScore = lowerSection[1].getScore(a, b, c, d, e);
		if(threeOfAKindScore == fourOfAKindScore && threeOfAKindScore == highest) {
			System.out.println("Three of a kind has the same points as four of a kind.\nWe will assign points to four of a kind since its more rare!\n");
			return lowerSection[1];
		}
		return lowerSection[highestIndex];
	}

	
	// I would rather have added a "managing" or a "utility" class which had all the method below but idk 
	//whether that was allowed, which is why i should have asked. My bad.
	public String[] getInput() throws Exception {

		Scanner in = new Scanner(System.in);
		int counter = 0;
		
		String[] numbers = new String[5];
		String input = in.nextLine();
		Scanner inputScanner = new Scanner(input);
		inputScanner.useDelimiter("\\s+");

		try {
			while (inputScanner.hasNext()) {
				numbers[counter] = inputScanner.next();
				counter++;
			}
		} catch (Exception e2) {
			throw new Exception("too many numbers");
		}

		return numbers;
	}

	public int[] checkNumbers(String[] numbers) throws Exception {
		int[] integers = new int[5];

		for (int i = 0; i < numbers.length; i++) {
			// check whether number is an Integer
			try {
				integers[i] = Integer.parseInt(numbers[i]);

			} catch (Exception e) {
				throw new Exception("Numbers not all Integers");
			}

			// check whether between [1-6]
			if (integers[i] >= 1 && integers[i] <= 6) {

			} else {
				throw new Exception("Integers not between 1 and 6");
			}

		}
		// Sorry, this is for readability. Thought this was quicker than a for loop.
		// checks whether numbers are in descending order
		int a = integers[0];
		int b = integers[1];
		int c = integers[2];
		int d = integers[3];
		int e = integers[4];
		if (!(a >= b && b >= c && c >= d && d >= e)) {
			throw new Exception("Numbers are not in descending order");
		}

		return integers;
	}

	public static int getDupes(int a, int b, int c, int d, int e, int number) {
		// count amount of dice rolls are the same as variable number. method for upper side of scoreboard.
		int counter = 0;
		int[] numbers = { a, b, c, d, e };
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == number) {
				counter++;
			}
		}

		return counter;
	}

	public void printScores(Combination highestLower, Combination highestUpper, int a, int b, int c, int d, int e) {
		System.out.printf("%s is the highest in the upper section with score (%d points)\n", highestUpper.getName(), highestUpper.getScore(a, b, c, d, e));
		System.out.printf("%s is the highest in the lower section with score (%d points)\n",highestLower.getName(), highestLower.getScore(a, b, c, d, e));
		
	}
}
