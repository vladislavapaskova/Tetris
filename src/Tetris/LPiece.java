package Tetris;

public class LPiece extends TetrisPiece
{
	/**
	 * Constructor
	 **/

 	
		public LPiece()
		{
			//call the function that creates a piece
			createPiece(); 
		}
		 public boolean[][][] createPiece()
		 {
			 //create a variable for the iPiece
			 piece= new boolean[][][] {{{false,false,true,false},{true,true,true,false},{false,false,false,false},{false,false,false,false}},
			 										  {{false,true,false,false},{false,true,false,false},{false,true,true,false},{false,false,false,false}},
			 										  {{false,false,false,false},{true,true,true,false},{true,false,false,false},{false,false,false,false}},
			 										  {{true,true,false,false},{false,true,false,false},{false,true,false,false},{false,false,false,false}}}; 
			 //return the array
			 return piece; 
		 }
}
