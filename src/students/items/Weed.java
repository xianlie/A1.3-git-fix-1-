package students.items;

class Weed extends Item {
	// This constructor create a Weed object.
	public Weed() {
		super(-1, -1, -1); // Initializes with arbitrary values.
	}
	
	// Override toString method to provide custom string representation for Weed.
	@Override
	public String toString() {
		return "#"; // Represent Weed with the "#" character.
	}

}
