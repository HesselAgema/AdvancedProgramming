package data;

public class Room {

	private double price;
	private boolean occupied;
	private String description;
	
	public Room(double price, boolean occupied, String description) {
		this.price = price;
		this.occupied = occupied;
		this.description = description;
		
	}
	
	public double getPrice() {
		return price;
	}
	
	public boolean getOccupancy() {
		return occupied;
	}
	
	public String getDescription() {
		return description;
	}
	
	
	
}
