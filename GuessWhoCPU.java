//********************************************************************
//Author: Jordan Sessa
// Dec. 12, 2015

// GuessWhoCPU.java -- Contains the binary decision tree with
// questions as the non-leaf nodes and characters as the leaves 
// also has methods for traversing, printing current element, 
// and returning the number of leaves 
//  GuessWho package 

//********************************************************************

import javafoundations.*; 
import java.util.*; 

public class GuessWhoCPU {
  // private Person PlayerChar;
  private LinkedBinaryTree<String> theTree; //creates an instance variable to hold the question tree
  
  public GuessWhoCPU() {
    //makes all of the leaves of the tree new linkedBinaryTrees that will be added together using a constructor
    LinkedBinaryTree<String> t1 = new LinkedBinaryTree<String>("Ernest");
    LinkedBinaryTree<String> t2 = new LinkedBinaryTree<String>("Bill"); 
    LinkedBinaryTree<String> t3 = new LinkedBinaryTree<String>("Chris"); 
    LinkedBinaryTree<String> t4 = new LinkedBinaryTree<String>("Theo"); 
    LinkedBinaryTree<String> t5 = new LinkedBinaryTree<String>("Magnus");
    LinkedBinaryTree<String> t6 = new LinkedBinaryTree<String>("Ted"); 
    LinkedBinaryTree<String> t7 = new LinkedBinaryTree<String>("Mike"); 
    LinkedBinaryTree<String> t8 = new LinkedBinaryTree<String>("Ray"); 
    LinkedBinaryTree<String> t9 = new LinkedBinaryTree<String>("Marie");
    LinkedBinaryTree<String> t10 = new LinkedBinaryTree<String>("Mimi"); 
    LinkedBinaryTree<String> t11 = new LinkedBinaryTree<String>("Chantal"); 
    LinkedBinaryTree<String> t12 = new LinkedBinaryTree<String>("May"); 
    LinkedBinaryTree<String> t13 = new LinkedBinaryTree<String>("Susan");
    LinkedBinaryTree<String> t14 = new LinkedBinaryTree<String>("Layla"); 
    LinkedBinaryTree<String> t15 = new LinkedBinaryTree<String>("Christine"); 
    LinkedBinaryTree<String> t16 = new LinkedBinaryTree<String>("Hannah"); 
    
    //adds the leaves to the left and right of the proper questions using the LinkedBinaryTree constructor
    LinkedBinaryTree<String> t17 = new LinkedBinaryTree<String>("Does this person have facial hair?", t1, t2);
    LinkedBinaryTree<String> t18 = new LinkedBinaryTree<String>("Is this person wearing a hat?", t3, t4);
    LinkedBinaryTree<String> t19 = new LinkedBinaryTree<String>("Does this person have facial hair?", t5, t6);
    LinkedBinaryTree<String> t20 = new LinkedBinaryTree<String>("Does this person have facial hair?", t7, t8);
    LinkedBinaryTree<String> t21 = new LinkedBinaryTree<String>("Is this person blonde?", t9, t10);
    LinkedBinaryTree<String> t22 = new LinkedBinaryTree<String>("Does this person have brown hair?", t11, t12);
    LinkedBinaryTree<String> t23 = new LinkedBinaryTree<String>("Is this person blonde?", t13, t14);
    LinkedBinaryTree<String> t24 = new LinkedBinaryTree<String>("Does this person have brown hair?", t15, t16);
    
    LinkedBinaryTree<String> t25 = new LinkedBinaryTree<String>("Does this person wear glasses?", t17, t18);
    LinkedBinaryTree<String> t26 = new LinkedBinaryTree<String>("Does this person have brown hair?", t19, t20);
    LinkedBinaryTree<String> t27 = new LinkedBinaryTree<String>("Is this person wearing a hat?", t21, t22);
    LinkedBinaryTree<String> t28 = new LinkedBinaryTree<String>("Is this person wearing jewelry?", t23, t24);
    
    LinkedBinaryTree<String> t29 = new LinkedBinaryTree<String>("Is this person bald?", t25, t26);
    LinkedBinaryTree<String> t30 = new LinkedBinaryTree<String>("Does this person wear glasses?", t27, t28);
    
    //sets the completed tree as the theTree instance variable
    theTree = new LinkedBinaryTree<String>("Is this person male?", t29, t30);
  }
  
  //prints out the tree in levelOrder
  public String toString() {
    String result = ""; 
    Iterator<String> iterator = theTree.levelorder(); 
    while (iterator.hasNext())
      result += iterator.next() + "/n";
    return result; 
  }
  
  //returns the root of the current tree
  public String getCurrent(){
    return theTree.getRootElement();
  }
  
  //sets the root of the new tree to be the right node of the previous tree's root
  public void goRight(){
    theTree = theTree.getRight();
  }
  
  //sets the root of the new tree to be the left node of the previous tree's root
  public void goLeft(){
    theTree = theTree.getLeft(); 
  }
  
  //determines if the root of the current tree is a leaf
  public boolean isLeaf(){
    return(theTree.getLeft() == null && theTree.getRight() == null); 
  }
  
  //counts the leaves of the current tree
  public int getNumResults() {
    return theTree.countLeaves();
  }
  
  public static void main(String[] args){
    GuessWhoCPU a = new GuessWhoCPU();
    //System.out.println(a.toString());
    System.out.println(a.getCurrent());
    a.goLeft();
    System.out.println(a.getCurrent());
    System.out.println(a.isLeaf());
    System.out.println(a.getNumResults());
    
    // a.queryTree();
    
    //System.out.println(a.toString());  
  }
}