package students.items;

class Apple extends Food{
	private static int generationCount = 0;
	
	public Apple() {
		super(3, 5, 3);
		generationCount++;
	}
	
	public static int getGenerationCount() {
		return generationCount;
	}
	
	@Override
	public String toString() {
		if (age < maturationAge) {
			return "a";
		} else {
			return "A";
		}
	}
}
