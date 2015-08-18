package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import book.Book;
import book.BookBuilder;

public class TestBook {
	public static void main(String[] args) {
		// Uses the builder-pattern to create new Book objects. Only selected values need be initialized.
		// Unknown values are skipped.
		Book bookTheBelgariad = BookBuilder.create().title("The Belgariad").author("Eddings, David").pages(1823).isbn(144056789000L).price(99.99).build();
		Book bookMasterCPlusPlus = BookBuilder.create().title("Master C++").author("Woollard, Rex").build();
		Book bookWebstersDictionary = BookBuilder.create().title("Webster's Dictionary").build();
		Book bookTheBible = BookBuilder.create().title("The Bible").isbn(1).build();

		// When building multiple Book objects with some common values, re-use a single BookBuilder object
		// In this case, the single BookBuilder object is populated with author and publisher
		BookBuilder rowlingsBookBuilder = BookBuilder.create().author("Rowlings, J.K.").publisher("Bloomsbury").price(34.95);
		// use the single BookBuilder object repeatedly to create Book objects which have only minor variations 
		Book bookPhilosophersStone = rowlingsBookBuilder.title("The Philosopher's Stone").build();
		Book bookChamberOfSecrets = rowlingsBookBuilder.title("The Chamber of Secrets").pages(345).build();
		Book bookPrisonerOfAzkaban = rowlingsBookBuilder.title("The Prisoner of Azkaban").build();
		
		BookBuilder tolkeinBookBuilder = BookBuilder.create().author("Tolkein, J.R.R.").publisher("Penguin");
		Book bookLordOfTheRings = tolkeinBookBuilder.title("Lord of the Rings").pages(1178).isbn(123456789012L).price(123.45).build();
		Book bookTheHobbit = tolkeinBookBuilder.title("The Hobbit").isbn(100056789000L).price(98.76).build();

		// Uses the constructor-style to create new Book objects. All arguments must be present, whether or
		// not they are needed. The Book constructor has been annotated with @Deprecated as a
		// mechanism to discourage its use, but retain the functionality.
		Book bookTheMallorean = new Book("The Mallorean", "Eddings, David", "New Line", 1940, 146758906640L, 88.88);
		// don't know page count, or isbn number but must enter a value
		Book bookGobletOfFire = new Book("The Goblet of Fire", "Rowlings, J.K.", "Bloomsbury", 0, 0L, 34.95); 
		Book bookOrderOfThePhoenix = new Book("Order of the Phoenix", "Rowlings, J.K.", "Bloomsbury", 0, 0L, 39.95); 
		Book bookHalfBloodPrince = new Book("Half Blood Prince", "Rowlings, J.K.", "Bloomsbury", 823, 0L, 37.95); 
		Book bookDeathlyHallows = new Book("Deathly Hallows", "Rowlings, J.K.", "Bloomsbury", 798, 0L, 42.95); 

		// store all books in a List Collection which can be sorted.
		// The Book objects could have been created directly using the listBooks.add() method call,
		// but were created independently for greater clarity in this example
		List<Book> listBooks = new ArrayList<Book>();
		listBooks.add(bookTheHobbit);
		listBooks.add(bookLordOfTheRings);
		listBooks.add(bookTheBelgariad);
		listBooks.add(bookTheMallorean);
		listBooks.add(bookPhilosophersStone);
		listBooks.add(bookChamberOfSecrets);
		listBooks.add(bookPrisonerOfAzkaban);
		listBooks.add(bookGobletOfFire);
		listBooks.add(bookOrderOfThePhoenix);
		listBooks.add(bookHalfBloodPrince);
		listBooks.add(bookDeathlyHallows);
		listBooks.add(bookMasterCPlusPlus);
		listBooks.add(bookWebstersDictionary);
		listBooks.add(bookTheBible);

		System.out.println("Original Order");
		for (Book book : listBooks)
			System.out.println(book);

		// Sort using Title as the key
		// sort() is a static method in the Collections class; encapsulates a high-performance sorting algorithm.
		Collections.sort(listBooks, Book.CompareTitle.instance);
		System.out.println("\nSorted Order: Title");
		for (Book book : listBooks)
			System.out.println(book);

		// Sort using Author as the key
		Collections.sort(listBooks, Book.CompareAuthor.instance);
		System.out.println("\nSorted Order: Author");
		for (Book book : listBooks)
			System.out.println(book);

		// Sort using ISBN as the key
		Collections.sort(listBooks, Book.CompareISBN.instance);
		System.out.println("\nSorted Order: ISBN");
		for (Book book : listBooks)
			System.out.println(book);

		// Sort using Price as the key
		Collections.sort(listBooks, Book.ComparePrice.instance);
		System.out.println("\nSorted Order: Price");
		for (Book book : listBooks)
			System.out.println(book);

		// Sort using Pages as the key
		Collections.sort(listBooks, Book.ComparePages.instance);
		System.out.println("\nSorted Order: Pages");
		for (Book book : listBooks)
			System.out.println(book);
	} // end main()
} // end class TestBook