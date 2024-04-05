package students.items;

class UntilledSoil extends Item {
	// This constructor create an UntilledSoil object.
	public UntilledSoil() {
		super(-1, -1, -1); // Initializes with arbitrary values。
	}
	
	// Override toString method to provide custom string representation for UntilledSoil.
	@Override
	public String toString() {
		return "/"; // Represent UntilledSoil with the "/" character.
	}


}
