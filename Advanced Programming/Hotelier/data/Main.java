package data;

import java.util.Scanner;

public class Main {

	public static Scanner scanner = new Scanner(System.in);
	static Setup setup = new Setup();

	//RoomManager Room;
	public static void main(String[] args) {
		Map<Integer, Room> roomMap = new MapImplementation<>();
		
		// setup of rooms
		try{
			System.out.println("Do you want to input custom rooms?, Awnser Yes or No");
			setup.createRooms(askInput(), roomMap);
			System.out.println("Do you want to update Rooms from last login? Awnser Yes or No");
			if(askInput()) {
				setup.askMemoryFile(roomMap);
			}
		}catch (Exception e){
			System.out.println(e.getMessage() + ",\tGoing with default options");
		}
		
		// performing commands
		performCommands(roomMap);		
		scanner.close();
		
		}
	
		private static void performCommands(Map<Integer, Room> roomMap) {
			boolean runTillExit = true;
			while (runTillExit) {

				String command = getCommand();
				switch (command) {

				case ("checkin"):
					System.out.println("What room you want to check in?");
					String number3 = scanner.nextLine();
					try {
						checkin(number3, roomMap);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case ("view"):
					System.out.println("What room you want to view?");
					String number = scanner.nextLine();
					try {
						viewRoom(number, roomMap);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case ("checkout"):
					System.out.println("what room you want to check out");
					String number2 = scanner.nextLine();
					try {
						checkout(number2, roomMap);
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case ("list"):
					System.out.println("here is the list!");
					list(roomMap);
					break;
				case ("exit"):
					System.out.println("Have a nice day");

					// bonus 2, kijk bovenaan setup class voor het providen van paths.
					setup.writeToFileAndExit(roomMap);
					runTillExit = false;
					break;
				}
			}
		}

	private static String getCommand() {

		System.out.println("Enter a command (checkin, checkout, list, view, exit)");
		return scanner.nextLine().trim(); // use nextLine so there are not still whitespaces in memory of scanner. trim explanation line 166
	}

	public static void checkin(String number, Map<Integer, Room> roomMap) throws Exception {
		int num = parseNum(number);
		if (roomMap.get(num) == null) {
			throw new Exception("Error : room was not found");
		}
		String name;
		//could check whether name is actually a string, and not characters,integers or doubles but dont think thats neccessary.
		if (!(roomMap.get(num).getOccupancy())) {
			roomMap.get(num).setOccupancy(true);
			System.out.println("Enter guest name");
			name = scanner.nextLine();
			roomMap.get(num).setPerson(name);
		} else {
			throw new Exception("Room is occupied");
		}
		System.out.printf("person %s checked in in room %d\n", name, num);
		return;
	}

	private static void checkout(String number, Map<Integer, Room> roomMap) throws Exception {
		int num = parseNum(number);
		// check whether there exists a room with this number
		if ((roomMap.contains(num) == false)) {
			throw new Exception("There is no room with this number");
		}

		// check if room is occupied. if not set occupancy to true and add person to room.
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

		int num = parseNum(number);

		if (!(roomMap.get(num) == null)) {
			Room room = roomMap.get(num);
			room.printInfo(num);
		} else {
			throw new Exception("Room number not found");
		}

	}

	private static int parseNum(String number) throws Exception {

		try {
			int num = Integer.parseInt(number);
			return num;
		} catch (Exception e) {
			throw new Exception("Number was not an integer");
		}
	}

	public static boolean askInput() throws Exception {

		String input = scanner.nextLine().trim(); // .trim() for when someone types "yes " or "no " with a white space.
												  // i also have this in the command input.
		if (input.equals("Yes") || input.equals("yes")) {
			return true;
		} else if (input.equals("No") || input.equals("no")) {
			return false;
		} else {
			throw new Exception("Input not correct");
		}
	}

	}




