/**
 * 
 */
package Tetris;

/**
 * @author pasko22v
 *Abstract class for the pieces
 */
public abstract class TetrisPiece 
{
/**
 * Instance Variables
 */
	//create a boolean 3D array that is going to hold all of the rotations of a piece
	protected  boolean[][][] piece;
	
	//create a var that is going to keep track of the current rotation
	protected  int currentRotation=0; 
	
	/**
	 * Constructor requires the name of the piece
	 */
	public TetrisPiece()
	{
		 //call the rotations
		//pieceRotateClockwise(); 
		//pieceRotateCounterClockwise(); 
	}
	
	//rotate clockwise
	public boolean[][] pieceRotateClockwise()
	{
		//update the rotation
		currentRotation=currentRotation+1; 
		//use modulus
		currentRotation=currentRotation%4; 
		
		//call a setter
		setCurrentRotation(currentRotation); 
		
		//return the rotated piece
		System.out.print(currentRotation);
		return piece[currentRotation]; 
	}
	
	//rotate counterclockwise
	public boolean[][] pieceRotateCounterClockwise()
	{
		//update the rotation
		currentRotation=currentRotation-1; 
		//use modulus
		currentRotation=currentRotation%4; 
		
		//call a setter
		setCurrentRotation(currentRotation); 
		
		//return the rotated piece
		return piece[currentRotation]; 
	}

	//create a getter that turns the rotation
	public int getCurrentRotation() {
		return currentRotation;
	}
	//create a setter thet sets the rotation
	public void setCurrentRotation(int currentRotation) {
		currentRotation = currentRotation;
	}
	//create a method that returns the piece
	public boolean[][] getPiece(int rotation)
	{
		//return the piece
		return piece[rotation];
	}
	
	//Checks to see if the given coordinates and rotation contain a tile.
	public boolean isPiece(int x, int y, int rotation) 
	{
		System.out.print(rotation);
		return piece[rotation][x][y];
	}
	
	//find left ending
	public int getLeftEnd(int rotation) 
	{
		//loop from left to right
		for(int x = 0; x <4; x++) 
		{
			for(int y = 0; y <4; y++) 
			{
				//check if the varue is true
				if(isPiece(x, y, rotation)) 
				{
					return x;
				}
			}
		}
		return -1;
	}
	
	//find right ending
	public int getRightEnd(int rotation) 
	{
		//loop from right to left
		for(int x = 3; x >= 0; x--) 
		{
			for(int y = 0; y < 4; y++) 
			{
				//check if the varue is true
				if(isPiece(x, y, rotation)) 
				{
					return x;
				}
			}
		}
		return -1;
	}
	
	//find top
	public int getTopEnd(int rotation) 
	{
		//loop from top to bottom
		for(int y = 0; y < 4; y++) 
		{
			for(int x = 0; x < 4; x++) 
			{
				//check if the value is true
				if(isPiece(x, y, rotation)) 
				{
					return y;
				}
			}
		}
		return -1;
	}
	
	//find bottom
	public int getBottomEnd(int rotation)
	{
		//loop from bottom to top
		for(int y = 3; y >= 0; y--) 
		{
			for(int x = 0; x < 4; x++) 
			{
				//check if the value is true
				if(isPiece(x, y, rotation)) 
				{
					//return 4 - y;
					return y;
				}
			}
		}
		return -1;
	}

}
