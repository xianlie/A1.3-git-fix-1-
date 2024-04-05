package students.items;

// This class represents food, which is considered an item.
public class Food extends Item {
	// This constructor creates food items with specified maturation age, death age and monetary value.
    public Food(int maturationAge, int deathAge, int monetaryValue) {
        super(maturationAge, deathAge, monetaryValue);
    }
    
    @Override
    public String toString() {
    	return null;
    }
}