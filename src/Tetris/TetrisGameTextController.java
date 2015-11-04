package Tetris;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class TetrisGameTextController 
{
	/**
	 * InstanceFields
	 **/
	//create an instance field of the game
	TetrisGame game;
	//create an instance field of the view
	TetrisGameTextView view; 
	//create an instance field of the tetris piece
	TetrisPiece tetrisPiece; 
	

	/*
	 * Constructor for a new tetris game for the command line.
	 */
	public TetrisGameTextController()
	{
		// create a tetris game
		game= new TetrisGame(); 
		// create its view
		view= new TetrisGameTextView(game); 
		// show the initial game
		// start play
		this.readInput(); 
		//System.out.println("hello");
		this.refreshDisplay(); 
	}
	
	/**
	 * Get input from the user, looping until the user types "Quit".
	 **/
	private void readInput()
	{
		// wrap input stream read input from user
		// you do not need to understand what is going on here
		// for now, just take it as is
		BufferedReader in = 
		new BufferedReader( new InputStreamReader( System.in ) );
  
		// I/O almost always requires a try/catch
		// block as exceptions may be thrown 
		try 
		{
			String line;
 
			// loop until the user types "Quit"
			do {
				// prompt the user for input
				System.out.println( "Please enter a move (l,r,d,z,x) or type Quit to end." ); 

				// try to read a line
				// this function potentially throws an IOException
				line = in.readLine(); 
 
				// enter the move
				moveEntered( line );
				
				// refresh the view
				refreshDisplay();
			} while ( (!line.equals( "Quit" ) ) );
		}
		// catch I/O exception
		catch ( IOException ioe )
		{
			// tell exception to print its error log
			ioe.printStackTrace();
		}
	}
	
	/**
	 *  Print text view of the game.
	 */
	private void refreshDisplay()
	{
	//System.out.println("hello");
	//view.getView(); 
	System.out.println(view.getCompleteView());	
		
	}

	/**
	 * r: right
	 * l: left
	 * d: down
	 * z: cw
	 * x: ccw
	 * @param move
	 */
	private void moveEntered( String move )
	{
		if(move.equals("r"))
		{
			game.moveRight(); 
		}
		else if (move.equals("l"))
		{
			game.moveLeft(); 
		}
		else if (move.equals("d"))
		{
			game.moveDown(); 
		}
		else if (move.equals("z"))
		{
			game.rotateClockwise(); 
		}
		else if (move.equals("x"))
		{
			game.counterClockwise(); 
		}
	
	

	}

	public static void main(String[] args) 
	{
		//make a new controller instance
		new TetrisGameTextController(); 
		
	}


}
