package students.items;

class Grain extends Food{
	private static int generationCount = 0;
	
	public Grain() {
		super(2, 6 ,2);
		generationCount++;
	}
	
	public static int getGenerationCount() {
		return generationCount;
	}
	
	@Override
	public String toString() {
		if(age < maturationAge) {
			return "g";
		} else {
			return "G";
		}
	}
}
