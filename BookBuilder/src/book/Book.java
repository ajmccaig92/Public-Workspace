package book;

import java.util.Comparator;

public class Book {
	private String title;
	private String author;
	private String publisher;
	private int pages;
	private long isbn;
	private double price;

	public Book(BookBuilder builder) {
		title = builder.title;
		author = builder.author;
		publisher = builder.publisher;
		pages = builder.pages;
		isbn = builder.isbn;
		price = builder.price;
	}

	@Deprecated	// @Deprecated annotation discourages use of the method, but still allows it to function.
	public Book(String title, String author, String publisher, int pages, long isbn, double price) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.pages = pages;
		this.isbn = isbn;
		this.price = price;
	}

	@Override	// @Override annotation checks spelling and argument matching with superclass version
	public String toString() {
		return String.format("Title:%-24s Author:%-15s Publisher:%-10s Pages:%4d ISBN:%013d Price:%6.2f",	title, author, publisher, pages, isbn, price);
	}

	// SINGLETON DESIGN PATTERN
	// Comparator interface ensures that each inner static class implements a compare() method.
	// The Collections.sort() method needs access to the specific compare() method.
	// Java won't allow sending a reference to a method, but it will allow a reference to an object.
	// Create an object that has access to a compare() method; capture object location as a static final reference.
	// Use the static final reference when calling Collections.sort().
	// The Colletions.sort() algorithm can access the compare() method using the object reference.
	public static class CompareTitle implements Comparator<Book> {
		// No CompareTitle object will be created if instance variable never used.
		public final static CompareTitle instance = new CompareTitle(); // final static is key to making this a SINGLETON
		private CompareTitle() { } // private keyword prevents creation of CompareTitle objects outside the class
		@Override	// Comparator interface enforces requirement that a compare() method be implemented.
		public int compare(Book book1, Book book2)	{	return book1.title.compareTo(book2.title);	}
	} // end class CompareTitle

	public static class CompareAuthor implements Comparator<Book> {
		// class that implements the Comparator interface will implement compare() using sAuthor
	} // end class CompareAuthor

	public static class ComparePages implements Comparator<Book> {
		// class that implements the Comparator interface will implement compare() using nPages
	} // end class ComparePages

	public static class CompareISBN implements Comparator<Book> {
		// class that implements the Comparator interface will implement compare() using lISBN
	} // end class CompareISBN

	public static class ComparePrice implements Comparator<Book> {
		// class that implements the Comparator interface will implement compare() using dPrice
	} // end class ComparePrice
} // end class Book