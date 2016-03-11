//********************************************************************
// Layout: Sarah May
// Functionality and design edits: Jordan Sessa
// Modified by: Katie Morris
// Dec. 12, 2015

// Last mod: 12/14/15

//  ChooseCharacterGUI.java  -- GUI from which the user selects their 
// 	character.  Creates a new GuessWhoPlayer object with this character,
//	and calls PlayGameGuiDriver with this GuessWhoPlayer object as input. 
//  GuessWho package 

//********************************************************************

import javax.swing.*;
import java.awt.*; 
import java.awt.event.*; 

public class ChooseCharacterGUI extends JPanel {
  
  private JLabel instructionsLabel; 
  
  private JButton submitButton, billButton, chantalButton, chrisButton, 
    christineButton, ernestButton, laylaButton, magnusButton, maryButton,
    mayButton, mikeButton, mimiButton, rayButton, susanButton, tedButton,
    theoButton, hannahButton; 
 
  //contains all of the images corresponding to characters
  private ImageIcons im; 
  private ImageIcon bill, chantal, chris, christine, ernest, layla,
    magnus, mary, may, mike, mimi, ray, susan, ted, theo, hannah; 
  final private ImageIcon NOTFOUND = 
		  new ImageIcon(getClass().getResource("/character/notfound.png"));
 
  
  private String name; //holds the name of the person that the player chooses
 
  private JFrame frame;
  
  /**
   * Constructor
   * @param j JFrame so that frame can close after user makes selection 
   */
  public ChooseCharacterGUI(JFrame j) {
	  
    frame = j;
    name = ""; //initially sets the name to nothing
    im = new ImageIcons(); // to access images
    
    // use border layout 
    setLayout (new BorderLayout(10,10)); 
    setBackground(Color.white); 

    add(makeNorthPanel(), BorderLayout.NORTH);
    add(makeEmptyPanel(), BorderLayout.WEST);
    add(makeCenterPanel(), BorderLayout.CENTER);
    add(makeEmptyPanel(), BorderLayout.EAST);
    add(makeEmptyPanel(), BorderLayout.SOUTH); 
  }
  
  /**
   * Creates and returns a JPanel
   * @return JPanel the panel that contains the instructions at top
   */
  private JPanel makeNorthPanel() {
    
    // create northPanel using default FlowLayout manager
    JPanel northPanel = new JPanel(); 
    northPanel.setBackground(Color.white);
    
    // tells the user what to do on the panel
    instructionsLabel = new JLabel(
                                   "<html>"
                                     + "<font color = 'ff0000'"
                                     + "face = 'arial black'"
                                     + "size = '10'>"
                                     + "Select a character for the computer to guess!"
                                     + "</font></html>", JLabel.CENTER);
   
    northPanel.add(instructionsLabel); 
    return northPanel;
  }
  
  /**
   * Creates and returns a JPanel
   * @return JPanel the Panel that contains no elements
   */
  private JPanel makeEmptyPanel() {
    
    // create emptyPanel using BorderLayout manager
    // although it does not contain anything, it 
    // adds a bit of breathing space
    
    JPanel emptyPanel = new JPanel(); 
    emptyPanel.setLayout(new BorderLayout(20,20));
    emptyPanel.setBackground(Color.white);
    return emptyPanel; 
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
    } catch (ImageNotFoundException e) { // if image is not found
      bill = NOTFOUND; // set to default not found image 
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
    
    // add buttons and action listeners, then return panel
    centerPanel.add(billButton);
    billButton.addActionListener(new ButtonListener());
  
    centerPanel.add(chantalButton);
    chantalButton.addActionListener(new ButtonListener());
    
    centerPanel.add(chrisButton);
    chrisButton.addActionListener(new ButtonListener());
    
    centerPanel.add(christineButton);
    christineButton.addActionListener(new ButtonListener());
    
    centerPanel.add(ernestButton);
    ernestButton.addActionListener(new ButtonListener());
    
    centerPanel.add(laylaButton);
    laylaButton.addActionListener(new ButtonListener());
    
    centerPanel.add(magnusButton);
    magnusButton.addActionListener(new ButtonListener());
    
    centerPanel.add(maryButton);
    maryButton.addActionListener(new ButtonListener());
    
    centerPanel.add(mayButton);
    mayButton.addActionListener(new ButtonListener());
    
    centerPanel.add(mikeButton);
    mikeButton.addActionListener(new ButtonListener());
    
    centerPanel.add(mimiButton);
    mimiButton.addActionListener(new ButtonListener());
    
    centerPanel.add(rayButton);
    rayButton.addActionListener(new ButtonListener());
    
    centerPanel.add(susanButton);
    susanButton.addActionListener(new ButtonListener());
    
    centerPanel.add(tedButton);
    tedButton.addActionListener(new ButtonListener());
    
    centerPanel.add(theoButton);
    theoButton.addActionListener(new ButtonListener());
    
    centerPanel.add(hannahButton);
    hannahButton.addActionListener(new ButtonListener());
    
    return centerPanel;
  }
  
  
  private class ButtonListener implements ActionListener {

	  /**
	   * checks to see which button was clicked and sets the name instance variable to the proper name
	   */
    public void actionPerformed (ActionEvent event) {
      if (event.getSource() == billButton){
        name = "Bill";
      }
      else if (event.getSource() == chantalButton){
        name = "Chantal";
      }
      else if (event.getSource() == chrisButton){
        name = "Chris";
      }
      else if (event.getSource() == christineButton){
        name = "Christine";
      }
      else if (event.getSource() == ernestButton){
        name = "Ernest";
      }
      else if (event.getSource() == laylaButton){
        name = "Layla";
      }
      else if (event.getSource() == magnusButton){
        name = "Magnus";
      }
      else if (event.getSource() == maryButton){
        name = "Mary";
      }
      else if (event.getSource() == mayButton){
        name = "May";
      }
      else if (event.getSource() == mikeButton){
        name = "Mike";
      }
      else if (event.getSource() == mimiButton){
        name = "Mimi";
      }
      else if (event.getSource() == rayButton){
        name = "Ray";
      }
      else if (event.getSource() == susanButton){
        name = "Susan";
      }
      else if (event.getSource() == tedButton){
        name = "Ted";
      }
      else if (event.getSource() == theoButton){
        name = "Theo";
      }
      else if(event.getSource() == hannahButton){
        name = "Hannah";
      }
      
      //System.out.println(name); ------ uncomment for testing
      
      //after a button is pressed, start the game
      GuessWhoPlayer g = null;
      
      try {
    	//tries to create a new GuessWhoPlayer object 
    	  //with the parameter of the name instance variable
        g = new GuessWhoPlayer(name); 
      } catch (Exception e) { 
        System.out.println("name does not correspond to a character");
      }  
      
    //passes the new GuessWhoPlayer in the PlayGameGuiDriver
      new PlayGameGuiDriver(g); 
      frame.dispose(); //closes the chooseCharacer window
    }
  }
}
