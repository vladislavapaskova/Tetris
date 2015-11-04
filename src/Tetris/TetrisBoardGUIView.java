package Tetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TetrisBoardGUIView extends JComponent
{
	/*
	 * Instance Fields
	 *
	 */
	//create an instance of the game
	public TetrisGame game; 
	
	/*
	 * Constructor
	 */
	public TetrisBoardGUIView(TetrisGame passedGame)
	{
		//save the passed game
		game=passedGame; 
	}
	
	public void paint(Graphics g){
		System.out.println("paint method");
		paintComponent(g);}
	
	//create a function that is going to paint the tetris pieces
	public void paintComponent(Graphics g)
	{
	//call the boardHasBlock method to check which tiles of the board hold pieces
		//create a for loop to go through the board
				for(int i=0; i<10; i++)
				{
					for(int j=0; j<18; j++)
					{
						//check if it has a block 
						if(game.boardHasBlock(i,j))
						{
							//System.out.println(i + " " + j);
							//System.out.println(getWidth()/10);
						//set the color of the inside of the piece
						g.setColor(Color.YELLOW); 
						//fill the tile
						g.fillRect(i*getWidth()/10, j*getHeight()/18, getWidth()/10, getHeight()/18); 
						//set the color of the border of the box
						g.setColor(Color.BLACK); 
						//draw it
						g.drawRect(i*getWidth()/10, j*getHeight()/18, getWidth()/10, getHeight()/18); 
						}
						else
						{
						//set the color of the inside of the empty tile
						//g.setColor(Color.BLUE); 
						//fill the tile
						//g.fillRect(0,  0, getWidth(), getHeight()); 
						//draw it
						//g.drawRect(0,  0, getWidth(),getHeight()); 
						}
					}

				}
	}
}
