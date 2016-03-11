//********************************************************************
// Author: Sarah May
// Dec. 11, 2015

//  NameNotFoundException.java -- Called if the program inputs into
// 	a method a name that doesn't correspond with a character
//  GuessWho package 

//********************************************************************

public class NameNotFoundException extends Exception{
  //------------------------------------------------------------------
  //  Sets up this exception with an appropriate message.
  //------------------------------------------------------------------
  public NameNotFoundException (String message){
    super (message);
  }
}
