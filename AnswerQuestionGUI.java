//********************************************************************
// Author: Sarah May
// Modified by: Jordan Sessa, Katie Morris
// Last mod: 12/14/15

//  AnswerQuestionGUI.java -- Computer asks user a question and 
// 	user responds. Requires the user to answer truthfully. 
//  GuessWho package 

//********************************************************************

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class AnswerQuestionGUI extends JPanel {

	private JLabel questionLabel, truthLabel;
	private JButton yButton, nButton;
	private GuessWhoCPU tree;
	private JFrame frame;
	private Person cpuChoice;
	private Person playersChoice;
	private PlayGameGUI g;

	/**
	 * Constructor
	 * @param g PlayGameGUI takes in PlayGameGUI object to modify visuals
	 * based on user's response within AnswerQuestionGUI
	 * @param f JFrame takes in JFrame to dispose of once user answers questions
	 */
	public AnswerQuestionGUI(PlayGameGUI g, JFrame f) {

		this.g = g;
		// GuessWhoCPU contains the binary decision  that we are operating on
		tree = g.getTree(); 
		
		// We need the player's character to 1st to make sure they are truthful
		// 2nd we need both player and cpu character to pass into winner gui when game 
		// is over
		cpuChoice = g.getCPUChoice();
		playersChoice = g.getPlayersChoice();
		frame = f;

		setBackground(Color.yellow); // visual
		add(makeQuestionPanel());

	}

	/**
	 * 
	 * @return JPanel returns the sole panel for the GUI containing question,
	 * truthfulness label, and buttons for user response 
	 */
	private JPanel makeQuestionPanel() {

		// create panel using Border layout manager
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBackground(Color.yellow);

		// create button panel using default grid layout
		JPanel buttonPanel = new JPanel();           
		buttonPanel.setBackground(Color.yellow);
		
		// add response buttons to button panel
		yButton = new JButton("Yes");
		nButton = new JButton("No");
		buttonPanel.add(yButton);
		yButton.addActionListener(new ButtonListener());
		buttonPanel.add(nButton);
		nButton.addActionListener(new ButtonListener());

		// question label displays the current question which is at the root of the
		// linked binary tree
		questionLabel = new JLabel(
				"<html> <div style = \'text-align: center;\'>" 
				+ "<font color = 'e6005c'"
				+ "face = 'arial black'" + "size = '6'>" 
				+ tree.getCurrent() 
				+ "</font> </div></html>", JLabel.CENTER);
		
		// by default, truth label asks user to answer truthfully
		// will change if they lie :)
		truthLabel = new JLabel(
				"<html> <div style = \'text-align: center;\'>" 
						+ "<font color = 'e6005c'"
						+ "face = 'arial black'"
						+ "size = '5'>" 
						+ "(Answer the question truthfully)" 
						+ "</font> </div></html>", JLabel.CENTER);


		// add all elements to the question panel and return the whole panel
		panel.add(questionLabel, BorderLayout.NORTH);
		panel.add(buttonPanel, BorderLayout.CENTER);
		panel.add(truthLabel, BorderLayout.SOUTH);
		panel.setBorder(new EmptyBorder(10, 10, 10, 10));
		return panel;
	}


	
	private class ButtonListener implements ActionListener {

		/**
		 * adds responsiveness for yButton and nButton 
		 */
		public void actionPerformed(ActionEvent event) {
			
			// determine whether the trait associated with the question 
			// is true or false for the player's character 
			Boolean trait = playersChoice.getQuestionResult(tree.getCurrent());
			
			// if the player lies, update truth label
			if ((event.getSource() == yButton && trait == false) 
					|| (event.getSource() == nButton && trait == true))
				truthLabel.setText("<html> <div style = \'text-align: center;\'>" 
						+ "<font color = 'e6005c'"
						+ "face = 'arial black'" + "size = '5'>" 
						+ "That was not a truthful response!"
						+ "</font> </div></html>");
			
			else { // the user is telling the truth 
				
				if (event.getSource() == yButton) {
					tree.goLeft(); //  go left on tree
					g.notCPUTurn(); // sets it to the player's turn so submit button
									// is enabled
				} else {
					tree.goRight(); // go right on tree 
					g.notCPUTurn(); // sets it to the computer's turn so submit
									// button is enabled
				}
				
				// update the number of characters that the computer 
				// still has as possibilities
				g.setNumRemain(  
	  		  			"<html> <font color = '8B008B'"
	  		  					+ "face = 'arial black' "
	  		  					+ "size = '7'>"
	  		  					+ tree.getNumResults()
	  		  					+ "</font> </html>");
				
				// if the cpu has narrowed it down to just one person -- the cpu has won!
				// open winner window and close all other frames
				if (tree.getNumResults() == 1) {
					new WinnerDriver("The Computer", cpuChoice.getName(), 
							cpuChoice.getImage(), playersChoice.getName(),
							playersChoice.getImage());
					g.closeFrame();
					frame.dispose();

				} else // the cpu has not won yet, simply close the answer question gui
					frame.dispose();
				
			}

	}
	}
	}
