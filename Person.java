//********************************************************************
// Author: Katie Morris
// Modifications by: Sarah May
// Dec. 10, 2015

// last mod: 12/14/15

//  Person.java -- Contains the attributes associated with characters 
// and methods for accessing and updating those attributes 
//  GuessWho package 

//********************************************************************

import javafoundations.exceptions.*;
import java.util.*;
import javax.swing.ImageIcon;


public class Person {
  //instance variables
  private String name; //name of the person
  private boolean[] traits; //boolean array containing true/false values for all traits
  private int numTraits = 10; //number of traits
  
  private ImageIcons imageList; 
  private ImageIcon image; // image icon variable to store image -- for display
  
  //index of each trait in the array
  final private static int male = 0;
  final private static int bald = 1;
  final private static int glasses = 2;
  final private static int jewelry = 3;
  final private static int blonde = 4;
  final private static int brown = 5;
  final private static int facial = 6;
  final private static int hat = 7;
  final private static int red = 8;
  final private static int black = 9;
  
  //initial array of all false traits
  final private boolean[] INITIAL = new boolean[] {false,false,false,false,false,false,false,false,false,false};
  
  //trait arrays corresponding to each character
  private boolean[] billArray = new boolean[]{true,true,true,false,false,false,false,false,false,false};
  private boolean[] chantalArray = new boolean[]{false,false,true,false,false,true,false,false,false,false};
  private boolean[] chrisArray = new boolean[]{true,true,false,false,false,false,false,true,false,false};
  private boolean[] christineArray = new boolean[]{false,false,false,false,false,true,false,false,false,false};
  private boolean[] ernestArray = new boolean[]{true,true,true,false,false,false,true,false,false,false};
  private boolean[] hannahArray = new boolean[]{false,false,false,false,false,false,false,false,true,false};
  private boolean[] laylaArray = new boolean[]{false,false,false,true,false,false,false,false,false,true};
  private boolean[] magnusArray = new boolean[]{true,false,false,false,false,true,true,false,false,false};
  private boolean[] maryArray = new boolean[]{false,false,true,false,true,false,false,true,false,false};
  private boolean[] mayArray = new boolean[]{false,false,true,false,false,false,false,false,false,false};
  private boolean[] mikeArray = new boolean[]{true,false,false,false,false,false,true,false,false,true};
  private boolean[] mimiArray = new boolean[]{false,false,true,false,false,false,false,true,true,false};
  private boolean[] rayArray = new boolean[]{true,false,false,false,false,false,false,false,true,false};
  private boolean[] susanArray = new boolean[]{false,false,false,true,true,false,false,false,false,false};
  private boolean[] tedArray = new boolean[]{true,false,false,false,false,true,false,false,false,false};
  private boolean[] theoArray = new boolean[]{true,true,false,false,false,false,false,false,false,false};
  
  
  
  
  
  
  
  //constructor #1
  //makes person object given name, an array of traits, and an image
  public Person(String name, boolean[] traits, String image) throws IncorrectArrayException{
    IncorrectArrayException problem = new IncorrectArrayException("Person could not be created. Trait array must contain T/F values for 8 traits");
    this.name = name; //set name
    this.image = new ImageIcon(getClass().getResource(image)); // set image 
    if (traits.length == numTraits){
      this.traits = traits; //set traits array if given array has correct length
    }
    else throw problem; //throw exception if traits array does not have proper length
  }
  
