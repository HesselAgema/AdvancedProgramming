package ap.assignments.yahtzee;

import java.util.Scanner;

public class YahtzeeGame {

    public static void main(String[] args) {
        // Create an instance of CombinationChecker
        CombinationChecker checker = new CombinationChecker();

        Scanner in = new Scanner(System.in);
        int[] nums = getInput(in);
        printInput(nums);
        
        
        
        // Test the findLower method with the dice roll {1,2,3,4,5}
        try {
            checker.findLower(5,5,5,3,2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

	private static void printInput(int[] nums) {

		for(int i = 0; i < nums.length; i++) {
			System.out.printf("number = %d\n", nums[i]);
		}
	}

	private static int[] getInput(Scanner in) {
		
		int[] num = new int[5];
		
		int counter = 0;
		while(in.hasNextInt() && counter != 5) {
			num[counter] = in.nextInt();
			System.out.printf("number %d in place %d\n", num[counter], counter);
			counter++;
		}
		return num;
	}
}
