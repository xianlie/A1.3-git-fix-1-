package students;

import java.util.Scanner;

import students.items.*;

public class Farm {
	private Field field;
	private int bankBalance;
	
	public Farm(int fieldWidth, int fieldHeight, int startingFunds)
	{
		this.field = new Field(fieldHeight, fieldWidth);
		this.bankBalance = startingFunds;
	}
	
	public void run()
	{
		Scanner scanner = new Scanner(System.in);
		String action;
		
		System.out.println(field);
		
		do {
			System.out.println("Bank balance :" + bankBalance + "\n");
			System.out.println("Enter your next action:");
			System.out.println(" t x y: till");
			System.out.println(" h x y: harvest");
			System.out.println(" p x y: plant");
			System.out.println(" s: field summary");
			System.out.println(" w: wait");
			System.out.println(" q: quit");
			
		
			action = scanner.nextLine().trim();
				
			switch (action.charAt(0)) {
				case 't':
					handleTillAction(action);
					break;
				case 'h':
					handleHarvestAction(action);
					break;
				case 'p':
					handlePlantAction(action);
					break;
				case 's':
					System.out.println(field.getSummary());
					break;
				case 'w':
					field.tick();
					break;
				case 'q':
					System.out.println("Quitting the game... ");
					break;
				default:
					System.out.println("Invalid action, please try again.");				
			}
			System.out.println(field);
		} while (!action.equals("q"));
		
		scanner.close();
	}
	private void handleTillAction(String action) {
			String[] parts = action.split(" ");
			if (parts.length == 3) {
				try {
					int x = Integer.parseInt(parts[1]) - 1;
					int y = Integer.parseInt(parts[2]) - 1;
					field.till(y,x);
				} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
					System.out.println("Invalid location, please try again.");
				}
			}
		}
	
	private void handleHarvestAction(String action) {
		String[] parts = action.split(" ");
		if (parts.length == 3) {
			try {
				int x = Integer.parseInt(parts[1]) - 1;
				int y = Integer.parseInt(parts[2]) - 1;
				Item item = field.get(y,x);
				if (item instanceof Food && item.age >= ((Food) item).maturationAge) {
					bankBalance += item.getValue();
					field.plant(y, x, new Soil());
				} else {
					System.out.println("Nothing to harvest at this location or not yet mature. \n");
				} 
			} catch (NumberFormatException | ArrayIndexOutOfBoundsException e ) {
				System.out.println("Invalid location, please try again.");
			}						
		} else {
			System.out.println("Invalid action, please try again.");
		}
	}

	
	private void handlePlantAction(String action) {
		String[] parts = action.split(" ");
		if (parts.length == 3) {
			try {
				int x = Integer.parseInt(parts[1]) - 1;
				int y = Integer.parseInt(parts[2]) - 1;
				
				Scanner scanner = new Scanner(System.in);
				System.out.println("Enter: \n - 'a' to buy an apple for $\n - 'g' to buy grain for ");
				String choice = scanner.nextLine().trim();
				
				Item item;
				if (choice.equals("a")) {
					if (bankBalance >= 2) {
						item = new Apple();
						bankBalance -= 2;
					} else {
						System.out.println("Insufficient funds to buy an apple.");
						return;
					}
				} else if (choice.equals("g")) {
					if (bankBalance >= 1) {
						item = new Grain();
						bankBalance -= 1;						
					} else {
						System.out.println("Insufficient funds to buy grain.");
						return;
					}
				} else {
					System.out.println("Invalid choice, please try again.");
					return;
				}
				
				field.plant(y,x,item);			
			} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
				System.out.println("Invalid location, please try again.");
			}
		} else {
			System.out.println("Invalid action, please try again.");
		}
	}
}