  //constructor #2
  //makes person object given name but not array of traits
  //all traits start out at false (can be changed using setters)
  public Person(String name) throws NameNotFoundException, ImageNotFoundException{
    NameNotFoundException problem = new NameNotFoundException("Name not found.");
    this.name = name; //set name
    imageList = new ImageIcons(); // to access images
    
    //set trait array to be one that corresponds to character name
    //set image to be the one that corresponds to character name
    if (name.equals("Bill")){
      this.traits = billArray;
      this.image = imageList.getImage("bill"); 
    }
    else if (name.equals("Chantal")){
      this.traits = chantalArray;
      this.image = imageList.getImage("chantal"); 
    }
    else if (name.equals("Chris")){
      this.traits = chrisArray;
      this.image = imageList.getImage("chris"); 
    }
    else if (name.equals("Christine")){
      this.traits = christineArray;
      this.image = imageList.getImage("christine"); 
    }
    else if (name.equals("Ernest")){
      this.traits = ernestArray;
      this.image = imageList.getImage("ernest"); 
    }
    else if (name.equals("Hannah")){
      this.traits = hannahArray;
      this.image = imageList.getImage("hannah"); 
    }
    else if (name.equals("Layla")){
      this.traits = laylaArray;
      this.image = imageList.getImage("layla"); 
    }
    else if (name.equals("Magnus")){
      this.traits = magnusArray;
      this.image = imageList.getImage("magnus"); 
    }
    else if (name.equals("Mary")){
      this.traits = maryArray;
      this.image = imageList.getImage("mary"); 
    }
    else if (name.equals("May")){
      this.traits = mayArray;
      this.image = imageList.getImage("may"); 
    }
    else if (name.equals("Mike")){
      this.traits = mikeArray;
      this.image = imageList.getImage("mike"); 
    }
    else if (name.equals("Mimi")){
      this.traits = mimiArray;
      this.image = imageList.getImage("mimi"); 
    }
    else if (name.equals("Ray")){
      this.traits = rayArray;
      this.image = imageList.getImage("ray"); 
    }
    else if (name.equals("Susan")){
      this.traits = susanArray;
      this.image = imageList.getImage("susan"); 
    }
    else if (name.equals("Ted")){
      this.traits = tedArray;
      this.image = imageList.getImage("ted"); 
    }
    else if (name.equals("Theo")){
      this.traits = theoArray;
      this.image = imageList.getImage("theo"); 
    }
    else throw problem;
  }
  
  //getters
  //returns name of person
  public String getName(){
    return name;
  }
  
  //returns traits array
  public boolean[] getArray(){
    return traits;
  }
  
  // returns image 
  public ImageIcon getImage() {
    return image; 
  }
  
  //returns true/false value of given trait (given as string keyword)
  public boolean getTrait(String trait) throws ElementNotFoundException{
    int t = getIndex(trait); //returns index value of given trait, can throw ElementNotFoundException
    return getTrait(t); //return boolean value at that index
  }
  
  //returns true/false value of given trait (given as index of array)
  public boolean getTrait(int t){
    return traits[t];
  }
  
  //setters
  //sets name of person to given string
  public void setName(String n){
    this.name = n;
  }
  
  //sets traits array to given array
  public void setArray(boolean[] array) throws IncorrectArrayException{
    IncorrectArrayException problem = new IncorrectArrayException("Array is incorrect length. Trait array must contain T/F values for all traits");
    if (traits.length == numTraits){
      this.traits = array;
    }
    else throw problem; //throw exception if given array is incorrect length
  }
  
  //sets given trait (given as string) to be given boolean value
  public void setTrait(String trait, boolean n) throws ElementNotFoundException{
    int t = getIndex(trait); //returns index value of given trait, can throw ElementNotFoundException
    setTrait(t,n); //sets that index of traits array to be given boolean value
  }
  
  //sets given trait (given as index) to be given boolean value
  public void setTrait(int t, boolean n){
    traits[t] = n; //sets given index of traits array to be given boolean value
  }
  
  // takes in question that has been dequeued 
  // returns string key mapping question to trait
  private String getQuestionKey(String question) {
    if (question.equals("Is this person male?")){
      return "male"; 
    }
    else if (question.equals("Does this person have facial hair?")){
      return "facial";
    }
    else if (question.equals("Is this person blonde?")){
      return "blonde"; 
    }
    else if (question.equals("Does this person have brown hair?")){
      return "brown"; 
    }
    else if (question.equals("Does this person wear glasses?")){
      return "glasses";
    }
    else if (question.equals("Is this person bald?")){
      return "bald"; 
    }
    else if (question.equals("Is this person wearing jewelry?")){
      return "jewelry"; 
    }
    else if (question.equals("Is this person wearing a hat?")){
      return "hat";
    }
    else if (question.equals("Does this person have red hair?")){
      return "red";
    }
    else{
      return "black";
    }
  }
  
  
  //gets index of trait given string keyword of trait
  public int getIndex(String trait) throws ElementNotFoundException{
    ElementNotFoundException problem = new ElementNotFoundException("Trait is not valid");
    if (trait.equals("male")){
      return male;
    }
    else if (trait.equals("bald")){
      return bald;
    }
    else if (trait.equals("glasses")){
      return glasses;
    }
    else if (trait.equals("jewelry")){
      return jewelry;
    }
    else if (trait.equals("blonde")){
      return blonde;
    }
    else if (trait.equals("brown")){
      return brown;
    }
    else if (trait.equals("facial")){
      return facial;
    }
    else if (trait.equals("hat")){
      return hat;
    }
    else if (trait.equals("red")){
      return red;
    }
    else if (trait.equals("black")){
      return black;
    }
    else throw problem; //if trait is not one of these listed, it is not in the traits array and is therefore invalid
  }
  
