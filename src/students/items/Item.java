package students.items;

public class Item {
	protected int age;
    protected int maturationAge;
    protected int deathAge;
    protected int monetaryValue;
    
    public Item(int maturationAge, int deathAge, int monetaryValue) {
        this.age = 0;
        this.maturationAge = maturationAge;
        this.deathAge = deathAge;
        this.monetaryValue = monetaryValue;
    }

	
}
