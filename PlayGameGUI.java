//********************************************************************
// Author: Sarah May
// Modified by: Katie Morris, Jordan Sessa
// Dec. 11, 2015

//  PlayGameGUI.java  -- Users interact with this gui to play the game 
//  GuessWho package 

//********************************************************************

import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
import java.util.LinkedList; 

public class PlayGameGUI extends JPanel {
  
  private JLabel titleLabel, instructionsLabel, questionLabel, 
    remainCharsLabel, numRemainLabel; 
  
  private JButton nextQButton, submitQButton,
    billButton, chantalButton, chrisButton, 
    christineButton, ernestButton, laylaButton, magnusButton, maryButton,
    mayButton, mikeButton, mimiButton, rayButton, susanButton, tedButton,
    theoButton, hannahButton, userCharButton; 
  
  private ImageIcon bill, chantal, chris, christine, ernest, layla,
    magnus, mary, may, mike, mimi, ray, susan, ted, theo, hannah; 
  final private ImageIcon NOTFOUND = 
		  new ImageIcon(getClass().getResource("/character/notfound.png"));
  final private ImageIcon ELIMINATED = 
		  resizeImage("/character/eliminated.png", 41, 100);
//ImageIcons contains all images corresponding to characters
  private ImageIcons im; 
  
  private Person playersChoice;
  private Person cpuChoice;
  
//true when cpu's turn, false when player's turn
  private boolean computerTurn; 
  

  private GuessWhoPlayer player; 
  //guess who player contains the binary decision tree that is used for CPU process
  private GuessWhoCPU tree; 
  
  //so frame can be disposed of when game is over
  private JFrame frame; 
  
  
  
  /**
   * Constructor
   * @param player GuessWhoPlayer object containing 
   * the user's character choice, computer's
   * character choice, and question queue 
   */
  public PlayGameGUI(GuessWhoPlayer player, JFrame frame) {
	  
	    // user border layout for gui 
	    setLayout (new BorderLayout(10,10)); 
	    setBackground(Color.white); 

	  
    computerTurn = false; // player gets first turn
    this.frame = frame; 
    // start new tree each time a new PlayGameGUI is instantiated
    tree = new GuessWhoCPU(); 
    // GuessWhoPlayer is instantiated in ChooseCharacterGUI and passed
    // in as a parameter 
    this.player = player; 
    


    playersChoice = player.getPlayerChoice(); // get the user's character
    cpuChoice = player.getCompChoice(); // gets the cpu's characters
    
    // create an icon showing the character the user has chosen
    userCharButton = new JButton(playersChoice.getName()); // adds text (name)
    userCharButton.setIcon(playersChoice.getImage());  // adds image 
   
    // to access images assoc. w/ each character (for center panel)
    im = new ImageIcons(); 
    
    add(makeNorthPanel(), BorderLayout.NORTH);
    add(makeCenterPanel(), BorderLayout.CENTER);
    add(makeSouthPanel(), BorderLayout.SOUTH);
    add(makeWestPanel(), BorderLayout.WEST);
    add(makeEastPanel(), BorderLayout.EAST);
    
  }
  
  /**
   * Resizes an image icon to fit the gui buttons 
   * @param loc String the location of the image 
   * @param d1 int the desired width
   * @param d2 int the desired height
   * @return ImageIcon of correct size 
   */
  private ImageIcon resizeImage(String loc, int d1, int d2) {
	//get image from location 
	  ImageIcon imageIcon = new ImageIcon 
			  (getClass().getResource(loc));
	  
	  // get image from image icon 
	  Image image = imageIcon.getImage();
	  // resize image 
	  Image resizedImage = image.getScaledInstance(d1, d2, java.awt.Image.SCALE_SMOOTH);
	  // return as image icon 
	  return new ImageIcon(resizedImage);
  }
  

  
  /**
   * closes the frame -- can be called outside the gui 
   * e.g. from answer question gui if the cpu wins the game
   */
  public void closeFrame(){
    frame.dispose();
  }
  
  // getters 
  
  /**
   * 
   * @return PlayGameGUI the entire PlayGameGUI and all it's information so that 
   * the PlayGameGUI object can be accessed outside the class e.g. in button listener 
   */
  public PlayGameGUI getGame() {
    return this;
  }

  /**
   * 
   * @return GuessWhoCPU the class containing the binary decision tree 
   */
  public GuessWhoCPU getTree() {
    return tree;
  }
  
  /**
   * 
   * @return Person the computer's character
   */
  public Person getCPUChoice() {
    return cpuChoice; 
  }
  
  /**
   * 
   * @return Person the player's character
   */
  public Person getPlayersChoice() {
    return playersChoice;
  }
  
