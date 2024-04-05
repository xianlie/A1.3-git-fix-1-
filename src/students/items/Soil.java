package students.items;

class Soil extends Item{
	// This constructor create a Soil object.
	public Soil() {
		super(-1, -1, 0); // Initializes with arbitrary values。
	}
	
	// Override toString method to provide custom string representation for soil.
	@Override
	public String toString() {
		return "."; // Represent Soil with the "." character.
	}

}
