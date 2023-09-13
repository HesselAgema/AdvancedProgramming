package oefen;

import java.io.PrintStream;

public class Oefen {

PrintStream out;

	
	Oefen() {
		out = new PrintStream(System.out);
	}
	
	void start() {
		
		int[] roll = {5,5,3,3,3};
		int[] roll2 = {6,6,6,3,3};
		int[] roll3 = {5,4,4,3,2};
		int[] roll4 = {6,5,4,3,2};
		int[] roll5 = {1,1,1,1,1};
		
		int[] roll0 = roll;
		if(smallStraight(roll0)) {
			out.printf("nice small straight\n");
			
		}else {
			out.printf("Not a small straight\n");
		}
		
		if(fullHouse(roll0)) {
			out.printf("FULL HOUSE!\n");
		}else {
			out.print("NOT FULL HOUSE\n");
		}
		
		if(ThreeKind(roll0)) {
			out.printf("Three of a kind!\n ");
		}else{
			out.printf("Not three of a kind\n");
		}
		
		
	int counter = howMany(roll0, 0 , 1);
	out.printf("Counter = %d\n", counter);
		
	}

	private boolean fullHouse(int[] roll) {

		int count = 1;
		int count2 =10;
		int finalCount  = 1;
		boolean maybe = false;
		for(int i = 1; i < roll.length; i++) {
			if(roll[i] == roll[i-1]) {
				count++;
				if(maybe) {
					count2++;

				}
				if(count >= 2) {
					// als count 2 of hoger is, dan kan het full house worden. Als die bij de volgende iteratie
					// niet hetzelfde is, slaat final count op en gaan we opnieuw tellen.
					maybe = true;
				}
			}else if(maybe) {
				finalCount = count;
				count = 1;
				
			}
		}
		
		if(finalCount == 2 && count == 3) {
			return true;
		}
		else if(finalCount == 3 && count == 2) {
			return true;
		}else {
			return false;
		}
		
	}

	private boolean smallStraight(int[] roll) {
		int count = 1;
		for(int i = 1; i < roll.length; i++) {
			if(roll[i] == roll[i-1] -1) {
				// if roll is last -1 so consecutive
				count++;
				
			}else if (roll[i] != roll[i - 1]) {
				// if roll is not consecutive and also not the same , so 2 or more lower
				count = 1;
			}
			
			if(count == 4) {
				return true;
			}
		}
		out.printf("%d\n", count);
		return false;
	}

	// we initialize like howMany(roll, 0, 1)

	private int howMany(int[] roll, int i, int counter) {

		if (i == 4) {

			//out.printf("i = %d and counter = %d\n", i, counter);
			return counter;

		}

		if (roll[i + 1] == roll[i]) {
			counter++;
			return howMany(roll, i + 1, counter);
		} else {
			return howMany(roll, i + 1, counter);
		}

	}


	public static void main(String[] argv) {
		new Oefen().start();
	}
	
}
