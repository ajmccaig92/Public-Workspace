package book;

// BUILDER DESIGN PATTERN
// Ordinary constructors might have long lists of unnamed arguments. The meaning of each argument may not be evident.
// The BUILDER design pattern creates a mechanism of implementing named arguments. It is an increasingly common style in the Java API.
public class BookBuilder {
	// the absence of access specifiers ("public" "private" "protected") means "package" access.
	// class Book is in the same package, and therefore has access to the instance fields of this class.
	String title = "";
	String author = "";
	String publisher = "";
	int pages;
	long isbn;
	double price;

	private BookBuilder()	{	}
	public static BookBuilder create() { return new BookBuilder(); } // causes "new BookBuilder()" to return an object of type BookBuilder

	// Named methods provide optional initialization. Returning "this" allows for cascading initialization calls.
	public BookBuilder title(String title)					{	this.title = title;					return this;	} // ALWAYS returns same object of type BookBuilder
	public BookBuilder author(String author)				{	this.author = author;				return this;	} // ALWAYS returns same object of type BookBuilder
	public BookBuilder publisher(String publisher)	{	this.publisher = publisher;	return this;	} // ALWAYS returns same object of type BookBuilder
	public BookBuilder pages(int pages)							{	this.pages = pages;					return this;	} // ALWAYS returns same object of type BookBuilder
	public BookBuilder isbn(long isbn)							{	this.isbn = isbn;						return this;	} // ALWAYS returns same object of type BookBuilder
	public BookBuilder price(double price)					{	this.price = price;					return this;	} // ALWAYS returns same object of type BookBuilder

	// build() creates a Book object, populates it with values already initialized by this BookBuilder object.
	// BookBuilder object is sent to a newly created Book() object. The BookBuilder has already fully organized initialization.
	public Book build()	{	return new Book(this);	}
} // end class BookBuilder