package students;

import java.util.Scanner;

import students.items.*;

public class Farm {
	private Field field; // Represents the field where farming activities occur.
	private int bankBalance; // Represents the available funds for the farm.

	// Constructor to initialize the farm with a field of specified dimensions and starting funds.
	public Farm(int fieldWidth, int fieldHeight, int startingFunds)
	{
		this.field = new Field(fieldHeight, fieldWidth);
		this.bankBalance = startingFunds;
	}
	
	// This method run the main loop of the farm simulation.
	public void run()
	{
		Scanner scanner = new Scanner(System.in);
		String action; // To store use action.
		
		System.out.println(field); // Display initial state of the field.
		
		do {
			 // Check for pest event
            if (PestEvent.occurs()) {
                System.out.println("Pest attack occurred! ");
                System.out.println("Untilled soil occurred randomly \n");
                field.pestAttack();
            }
			// Display options and prompt use for action.
			System.out.println("Bank balance : $" + bankBalance + "\n");
			System.out.println("Enter your next action:");
			System.out.println(" t x y: till");
			System.out.println(" h x y: harvest");
			System.out.println(" p x y: plant");
			System.out.println(" s: field summary");
			System.out.println(" w: wait");
			System.out.println(" q: quit");
			
		    // Read use action.
			action = scanner.nextLine().trim();
				
		    // Process use action based on the entered command.
			switch (action.charAt(0)) {
				case 't':
					handleTillAction(action); // Till action
					break;
				case 'h':
					handleHarvestAction(action); // Harvest action
					break;
				case 'p':
					handlePlantAction(action); // Plant action
					break;
				case 's':
					System.out.println(field.getSummary()); // Display field summary
					break;
				case 'w':
					field.tick();
					break;
				case 'q':
					System.out.println("Quitting the game... ");
					break;
				default:
					System.out.println("Invalid action, please try again."); // Invalid action				
			}
			System.out.println(field); // Display updated state of the field.
		} while (!action.equals("q")); // Continue until user quits.
		
		scanner.close(); // Close the scanner after use.
	}
	
	// This method handles the till action.
	private void handleTillAction(String action) {
			String[] parts = action.split(" ");
			if (parts.length == 3) {
				try {
					int x = Integer.parseInt(parts[1]) - 1;
					int y = Integer.parseInt(parts[2]) - 1;
					field.till(y,x); // Perform till action.
					field.tick(); // Apply the tick function.
				} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
					System.out.println("Invalid location, please try again.");
				}
			}
		}
	
	// This method handles the harvest action.
	private void handleHarvestAction(String action) {
		String[] parts = action.split(" ");
		if (parts.length == 3) {
			try {
				int x = Integer.parseInt(parts[1]) - 1;
				int y = Integer.parseInt(parts[2]) - 1;
				Item item = field.get(y,x);
				if (item instanceof Food && item.age >= ((Food) item).maturationAge) {
					System.out.println("Sold " + item + " for " + item.getValue() +"\n");
					bankBalance += item.getValue();
					field.plant(y, x, new Soil()); // Plant the selected item.
					field.tick(); // Apply the tick function.
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

	// This method handles the plant action.
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
						System.out.println("Insufficient funds to buy an apple. \n");
						return;
					}
				} else if (choice.equals("g")) {
					if (bankBalance >= 1) {
						item = new Grain();
						bankBalance -= 1;						
					} else {
						System.out.println("Insufficient funds to buy grain. \n");
						return;
					}
				} else {
					System.out.println("Invalid choice, please try again. \n");
					return;
				}
				field.plant(y,x,item); // Plant the selected item.
				field.tick(); // Apply the tick function.
			} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
				System.out.println("Invalid location, please try again.");
			}
		} else {
			System.out.println("Invalid action, please try again.");
		} 
	}
	
}