  // setter type methods
  
  /**
   * sets the computers turn to be false -- 
   * e.g. it is the player's turn again 
   */
  public void notCPUTurn(){
    computerTurn = false;
  }
  
  /**
   * 
   * @param s Sets the parameter s as the label 
   * for the number of characters the computer
   * has it narrowed down to 
   */
  public void setNumRemain(String s) {
    numRemainLabel.setText(    
                           "<html> <font color = '8B008B'"
                             + "face = 'arial black' "
                             + "size = '10'>"
                             + s
                             + "</font> </html>");
  }
  
  
  // methods to create panels 
  
  /**
   * Creates and returns a JPanel
   * @return JPanel the panel that contains title & instructions at top
   */
  private JPanel makeNorthPanel() {
    
    // create northPanel using gridlayout manager
    JPanel northPanel = new JPanel(); 
    northPanel.setBackground(Color.white);
    northPanel.setLayout(new GridLayout(2,1,10,10));
    
    // title label just has the title of the game
    titleLabel = new JLabel(
                            "<html> <div style = \'text-align: center;\'>"
                              + "<font color = 'e6005c'"
                              + "face = 'arial black'"
                              + "size = '12'>"
                              + "Guess Who!"
                              + "</font> </div></html>", JLabel.CENTER); 
    
    // instructions label tells user to select a question and where 
    instructionsLabel = new JLabel(
                                   "<html> <div style = \'text-align: center;\'>"
                                     + "<font color = '8B008B'"
                                     + "face = 'arial black'"
                                     + "size = '6'>"
                                     + "Select a question at the bottom of the screen"
                                     + "</font> </div> </html>", JLabel.CENTER);
    
    
    
    northPanel.add(titleLabel);
    northPanel.add(instructionsLabel);
    return northPanel;
  }
  
  /**
   * Creates and returns a JPanel 
   * @return JPanel the panel with the player's character and the 
   * number of characters the cpu has it narrowed down to 
   */
  private JPanel makeEastPanel() {
    
	  //create eastPanel using grid layout -- 3 rows, 1 column
    JPanel eastPanel = new JPanel(); 
    eastPanel.setBackground(Color.yellow); 
    eastPanel.setLayout(new GridLayout(3,1,10,10));
    

    remainCharsLabel = new JLabel(
                                  "<html> <font color = '8B008B'"
                                    + "face = 'arial black' "
                                    + "size = '5'>"
                                    + "CPU's remaining characters: "
                                    + "</font> </html>", JLabel.CENTER);
    
    // shows the number of characters the computer still thinks are
    // possiblities (e.g. the number of leaves on the tree)
    numRemainLabel = new JLabel(
                                "<html> <font color = '8B008B'"
                                  + "face = 'arial black' "
                                  + "size = '7'>"
                                  + tree.getNumResults()
                                  + "</font> </html>", JLabel.CENTER);
    
    
    eastPanel.add(userCharButton);
    eastPanel.add(remainCharsLabel);
    eastPanel.add(numRemainLabel);
    return eastPanel; 
  }
  
