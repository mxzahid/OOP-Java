package lab03;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 * Testing class for Library.
 * 
 * 
 */
public class LibraryTest {

  public static void main(String[] args) {
	  
	 String holder = "Nothing";
	 String author = "Thomas L. Friedman";
	 String title = "The World is Flat";
	 long isbn = 9780374292799L;
	 
	 
	 String holder1 = "AZ";
	 String author1 = "Jon Krakauer";
	 String title1 = "Into the Wild";
	 long isbn1 = 9780330351690L;
	
	 GregorianCalendar dueDate = new GregorianCalendar();
	 LibraryBook first = new LibraryBook(isbn,author,title);
	 LibraryBook second = new LibraryBook(isbn1, author1, title1);
	 first.checkout(holder1, dueDate);
	// System.out.print("holder: " + holder1 + "\nDue Date: " + dueDate);
	 //System.out.print("\n" + second.equals(first));
	 
	 
	 
	 // lab03 - part 2 samples
	 // book1
	 //isbn:  9780374292799L
	 // author:  Thomas L. Friedman
	 // title: The World is Flat
	  
	 // book2
	 // isbn:  9780330351690L
	 // author:  Jon Krakauer
	 // title: Into the Wild	 
	 
	// lab03 - part 3 tests
	
	Library lib = new Library();
	
    if (lib.lookup(978037429279L) != null)
        System.err.println("TEST FAILED -- empty library: lookup(isbn)");	
	
    // test a small library - with four books in it
    lib.add(9780374292799L, "Thomas L. Friedman", "The World is Flat");
    lib.add(9780330351690L, "Jon Krakauer", "Into the Wild");
    lib.add(9780446580342L, "David Baldacci", "Simple Genius");	
	
    if (lib.lookup(9780330351690L) != null)
        System.err.println("TEST FAILED -- small library: lookup(isbn)");   
    
    lib.checkout(978037429279L, "Jane Doe", 1, 1, 2008);
    
    if (lib.lookup(9780330351690L) != null)
        System.err.println("TEST FAILED -- small library: lookup(isbn)");  
    
    System.out.println("Testing done.");
    
  }

}

