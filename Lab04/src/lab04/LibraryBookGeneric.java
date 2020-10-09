package lab04;

import java.util.GregorianCalendar;

public class LibraryBookGeneric<Type> extends Book{
	
	public Type holder;
	public GregorianCalendar dueDate;
	public LibraryBookGeneric(long isbn, String author, String title)
	{
		super(isbn, author, title);	
	}
	
	
	public Type getHolder()
	{
		return this.holder;
	}
	
	public GregorianCalendar getDueDate()
	
	{
		return this.dueDate;
	}
	
	public void checkin()
	{
		holder = null;
		dueDate = null;		
	}
	
	public void checkout(Type holder, GregorianCalendar dueDate)
	{
		this.holder = holder;
		this.dueDate = dueDate;
	}
}

