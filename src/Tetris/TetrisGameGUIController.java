package Tetris;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.text.Keymap;

public class TetrisGameGUIController extends JPanel implements KeyListener
{
	/*
	 * Instance Fields
	 */
	//create an instance of a Timer
	private Timer timer; 
	
	//create an instance of the timer box
	private JTextField timerTextField;
	//create a field for thescore
	private JTextField scoreTextField; 
	//create a field for the tetrises
	private JTextField tetrisesTextField; 
	
	//create an instance field of the game
	TetrisGame game;
	//create an instance field of the view
	TetrisBoardGUIView view; 
	//create an instance field of the tetris piece
	TetrisPiece tetrisPiece; 
	//create an instance var of the small panel that is going to contain the timer score and tetrises
	private JPanel upPanel; 
	
	/*
	 * Constructor
	 */
	public TetrisGameGUIController()
	{
		// create a tetris game
		game= new TetrisGame(); 
		// create its view
		view= new TetrisBoardGUIView(game);
		//call the function that makes the main panel
		makeMainPanel();
		
		this.setFocusable(true);
		this.addKeyListener(this);
	}
	//create a function to show the whole panel
	public void makeMainPanel()
	{
		//set the layout as border layout
		this.setLayout(new BorderLayout());
		//add theup panel
		this.add(makeUpPanel(), BorderLayout.NORTH); 
		//add the board to the center
		this.add(view, BorderLayout.CENTER); 
		 
	}
	
	//create a function that is going to return the upPanel
	public JPanel makeUpPanel()
	{
		//create a new instance of the panel
		upPanel = new JPanel();
		//set the layout as grid
		upPanel.setLayout(new GridLayout(3,1));
		//add timer
		timerTextField= new JTextField("0000");
		timerTextField.setEditable(false);
		//set up tumer
		setUpTimer(); 
		//add the timer
		upPanel.add(timerTextField); 
		//create a new instance of the score
		scoreTextField = new JTextField("Number of lines: " + scoreUpdate()); 
		//add score
		upPanel.add(scoreTextField);
		//create a new instance of the tetrises
		tetrisesTextField = new JTextField("Number of Tetrises: " + game.getTetrises()); 
		//add tetrises
		upPanel.add(tetrisesTextField); 
		
		//return panel
		return upPanel; 
	}
	
	public int scoreUpdate()
	{
		return game.getScore(); 
	}
	
	//create a function that starts the timer	
	public void setUpTimer()
	{
			
	//delay in milliseconds
	int delay = 1000;
	
	//create an action Listener
	ActionListener taskPerformed = new ActionListener()
	{
		//create action performed
		public void ActionPerformed(ActionEvent e)
		{

		
		}

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
			game.moveDown();
			//call addSeconds
			addSeconds(); 

		}
	};

	//add the new timer instance
	timer= new Timer(delay, taskPerformed);
	//start the zero 
	timer.start(); 
	}
		
		//create a function that is going to add seconds 
		public void addSeconds()
		{
			//create a string variable to store the number of seconds
			String numSeconds; 
			//take the number of seconds from the textfield
			numSeconds=timerTextField.getText(); 
			//create an integer variable to add the new second to it 
			int intNumSeconds = Integer.parseInt(numSeconds); 
			intNumSeconds= intNumSeconds + 1;
			//add the second to the textfield
			timerTextField.setText(Integer.toString(intNumSeconds)); 
			//setScore(); 
			
		}
		//create a function that ends the timer
		public void endTimer()
		{
			//stop the timer
			timer.stop(); 
		}
	
	
	
	@Override
	public void keyPressed(KeyEvent e) 
	{
		// TODO Auto-generated method stub
		// different behavior depending on which key was released
        switch( e.getKeyCode() )
        {
	        // if it's the right key
	        case KeyEvent.VK_RIGHT:
	        //make the piece rotate clockwise
	        game.moveRight(); 
		    //refresh
		    refreshDisplay();
	        break;
	        
	        // if it's the left key
	        case KeyEvent.VK_LEFT:
	        //make the piece rotate clockwise
	        game.moveLeft(); 
		    //refresh
		    refreshDisplay();; 
	        break;
	        	
	        case KeyEvent.VK_DOWN:
	        //make the piece move down
	        game.moveDown();
		    //refresh
		    refreshDisplay();
	        break;
	        
	        case KeyEvent.VK_X:
		    //make the piece move down
		    game.rotateClockwise();
		    //refresh
		    refreshDisplay();
		    break;
		    
	        case KeyEvent.VK_Z:
		    //make the piece move down
		    game.counterClockwise();
		    //refresh
		    refreshDisplay();
		    break;		    
	        
	        default:
                System.out.println("KEY PRESSED: " + e.getKeyCode() );
        }
	}
	//refresh the display
	private void refreshDisplay() 
	{
		//reset both of the score nad tetrises textfields
		tetrisesTextField.setText("Number of Tetrises: " + game.getTetrises());
		scoreTextField.setText("Number of lines: " + scoreUpdate());
		//call repaint
	    view.repaint();
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
