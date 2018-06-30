package BrackoutGame;
/*
 * File: Brackout.java
 * this game is invented by steave wozniac before founding apple with steave jobs
 */
import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.awt.*;
import java.awt.event.*;
public class Brackout extends GraphicsProgram {
	/** width and height of application window in pixels*/
	public static final int APPLICATION_WIDTH = 400;
	public static final int APPLICATION_HEIGHT = 600;
	/** Diamension of game bords (usually same as application game widt and Height*/
	private static final int WIDTH = APPLICATION_WIDTH;
	private static final int HEIGHT = APPLICATION_HEIGHT;
	/** Diamension for paddle */
	private static final int PADDLE_WIDTH = 60;
	private static final int PADDLE_HEIGHT = 10;
	
    /** Offset of paddle from bottom */
	private static final int PADDLE_Y_OFFSET = 30;
	/** Number of brick per row*/
	 private static final int NBRICK_PER_ROW = 10;
	 
	 /** Number of rows of brick*/
	 private static final int NBRICK_ROW = 10;
	 
	 /** Seperation between brick*/
	 private static final int BRICK_SEP = 4;
	 
	 /** Width of brick*/
	 private static final int BRICK_WIDTH = 
			 (WIDTH - (NBRICK_PER_ROW -1)* BRICK_SEP)/NBRICK_PER_ROW;
	 /** Height of brick*/
	 private static final int BRICK_HEIGHT = 8;
	 /** Radius of the ball */
	 private static final int BALL_RADIUS = 10;
	 /** Brick Y offset from the top of canvas*/ 
	 private static final int BRICK_Y_OFFSET = 70;
	 
	 /** Number of turns*/ 
	 private static final int NTURNS = 70;
	private GOval ball;		 

   public void init() {
	   setSize(400, 600);
      // setting of brick wall  	   
	  for (int i =0; i< NBRICK_ROW; i++) {
		  for (int j = 0; j<NBRICK_PER_ROW; j++) {
			 
			  double x =
					  BRICK_WIDTH * j + BRICK_SEP*j;
			  double y = BRICK_HEIGHT*i  + BRICK_Y_OFFSET + BRICK_SEP*i;
			 GRect brick = new GRect(x,y,BRICK_WIDTH, BRICK_HEIGHT);
			   x = BRICK_SEP;
			 if(i == 0 || i ==1) {
				  brick.setFilled(true);
				  brick.setFillColor(Color.RED);  // sets red color top wall
				  
			  } else if(i == 2 || i == 3 ) {
				  brick.setFilled(true);
				  brick.setFillColor(Color.ORANGE); // sets orange color
			  } else if(i == 4 || i == 5 ) {
				  brick.setFilled(true);
				  brick.setFillColor(Color.YELLOW); // sets yellow color
		  }   else if(i == 6 || i == 7 ) {
			  brick.setFilled(true);
			  brick.setFillColor(Color.GREEN);  // sets green color
	  }    else if(i == 8 || i == 9 ) {
		  brick.setFilled(true);
		  brick.setFillColor(Color.CYAN);    // sets cyan color
  }  
		   add(brick);
			 
		  }
		  
		 
		 
	  }
	   
	   // create paddle 
	  GRect paddle = new GRect((WIDTH -PADDLE_WIDTH)/2, HEIGHT -PADDLE_Y_OFFSET, PADDLE_WIDTH, PADDLE_HEIGHT );
	  paddle.setFilled(true);
	  add(paddle);
	 // create ball filled with black color
	  GOval ball = new GOval((WIDTH-BALL_RADIUS)/2,(HEIGHT-BALL_RADIUS)/2,2*BALL_RADIUS, 2*BALL_RADIUS);
	  ball.setFilled(true);
	  add(ball);
   }
   
   public void run() {
        moveball();
	    addMouseListeners(); 
	  
   }
   
 
  
   

  private void moveball() {
	  ball.move(Vx, Vy);
	
}

/* Mouse pressed event sense objects prasence*/
   public void mousePressed(MouseEvent e) {
		  lastX = e.getX();
		  lastY = HEIGHT -PADDLE_Y_OFFSET;
		  gobj = getElementAt(lastX, lastY);
		  
	  }
	  
	  public void mouseDragged(MouseEvent e) {
		  /* this if condition for not exceeds the application window*/
		  if((gobj != null )  && (PADDLE_WIDTH/2 < e.getX() && e.getX() < WIDTH -PADDLE_WIDTH/2)) {
			 
				  gobj.move(e.getX() - lastX, 0);
				  lastX = e.getX();
			 
			
		  }
   
   }
   
   // instance variable used for mouse event driven program
   private double lastX;
   private double lastY;
   private GObject gobj;
   private double Vx =3, Vy = 3;
   private RandomGenerator rgen = new RandomGenerator();
}