  /**
   * Creates and returns a JPanel
   * @return JPanel the panel of icons with characters images / names 
   */
  private JPanel makeCenterPanel() {
    
    
    // create centerPanel using GridLayout manager
    JPanel centerPanel = new JPanel(); 
    centerPanel.setBackground(Color.white);
    centerPanel.setLayout(new GridLayout(4,4,10,10));
    
    // create the various icons with characters images / names 
    billButton = new JButton("Bill"); 
    try {
      bill = im.getImage("bill"); // get image from ImageIcons class 
    } catch (ImageNotFoundException e) { // if image isn't found
      bill = NOTFOUND; 	// set to NOTFOUND default image 
    }
    billButton.setIcon(bill);
    
    chantalButton = new JButton("Chantal"); 
    try {
      chantal = im.getImage("chantal");
    } catch (ImageNotFoundException e) {
      chantal = NOTFOUND; 
    }
    chantalButton.setIcon(chantal);
    
    chrisButton = new JButton("Chris");
    try {
      chris = im.getImage("chris");
    } catch (ImageNotFoundException e) {
      chris = NOTFOUND; 
    }
    chrisButton.setIcon(chris);
    
    christineButton = new JButton("Christine");
    try {
      christine = im.getImage("christine");
    } catch (ImageNotFoundException e) {
      christine = NOTFOUND; 
    }
    christineButton.setIcon(christine);
    
    ernestButton = new JButton("Ernest");
    try {
      ernest = im.getImage("ernest");
    } catch (ImageNotFoundException e) {
      ernest = NOTFOUND; 
    }
    ernestButton.setIcon(ernest);
    
    laylaButton = new JButton("Layla");
    try {
      layla = im.getImage("layla");
    } catch (ImageNotFoundException e) {
      layla = NOTFOUND; 
    }
    laylaButton.setIcon(layla);
    
    magnusButton = new JButton("Magnus");
    try {
      magnus = im.getImage("magnus");
    } catch (ImageNotFoundException e) {
      magnus = NOTFOUND; 
    }
    magnusButton.setIcon(magnus);
    
    maryButton = new JButton("Mary");
    try {
      mary = im.getImage("mary");
    } catch (ImageNotFoundException e) {
      mary = NOTFOUND; 
    }
    maryButton.setIcon(mary);
    
    mayButton = new JButton("May");
    try {
      may = im.getImage("may");
    } catch (ImageNotFoundException e) {
      may = NOTFOUND; 
    }
    mayButton.setIcon(may);
    
    mikeButton = new JButton("Mike");
    try {
      mike = im.getImage("mike");
    } catch (ImageNotFoundException e) {
      mike = NOTFOUND; 
    }
    mikeButton.setIcon(mike);
    
    mimiButton = new JButton("Mimi");
    try {
      mimi = im.getImage("mimi");
    } catch (ImageNotFoundException e) {
      mimi = NOTFOUND; 
    }
    mimiButton.setIcon(mimi);
    
    rayButton = new JButton("Ray");
    try {
      ray = im.getImage("ray");
    } catch (ImageNotFoundException e) {
      ray = NOTFOUND; 
    }
    rayButton.setIcon(ray);
    
    susanButton = new JButton("Susan");
    try {
      susan = im.getImage("susan");
    } catch (ImageNotFoundException e) {
      susan = NOTFOUND; 
    }
    susanButton.setIcon(susan);
    
    tedButton = new JButton("Ted");
    try {
      ted = im.getImage("ted");
    } catch (ImageNotFoundException e) {
      ted = NOTFOUND; 
    }
    tedButton.setIcon(ted);
    
    theoButton = new JButton("Theo");
    try {
      theo = im.getImage("theo");
    } catch (ImageNotFoundException e) {
      theo = NOTFOUND; 
    }
    theoButton.setIcon(theo);
    
    hannahButton = new JButton("Hannah");
    try {
      hannah = im.getImage("hannah");
    } catch (ImageNotFoundException e) {
      hannah = NOTFOUND; 
    }
    hannahButton.setIcon(hannah);
    
    centerPanel.add(billButton);
    centerPanel.add(chantalButton);
    centerPanel.add(chrisButton);
    centerPanel.add(christineButton);
    centerPanel.add(ernestButton);
    centerPanel.add(laylaButton);
    centerPanel.add(magnusButton);
    centerPanel.add(maryButton);
    centerPanel.add(mayButton);
    centerPanel.add(mikeButton);
    centerPanel.add(mimiButton);
    centerPanel.add(rayButton);
    centerPanel.add(susanButton);
    centerPanel.add(tedButton);
    centerPanel.add(theoButton);
    centerPanel.add(hannahButton);
    
    return centerPanel;
  }
  
  /**
   * Creates and returns a JPanel
   * @return JPanel the panel contains no elements 
   */
  private JPanel makeWestPanel() {
    
    // create westPanel using BorderLayout manager
    // although it does not contain anything, it 
    // adds a bit of breathing space
    
    JPanel westPanel = new JPanel(); 
    westPanel.setLayout(new BorderLayout(20,20));
    westPanel.setBackground(Color.white);
    return westPanel; 
  }
  
