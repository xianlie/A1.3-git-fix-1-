package students;

import java.util.Random;

public class PestEvent {
	private static final double Probability = 0.1;
	
	public static boolean occurs() {
		Random random = new Random();
		return random.nextDouble() < Probability;
	}

}
