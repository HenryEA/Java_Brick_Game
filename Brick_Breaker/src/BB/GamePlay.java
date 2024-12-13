package BB;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JPanel;
import javax.swing.Timer;

//KeyListener and ActionListener classes are to implement keyboard directions and movement of the ball
public class GamePlay extends JPanel implements KeyListener, ActionListener{
	
	//boolean value to tell when the game can be played or not
	private boolean play = false;
	private int score = 0;
	
	private int totalBricks = 21;
	
	private Timer timer;
	private int delay = 8;
	
	//position of the player and the ball 
	private int playerX = 310;
	private int ballposX = 120;
	private int ballposY = 350;
	// the directions below indicate how the ball changes position once tthe player has hit the ball
	//(it being negative means that it is coming up)
	private int ballXdir = -1;
	private int ballYdir = -2;
	
	private MapGenerator map;
	
	//values for GamePlay initialisation
	public GamePlay() {
		//initalise the MapGenerator and set thenumber of rows and columns
		map = new MapGenerator(3, 7);
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black); //background colour is white
		g.fillRect(1, 1, 692, 592); // the background fills this areas
		
		//modify graphics class
		map.draw((Graphics2D)g);
		
		g.setColor(Color.yellow); //border is yellow
		// the position of the borders are below
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);
		
		// object for the player
		g.setColor(Color.blue);
		// I am setting the positionX variable of the player to be dependent on the player's movement
		//(because during the game, the player can only move from left to right (on the x-axis))
		// this way, I can later connect the player movement to the keyboard movements
		g.fillRect(playerX, 550, 100, 8);
		
		//object for the ball
		g.setColor(Color.green);
		//the ball moves in both x and y directions
	
		g.fillOval(ballposX, ballposY, 20, 20);
		
		//to display the player's score
		g.setColor(Color.white);
		g.setFont(new Font("serif", Font.BOLD,  25));
		
		//to update the score
		g.drawString("" + score,590, 30);
		
		//when the user wins the game
		if(totalBricks <= 0) {
			play=false;
			ballXdir = 0;
			ballYdir = 0;
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("You won, Score: " + score, 190, 300);
			
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Press Enter to Restart!", 230, 350);
		}
		
		
		//display game over if the ball goes below the paddle
		if(ballposY > 570) {
			play=false;
			ballXdir = 0;
			ballYdir = 0;
			g.setColor(Color.red);
			g.setFont(new Font("serif", Font.BOLD, 30));
			g.drawString("Game Over, Score: " + score, 190, 300);
			
			g.setFont(new Font("serif", Font.BOLD, 20));
			g.drawString("Press Enter to Restart!", 230, 350);
		}
		//to ensure that once the function is executed, the system will release the resources used for it
		g.dispose();
	}

	//this method tells what happens when the player performs a certain action as will be prescribed by -
	// the keys methods
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		timer.start();
		
		//enable the movement of the ball when it comes in contact(intersects) with the paddle
		// the rectangle on the left represents that of the ball while that on the right represents that
		//of the player's paddle
		if(play) {
			if(new Rectangle(ballposX, ballposY, 20, 30).intersects(new Rectangle(playerX, 550, 100, 8))) {
				ballYdir = -ballYdir;
			}
			
			//ball-brick interaction
			// we have map.map.length because the I am accessing tthe 'map' object and then the 'map' 2D-array.
			for(int i=0; i<map.map.length; i++) {
				for(int j = 0; j<map.map[0].length; j++) {
					//create location for the brick for each location that is greater than 0 
					if(map.map[i][j]>0) {
						int brickX = j*map.brickWidth + 80;
						int brickY = i*map.brickHeight + 80;
						int brickWidth = map.brickWidth;
						int brickHeight = map.brickHeight;
						
						//creating rectangles for the bricks and the ball when the above conditions are achieved
						Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
						Rectangle ballRect = new Rectangle(ballposX, ballposY, 20, 20);
						Rectangle brickRect = rect;
						
						// to make the brick equal to 0 after the ball and the brick has interacted with each other
						//the setBrickValue method was specified in the MapGenerator file
						if(ballRect.intersects(brickRect)) {
							map.setBrickValue(0, i, j);
							totalBricks --;
							score += 5;
							
						if(ballposX +19 <= brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width) {
							ballXdir = -ballXdir;
						} else {
							ballYdir = -ballYdir;
						}
						}
					}
				}
			}
				//movement of the ball
			ballposX += ballXdir;
			ballposY += ballYdir;
			
			//to adjust the ball the correct way when it touches the wall of the frames
			//(that is to prevent it from going out of bounds)
			if(ballposX < 0) {
				ballXdir = -ballXdir;
			}
			if(ballposY < 0) {
				ballYdir = -ballYdir;
			}
			if(ballposX > 670) {
				ballXdir = -ballXdir;
			}
		}
		repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		//checks if the argument in the game is the right key
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			//to ensure that the player does not go out of bounds when moving to the right
			if(playerX >= 600 ) {
				playerX = 600;
			} else {
				moveRight();
			}
		}
		
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			//to ensure that the player does not go out of bounds when moving to the left
			if(playerX <= 10 ) {
				playerX = 10;
			} else {
				moveLeft();
			}
		}
		
		//restart functionality when the enter key is pressed
		if(e.getKeyChar() == KeyEvent.VK_ENTER) {
			if(!play) {
				play = true;
				ballposX = 120;
				ballposY = 350;
				ballXdir = -1;
				ballYdir = -2;
				score = 0;
				totalBricks = 21;
				map= new MapGenerator(3,7);
				
				repaint();
			}
		}
		
	}

		public void moveRight() {
			play = true;
			playerX += 20;
		}
		
		public void moveLeft() {
			play = true;
			playerX -= 20;
		}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
