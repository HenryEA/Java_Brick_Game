package BB;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

public class MapGenerator {
	
	public int map [][];
	public int brickWidth;
	public int brickHeight;
	
	//the code that creates a 2D array
	// this 2D array will be used to create the bricks
	public MapGenerator(int row, int col) {
		map = new int [row][col];
		for (int i = 0; i<map.length; i++) {
			for (int j = 0; j<map[0].length; j++) {
				map[i][j] = 1;
				
			}
		}
		
		brickWidth = 540/col;
		brickHeight = 150/row;
	}
		
	//graphics for the bricks
	public void draw(Graphics2D g) {
		//setting the color for each position on the map
		for (int i = 0; i<map.length; i++) {
			for (int j = 0; j<map[0].length; j++) {
				if(map[i][j] > 0) {
					g.setColor(Color.white);
					//the location of the brick
					g.fillRect(j*brickWidth + 80, i*brickHeight + 50, brickWidth, brickHeight);
					
					//dividing the bricks with strokes, giving it color and drawing the lines
					g.setStroke(new BasicStroke(3));
					g.setColor(Color.black);
					g.drawRect(j*brickWidth + 80, i*brickHeight + 50, brickWidth, brickHeight);
				}
			}
		}
	}
			//method to make bricks disapear when they are being hit
			public void setBrickValue( int value, int row, int col) {
					map[row][col] = value;
			}
}