  //gets result of question; returns true/false value of trait
  public boolean getQuestionResult(String q) {
    String s = getQuestionKey(q); //get question keyword
    return getTrait(s); //get trait value of keyword
  }
  
  //returns string name of trait given index value of trait
  //for use in toString
  public String getTraitName(int t) throws ElementNotFoundException{
    ElementNotFoundException problem = new ElementNotFoundException("Trait is not valid");
    String[] traitNames = new String[]{"Male","Bald","Glasses","Jewelry","Blonde","Brown Hair","Facial Hair","Hat","Red Hair","Black Hair"}; //names of traits with corresponding indices to traits array
    if (t<numTraits){
      return traitNames[t]; //return corresponding name of trait if index is valid
    }
    else throw problem; //index is not a valid trait, so throw exception
  }
  
  //returns list of traits that are true for this person
  public LinkedList<String> trueTraits(){
    LinkedList<String> list = new LinkedList<String>(); //create new empty linked list to be populated with true traits
    for (int i = 0; i<numTraits; i++){ //go through all traits
      if (traits[i] == true){
        list.add(getTraitName(i)); //add trait to list if it is true
      }
    }
    return list; //return list of true traits
  }
  
  //returns list of traits that are false for this person
  public LinkedList<String> falseTraits(){
    LinkedList<String> list = new LinkedList<String>(); //create new empty linked list to be populated with false traits
    for (int i = 0; i<numTraits; i++){ //go through all traits
      if (traits[i] == false){
        list.add(getTraitName(i)); //add trait to list if it is false
      }
    }
    return list; //return list of false traits
  }
  
  //returns string representation of person object
  public String toString(){
    LinkedList<String> trueList = this.trueTraits(); //linked list of all true traits
    LinkedList<String> falseList = this.falseTraits(); //linked list of all false traits
    String result = "Name: " + name + "\n\n"; //name of person
    result = result + name + " has these traits (True traits):\n";
    if (trueList.size() == 0){
      result = result + "-none-\n"; //if no true traits, print -none-
    }
    else{
      for (int i = 0; i<trueList.size(); i++){
        result = result + trueList.get(i) + "\n"; //list of all true traits
      }
    }
    result = result + "\n" + name + " does not have these traits (False traits):\n";
    if (trueList.size() == 0){
      result = result + "-none-\n"; //if no false traits, print -none-
    }
    else{
      for (int j = 0; j<falseList.size(); j++){
        result = result + falseList.get(j) + "\n"; //list of all false traits
      }
    }
    result = result + "\n******\n";
    return result; //return string representation of person with their name, all true traits, and all false traits
  }
  
  public static void main(String[] args) throws IncorrectArrayException, NameNotFoundException, ImageNotFoundException{
    //create all 16 characters for Guess Who game
    Person bill = new Person("Bill");
    Person chantal = new Person("Chantal");
    Person chris = new Person("Chris");
    Person christine = new Person("Christine");
    Person ernest = new Person("Ernest");
    Person hannah = new Person("Hannah");
    Person layla = new Person("Layla");
    Person magnus = new Person("Magnus");
    Person mary = new Person("Mary");
    Person may = new Person("May");
    Person mike = new Person("Mike");
    Person mimi = new Person("Mimi");
    Person ray = new Person("Ray");
    Person susan = new Person("Susan");
    Person ted = new Person("Ted");
    Person theo = new Person("Theo");
    
    //print out to string for all the characters
    //prints true traits and false traits
    System.out.println(bill); //true: male, bald, glasses
    System.out.println(chantal); //true: glasses, brown hair
    System.out.println(chris); //true: male, bald, hat
    System.out.println(christine); //true: brown hair
    System.out.println(ernest); //true: male, bald, glasses, facial hair
    System.out.println(hannah); //true: red hair
    System.out.println(layla); //true: jewelry, black hair
    System.out.println(magnus); //true: male, brown hair, facial hair
    System.out.println(mary); //true: glasses, blonde, hat
    System.out.println(may); //true: glasses
    System.out.println(mike); //true: male, facial hair, black hair
    System.out.println(mimi); //true: glasses, hat, red hair
    System.out.println(ray); //true: male, red hair
    System.out.println(susan); //true: jewelry, blonde
    System.out.println(ted); //true: male, brown hair
    System.out.println(theo); //true: male, bald
  }
}