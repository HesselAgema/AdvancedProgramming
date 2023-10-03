package data;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Setup {
	// bonus 1
	private static final String inputRooms = "C://Users//Hesse//OneDrive//Documenten//Vu//Advanced Programming//Assignments//Assignment2/hotelier_bonus1.txt";
	// bonus 2
	private static final String updateFile = "C://Users//Hesse//OneDrive//Documenten//Vu//Advanced Programming//Assignments//Assignment2/bonus2_HesselAgema.txt";
	
	
	// bij eerste keer launchen, hier path naar gewilde locatie neerzetten. hij paakt dan in die locatie een txt bestand aan genaamd bonus2_HesselAgema
	// daarna locatie van dit txt bestand zetten bij updateFile.
	private static final String pathToNewFile = "C://Users//Hesse//OneDrive//Documenten//Vu//Advanced Programming//Assignments//Assignment2/";
	
	
	
	public void createRooms(boolean ask, Map<Integer, Room> roomMap) {
		if(ask) {       		// dont use askInput() because we will need another try catch.
			addRooms(roomMap);	
		}else {
			// hardcode standard rooms
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
	
	private void addRooms(Map<Integer, Room> roomMap) {
		// add rooms from file.
		try {
		      File myObj = new File(inputRooms);
		      Scanner myReader = new Scanner(myObj);
		      myReader.nextLine(); // we dont need first line.
		      while (myReader.hasNextLine()) {
		        Scanner lineScanner = new Scanner(myReader.nextLine());
		        lineScanner.useDelimiter(",\\s*");
		        if(!(lineScanner.hasNext())) {     // use hasNext because it returns boolean, the .next() throws noSuchElement error when theres nothing to read.
		        	break;
		        }
		        int number = Integer.parseInt(lineScanner.next());
		        String description = lineScanner.next();
		        double price = Double.parseDouble(lineScanner.next());
		        if(description == null) {
		        	break; // would have been caught in catch but i like this for readability.
		        }
		        Room room = new Room(price, false, description);
		        roomMap.add(number, room);
		      }
		      System.out.println("File has been read");
		      myReader.close();
		    } catch (Exception e) {
		      System.out.println("An error occurred.");
		      //e.printStackTrace();
		    }
		
	}
	
public void askMemoryFile(Map<Integer, Room> roomMap) {
		// reads status of rooms and updates rooms accordingly from updateFile txt file.
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

public void writeToFileAndExit(Map<Integer, Room> roomMap) {
	
	
	System.out.println("Do you want to create a new file? Awnser 'yes' or 'no' \t only needed first time.");
	FileWriter myWriter;
	
	try {
		// selecting appropriate file voor eerste keer. werkt later nog steeds als je "yes" doet. hij overwrite het bestand dan.
		boolean ask = Main.askInput();
		if(ask) {
			System.out.println("Creating a new file");
			File updateFile2 = new File(pathToNewFile+"bonus2_HesselAgema.txt");
			myWriter = new FileWriter(updateFile2);
		}else {
			myWriter = new FileWriter(updateFile);
		}
		
		// write to appropriate file
		LinkedList<Integer> a = roomMap.getKeys();
		for (int i = 0; i < a.size(); i++) {
			int num = a.get(i);
			myWriter.write("" + num + "," + roomMap.get(num).getOccupancy() + "," + roomMap.get(num).getPerson() + "\n");
		}
		myWriter.close();
		System.out.println("Successfully wrote to the file.");
	} catch (Exception e) { //Exception e so it can catch both exceptions
		System.out.println("An error occurred.");
	}
}
}
