//********************************************************************
// Author: Sarah May
// Dec. 11, 2015

//  ImageNotFoundException.java -- Called if the image corresponding 
//  to an inputed character name is not found  
//  GuessWho package 

//********************************************************************

public class ImageNotFoundException extends Exception{
  //------------------------------------------------------------------
  //  Sets up this exception with an appropriate message.
  //------------------------------------------------------------------
  public ImageNotFoundException (String message){
    super (message);
  }
}
