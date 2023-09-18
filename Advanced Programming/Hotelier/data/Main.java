package data;

public class Main {

	public static void main(String[] args) {

		Map<Integer, Room> roomMap = new MapImplementation<>();
		Room room1 = new Room(50.00, false, "Nice Room!");
		roomMap.add(101, room1);
		
		
		Room room2 = new Room(40.00, false, "Fine Room");
		roomMap.add(102, room2);
		
		Room room3 = new Room(30.00, false, "Okay Room");
		roomMap.add(103, room3);
		
		Room room4 = new Room(20.00, false, "Okay Room");
		roomMap.add(104, room4);
		
		
		
	}

}
