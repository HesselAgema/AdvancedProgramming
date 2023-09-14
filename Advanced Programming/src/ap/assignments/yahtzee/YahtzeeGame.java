package ap.assignments.yahtzee;

import java.util.Scanner;

public class YahtzeeGame {

    public static void main(String[] args) {
        // Create an instance of CombinationChecker
        CombinationChecker checker = new CombinationChecker();

        System.out.printf("Yachtzee! Enter your numbers here\n");       
        
        String [] finalNumbers = new String[5];
        int [] finalNumbersInt = new int[5];

        boolean wrongInput = true;
        // Test the findLower method with the dice roll {1,2,3,4,5}
        while(wrongInput) {
        	try {
           	 	finalNumbers = getInput();
            	finalNumbersInt = checkNumbers(finalNumbers);
           	 	wrongInput = false;
            	checker.findLower(finalNumbersInt[0],finalNumbersInt[1],finalNumbersInt[2],finalNumbersInt[3],finalNumbersInt[4]);
                checker.findUpper(finalNumbersInt[0],finalNumbersInt[1],finalNumbersInt[2],finalNumbersInt[3],finalNumbersInt[4]);

               
            } catch (Exception e2) {
                //e2.printStackTrace();
            	System.out.println(e2.getMessage());
                //System.out.println("Entered too many or too few numbers!");
            }
        }
        
        
        //printInput(finalNumbers);
    }

//	private static void printInput(int[] nums) {
//
//		for(int i = 0; i < nums.length; i++) {
//			System.out.printf("number = %d\n", nums[i]);
//		}
//	}

	private static String[] getInput() throws Exception {
		
		Scanner in = new Scanner(System.in);
		int counter = 0;
		
		String [] numbers = new String[5];
		//int[] finalNumbers = new int[5];
		String input = in.nextLine();
		Scanner inputScanner = new Scanner(input);
		inputScanner.useDelimiter("\\s+");
		
		try {
			while(inputScanner.hasNext()) {
				numbers[counter] = inputScanner.next();

				counter++;
				}
			}catch (Exception e2) {
        	throw new Exception("too many numbders");
        }
		
		return numbers;
	}

	private static int[] checkNumbers(String[] numbers) throws Exception {
		int[] integers = new int[5];
		
		for(int i = 0; i < numbers.length; i++) {
			//check whether number is an Integer
			try {
				integers[i] = Integer.parseInt(numbers[i]);

			} catch(Exception e) {
				throw new Exception("Numbers not all Integers");
			}

			// check whether between [1-6]
			if(integers[i] >= 1 && integers[i] <= 6 ) {
				
			}else {
				throw new Exception("Integers not between 1 and 6");
			}
			
			
		}
		// Sorry, this is for readability. Thought this was better than a for loop.
		int a = integers[0]; int b = integers[1]; int c = integers[2]; int d = integers[3]; int e = integers[4];
		if(!(a >= b && b >= c && c >= d && d >= e)) {
			throw new Exception("Numbers are not in descending order");
		}
		
		return integers;
	}
}
