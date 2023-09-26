package oefen;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

public class Oefen {

PrintStream out;

	
	Oefen() {
		out = new PrintStream(System.out);
	}
	
	void start() {
	      File myObj = new File("C://Users//Hesse//OneDrive//Documenten//Vu//Advanced Programming//Assignments//Assignment2/inputRooms.txt");

		try {
		      FileWriter myWriter = new FileWriter("C://Users//Hesse//OneDrive//Documenten//Vu//Advanced Programming//Assignments//Assignment2/testcreate.txt");
		      myWriter.write("Hi, This is my first write");
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	public static void main(String[] argv) {
		new Oefen().start();
	}
	
}
