package de.dpma.pumaz.bvs.model;

import java.util.logging.Logger;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Book {

	private IntegerProperty id = new SimpleIntegerProperty();
	private StringProperty name = new SimpleStringProperty();
	private StringProperty author = new SimpleStringProperty();
	private StringProperty release_year = new SimpleStringProperty();

	private StringProperty ISBN = new SimpleStringProperty();
	private IntegerProperty id_categorys = new SimpleIntegerProperty();

	private StringProperty count = new SimpleStringProperty();
	private StringProperty available_count = new SimpleStringProperty();
	private StringProperty categoryname = new SimpleStringProperty();

	private IntegerProperty books_single_id = new SimpleIntegerProperty();
	private IntegerProperty books_single_id_books = new SimpleIntegerProperty();
	private IntegerProperty books_single_id_borrower = new SimpleIntegerProperty();
	private IntegerProperty books_single_available = new SimpleIntegerProperty();

	Logger log = Logger.getLogger(Book.class.getName());

	// Constructor um in BuchDAO Select ein Buch zu erstellen und dieses mit
	// Daten zu füllen
	public Book() {

	}

	// Standard Buch Constructor
	public Book(String name, String author, String release_year, String ISBN, int id_categorys) {
		this.name = new SimpleStringProperty(name);
		this.author = new SimpleStringProperty(author);
		this.release_year = new SimpleStringProperty(release_year);
		this.ISBN = new SimpleStringProperty(ISBN);
		this.id_categorys = new SimpleIntegerProperty(id_categorys);
	}

	// Standard Buch Constructor mit Anzahlangaben
	public Book(String name, String author, String release_year, String ISBN, int id_categorys, String count,
			String available_count) {
		this.name = new SimpleStringProperty(name);
		this.author = new SimpleStringProperty(author);
		this.release_year = new SimpleStringProperty(release_year);
		this.ISBN = new SimpleStringProperty(ISBN);
		this.id_categorys = new SimpleIntegerProperty(id_categorys);
		this.count = new SimpleStringProperty(count);
		this.available_count = new SimpleStringProperty(available_count);
	}

	// Single Buch Constructor
	public Book(int books_single_id_books, int books_single_id_borrower, int books_single_available) {
		this.books_single_id_books = new SimpleIntegerProperty(books_single_id_books);
		this.books_single_id_borrower = new SimpleIntegerProperty(books_single_id_borrower);
		this.books_single_available = new SimpleIntegerProperty(books_single_available);
	}

	// Single Buch Constructor Short
	public Book(int books_single_id_books) {
		this.books_single_id_books = new SimpleIntegerProperty(books_single_id_books);
	}

	public int getBooks_single_id() {
		return books_single_id.get();
	}

	public void setBooks_single_id(int books_single_id) {
		this.books_single_id.set(books_single_id);
	}

	public IntegerProperty Books_single_idProperty() {
		return this.books_single_id;
	}

	public int getBooks_single_id_books() {
		return books_single_id_books.get();
	}

	public void setBooks_single_id_books(int books_single_id_books) {
		this.books_single_id_books.set(books_single_id_books);
	}

	public IntegerProperty Books_single_id_booksProperty() {
		return this.books_single_id_books;
	}

	public int getBooks_single_id_borrower() {
		return books_single_id_borrower.get();
	}

	public void setBooks_single_id_borrower(int books_single_id_borrower) {
		this.books_single_id_borrower.set(books_single_id_borrower);
	}

	public IntegerProperty Books_single_idP_borrowerroperty() {
		return this.books_single_id_borrower;
	}

	public int getBooks_single_available() {
		return books_single_available.get();
	}

	public void setBooks_single_available(int books_single_available) {
		this.books_single_available.set(books_single_available);
	}

	public IntegerProperty Books_single_avialableProperty() {
		return this.books_single_available;
	}

	public String getCount() {
		return count.get();
	}

	public void setCount(String count) {
		this.count.set(count);
	}

	public StringProperty countProperty() {
		return this.count;
	}

	public String getAvailable_count() {
		return available_count.get();
	}

	public void setAvailable_count(String available_count) {
		this.available_count.set(available_count);
	}

	public StringProperty available_countProperty() {
		return this.available_count;
	}

	public String getCategoryName() {
		return categoryname.get();
	}

	public void setCategoryName(String categoryname) {
		this.categoryname.set(categoryname);
	}

	public StringProperty categoryName() {
		return this.categoryname;
	}

	public StringProperty overviewCountProperty() {
		return new SimpleStringProperty(this.available_count.get() + " / " + this.count.get());
	}

	public int getId() {
		return id.get();
	}

	public void setId(int id) {
		this.id.set(id);
	}

	public IntegerProperty idProperty() {
		return this.id;
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public StringProperty nameProperty() {
		return this.name;
	}

	public String getAuthor() {
		return author.get();
	}

	public void setAuthor(String author) {
		this.author.set(author);
	}

	public StringProperty authorProperty() {
		return this.author;
	}

	public String getRelease_year() {
		return release_year.get();
	}

	public void setRelease_year(String release_year) {
		this.release_year.set(release_year);
	}

	public StringProperty release_yearProperty() {
		return this.release_year;
	}

	public String getISBN() {
		return ISBN.get();
	}

	public void setISBN(String ISBN) {
		this.ISBN.set(ISBN);
	}

	public StringProperty ISBNProperty() {
		return this.ISBN;
	}

	public int getId_categorys() {
		return id_categorys.get();
	}

	public void setId_categorys(int id_categorys) {
		this.id_categorys.set(id_categorys);
	}

	public IntegerProperty id_categorysProperty() {
		return this.id_categorys;
	}

}
