package students;

import java.util.Random;

import students.items.*;

public class Field {
	private Item[][] grid;
	private int height;
	private int width;
	
	
	public Field(int height, int width){
		this.height = height;
		this.width = width; 
		this.grid = new Item[height][width];
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				grid[i][j] = new Soil();
			}
		}
	}
	
}
