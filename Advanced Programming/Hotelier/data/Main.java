package data;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	//RoomManager Room;
	public static void main(String[] args) {
		Map<Integer, Room> roomMap = new MapImplementation<>();

		boolean ask = false;
		try{
			System.out.println("Do you want to input custom rooms?, Awnser Yes or No");

			ask = askInput();
			createRooms(ask, roomMap);
			System.out.println("Do you want to update Rooms from last login? Awnser Yes or No");
			ask = askInput();
			if(ask) {
				askMemoryFile(roomMap);
			}
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		
				
		
		
		boolean runTillExit = true;
		while(runTillExit) {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a command");
		Scanner lineScanner = new Scanner(in.nextLine());
		String command = lineScanner.nextLine();
		boolean wrongInput = true;

		switch(command) {
		
		case("checkin"):
			System.out.println("What room you want to check in?");

			

				String number3 = in.next();	
				try{
					checkin(number3, roomMap);
					break;
					//wrongInput = false;
				}catch( Exception e) {
					System.out.println(e.getMessage());
				}
				
			
			break;
		case("view"):
			System.out.println("What room you want to view?");
			String number = in.next();
			try {
				viewRoom(number, roomMap);
				break;
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		case("checkout"):
			System.out.println("what room you want to check out");
		String number2 = in.next();
		try {
			checkout(number2, roomMap);
			break;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		break;
		case("list"):
			System.out.println("here is the list!");
			list(roomMap);
		
			break;
		case("exit"):
			System.out.println("Have a nice day");
			runTillExit = writeToFileAndExit(roomMap);
			runTillExit = false;
			break;
		}
		
		}
	}
	
	private static void askMemoryFile(Map<Integer, Room> roomMap) {
		
		try {
		      File myObj = new File("C://Users//Hesse//OneDrive//Documenten//Vu//Advanced Programming//Assignments//Assignment2/testcreate.txt");
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
		      e.printStackTrace();
		    }
		// import de file van hieronder
		// check of rooms daarin zelfde zijn als rooms nu.
		// als dat niet het geval is stopt deze method gewoon en staan alle rooms op free zoals standaard.
		// anders pakken we de int roomNumber, String boolean, String peron en stoppen die in de goede Room via roomMap.
		// en dan hopelijk is alles geupdate.
		// ff bedenken wat chiller is, person wordt null als er niemand is, of dat er dan niks staat in de file./
		// wat is makkelijker met input lezen.
		
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

	private static boolean writeToFileAndExit(Map<Integer, Room> roomMap) {

		try {
			FileWriter myWriter = new FileWriter(
					"C://Users//Hesse//OneDrive//Documenten//Vu//Advanced Programming//Assignments//Assignment2/testcreate.txt");
			LinkedList<Integer> a = roomMap.getKeys();
			for (int i = 0; i < a.size(); i++) {
				int num = a.get(i);
				boolean occupancy = roomMap.get(num).getOccupancy();
				String person = roomMap.get(num).getPerson();
				myWriter.write("" + num + "," + occupancy + "," + person + "\n");
			}
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return false;
	}

	private static void createRooms(boolean ask, Map<Integer, Room> roomMap) {
		if(ask) {
			addRooms(roomMap);	
		}else {
			Room room1 = new Room(50.00, false, "Nice First room, beachview");
			roomMap.add(101, room1);
			
			
			Room room2 = new Room(40.00, false, "Fine Second room, cityview");
			roomMap.add(102, room2);
			
			Room room3 = new Room(30.00, false, "Okay Third room, garbageview");
			roomMap.add(103, room3);
			
			Room room4 = new Room(20.00, false, "Okay Fourth room, no view");
			roomMap.add(104, room4);
			
			printRoom(roomMap.get(104));
		}
		
	}

	private static boolean askInput() throws Exception {
		
		Scanner askInput = new Scanner(System.in);
		
			String input = askInput.next();
			if(input.equals("Yes") || input.equals("yes")) {
				return true;
			}else if(input.equals("No") || input.equals("no")) {
				return false;
			}else {
				throw new Exception("Input not correct");
			}
			
		
	}

	private static void addRooms(Map<Integer, Room> roomMap) {
		try {
		      File myObj = new File("C://Users//Hesse//OneDrive//Documenten//Vu//Advanced Programming//Assignments//Assignment2/inputRooms.txt");
		      Scanner myReader = new Scanner(myObj);
		      String firstLine = myReader.nextLine();
		      while (myReader.hasNextLine()) {
		        //String line = myReader.nextLine();
		        Scanner lineScanner = new Scanner(myReader.nextLine());
		        lineScanner.useDelimiter(",");
		        int number = Integer.parseInt(lineScanner.next());
		        String description = lineScanner.next();
		        double price = Double.parseDouble(lineScanner.next());
		        Room room = new Room(price, false, description);
		        roomMap.add(number, room);
		      }
		      myReader.close();
		    } catch (Exception e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
	}
	
	private static void printRoom(Room room) {
		String description = room.getDescription();
		String person = room.getPerson();
	}

	private static void checkout(String number, Map<Integer, Room> roomMap) throws Exception {
		int num = 0;
		try {
			num = Integer.parseInt(number);
			
		} catch (Exception e) {
			throw new Exception("Number was not an integer");
		}
		
		//Check if number is even a room.
		if(!(roomMap.contains(num))) {
			throw new Exception("There is no room with this number");
		}

		Room roomToCheckOut = roomMap.get(num);
		if (roomToCheckOut.getOccupancy() == false) {
			throw new Exception("Error: Room is empty");
		} else {
			roomToCheckOut.setOccupancy(false);
			System.out.printf("Person %s has been checked out of room %d\n", roomToCheckOut.getPerson(), num);
		}

	}

	private static void list(Map<Integer, Room> roomMap) {

		LinkedList<Integer> keys = roomMap.getKeys();
		for (int i = 0; i < keys.size(); i++) {
			int roomNumber = keys.get(i);
			Room room = roomMap.get(roomNumber);
			room.printInfo(roomNumber);
		}

	}

	private static void viewRoom(String number, Map<Integer, Room> roomMap) throws Exception {

		int num = 0;
		try {
			num = Integer.parseInt(number);
		} catch (Exception e) {
			throw new Exception("Number was not an integer");
		}

		if (roomMap.contains(num)) {
			Room room = roomMap.get(num);
			room.printInfo(num);
		} else {
			throw new Exception("Room number not found");
		}

	}

	public static void checkin(String number, Map<Integer, Room> roomMap) throws Exception {
		int num = 0;
		try {
			num = Integer.parseInt(number);
		} catch (Exception e) {
			throw new Exception("Number was not an integer");
		}
		if (roomMap.get(num) == null) {
			throw new Exception("Error : room was not found");
		}
		System.out.println("Enter guest name");
		Scanner in = new Scanner(System.in);
		Scanner nameScanner = new Scanner(in.nextLine());
		String name = nameScanner.next();
		if (!(roomMap.get(num).getOccupancy())) {
			roomMap.get(num).setOccupancy(true);
			roomMap.get(num).setPerson(name);
//			System.out.println("checkin in");
		} else {
			throw new Exception("Room is occupied");
		}
		System.out.printf("person %s checked in in room %d\n", name, num);
		return;
	}
	}




