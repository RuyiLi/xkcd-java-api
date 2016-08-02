package me.ruyili.test;

import java.io.File;
import java.io.IOException;

import me.ruyili.xkcd;

public class Test {
	public static void main(String[] args){
		
		try {
			// Getting the alt of the comic strip, in this case the strip on page 789
			System.out.println(xkcd.getAlt(789));
		
			// Getting the image file of the comic strip on page 789
			File sevenAteNine = xkcd.getImageFile(789);
			
			// Get the URL of the image on page 789
			System.out.println(xkcd.getImageURL(789));
			
			// Get the URL of the latest xkcd comic
			System.out.println(xkcd.getNewestURL());
			
			// Get an image file of the newest xkcd comic
			File late = xkcd.getNewestImageFile();
			
			// Get the title of the comic on page 789
			System.out.println(xkcd.getTitle(789));
			
			// Returns the latest xkcd comic's page number
			System.out.println(xkcd.getNewestPageNumber());
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
