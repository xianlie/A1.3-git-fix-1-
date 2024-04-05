package students.items;

//This class represents a specific type of food: Apple.
public class Apple extends Food{
	private static int generationCount = 0; // Count of the number of Apple objects generated
	
	// This constructor creates a Apple object.
	public Apple() {
		super(3, 5, 3); // This sets the default maturation age, death age, and monetary value for Apple object.
		generationCount++; //  This increases the count of Apple objects each time a new one is created.
	}
	
	// Method to get the count of Apple objects generated.
	public static int getGenerationCount() {
		return generationCount;
	}
	
	// This method overrides the toString method to create a custom string representation for Apple objects.
	@Override
	public String toString() {
		if (age < maturationAge) {
			return "a"; // Represents immature Apple as lowercase 'a'.
		} else {
			return "A"; // Represents mature Apple as uppercase 'A'.
		}
	}
}	
