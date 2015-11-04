package Tetris;

public class IPiece extends TetrisPiece
{
/**
 * Constructor
 **/

	
	public IPiece()
	{
		//call the function that creates a piece
		createPiece(); 
	}
	 public boolean[][][] createPiece()
	 {
		 //create a variable for the iPiece
		 piece= new boolean[][][] {{{false,false,false,false},{true,true,true,true},{false,false,false,false},{false,false,false,false}},
		 										  {{false,false,true,false},{false,false,true,false},{false,false,true,false},{false,false,true,false}},
		 										  {{false,false,false,false},{false,false,false,false},{true,true,true,true},{false,false,false,false}},
		 										  {{false,true,false,false},{false,true,false,false},{false,true,false,false},{false,true,false,false}}}; 
		 //return the array
		 return piece; 
	 }
}
