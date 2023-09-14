package oefen;

import java.io.PrintStream;
import java.util.Scanner;


public class Oefen3 {
PrintStream out;

	
	Oefen3() {
		out = new PrintStream(System.out);
	}
	
	void start() {
		
		
		int[] numbers = new int[5];
		numbers[0] = 1;
		numbers[1] = 2;
		numbers[2] = 3;
		numbers[3] = 4;
		numbers[4] = 5;
		
		int i =4;
		
		//out.printf("number %d in array has number %d", i , numbers[i]);
		out.print("Enter 5 numbers below\n");
		int []finalNumbers = getInput();
		//printNumbers2(finalNumbers);

		
	}

	private int[] getInput () {
		Scanner in = new Scanner(System.in);
		int counter = 0;
		
		String [] numbers = new String[5];
		int[] finalNumbers = new int[5];
		String input = in.nextLine();
		Scanner inputScanner = new Scanner(input);
		inputScanner.useDelimiter("\\s+");
		
		
		try {
			while(inputScanner.hasNext()) {
				numbers[counter] = inputScanner.next();
				//System.out.printf("Number = %s with counter = %d\n", numbers[counter], counter);

				counter++;
			}
            finalNumbers = checkNumbers(numbers);
    		//printNumbers2(finalNumbers);


        } catch (Exception e2) {
        	System.out.printf("Numbers are not correct\n");
           // e2.printStackTrace();
        }

		//printNumbers(numbers);
		//int [] finalNumbers = checkNumbers(numbers);
		return finalNumbers;
	}

	private int[] checkNumbers(String[] numbers) throws Exception {
		int[] integers = new int[5];
		
		for(int i = 0; i < numbers.length; i++) {
			//check whether number is an Integer
			integers[i] = Integer.parseInt(numbers[i]);

			// check whether between [1-6]
			if(integers[i] >= 1 && integers[i] <= 6 ) {
				
			}else {
				throw new Exception();
			}
		}
		
		return integers;
	}

	private void printNumbers(String[] numbers) {
		
		
		
		for(int i = 0 ; i < numbers.length; i++) {
			System.out.printf("Number = %s with counter = %d\n", numbers[i], i);

		}
		
	}
private void printNumbers2(int[] finalNumbers) {
		
		
		
		for(int i = 0 ; i < finalNumbers.length; i++) {
			System.out.printf("Number = %d with counter = %d\n", finalNumbers[i], i);

		}
		
	}

	public static void main(String[] argv) {
		new Oefen3().start();
	}
}
