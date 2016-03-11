//********************************************************************
// Author: Sarah May
// Dec. 10, 2015

//  AnswerQuestionDriver.java -- Creates a new AnswerQuestionGUI
//  GuessWho package 

//********************************************************************

import javax.swing.JFrame;

public class AnswerQuestionDriver {
  private PlayGameGUI g;
  
  /**
   * Creates an AnswerQuestionGUI 
   * @param g Takes in the PlayGameGUI object that has all the information 
   * about the current game
   */
  public AnswerQuestionDriver(PlayGameGUI g) {
    this.g = g;
    
    // creates and shows a frame
    JFrame frame = new JFrame("Computer's turn!"); 
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    
    AnswerQuestionGUI panel = new AnswerQuestionGUI(g, frame);
    
    frame.getContentPane().add(panel); 
    
    frame.pack(); 
    
    frame.setVisible(true);
  }
}



