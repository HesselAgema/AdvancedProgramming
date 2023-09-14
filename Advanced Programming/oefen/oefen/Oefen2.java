package oefen;

import java.io.PrintStream;
import java.util.Scanner;


public class Oefen2 {
PrintStream out;

	
	Oefen2() {
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
		
		getInput();
		
	}

	private void getInput() {
		Scanner in = new Scanner(System.in);
		
		int[] numbers = new int[5];
		int counter = 0;
		
		while(in.hasNext() && counter <5) {
			int numbers2 = in.nextInt();
			System.out.printf("Number = %d with counter = %d\n", numbers2, counter);
			counter++;
			//System.out.printf("Number = %d with counter = %d\n", numbers2, counter);


		}
		
		
		
	}

	public static void main(String[] argv) {
		new Oefen2().start();
	}
}
