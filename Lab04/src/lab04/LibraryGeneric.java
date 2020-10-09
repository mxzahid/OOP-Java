package lab04;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.Comparator;

/**
 * Class representation of a library (a collection of library books).
 * 
 */
public class LibraryGeneric<Type> {
	
	 /**
	   * Returns the list of library books, sorted by ISBN (smallest ISBN first).
	   */
	  public ArrayList<LibraryBookGeneric<Type>> getInventoryList() {
	    ArrayList<LibraryBookGeneric<Type>> libraryCopy = new ArrayList<LibraryBookGeneric<Type>>();
	    libraryCopy.addAll(library);

	    OrderByIsbn comparator = new OrderByIsbn();

	    sort(libraryCopy, comparator);

	    return libraryCopy;
	  }
	  
	  /**
	   * Performs a SELECTION SORT on the input ArrayList. 
	   *    1. Find the smallest item in the list. 
	   *    2. Swap the smallest item with the first item in the list. 
	   *    3. Now let the list be the remaining unsorted portion 
	   *       (second item to Nth item) and repeat steps 1, 2, and 3.
	   */
	  private static <ListType> void sort(ArrayList<ListType> list,
	      Comparator<ListType> c) {
	    for (int i = 0; i < list.size() - 1; i++) {
	      int j, minIndex;
	      for (j = i + 1, minIndex = i; j < list.size(); j++)
	        if (c.compare(list.get(j), list.get(minIndex)) < 0)
	          minIndex = j;
	      ListType temp = list.get(i);
	      list.set(i, list.get(minIndex));
	      list.set(minIndex, temp);
	    }
	  }

	  /**
	   * Comparator that defines an ordering among library books using the ISBN.
	   */
	  protected class OrderByIsbn implements Comparator<LibraryBookGeneric<Type>> {

		  @Override
		  public int compare(LibraryBookGeneric<Type> T1, LibraryBookGeneric<Type> T2)
		  {
			  if(T1.getIsbn() < T2.getIsbn())
			  {
				  return 1;
			  }
			  else if(T1.getIsbn() < T2.getIsbn())
			  {
				  return -1;
			  }
			  else 
				  return 0;
		  }
	 	// FILL IN - write the compare method
	  }

	  /**
	   * Returns the list of library books, sorted by author
	   */
	  
	  public ArrayList<LibraryBookGeneric<Type>> getOrderedByAuthor() {
		  
		  ArrayList<LibraryBookGeneric<Type>> authorNL = new ArrayList<LibraryBookGeneric<Type>>();
		      authorNL.addAll(library);
		      OrderByAuthor comparator = new OrderByAuthor();
		      sort(authorNL, comparator);
		      return authorNL;
		      
		 
	    // FILL IN -- do not return null	  
	  }
	  

	  /**
	   * Returns the list of library books whose due date is older than the input
	   * date. The list is sorted by date (oldest first).
	   *
	   * If no library books are overdue, returns an empty list.
	   */
	  
	  public ArrayList<LibraryBookGeneric<Type>> getOverdueList(int month, int day,
	      int year) {
		  
		 ArrayList<LibraryBookGeneric<Type>> duedateNL = new ArrayList<LibraryBookGeneric<Type>>();
		 GregorianCalendar newduedate = new GregorianCalendar();
		 newduedate.set(year,month, day);
		 for(int i =0; i<library.size(); i++)
		 {
			 if(library.get(i).dueDate != null)
			 {
				 
				 if(library.get(i).dueDate.compareTo(newduedate) > 0)
				 {
					 duedateNL.add(library.get(i));
				 }	
			 }
		 }	
		 
		 OrderByDueDate comparator = new OrderByDueDate();
		 sort(duedateNL,comparator);
		 return duedateNL;
		 
	    // FILL IN -- do not return null
	  }
	  

	 /**
	   * Comparator that defines an ordering among library books using the author,  and book title as a tie-breaker.
	   */
	  
