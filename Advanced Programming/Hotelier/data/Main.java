package data;

import java.util.Scanner;

public class Main {


	//RoomManager Room;
	public static void main(String[] args) {
		Map<Integer, Room> roomMap = new MapImplementation<>();

		//RoomManager Room = new RoomManager(roomMap);

		Room room1 = new Room(50.00, false, "Nice Room!");
		roomMap.add(101, room1);
		
		
		Room room2 = new Room(40.00, false, "Fine Room");
		roomMap.add(102, room2);
		
		Room room3 = new Room(30.00, false, "Okay Room");
		roomMap.add(103, room3);
		
		Room room4 = new Room(20.00, false, "Okay Room");
		roomMap.add(104, room4);
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter a command");
		Scanner lineScanner = new Scanner(in.nextLine());
		String command = lineScanner.nextLine();
		boolean wrongInput = true;
		System.out.println("What room you want to check in?");

		switch(command) {
		case("checkin"):
			while(wrongInput) {
				String number = in.next();	
				try{
					checkin(number, roomMap);
					//wrongInput = false;
				}catch( Exception e) {
					System.out.println(e.getMessage() + " Enter new room number");
				}
				
			}
			break;
		case("view"):
			System.out.println("What room you want to view?");
			break;
		case("checkout"):
			System.out.println("what room you want to check out");
			break;
		case("list"):
			System.out.println("here is the list!");
			break;
		case("exit"):
			System.out.println("Have a nice day");
			break;
		}
		
		
	}
	
	public static void checkin(String number, Map<Integer, Room> roomMap) throws Exception {
		int num= 0;
		try {
			num = Integer.parseInt(number);
			
		}catch (Exception e) {
			throw new Exception("Number was not an integer");
		}
		//System.out.println("Enter guest name");
		//Scanner in = new Scanner(System.in);
		//Scanner nameScanner = new Scanner(in.nextLine());
		//String name = nameScanner.next();
		//in.close();
		String name = "Hessel";
		System.out.printf("num = %d\n", num);
		
		
		
		if(roomMap.get(num) == null) {
			throw new Exception("Error : room was not found");
		}else {
			if(!(roomMap.get(num).getOccupancy())){
				roomMap.get(num).setOccupancy(true);
				roomMap.get(num).setPerson(name);
			}else {
				throw new Exception("Room is occupied");
			}
			
			
			System.out.printf("person %s checked in in room %d\n", name,num);
			return;
		}
	}


}
