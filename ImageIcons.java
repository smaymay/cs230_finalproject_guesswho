//********************************************************************
// Author: Sarah May
// Modified by: Katie Morris
// Dec. 11, 2015

// Last mod: Dec 14, 2015

//  ImageIcons.java -- Contains all of the images associated 
// 	with the characters and methods for accessing those images 
//  GuessWho package 

//********************************************************************

import javax.swing.ImageIcon;

/*
 * Class that holds all of the image icons as private variables
 * 
 */

public class ImageIcons {

	// images that correspond to each character
	private ImageIcon billImage = new ImageIcon(getClass().getResource("/character/Bill.png"));
	private ImageIcon chantalImage = new ImageIcon(getClass().getResource("/character/Chantal.png"));
	private ImageIcon chrisImage = new ImageIcon(getClass().getResource("/character/Chris.png"));
	private ImageIcon christineImage = new ImageIcon(getClass().getResource("/character/Christine.png"));
	private ImageIcon ernestImage = new ImageIcon(getClass().getResource("/character/Ernest.png"));
	private ImageIcon laylaImage = new ImageIcon(getClass().getResource("/character/Layla.png"));
	private ImageIcon magnusImage = new ImageIcon(getClass().getResource("/character/Magnus.png"));
	private ImageIcon maryImage = new ImageIcon(getClass().getResource("/character/Mary.png"));
	private ImageIcon mayImage = new ImageIcon(getClass().getResource("/character/May.png"));
	private ImageIcon mikeImage = new ImageIcon(getClass().getResource("/character/Mike.png"));
	private ImageIcon mimiImage = new ImageIcon(getClass().getResource("/character/Mimi.png"));
	private ImageIcon rayImage = new ImageIcon(getClass().getResource("/character/Ray.png"));
	private ImageIcon susanImage = new ImageIcon(getClass().getResource("/character/Susan.png"));
	private ImageIcon tedImage = new ImageIcon(getClass().getResource("/character/Ted.png"));
	private ImageIcon theoImage = new ImageIcon(getClass().getResource("/character/Theo.png"));
	private ImageIcon hannahImage = new ImageIcon(getClass().getResource("/character/Hannah.png"));


	/**
	 * 
	 * @param name Input string name 
	 * @return ImageIcon image corresponding to character name
	 * @throws ImageNotFoundException name is not recognized/doesn't correspond
	 * to an image
	 */
	public ImageIcon getImage(String name) throws ImageNotFoundException {

		if (name.equals("bill")) {
			return billImage;
		} else if (name.equals("chantal")) {
			return chantalImage;
		} else if (name.equals("chris")) {
			return chrisImage;
		} else if (name.equals("christine")) {
			return christineImage;
		} else if (name.equals("ernest")) {
			return ernestImage;
		} else if (name.equals("hannah")) {
			return hannahImage;
		} else if (name.equals("layla")) {
			return laylaImage;
		} else if (name.equals("magnus")) {
			return magnusImage;
		} else if (name.equals("mary")) {
			return maryImage;
		} else if (name.equals("may")) {
			return mayImage;
		} else if (name.equals("mike")) {
			return mikeImage;
		} else if (name.equals("mimi")) {
			return mimiImage;
		} else if (name.equals("ray")) {
			return rayImage;
		} else if (name.equals("susan")) {
			return susanImage;
		} else if (name.equals("ted")) {
			return tedImage;
		} else if (name.equals("theo")) {
			return theoImage;
		} else
			throw new ImageNotFoundException("String does not correspond to an image");
	}
}
