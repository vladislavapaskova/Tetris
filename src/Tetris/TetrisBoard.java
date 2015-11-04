/**
 * 
 */
package Tetris;

/**
 * @author pasko22v
 *The board is going to be responsible to represent the grid and hte pieces on top of it
 */
public class TetrisBoard
{
	
/**
 * Instance Properties
 */
	//the pieces that are going to make up the board
	public static TetrisPiece tetrisPiece; 
	
	//create a variable for the board height
	public static final int boardHeight=18; 
	
	//create a variable for the board width
	public static final int boardWidth=10;
	
	//create a boolean 2D array for the board
	public boolean[][] board; 
	
	
/**
 * Constructor
 */
	public TetrisBoard()
	{
		
		//call the create board function to create the board
		createBoard(); 
		
		//call the update board function
		//updateBoard(); 
	}
	
	//create a method that is going to create the 2D boolean array
	public boolean[][] createBoard()
	{	
		//create a new instance of the boolean array for the board
		board = new boolean[boardWidth][boardHeight]; 
		//create two for loop that is going to put all false values into the two dimenstional array
				for( int i=0; i < boardWidth; i++)
				{
					for( int j=0; j < boardHeight; j++)
					{
						//put a false value inside each of the array boxes
						board[i][j]= false; 
					}
				}
		//return the board
		return board; 
	}
	
	public static TetrisPiece choosePiece()
	{
				//generate a random number between 0-6
				double randomNumber= Math.random()*6; 
				//generate an integer between 0-6
				int pieceNumber = (int) Math.floor(randomNumber); 
				// create a switch statement that is going to generate the random piece
				switch(pieceNumber)
				{
				case 0:
				{
					//create a new instance of the piece
					tetrisPiece = new IPiece(); 
					break; 
				}
				case 1:
				{
					//create a new instance of the piece
					tetrisPiece = new JPiece(); 
					break; 
				}
				case 2:
				{
					//create a new instance of the piece
					tetrisPiece = new LPiece(); 
					break; 
				}
				case 3:
				{
					//create a new instance of the piece
					tetrisPiece = new OPiece(); 
					break; 
				}
				case 4:
				{
					//create a new instance of the piece
					tetrisPiece = new SPiece(); 
					break; 
				}
				case 5:
				{
					//create a new instance of the piece
					tetrisPiece = new TPiece(); 
					break; 
				}
				case 6:
				{
					//create a new instance of the piece
					tetrisPiece = new ZPiece(); 
					break; 
				}
				default:
				{
					//create a new instance of the piece
					tetrisPiece = new IPiece(); 
					break; 
				}
				
				}
				//return the piece
				return tetrisPiece; 

	}
	
	//create a method that adds a piece
	public void addPiece(TetrisPiece piece, int x, int y, int rotation)
	{
		//get the two d array of the current piece
		boolean[][] positionPiece = piece.getPiece(rotation);
		
		//create a for loop to make the piece
		for(int i=0; i<4; i++ )
		{
			for(int j=0; j<4; j++ )
			{
				if(piece.isPiece(i, j, rotation))
					board[x+i][y+j]= positionPiece[i][j];
			}
		}
		
	}
	//check if a space is occupied
	public boolean isOccupied(int x, int y)
	{
		//System.out.println(x);
		//System.out.println(y);
		return board[x][y];
	}
	
	//check if a piece clashes with any other pieces
	public boolean checkOtherPiece(TetrisPiece piece, int x, int y, int rotation )
	{
		//Loop through every tile in the piece and see if it conflicts with an existing tile.
		for(int col = 0; col < 4; col++) 
		{
			for(int row = 0; row < 4; row++) 
			{
				//System.out.println(piece.isPiece(col, row, rotation)); 
				//System.out.println(y+row);
				if(piece.isPiece(col, row, rotation) && isOccupied(x + col, y + row)) 
				{
					return false;
				}
			}
		}
		return true;
	}
	
	//make a function that check for the piece not to move beyond the borders of the board
	public boolean checkSideBorders(TetrisPiece piece, int x, int y, int rotation)
	{
		//Ensure the piece is in a valid column and row. 
		if(x < -piece.getLeftEnd(rotation) || x + piece.getRightEnd(rotation) >= boardWidth || y < -piece.getTopEnd(rotation) || y + piece.getBottomEnd(rotation) >= boardHeight)
					return false;
		return true; 
	}
	
	
	//check to see if any lines have been cleared
	public int checkLines() 
	{
		//create a variable to store the completed lines
		int compLines = 0;
		
		//check from the 0 position on the board till down if there is a line where all of the values are true
		for(int i = 0; i < boardHeight; i++)
		{
			//if all of the values on the line are true
			if(checkL(i)) 
			{
				//update the value of the completed lines
				compLines++;
			}
		}
		//return the number of completed lines
		return compLines;
	}
			
	//make a function that is going to check if there are any full lines
	private boolean checkL(int row) 
	{
		//create a variable to store the boolean argument if there is a line 
		boolean seeLine= false; 
		//check if the rows are empty
		for(int i = 0; i < boardWidth; i++) 
		{
			//check if it is occupied
			if(isOccupied(i,row)==false) 
			{
				seeLine=true; 
				//return false
				//return false;
			}
		}
		if(seeLine==false)
		{
			//remove line and shift the above lines one step down 
			for(int j = row - 1; j >= 0; j--) 
			{
				for(int k = 0; k < boardWidth; k++) 
				{
					//reset the pieces value
					setBoard(k, j + 1, getBoard(k, j));
				}
			}
		}
		return !seeLine;
	}

	//sets the board
	private void setBoard(int  x, int y, boolean boardNew) 
	{
		//set the board
		board[x][y] = boardNew;
	}
		
	//gets the current board
	private boolean getBoard(int x, int y) 
	{
		//return the new board
		return board[x][y];
	}
	
}
