package data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Setup {
	// bonus 1
	private static final String inputRooms = "C://Users//Hesse//OneDrive//Documenten//Vu//Advanced Programming//Assignments//Assignment2/hotelier_bonus1.1.txt";
	// bonus 2
	private static final String updateFile = "C://Users//Hesse//OneDrive//Documenten//Vu//Advanced Programming//Assignments//Assignment2/testcreate.txt";
	
	public void createRooms(boolean ask, Map<Integer, Room> roomMap) {
		if(ask) {       		// niet hier askInput() gebruiken want dan hebben we try catch nodig. staat boven al.
			addRooms(roomMap);	
		}else {
			// Initializie standard rooms
			Room room1 = new Room(50.00, false, "Nice First room, beachview");
			roomMap.add(101, room1);
			Room room2 = new Room(40.00, false, "Fine Second room, cityview");
			roomMap.add(102, room2);	
			Room room3 = new Room(30.00, false, "Okay Third room, garbageview");
			roomMap.add(103, room3);
			Room room4 = new Room(20.00, false, "Okay Fourth room, no view");
			roomMap.add(104, room4);
			}
		
	}
	
	public void addRooms(Map<Integer, Room> roomMap) {
		try {
		      File myObj = new File(inputRooms);
		      Scanner myReader = new Scanner(myObj);
		      myReader.nextLine(); // we dont need first line.
		      while (myReader.hasNextLine()) {
		        Scanner lineScanner = new Scanner(myReader.nextLine());
		        lineScanner.useDelimiter(",\\s*");
		        if(!(lineScanner.hasNext())) {     // gebruiken hasNext want returnt boolean, de .next() gooit noSuchElement error als er niks te lezen is.
		        	break;
		        }
		        int number = Integer.parseInt(lineScanner.next());
		        String description = lineScanner.next();
		        double price = Double.parseDouble(lineScanner.next());
		        if(description == null) {
		        	break;
		        }
		        Room room = new Room(price, false, description);
		        roomMap.add(number, room);
		      }
		      System.out.println("has no more to read");
		      myReader.close();
		    } catch (Exception e) {
		      System.out.println("An error occurred.");
		      //e.printStackTrace();
		    }
		
	}
	
public void askMemoryFile(Map<Integer, Room> roomMap) {
		
		try {
		      File myObj = new File(updateFile);
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        Scanner lineScanner = new Scanner(myReader.nextLine());
		        lineScanner.useDelimiter(",");
		        int number = Integer.parseInt(lineScanner.next());
		        String occupancy = lineScanner.next();
		        String person = lineScanner.next();
		        updateRoom(number, occupancy, person, roomMap);
		      }
		      myReader.close();
		    } catch (Exception e) {
		      System.out.println("An error occurred.");
		      //e.printStackTrace();
		    }
		
	}

private static void updateRoom(int number, String occupancy, String person, Map<Integer, Room> roomMap) {
	
	Room currentRoom = roomMap.get(number);
	// if currentRoom actually has a person in it, update it.
	if(currentRoom.getOccupancy() == false && occupancy.equals("true")) {
		currentRoom.setOccupancy(true);
		currentRoom.setPerson(person);
	}
	// else no update needed
}

public boolean writeToFileAndExit(Map<Integer, Room> roomMap) {
	
	
//	System.out.println("Do you want to create a new file? Awnser 'yes' or 'no'");

	try {
//		boolean ask = Main.askInput();
//		if(ask) {
//			System.out.println("Wants to create a new file");
//			File updateFile = new File("updateFile.txt");
//		}
		FileWriter myWriter = new FileWriter(updateFile);
		
		
		
		
		LinkedList<Integer> a = roomMap.getKeys();
		for (int i = 0; i < a.size(); i++) {
			int num = a.get(i);
			myWriter.write("" + num + "," + roomMap.get(num).getOccupancy() + "," + roomMap.get(num).getPerson() + "\n");
		}
		myWriter.close();
		System.out.println("Successfully wrote to the file.");
	} catch (Exception e) { //Exception e omdat die beide exceptions dan kan catchen.
		System.out.println("An error occurred.");
		//e.printStackTrace();
	}
	return false;
}
}