  /**
   * Creates and returns a JPanel
   * @return JPanel panel allows users to select and ask a question
   */
  private JPanel makeSouthPanel() {
    
    // create centerPanel using boxlayout manager
    JPanel southPanel = new JPanel(); 
    southPanel.setBackground(Color.white);
    southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
    
    // question label shows the question at the top of the question queue 
    questionLabel = new JLabel(
                                "<html> <div style = \'text-align: center;\'>"
                                 + "<font color = 'e6005c'"
                                 + "face = 'arial black' "
                                 + "size = '6'>"
                                 + player.getQuestion()
                                 + "</font></div></html>",JLabel.CENTER);
    
    // user can click next question button to see next question
    // (move question to back of queue)
    nextQButton = new JButton(
                              "<html> <font color = 'e6005c'"
                                + "face = 'arial black'"
                                + "size = '5'>"
                                + "Next question >"
                                + "</font></html>");
    nextQButton.addActionListener(new ButtonListener());
    
    // submit question "asks" (dequeues / further actions) the question 
    submitQButton = new JButton(
                                "<html> <font color = '8B008B'"
                                  + "face = 'arial black'"
                                  + "size = '5'>"
                                  + "Submit question"
                                  + "</font></html>");
    submitQButton.addActionListener(new ButtonListener());
    
    // create a new panel p with box layout manager
    // containing next q button and submit q button 
    JPanel p = new JPanel();
    p.setLayout(new BoxLayout(p, BoxLayout.X_AXIS));
    p.add(nextQButton); 
    p.add(submitQButton);
    
    // add question at top of south panel 
    southPanel.add(Box.createRigidArea(new Dimension(0, 15)));
    southPanel.add(Box.createVerticalGlue());
    southPanel.add(questionLabel);
    questionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
    
    // add panel with next q button and submit q button 
    southPanel.add(Box.createVerticalGlue());
    southPanel.add(Box.createRigidArea(new Dimension(0, 15)));
    southPanel.add(Box.createVerticalGlue());
    southPanel.add(p);
    southPanel.add(Box.createVerticalGlue());
    
    return southPanel;
  }
  
  
  // helper methods for action listener
  
  /**
   * Changes the button images to represent that characters have been eliminated when 
   * the user asks a question
   */
  private void eliminateCharacters() {
	  
    LinkedList<Person> eliminated = player.getEliminated();
    
    // for each person that has been eliminated from the array of possibilities 
    // in GuessWhoPlayer ...
    for (Person p : eliminated) {
      try {
        JButton b = findButton(p.getName());
        b.setIcon(ELIMINATED); // set the icon to be eliminated 
      } catch (NameNotFoundException e) {
        System.out.println("name not found");
      }
    }
  }
  
  /**
   * 
   * @param name Takes in the name of a character
   * @return JButton Returns the button associated with a character
   * @throws NameNotFoundException If the name does not correspond with a character
   */
  private JButton findButton(String name) throws NameNotFoundException {
    if (name.equals("Bill"))
      return billButton; 
    else if (name.equals("Chantal"))
      return chantalButton; 
    else if (name.equals("Chris"))
      return chrisButton; 
    else if (name.equals("Christine"))
      return christineButton; 
    else if (name.equals("Ernest"))
      return ernestButton; 
    else if (name.equals("Layla"))
      return laylaButton; 
    else if (name.equals("Magnus"))
      return magnusButton; 
    else if (name.equals("Mary"))
      return maryButton; 
    else if (name.equals("May"))
      return mayButton; 
    else if (name.equals("Mike"))
      return mikeButton; 
    else if (name.equals("Mimi"))
      return mimiButton; 
    else if (name.equals("Ray"))
      return rayButton; 
    else if (name.equals("Susan"))
      return susanButton; 
    else if (name.equals("Ted"))
      return tedButton; 
    else if (name.equals("Theo"))
      return theoButton; 
    else if (name.equals("Hannah"))
      return hannahButton; 
    else throw new NameNotFoundException
      ("Name does not correspond to a button"); 
    
  }
  
  
  
  
  private class ButtonListener implements ActionListener {
    
    /**
     * ActionListener for buttons in PlayGameGUI
     */
    public void actionPerformed (ActionEvent event) {
      
      
      // if user clicks next question, move question to back of queue 
      if (event.getSource() == nextQButton) {
        player.nextQuestion();
        questionLabel.setText(
                              "<html> <font color = 'e6005c'"
                                + "face = 'arial black' "
                                + "size = '6'>"
                                + player.getQuestion()
                                + "</font> </html>");
      }
      
      // submitButton was pressed
      else if (event.getSource() == submitQButton && computerTurn == false){
        
    	  String t = player.askQuestion(); // trait assoc. with question asked 
        
        // eliminate characters from back end based on question
        player.eliminate(t, cpuChoice.getTrait(t)); 
        // then eliminate characters from visuals
        eliminateCharacters();  
        
        // change the text on question label -- to represent that question has been asked
        questionLabel.setText( 
                              "<html> <font color = 'e6005c'"
                                + "face = 'arial black' "
                                + "size = '6'>"
                                + player.getQuestion()
                                + "</font> </html>");
        
        // determine if the game is over -- if so, create new winner gui and 
        // dispose of this frame
        if (player.getNumLeft() == 1){
          new WinnerDriver("You", cpuChoice.getName(), cpuChoice.getImage(),
                           playersChoice.getName(), playersChoice.getImage());
          frame.dispose();
        }
        
        else{ // the game is not over -- it's the cpu's turn 
          new AnswerQuestionDriver(getGame());
        }
        computerTurn = true;
      }
    }
  }
}
