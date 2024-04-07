package students.items;

import java.util.Objects;

public abstract class Item {
	public int age;
    public final int maturationAge;
    public final int deathAge;
    public final int monetaryValue;
    
    // This is a constructor for creating an item with a specified maturation age, death age and monetary value.
    public Item(int maturationAge, int deathAge, int monetaryValue) {
        this.age = 0;
        this.maturationAge = maturationAge;
        this.deathAge = deathAge;
        this.monetaryValue = monetaryValue;
    }
    
    // This method advances the age of the item by one time unit.
    public void tick() {
        age++;
    }
    
    // This is a setter method used to set the age of the item.
    public void setAge(int age) {
        this.age = age;
    }
    
    // This method checks whether the item has died.
    public boolean died() {
        return deathAge > age;
    }
    
    // This method retrieves the monetary value of the item.
    public int getValue() {
        if (age >= maturationAge) {
            return monetaryValue;
        } else {
            return 0;
        }
    }

    // This abstract method needs to be implemented by subclasses to create a custom string representation.
    public abstract String toString();
    
    // This method compares item based on their attributes
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Item item = (Item) obj;
        return age == item.age && maturationAge == item.maturationAge &&
                deathAge == item.deathAge && monetaryValue == item.monetaryValue;
    }        
}





	

