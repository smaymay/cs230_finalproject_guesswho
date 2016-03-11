//********************************************************************
// Author: Katie Morris
// Modifications by: Sarah May
// Dec. 10, 2015

//  GuessWhoPlayer.java -- The user's end of a single game -- contains
// 	the question queue, the list of characters that are possibilities 
// 	as the computer's choice, the list of characters that have 
// 	been eliminated, and both the player's and computer's characters
//  GuessWho package 

//********************************************************************

import javafoundations.*;
import java.util.*;

public class GuessWhoPlayer{
  //instance variables
  private Person playerChoice; //character that the player chose
  private Person compChoice; //character that the computer chose (random)
  private LinkedList<Person> possibilities; //list of characters that have not yet been eliminated
  private LinkedList<Person> eliminated; //list of eliminated characters
  private int numLeft; //number of possibilities remaining
  private LinkedQueue<String> questions; //queue containing all unasked questions
  final static private int INITIAL = 16; //initial number of characters
  
  
  //constructor
  public GuessWhoPlayer(String s) throws IncorrectArrayException, NameNotFoundException, ImageNotFoundException{
    playerChoice = new Person(s); //character that the user chose in ChooseCharacterGUI, taken is as a parameter
    compChoice = randomPerson(); //random character that is assigned to the computer's choice
    
    //set initial values of possibilites, eliminated, numLeft, and questions
    //possibilities is all possible characters, eliminated is empty
    //numLeft is num of initial characters, and questions is all possible questions
    setInitial();
  }
  
  //getters
  //returns the player's person
  public Person getPlayerChoice(){
    return playerChoice;
  }
  
  //returns the computer's person
  public Person getCompChoice(){
    return compChoice;
  }
  
  //returns linked list containing person objects that have not yet been eliminated
  public LinkedList<Person> getPossibilities(){
    return possibilities;
  }
  
  
  // returns linked list containing person objects that have been eliminated
  public LinkedList<Person> getEliminated() {
    return eliminated;
  }
  
  //returns number of faces that are still possibilities
  public int getNumLeft(){
    return numLeft;
  }
  
  //returns queue of questions that have not yet been asked
  public LinkedQueue<String> getQuestions(){
    return questions;
  }
  
  //setters
  //sets the player's person to the given person object
  public void setPlayerChoice(Person p){
    playerChoice = p;
  }
  
  //sets the computer's person to the given person object
  public void setCompChoice(Person p){
    compChoice = p;
  }
  
  
  //sets possibilities to be given list and sets numLeft to be number of person objects within that list
  public void setPossibilites(LinkedList<Person> list) throws IncorrectArrayException, NameNotFoundException, ImageNotFoundException{
    possibilities = list; //possibilities set to given list
    numLeft = list.size(); //numLeft set to  number of characters in given list
    LinkedList<Person> allCharacters = allCharacters(); //list of all possible characters
    eliminated = new LinkedList<Person>(); //eliminated list reset
    for (int i = 0; i < INITIAL; i++){
      if (! list.contains(allCharacters.get(i))){
        eliminated.add(allCharacters.get(i)); //all characters that are not in given possibilities list are added to eliminated list
      }
    }
  }
  
  //sets questions to be given queue
  public void setQuestions(LinkedQueue<String> lq){
    questions = lq;
  }
  
  //sets instance variables to be initial values of all possible characters and questions
  public void setInitial() throws IncorrectArrayException, NameNotFoundException, ImageNotFoundException{
    this.possibilities = allCharacters(); //all possible characters
    this.numLeft = INITIAL; //initial value for number of possibilities (16)
    this.questions = allQuestions(); //all possible questions
    this.eliminated = new LinkedList<Person>(); //intially no eliminated characters
  }
  
  //list of all 16 possible characters
  private LinkedList<Person> allCharacters() throws IncorrectArrayException, NameNotFoundException, ImageNotFoundException{
    LinkedList<Person> characters = new LinkedList<Person>(); //create empty linked list to be populated with characters
    
    //create all 16 characters
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
    
    //add all 16 characters to list
    characters.add(bill);
    characters.add(chantal);
    characters.add(chris);
    characters.add(christine);
    characters.add(ernest);
    characters.add(hannah);
    characters.add(layla);
    characters.add(magnus);
    characters.add(mary);
    characters.add(may);
    characters.add(mike);
    characters.add(mimi);
    characters.add(ray);
    characters.add(susan);
    characters.add(ted);
    characters.add(theo);
    
    return characters; //return list of all 16 characters as person objects
  }
  
