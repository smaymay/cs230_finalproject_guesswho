//********************************************************************
// Author: Jordan Sessa
// Modified by: Sarah, Katie Morris
// Dec. 13, 2015

//  WinnerGUI.java --- WinnerGUI pops up when someone has won the game
// 	From here, the user can X out or continue on with a play again button 
//  GuessWho package 

//********************************************************************

import java.awt.Color;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; 

public class WinnerGUI extends JPanel {
  
  String cpuChar, playerChar; 
  ImageIcon imCPU, imPlayer;
  JLabel winnerLabel;
  JButton playAgainButton;
  JFrame frame;
  
  	/**
	 * Creates a WinnerGUI 
	 * @param winner Either "The computer" or "You" depending on who won
	 * @param cpuChar the computer's character
	 * @param imCPU the computer's character image
	 * @param playerChar the user's character
	 * @param imPlayer the user's character image 
	 */
  public WinnerGUI(String winner, String cpuChar, 
                   ImageIcon imCPU, String playerChar, ImageIcon imPlayer,
                   JFrame frame) {
    
    this.cpuChar = cpuChar; 
    this.imCPU = imCPU;
    this.playerChar = playerChar; 
    this.imPlayer = imPlayer; 
    this.frame = frame; 
    
    // use box layout manager
    setBackground(Color.yellow);
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    
    // winner label displays who won the game 
    winnerLabel = new JLabel(
                             "<html> <div style = \'text-align: center;\'>"
                               + "<font face = 'arial black'"
                               + "size = '7' color = 'e6005c'>"
                               + winner + "<br> </font>"
                               + "<font size = '5' color = '8B008B'"
                               + "face = 'arial black'>"
                               + " won the game! </font>"
                               + "</div> </html>",
                             JLabel.CENTER);
    
    
    // play again button allows the user to start a new game 
    playAgainButton = new JButton("Play again");
    
    add(winnerLabel); 
    winnerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    add(Box.createVerticalGlue());
    add(makeButtonGUI());
    add(Box.createVerticalGlue());
    add(Box.createRigidArea(new Dimension(0, 15)));
    add(Box.createVerticalGlue());
    add(playAgainButton); 
    add(Box.createRigidArea(new Dimension(0, 15)));
    add(Box.createVerticalGlue());
    playAgainButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    playAgainButton.addActionListener(new ButtonListener());
  }
  
  /**
   * @return JPanel panel containing the computer's player
   * and the user's player (and their images) 
   */
  private JPanel makeButtonGUI() {
    JPanel p = new JPanel(); 
    
    JButton compButton = new JButton("The computer's player: " + cpuChar);
    compButton.setIcon(imCPU);
    
    JButton playerButton = new JButton("Your player: " + playerChar);
    playerButton.setIcon(imPlayer);
    
    p.add(playerButton);
    p.add(compButton);
    
    return p; 
  }
  
  
  private class ButtonListener implements ActionListener {
    
	  /**
	   * if the user clicks play again, the whole game restarts 
	   */
    public void actionPerformed (ActionEvent event) {
      
      if (event.getSource() == playAgainButton) {
        new Driver(); 
        frame.dispose();
      }
    }
  }
}
