package data;

import java.util.Scanner;

public class Main {

	//RoomManager Room;
	public static void main(String[] args) {
		Map<Integer, Room> roomMap = new MapImplementation<>();

		//RoomManager Room = new RoomManager(roomMap);

		Room room1 = new Room(50.00, false, "Nice First room, beachview");
		roomMap.add(101, room1);
		
		
		Room room2 = new Room(40.00, false, "Fine Second room, cityview");
		roomMap.add(102, room2);
		
		Room room3 = new Room(30.00, false, "Okay Third room, garbageview");
		roomMap.add(103, room3);
		
		Room room4 = new Room(20.00, false, "Okay Fourth room, no view");
		roomMap.add(104, room4);
		
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

			while(wrongInput) {

				String number = in.next();	
				try{
					checkin(number, roomMap);
					break;
					//wrongInput = false;
				}catch( Exception e) {
					System.out.println(e.getMessage() + " Enter new room number");
				}
				
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
			runTillExit = false;
			break;
		}
		
		}
	}
	
	private static void checkout(String number2, Map<Integer, Room> roomMap) throws Exception {
		int num= 0;
		try {
			num = Integer.parseInt(number2);
			
		}catch (Exception e) {
			throw new Exception("Number was not an integer");
		}
		
		Room roomToCheckOut = roomMap.get(num);
		if(roomToCheckOut.getOccupancy() == false) {
			throw new Exception("Error: Room is empty");
		}else {
			roomToCheckOut.setOccupancy(false);
			//String person = roomToCheckOut.getPerson();
			System.out.printf("Person %s has been checked out of room %d\n", roomToCheckOut.getPerson(), num);
		}
		
	}

	private static void list(Map<Integer, Room> roomMap) {
		
		//Room testroom = roomMap.get(101);
		//testroom.printInfo();
		
		LinkedList<Integer> keys = roomMap.getKeys(); 
		for(int i = 0 ; i < keys.size(); i++) {
			int roomNumber = keys.get(i);
			Room room = roomMap.get(roomNumber);
			//System.out.println(keys.get(i));
			room.printInfo(roomNumber);
		}
		// change get all keys to return integer
		// loop over that integer array which has room numbers to go
		// over Room objects and print their
		// price, description, occupancy, person if occupied. and number ofcourse.
		
	}

	private static void viewRoom(String number, Map<Integer, Room> roomMap) throws Exception {
		
		int num= 0;
		try {
			num = Integer.parseInt(number);
			
		}catch (Exception e) {
			throw new Exception("Number was not an integer");
		}
		
		System.out.printf("Num = %d\n", num);
		if(roomMap.contains(num)) {
			Room room = roomMap.get(num);
			room.printInfo(num);
				
		}else {
			throw new Exception("Room number not found");
		}
		
		
	}

	public static void checkin(String number, Map<Integer, Room> roomMap) throws Exception {
		int num= 0;
		try {
			num = Integer.parseInt(number);
			
		}catch (Exception e) {
			throw new Exception("Number was not an integer");
		}
		System.out.println("Enter guest name");
		Scanner in = new Scanner(System.in);
		Scanner nameScanner = new Scanner(in.nextLine());
		String name = nameScanner.next();
		//in.close();
		//String name = "Hessel";
		System.out.printf("num = %d\n", num);
		
		
		
		if(roomMap.get(num) == null) {
			throw new Exception("Error : room was not found");
		}else {
			if(!(roomMap.get(num).getOccupancy())){
				roomMap.get(num).setOccupancy(true);
				roomMap.get(num).setPerson(name);
				System.out.println("checkin in");
			}else {
				throw new Exception("Room is occupied");
			}
			
			
			System.out.printf("person %s checked in in room %d\n", name,num);
			return;
		}
	}


}
