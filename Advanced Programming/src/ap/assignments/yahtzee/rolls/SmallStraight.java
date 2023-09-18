package ap.assignments.yahtzee.rolls;

public class SmallStraight implements Combination {

	@Override
	public String getName() {
		return "Small Straight";
	}
	
	@Override
	public int getScore(int a, int b, int c, int d, int e) {

		int[] roll = {a,b,c,d,e};
		
		int count = 1;
		for(int i = 1; i < roll.length; i++) {
			if(roll[i] == roll[i-1] -1) {
				// if dice i is 1 bigger than i-1, (starting from 2nd dice) 
				count++;
				
			}else if (roll[i] != roll[i - 1]) {
				// if roll is NOT the same as previous, then we reset count to one. (because roll can also be 5 <4> <4> 2 1)
				// then if 4 is same as 4, we don't want to reset count to one. just if they are not consecutive nor the same.
				count = 1;
			}
			
			if(count == 4) {
				return 30;
			}
		}
		return 0;
	}
}