	  protected class OrderByAuthor implements 
	Comparator<LibraryBookGeneric<Type>> {
         public int compare(LibraryBookGeneric<Type> author1, LibraryBookGeneric<Type> author2)
         {
        	 if (author1.getAuthor().compareTo(author2.getAuthor()) == 0)
        	 {
        		 if(author1.getTitle().compareTo(author2.getTitle()) > 0)
        		 {
        			 return 1;
        			 
        		 }
        		 else 
        		 {
        			 return -1;
        		 }
        	 }
        	 else if (author1.getAuthor().compareTo(author2.getAuthor()) > 0)
        	 {
        		 return 1;
        	 }
        	 else 
        	 {
        		 return -1;
        	 }
         }
         
	    // FILL IN - write the compare method
	  }
	  

	  /**
	   * Comparator that defines an ordering among library books using the due date.
	   */
	  
	  protected class OrderByDueDate implements Comparator<LibraryBookGeneric<Type>> {

		  public int compare(LibraryBookGeneric<Type> overduebook1, LibraryBookGeneric<Type> overduebook2)
		  {
			  if (overduebook1.dueDate.compareTo(overduebook2.dueDate) == 0)
			  {
				  return 0;
			  }
			  else if (overduebook1.dueDate.compareTo(overduebook2.dueDate) > 0)
			  {
				 return 1; 
			  }
			  else 
			  {
				  return -1;
			  }
		  }
	    // FILL IN - write the compare method
	   	  
	  }
	 


  private ArrayList<LibraryBookGeneric<Type>> library;

  public LibraryGeneric(){
    library = new ArrayList<LibraryBookGeneric<Type>>();
  }

  /**
   * Add the specified book to the library, assume no duplicates.
   * 
   * @param isbn --
   *          ISBN of the book to be added
   * @param author --
   *          author of the book to be added
   * @param title --
   *          title of the book to be added
   */
  public void add(long isbn, String author, String title) {
    library.add(new LibraryBookGeneric<Type>(isbn, author, title));
  }
  

  /**
   * Add the list of library books to the library, assume no duplicates.
   * 
   * @param list --
   *          list of library books to be added
   */
  public void addAll(ArrayList<LibraryBookGeneric<Type>> list) {
    library.addAll(list);
  }

  /**
   * Add books specified by the input file. One book per line with ISBN, author,
   * and title separated by tabs.
   * 
   * If file does not exist or format is violated, do nothing.
   * 
   * @param filename
   */
  public void addAll(String filename) {
    ArrayList<LibraryBookGeneric<Type>> toBeAdded = new ArrayList<LibraryBookGeneric<Type>>();

    try {
      Scanner fileIn = new Scanner(new File(filename));
      int lineNum = 1;

      while (fileIn.hasNextLine()) {
        String line = fileIn.nextLine();

        Scanner lineIn = new Scanner(line);
        lineIn.useDelimiter("\\t");

        if (!lineIn.hasNextLong())
          throw new ParseException("ISBN", lineNum);
        long isbn = lineIn.nextLong();

        if (!lineIn.hasNext())
          throw new ParseException("Author", lineNum);
        String author = lineIn.next();

        if (!lineIn.hasNext())
          throw new ParseException("Title", lineNum);
        String title = lineIn.next();

        toBeAdded.add(new LibraryBookGeneric<Type>(isbn, author, title));

        lineNum++;
      }
    } catch (FileNotFoundException e) {
      System.err.println(e.getMessage() + " Nothing added to the library.");
      return;
    } catch (ParseException e) {
      System.err.println(e.getLocalizedMessage()
          + " formatted incorrectly at line " + e.getErrorOffset()
          + ". Nothing added to the library.");
      return;
    }

    library.addAll(toBeAdded);
  }

