package students;

import java.util.Random;

import students.items.*;

public class Field {
	private static final boolean True = false;
	private Item[][] grid; // This is a 2D array that represents the field grid.
	private int height; // Height of the field.
	private int width; // width of the field.
	private Random random; // a random object used for generating random events.
	
	// A constructor used to initialize a field with soil and set its dimensions.
	public Field(int height, int width){
		this.height = height;
		this.width = width; 
		this.grid = new Item[height][width]; // Initialize the grid
		this.random = new Random(); // Initialize the random object
		
		// Fill the grid and soil objects initially
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				grid[i][j] = new Soil();
			}
		}
	}
		
	public void tick() {
		// Looping through each grid cell
		for (int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				Item item = grid[i][j]; // Get the item at the current position
				item.tick();
				
				// Randomly generate weeds on soil cells
				if (item instanceof Soil && random.nextDouble() < 0.02) {
					grid[i][j] = new Weed(); // Replace the soil with weed
				}
			
				// Replace an item that has already died with untilledSoil
				/*if (item.died()) {
					grid[i][j] = new UntilledSoil();
				}*/
		   }
		}
	}
	
	public void pestAttack() {
		// Loop through each cell in the field.
		for (int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				Item item = grid[i][j]; // Get the item at the current position
				item.tick();
				// Check if a pest event occurs and if the random chance is met
				if (PestEvent.occurs() == True && random.nextDouble() < 0.1) {
					grid[i][j] = new UntilledSoil(); // Replace the item with untilledSoil.
					}
				}
			}
		}
			
			
	// This method involves tilling the soil at a specified position.
	public void till(int x, int y) {
		if (isValidPosition(x,y)) {
			grid[x][y] = new Soil(); // Replace the item at the position with soil
		}
	}
	
	// Method to check if a position is valid within the field grid
	private boolean isValidPosition(int x, int y) {
		return x >= 0 && x < height && y >= 0 && y < width;
	}
	
	// Method to get the item at a specified position
	public Item get(int x, int y) {
		if (isValidPosition(x, y)) {
			return grid[x][y]; // Return the item at the position
		}
		return null;
	}
	
	// Method to plant an item at a specified position
	public void plant(int x, int y, Item item) {
		if (isValidPosition(x,y)) {
			grid[x][y] = item; // Place the item at the specified position
		}
	}
	
	// This method calculate the total value of all items on the field
	public int getValue() {
		int totalValue = 0;
		// Looping through each grid cell and accumulating the value of all items
		for (Item[] row : grid) {
			for (Item item : row) {
				totalValue += item.getValue(); // Add the value of the item
			}
		}
		return totalValue; // Return the total value
	}
	
    // This method generate a summary of the field's contents
	public String getSummary() {
		// Variables to store counts of different type of items
		int apple = 0;
		int grain = 0;
		int soil = 0;
		int untilledSoil = 0;
		int weed = 0;
		
		// Looping through each grid cell and count the number of each item type
		for (Item[] row : grid) {
			for(Item item : row) {
				if (item instanceof Apple) {
					apple++;					
				} else if (item instanceof Grain) {
					grain++;
				} else if (item instanceof Soil) {
					soil++;
				} else if (item instanceof UntilledSoil) {
					untilledSoil++;
				} else if (item instanceof Weed) {
					weed++;
				}
			}
		}
		
		// Build a summary string with item counts and total value
		StringBuilder summary = new StringBuilder();
		summary.append("Apple:        ").append(apple).append("\n");
		summary.append("Grain:        ").append(grain).append("\n");
		summary.append("Soil:         ").append(soil).append("\n");
		summary.append("Untilled:     ").append(untilledSoil).append("\n");
		summary.append("Weed:         ").append(weed).append("\n");
		summary.append("For a total of $").append(getValue()).append("\n");
		summary.append("Total Apple created:     ").append(Apple.getGenerationCount()).append("\n");
		summary.append("Total Grain created:     ").append(Grain.getGenerationCount()).append("\n");
		
		return summary.toString();
	}
	
	//This method generate a string representation of the field
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("  ");
		for (int i = 1; i <= width; i++) {
			
			sb.append(i).append(" ");
		}
		sb.append("\n");
		for (int i=0; i < height ; i++) {
			sb.append(i+1).append(" ");
			for (int j = 0; j < width; j++) {
				sb.append(grid[i][j]).append(" ");
			}
			sb.append("\n");
		}
		return sb.toString(); // Return the string representation of the field
	}
}


