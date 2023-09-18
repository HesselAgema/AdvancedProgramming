package ap.assignments.yahtzee;

import ap.assignments.yahtzee.rolls.Combination;

public class YahtzeeGame {
	
    public static void main(String[] args) {
        // Create an instance of CombinationChecker
    	
        CombinationChecker checker = new CombinationChecker();

        System.out.printf("Yachtzee! Enter your numbers below\n");       
        
        String [] finalNumbers = new String[5];
        int [] finalNumbersInt = new int[5];

        boolean wrongInput = true;
        while(wrongInput) {
        	try {
        		//check numbers and throw appropriate error message until wrongInput is false. (so input is good)
           	 	finalNumbers = checker.getInput();
            	finalNumbersInt = checker.checkNumbers(finalNumbers);
           	 	wrongInput = false;
            	Combination highestLower = checker.findLower(finalNumbersInt[0],finalNumbersInt[1],finalNumbersInt[2],finalNumbersInt[3],finalNumbersInt[4]);
                Combination highestUpper = checker.findUpper(finalNumbersInt[0],finalNumbersInt[1],finalNumbersInt[2],finalNumbersInt[3],finalNumbersInt[4]);
                checker.printScores(highestLower, highestUpper, finalNumbersInt[0],finalNumbersInt[1],finalNumbersInt[2],finalNumbersInt[3],finalNumbersInt[4]);
                
            } catch (Exception e) {
            	System.out.println(e.getMessage() + ", please enter new numbers");
            }
        }
    }

	}
