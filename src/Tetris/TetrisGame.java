/**
 * 
 */
package Tetris;

/**
 * @author pasko22v
 *Manipulates the Game
 */
public class TetrisGame 
{
/**
 * Instance Fields
 */
	//make an instance of the board
	TetrisBoard board; 
	
	//make a variable that keeps track of the score
	public int score; 
	public int tetrises; 
	
	//create a variable for the current piece
	public TetrisPiece currentPiece; 
	
	//create a variable that is going to represent the next piece
	public TetrisPiece nextPiece; 
	
	//define current positions
	private int currCol; 
	private int currRow;
	
	//define current rotation
	private int currRotation; 

	
	
public TetrisGame()
{
	
	//call to update the game
	startGame(); 
}

private void startGame()
{
	//initialize the pieces position and rotation
	currCol=3; 
	currRow=0; 
	currRotation=0; 
	
	//take a random piece
	//reset values
	currentPiece = TetrisBoard.choosePiece();
	//add a new instance of the board
	board = new TetrisBoard(); 
	
	//call update game 
	updateGame(); 
	
}
//create a function that checks if the board has a block
public boolean boardHasBlock(int x,int y)
{
	//create an if statement to check if a current position is occupied in the board
	if(board.isOccupied(x,y))
	{
		return true; 
	}
	//it is not going to be a landed piece
	else
	{
		//make a boolean array for the piece
		boolean[][] thisPiece = currentPiece.getPiece(currRotation);
		
		for (int i=0; i<4; i++)
		{
			for(int j=0; j<4; j++)
			{
				//check if the values of x and y correspond to the piece
				if(i+currCol==x && j+currRow==y)
				return thisPiece[i][j]; 
			}
		}
	}
	//otherwise 
	return false; 
}
//rotates the piece and check if after rotation they will go out of boundaries
private void rotatePiece(int newRotation) 
{
	//create variables for the imaginary new column and row
	int newCol = currCol;
	int newRow = currRow;
	
	//get the piece endings inside each of the rotations
	int left = currentPiece.getLeftEnd(newRotation);
	int right = currentPiece.getRightEnd(newRotation);
	int top = currentPiece.getTopEnd(newRotation);
	int bottom = currentPiece.getBottomEnd(newRotation);
	
	//if the piece is away from the sides of the board move it from the edges of the array
	if(currCol < -left) 
	{
		//update the value for the new column
		newCol = newCol - currCol + left;
	}
	else if(currCol +right >= TetrisBoard.boardHeight) 
	{
		//update hte value for the new column
		newCol -= (currCol + right) - TetrisBoard.boardHeight + 1;
	}
	
	//if the piece is away from the sides of the board move it from the edges of the array
	if(currRow < -top) 
	{
		//update the value for the new row
		newRow = newRow - currRow + top;
	} 
	else if(currRow + bottom >= TetrisBoard.boardWidth) 
	{
		//update the value for the new row
		newRow -= (currRow +  bottom) - TetrisBoard.boardWidth + 1;
	}
	
	//check if the position of the piece can exist
	if(board.checkSideBorders(currentPiece, newCol, newRow, newRotation) && board.checkOtherPiece(currentPiece, newCol, newRow, newRotation)) 
	{
		//update the values for rotation row and col 
		currRotation = newRotation;
		currRow = newRow;
		currCol = newCol;
	}
}

private void updateGame() 
{
	//check to see if piece can move down
	//System.out.println(currentPiece==null);
	//System.out.println(currCol);
	if(board.checkSideBorders(currentPiece, currCol, currRow + 1,currRotation) && board.checkOtherPiece(currentPiece, currCol, currRow + 1, currRotation))
	{
		//wait for next move
		
	} 
	else 
	{
		//we need to land the piece
		//add a new piece
		//System.out.println(currCol);
		//System.out.println(currRow);
		board.addPiece(currentPiece, currCol, currRow, currRotation);
		
		//check if any lines were cleared
		//update the score
		int clearedLines = board.checkLines();
		//System.out.println(cleared);
		//check the value of cleared to assign score and tetrises
		if(clearedLines > 3) 
		{
			keepTetrises(); 
		}
		
		if(clearedLines > 0) 
		{
			keepScore();
		}
		
		updateValues();
	}		
}

//create getter for the score
public int getScore() {
	return score;
}
//create a setter for the score
public void setScore(int score) {
	this.score = score;
}
//create a getter for the terises
public int getTetrises() {
	return tetrises;
}
//create a setter for the tetrises
public void setTetrises(int tetrises) {
	this.tetrises = tetrises;
}

//make a method to keep track of the score
public void keepScore()
{
	//get score
	score=getScore(); 
	//update score
	score+=1; 
	//set score
	setScore(score); 
}
//make a method to keep track of the tetrses
public void keepTetrises()
{
	//get tetrises
	tetrises=getTetrises(); 
	//update terises
	tetrises +=1;
	//set tetrises
	setTetrises(tetrises); 
}

//updates values and checks if game is over
private void updateValues() 
{
	//reset values
	currentPiece = TetrisBoard.choosePiece();
	currRotation = 0;
	currCol=3;
	currRow=0;
	
	//check if the board is filled up with pieces
	if(!board.checkSideBorders(currentPiece, currCol, currRow, currRotation) && !board.checkOtherPiece(currentPiece, currCol, currRow, currRotation)) 
	{
		System.out.println("The Game is Over"); 
	}		
}
//create a method to move the piece to the left
public void moveLeft()
{
	//check if there is space for the piece to be moved
	if(board.checkSideBorders(currentPiece, currCol - 1, currRow, currRotation) && board.checkOtherPiece(currentPiece, currCol - 1, currRow, currRotation))
	{
		//move it
		currCol--; 
	}
	updateGame(); 
	
}

//create a method to move hte piece to the right
public void moveRight()
{
	//check if there is space for the piece to be moved
	if(board.checkSideBorders(currentPiece, currCol + 1, currRow, currRotation) && board.checkOtherPiece(currentPiece, currCol + 1, currRow, currRotation))
	{
		//move it
		currCol++; 
	}
	updateGame(); 
	
}
//create a method to move the piece down 
public void moveDown()
{
	//check to see if piece can move down
		//System.out.println("LABEL " + board.checkSideBorders(currentPiece, currCol, currRow + 1, currRotation));
		//System.out.println("currow " + currRow);
		if(board.checkSideBorders(currentPiece, currCol, currRow + 1, currRotation) && board.checkOtherPiece(currentPiece, currCol, currRow + 1, currRotation))
		{
			//increase the currRow
			//pull the piece down
			currRow++;
		}
		updateGame(); 
}

//create a method to rotate clockwise
public void rotateClockwise()
{
	//create a variable for the new rotation
	int newRotation; 
	//update the rotation
	newRotation=currRotation+1; 
	//use modulus
	newRotation=newRotation%4; 
	
	//call a rotation method
	rotatePiece(newRotation); 
	
	updateGame(); 
}

//create a method to rotate anticlockwise
public void counterClockwise()
{
	//create a variable for the new rotation
	int newRotation; 
	//update the rotation
	newRotation=currRotation-1; 
	//use modulus
	newRotation=Math.floorMod(newRotation,4);
	
	//call a rotation method
	rotatePiece(newRotation); 
	
	updateGame(); 
}
}
