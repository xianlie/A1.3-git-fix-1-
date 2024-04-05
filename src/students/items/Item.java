package students.items;

import java.util.Objects;

public abstract class Item {
	protected int age;
    protected int maturationAge;
    protected int deathAge;
    protected int monetaryValue;
    
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
        return age > deathAge;
    }
    
    // This method retrieves the monetary value of the item.
    public int getValue() {
        if (age >= maturationAge) {
            return monetaryValue;
        } else {
            return 0;
        }
    }

    public abstract String toString();
    
    
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Item item = (Item) obj;
        return age == item.age && maturationAge == item.maturationAge &&
                deathAge == item.deathAge && monetaryValue == item.monetaryValue;
    }        
}

abstract class Food extends Item {
    public Food(int maturationAge, int deathAge, int monetaryValue) {
        super(maturationAge, deathAge, monetaryValue);
    }
}

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

