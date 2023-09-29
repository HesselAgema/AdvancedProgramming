package data;

public class Room {

	private double price;
	private boolean occupancy;
	private String description;
	private String person;
	
	public Room(double price, boolean occupied, String description) {
		this.price = price;
		this.occupancy = occupied;
		this.description = description;
		this.person = null;
		
	}
	
	public double getPrice() {
		return price;
	}
	
	public boolean getOccupancy() {
		return occupancy;
	}
	
	public String getDescription() {
		return description;
	}
	
	public String getPerson() {
		return person;
	}
	public void setPerson(String name) {
		this.person = name;
	}
	
	public void setOccupancy(boolean occupancy) {
		if(occupancy) {
			this.occupancy = true;
		}else {	
			this.occupancy = false;
		}
	}
	
	public void printInfo(int i) {
		if((!this.occupancy)) {
			System.out.printf("Room %d \t price = %s \t %s, \t free\n" , i , this.price, this.description);
		}else {
			System.out.printf("Room %d \t price = %s \t %s, \toccupied \t Mr/Ms %s\n" , i , this.price, this.description, this.person);

		}
	}
	
}
