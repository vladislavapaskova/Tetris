package Tetris;

public class TPiece extends TetrisPiece
{
	/**
	 * Constructor
	 **/

		
		public TPiece()
		{
			//call the function that creates a piece
			createPiece(); 
		}
		 public boolean[][][] createPiece()
		 {
			 //create a variable for the iPiece
			 piece= new boolean[][][] {{{false,true,false,false},{true,true,true,false},{false,false,false,false},{false,false,false,false}},
			 										  {{false,true,false,false},{false,true,true,false},{false,true,false,false},{false,false,false,false}},
			 										  {{false,false,false,false},{true,true,true,false},{false,true,false,false},{false,false,false,false}},
			 										  {{false,false,false,false},{false,false,true,false},{false,true,true,false},{false,false,true,false}}}; 
			 //return the array
			 return piece; 
		 }
		 

		 
}
