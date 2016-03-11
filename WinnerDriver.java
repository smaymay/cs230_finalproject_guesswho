//********************************************************************
// Author: Sarah May
// Modified by: Jordan Sessa, Katie Morris
// Dec. 13, 2015

//  WinnerDriver.java -- Calls WinnerGUI 
//  GuessWho package 

//********************************************************************

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class WinnerDriver {
  
	/**
	 * Creates a WinnerGUI 
	 * @param winner Either "The computer" or "You" depending on who won
	 * @param cpuChar the computer's character
	 * @param imCPU the computer's character image
	 * @param playerChar the user's character
	 * @param imPlayer the user's character image 
	 */
  public WinnerDriver(String winner, String cpuChar, ImageIcon imCPU, 
                      String playerChar, ImageIcon imPlayer) {
    
    // creates and shows a frame
    JFrame frame = new JFrame("GameOver!"); 
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    
    // creates winner gui 
    WinnerGUI panel = new WinnerGUI(winner, cpuChar, imCPU, playerChar, imPlayer, frame);
    
    frame.getContentPane().add(panel); 
    frame.pack(); 
    frame.setVisible(true);
  }
}



