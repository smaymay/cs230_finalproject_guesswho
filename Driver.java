//********************************************************************
// Author: Sarah May
// Dec. 10 2015

// Last mod: 12/13/15

//  Driver.java -- Creates a new ChooseCharacterGUI, which begins
// 	the game 
//  GuessWho package 

//********************************************************************

import javax.swing.JFrame;

public class Driver {
  
	/**
	 * constructor allows the game to start/ to be called from 
	 * replay button on winner GUI
	 */
  public Driver() {
    // creates and shows a frame
    JFrame frame = new JFrame("Select your character"); 
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    
    // create a panel and add it to the frame 
    ChooseCharacterGUI panel = new ChooseCharacterGUI(frame);
    
    frame.getContentPane().add(panel); 
    frame.pack(); 
    frame.setVisible(true);
    
  }
  
  
  /**
   * Main method allows the game to start/ to be called
   * from the command line
   * @param args none
   */
  public static void main (String[] args) {
    new Driver(); 
  }
}