  /**
   * Returns the holder of the library book with the specified ISBN.
   * If no book with the specified ISBN is in the library, returns null.
   * 
   * @param isbn --
   *          ISBN of the book to be looked up
   */
  public Type lookup(long isbn) {
	 // *FILL IN -- do not return null unless appropriate
	  
	 for (int i = 0; i < library.size(); i++)
	 {
		 if (isbn == library.get(i).getIsbn())
		 {
			 return library.get(i).getHolder();
		 }
	 }

    return null;
  }



  /**
   * Sets the holder and due date of the library book with the specified ISBN.
   * If no book with the specified ISBN is in the library, returns false.
   * If the book with the specified ISBN is already checked out, returns false.
   * Otherwise, returns true.
   * 
   * @param isbn --
   *          ISBN of the library book to be checked out
   * @param holder --
   *          new holder of the library book
   * @param month --
   *          month of the new due date of the library book
   * @param day --
   *          day of the new due date of the library book
   * @param year --
   *          year of the new due date of the library book
   */
  public boolean checkout(long isbn, Type holder, int month, int day, int year) {
    // *FILL IN -- do not return false unless appropriate
	  for (int i = 0; i < library.size(); i++)
		 {
			 if (isbn == library.get(i).getIsbn())
			 {
				 if (library.get(i).getDueDate() == null)
				 {
					 library.get(i).holder = holder;
					 library.get(i).dueDate = new GregorianCalendar(year,month,day);
					 return true;
				 }
				 else 
					 return false;
			 }
			 
		 }
	
    return false;
  }
  
  // *** you will implement the rest of the methods for your assignment
  // *** don't touch them before finishing the lab portion
 
  /**
   * Returns the list of library books checked out to the specified holder.
   * 
   * If the specified holder has no books checked out, returns an empty list.
   * 
   * @param holder --
   *          holder whose checked out books are returned
   */
  public ArrayList<LibraryBookGeneric<Type>> lookup(Type holder) {
	  
	  ArrayList<LibraryBookGeneric<Type>> CheckedOut = new ArrayList<LibraryBookGeneric<Type>>();
	  for(int i = 0; i < library.size(); i++) 
	  {
		  if(library.get(i).holder == holder)
		  {
			  CheckedOut.add(library.get(i));
		  }
	  }
	  return CheckedOut;
  
	
	  
    // FILL IN -- do not return null
	  }  

  /**
   * Unsets the holder and due date of the library book.
   * If no book with the specified ISBN is in the library, returns false.
   * If the book with the specified ISBN is already checked in, returns false.
   * Otherwise, returns true.
   * 
   * @param isbn --
   *          ISBN of the library book to be checked in
   */
  public boolean checkin(long isbn) {
	  
	  for (int i = 0; i<library.size(); i++) 
	  
	  {
		  if(library.get(i).getIsbn() == isbn)
		  {
		  if(library.get(i).getDueDate() == null) 
		  {
		  return false;
		  }
		  else
		  {
		  library.get(i).dueDate = null;
		  library.get(i).holder = null;
		  return true;
		  }
	}
  }
		  return false;
}
    // FILL IN -- do not return false unless appropriate

  /**
   * Unsets the holder and due date for all library books checked out by the
   * specified holder.
   * If no books with the specified holder are in the library, returns false;
   * Otherwise, returns true.
   * 
   * @param holder --
   *          holder of the library books to be checked in
   */
  public boolean checkin(Type holder) {
	  
	  ArrayList <LibraryBookGeneric<Type>> nullify = new ArrayList<LibraryBookGeneric<Type>>();
	  for(int i = 0; i<library.size(); i++) {
	  if(library.get(i).getHolder() == holder) {
	  nullify.add(library.get(i));
	  }
	  }
	  if(nullify.size() != 0) {
	  for(int y = 0; y < nullify.size(); y++) {
	  nullify.get(y).holder = null;
	  nullify.get(y).dueDate = null;
	  }
	  return true;
	  }
	  else
	  return false;
	  }
	}