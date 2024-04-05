package students.items;

abstract class Food extends Item {
    public Food(int maturationAge, int deathAge, int monetaryValue) {
        super(maturationAge, deathAge, monetaryValue);
    }
}