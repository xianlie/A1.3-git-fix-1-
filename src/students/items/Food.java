package students.items;

// This abstract class represents food, which is considered an item.
abstract class Food extends Item {
	// This constructor creates food items with specified maturation age, death age and monetary value.
    public Food(int maturationAge, int deathAge, int monetaryValue) {
        super(maturationAge, deathAge, monetaryValue);
    }
}