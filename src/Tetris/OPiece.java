package Tetris;

public class OPiece extends TetrisPiece
{
	/**
	 * Constructor
	 **/

		public OPiece()
		{
			//call the function that creates a piece
			createPiece(); 
		}
		 public boolean[][][] createPiece()
		 {
			 //create a variable for the iPiece
			piece= new boolean[][][] {{{true,true,false,false},{true,true,false,false},{false,false,false,false},{false,false,false,false}},
			 										  {{true,true,false,false},{true,true,false,false},{false,false,false,false},{false,false,false,false}},
			 										  {{true,true,false,false},{true,true,false,false},{false,false,false,false},{false,false,false,false}},
			 										  {{true,true,false,false},{true,true,false,false},{false,false,false,false},{false,false,false,false}}}; 
			 //return the array
			 return piece; 
		 }
}
