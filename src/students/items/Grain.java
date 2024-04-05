package students.items;

// This class represents a specific type of food: Grain.
public class Grain extends Food{
	private static int generationCount = 0; // Count of the number of Grain objects generated
	
	// This constructor creates a Grain object.
	public Grain() {
		super(2, 6 ,2); // This sets the default maturation age, death age, and monetary value for Grain object.
		generationCount++; //  This increases the count of Grain objects each time a new one is created.
	}
	
	// Method to get the count of Grain objects generated.
	public static int getGenerationCount() {
		return generationCount;
	}
	
	// This method overrides the toString method to create a custom string representation for Grain objects.
	@Override
	public String toString() {
		if(age < maturationAge) {
			return "g"; // Represents immature Grain as lowercase 'g'.
		} else {
			return "G"; // Represents mature Grain as uppercase 'G'.
		}
	}
}
