package ap.assignments.yahtzee.rolls;

public class SmallStraight implements Combination {

	@Override
	public String getName() {
		return "Small Straight";
	}
	
	@Override
	public int getScore(int a, int b, int c, int d, int e) {

		int[] roll = {a,b,c,d,e};
		// of 6,5,4,3,3
		// of 6,4,3,2,1
		// of 6,5,5,4,3
		
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
				return 25;
			}
		}
		System.out.printf("%d\n", count);
		return 0;
	}
}
