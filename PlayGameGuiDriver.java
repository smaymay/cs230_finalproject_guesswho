
//********************************************************************
// Author: Jordan Sessa 
// Modified by: Sarah May, Katie Morris 
// Last mod: Dec. 14, 2015

//  PlayGameGUI.java -- Calls PlayGameGUI 
//  GuessWho package 

//********************************************************************


import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PlayGameGuiDriver {
 
	/**
	 * 
	 * @param player Takes in a GuessWhoPlayer object
	 * that was created in ChooseCharacterGUI 
	 */
 public PlayGameGuiDriver(GuessWhoPlayer player) {
  
  // creates and shows a frame
  JFrame frame = new JFrame("Guess Who!"); 
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
  
  // create a panel and add it to the frame 
  PlayGameGUI panel = new PlayGameGUI(player, frame);
  frame.getContentPane().add(panel); 
  frame.pack(); 
  frame.setVisible(true);
  
  // create and show pop up window with instructions for user 
  String s1 = "<html><span style='font-size:14px'>"
		  	+"First, select a question to ask the Computer"
		  	+ " Player about their character from the options "
		  	+ "at the bottom of the screen.\n\n" ;
  String s2 = "<html><span style='font-size:14px'>"
		  	+"Then, the Computer Player will ask you a question"
		  	+ " about your chosen character that you will "
		  	+ "have to answer.\n\n";
  String s3 = "<html><span style='font-size:14px'>"
		  	+ "Whoever gets down to one remaining"
		  	+ " character first, wins the game";
  String s4 = s1+s2+s3;
  JOptionPane.showMessageDialog(null,s4,"",JOptionPane.INFORMATION_MESSAGE);

 }

}