package students;

import java.util.Scanner;

import students.items.*;

public class Farm {
	private Field field;
	private int bankBalance;
	
	public Farm(int fieldWidth, int fieldHeight, int startingFunds)
	{
		this.field = new Field(fieldWidth, fieldHeight);
		this.bankBalance = startingFunds;
	}
	
	public void run()
	{
		System.out.println(field);
		
		System.out.println("Bank balance :" + bankBalance + "\n");
		System.out.println("Enter your next action:");
		System.out.println(" t x y: till");
		System.out.println(" h x y: harvest");
		System.out.println(" p x y: plant");
		System.out.println(" s: field summary");
		System.out.println(" w: wait");
		System.out.println(" q: quit");
	}
	
}
