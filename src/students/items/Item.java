package students.items;

import java.util.Objects;

public abstract class Item {
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
    
    public void tick() {
        age++;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public boolean died() {
        return age > deathAge;
    }

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