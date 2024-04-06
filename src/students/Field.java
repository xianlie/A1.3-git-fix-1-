package students;

import java.util.Random;

import students.items.*;

public class Field {
	private Item[][] grid;
	private int height;
	private int width;
	private Random random;
	
	
	public Field(int height, int width){
		this.height = height;
		this.width = width; 
		this.grid = new Item[height][width];
		this.random = new Random();
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				grid[i][j] = new Soil();
			}
		}
	}
		
	public void tick() {
		for (int i = 0; i < height; i++) {
			for(int j = 0; j < width; j++) {
				Item item = grid[i][j];
				item.tick();
			
			if (item instanceof Soil && random.nextDouble() < 0.2) {
				grid[i][j] = new Weed();
			}
			
			if (item.died()) {
				grid[i][j] = new UntilledSoil();
			}
		  }
		}
	}
	
	public void till(int x, int y) {
		if (isValidPosition(x,y)) {
			grid[x][y] = new Soil();
		}
	}
	
	private boolean isValidPosition(int x, int y) {
		return x >= 0 && x < height && y >= 0 && y < width;
	}
	
	public Item get(int x, int y) {
		if (isValidPosition(x, y)) {
			return grid[x][y];
		}
		return null;
	}
	
	public void plant(int x, int y, Item item) {
		if (isValidPosition(x,y)) {
			grid[x][y] = item;
		}
	}
	
	public int getValue() {
		int totalValue = 0;
		for (item[] row : grid) {
			for (Item item : row) {
				totalValue += item.getValue();
			}
		}
		return totalValue;
	}
	
}


