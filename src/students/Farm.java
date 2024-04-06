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
	}
	
}
