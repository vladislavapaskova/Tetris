package Tetris;

public class SPiece extends TetrisPiece
{
	/**
	 * Constructor
	 **/

		public SPiece()
		{
			//call the function that creates a piece
			createPiece(); 
		}
		 public boolean[][][] createPiece()
		 {
			 //create a variable for the iPiece
			  piece= new boolean[][][] {{{false,true,true,false},{true,true,false,false},{false,false,false,false},{false,false,false,false}},
			 										  {{false,true,false,false},{false,true,true,false},{false,false,true,false},{false,false,false,false}},
			 										  {{false,false,false,false},{false,true,true,false},{true,true,false,false},{false,false,false,false}},
			 										  {{true,false,false,false},{true,true,false,false},{false,true,false,false},{false,false,false,false}}}; 
			 //return the array
			 return piece; 
		 }

}
