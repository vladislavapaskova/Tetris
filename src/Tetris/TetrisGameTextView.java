package Tetris;

public class TetrisGameTextView
{
	//make na instance of the game 
	TetrisGame game; 
	
	//the tetris game needs to be passsed
	public TetrisGameTextView(TetrisGame passedGame)

	{
		//System.out.println("text view constructor");
		//save the passed game
		game=passedGame; 
		getCompleteView();
	}
	
	//create a method that returns the String on the terminal
	public String getView()
	{
		//create an variable for the view
		String boardView= ""; 
		
		//create a for loop to go through the board
		for(int i=0; i<18; i++)
		{
			for(int j=0; j<10; j++)
			{
				//check if it has a block 
				if(game.boardHasBlock(j,i))
						{
					//add an x
							boardView += "x"; 
						}
				else
				{
					//add empty space
					boardView += " ";
				}
			}
			//make it on a new line
			boardView += "\n"; 
		}
		//return the string
		return boardView; 
	}
	
	public String getCompleteView()
	{
		System.out.println("text view constructor");
		//create a variable to hold the view
		String completeView= "";
		//assign the tetrises
		completeView += "Number of Tetrises: " + game.getTetrises(); 
		completeView += "\n"; 
		//assign the score
		completeView += "Number of lines: " + game.getScore(); 
		completeView += "\n"; 
		//add the division line
		completeView += "__________"; 
		completeView += "\n"; 
		//add the board
		completeView += getView(); 
		completeView += "\n"; 
		//add the division line
		completeView += "__________"; 
		
		//return the completeview
		return completeView; 
	}
}
