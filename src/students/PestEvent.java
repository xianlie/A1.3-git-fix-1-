package students;

import java.util.Random;

public class PestEvent {
	private static final double Probability = 0.1; // Probability of pest event occurrence.
	
	// Method to check if a pest event occurs.
	public static boolean occurs() {
		Random random = new Random(); // Create a new random object.
		// Generate a random double value between 0 and 1.
		// If the generated value is less than the predefined probability, return true.
		return random.nextDouble() < Probability;
	}

}