  //returns list of all possible questions (none yet asked)
  public LinkedQueue<String> allQuestions(){
    LinkedQueue<String> allQuestions = new LinkedQueue<String>(); //create new empty queue to be populated with questions
    
    //add all questions to queue
    allQuestions.enqueue("Is this person male?");
    allQuestions.enqueue("Does this person have red hair?");
    allQuestions.enqueue("Is this person wearing a hat?");
    allQuestions.enqueue("Does this person have facial hair?");
    allQuestions.enqueue("Is this person blonde?");
    allQuestions.enqueue("Does this person wear glasses?");
    allQuestions.enqueue("Is this person bald?");
    allQuestions.enqueue("Does this person have brown hair?");
    allQuestions.enqueue("Is this person wearing jewelry?");
    allQuestions.enqueue("Does this person have black hair?");
    
    return allQuestions; //return queue of questions
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
  
  //selects random character from list of allCharacters
  //returns random character to be set as the computer's choice
  public Person randomPerson() throws IncorrectArrayException, NameNotFoundException, ImageNotFoundException{
    LinkedList<Person> characters = allCharacters(); //list of all possible characters
    Random rand = new Random();
    int x = rand.nextInt(INITIAL); //generate random integer between 0 and Initial-1
    Person p = characters.get(x); //get character at that index in list of all characters
    return p; //return selected character
  }
  
  //removes all characters do not match given boolean for given trait from possibilities list
  public LinkedList<Person> eliminate(String t, boolean x){
    int n = numLeft; //numLeft at beginning
    for (int i = n-1; i >= 0; i--){ //cycles through all possibilities backwards
      Person a = possibilities.get(i); //gets person object at each index of possibilities list
      if (a.getTrait(t) != x){
        eliminateCharacter(a); //eliminate character if they do not match given trait
      }
    }
    return eliminated; //return list of eliminated characters
  }
  
  //removes given character from possibilities list and adds it to eliminated list
  private void eliminateCharacter(Person a){
    possibilities.remove(a); //remove first instance of given person object from list
    eliminated.add(a); // add to eliminated linked list 
    numLeft--; //subtract one from count of number of possibilities
  }
  
  //gets question from top of queue
  public String getQuestion() {
    return questions.first(); //returns element at top of queue
  }
  
  //removes next question from queue and returns it
  //does not replace question into queue
  public String askQuestion(){
    String q = questions.dequeue(); //remove next question from queue
    return getQuestionKey(q); //return this trait corresponding to the question that was asked
  }
  
  //Takes a question from top of queue and moves it to the end of the queue 
  public void nextQuestion(){
    String q = questions.dequeue(); //remove next question from queue
    questions.enqueue(q); //put removed question back at end of queue
  }
  
  //checks if game is over (only one possibility remaining) and returns boolean value
  public boolean isEnd(){
    boolean end;
    if (numLeft == 1){
      end = true; //true if only one possibility is remaining, game is over
    }
    else{
      end = false; //otherwise game is not over
    }
    return end; //return boolean representing if game is over or not
  }
  
  //returns a string representation of the game
  //list of the names of remaining possible characters and list of all the questions that have yet to be asked
  public String toString(){
    int elim = INITIAL - numLeft; //number of characters that have been elimiinated
    String result = "";
    result = result + elim + " characters have been eliminated. There are " + numLeft + " possibilites remaining:\n";
    for (int i = 0; i < numLeft; i++){
      result = result + possibilities.get(i).getName() + "\n"; //list of names of all possibilities remaining
    }
    result = result + "\nQuestions that have not yet been asked:\n";
    result = result + questions.toString(); //list of questions that have not yet been asked
    result = result +"\n\n******\n";
    return result; //return string representation of game
  }
  
  //returns a string representation of the game which lists the traits of each character instead of just their name
  public String toStringTraits(){
    int elim = INITIAL - numLeft; //number of characters that have been eliminated
    String result = "";
    result = result + elim + " characters have been eliminated. There are " + numLeft + " possibilites remaining:\n";
    for (int i = 0; i < numLeft; i++){
      result = result + possibilities.get(i).toString() + "\n"; //list of names and traits of all possibilities remaining
    }
    result = result + "\nQuestions that have not yet been asked:\n";
    result = result + questions.toString(); //list of questions that have not yet been asked
    result = result +"\n\n******\n";
    return result; //return string representation of game
  }
  
  public static void main(String[] args){
    try{
      GuessWhoPlayer game = new GuessWhoPlayer("bill"); //create new game where player's choice is Bill
      System.out.println(game); //all characters and questions remaining (none yet been asked, none yet been eliminated)
      game.askQuestion(); //ask top questions (is male?), removes this question from list
      game.eliminate("male",false); //eliminates all men
      System.out.println(game.getEliminated()); //returns list of men
      System.out.println(game); //returns list of remaining characters (all women) and questions (all but is male)
//      Person p = game.randomPerson(); //generate random person
//      Person p2 = game.randomPerson(); //generate random person
//      System.out.println(p.toString()); //print out name and traits of first random person
//      System.out.println(p2.toString()); //print out name and traits of second random person
    }
    catch (Exception problem){
      System.out.println("There was an error in game creation.  Please try again.\n" + problem); //if any exception happens
    }
  }
}