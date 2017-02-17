package de.dpma.pumaz.bvs.model;

import java.sql.SQLException;
import java.util.logging.Logger;

import de.dpma.pumaz.bvs.MainApp;
import de.dpma.pumaz.bvs.dao.BookDAO;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Book {

	private IntegerProperty id;
	private StringProperty name;
	private StringProperty author;
	private IntegerProperty release_year;
	private StringProperty ISBN;
	private IntegerProperty id_categorys;

	private IntegerProperty count;
	private IntegerProperty available_count;

	private IntegerProperty books_single_id;
	private IntegerProperty books_single_id_books;
	private IntegerProperty books_single_id_borrower;
	private IntegerProperty books_single_available;

	Logger log = Logger.getLogger(Book.class.getName());

	// Constructor um in BuchDAO Select ein Buch zu erstellen und dieses mit
	// Daten zu füllen
	public Book() {

	}

	// Standard Buch Constructor
	public Book(String name, String author, int release_year, String ISBN, int id_categorys) {
		this.name = new SimpleStringProperty(name);
		this.author = new SimpleStringProperty(author);
		this.release_year = new SimpleIntegerProperty(release_year);
		this.ISBN = new SimpleStringProperty(ISBN);
		this.id_categorys = new SimpleIntegerProperty(id_categorys);
	}

	// Standard Buch Constructor mit Anzahlangaben
	public Book(String name, String author, int release_year, String ISBN, int id_categorys, int count,
			int available_count) {
		this.name = new SimpleStringProperty(name);
		this.author = new SimpleStringProperty(author);
		this.release_year = new SimpleIntegerProperty(release_year);
		this.ISBN = new SimpleStringProperty(ISBN);
		this.id_categorys = new SimpleIntegerProperty(id_categorys);
		this.count = new SimpleIntegerProperty(count);
		this.available_count = new SimpleIntegerProperty(available_count);
	}

	// Single Buch Constructor
	public Book(int books_single_id_books, int books_single_id_borrower, int books_single_available) {
		this.books_single_id_books = new SimpleIntegerProperty(books_single_id_books);
		this.books_single_id_borrower = new SimpleIntegerProperty(books_single_id_borrower);
		this.books_single_available = new SimpleIntegerProperty(books_single_available);
	}

	public StringProperty categoryName() throws SQLException {
		BookDAO bookDao = new BookDAO(MainApp.dbcon.getConnection());
		return new SimpleStringProperty(bookDao.getBookCategoryString(this));
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

	public int getCount() {
		return count.get();
	}

	public void setCount(int count) {
		this.count.set(count);
	}

	public IntegerProperty countProperty() {
		return this.count;
	}

	public int getAvailable_count() {
		return available_count.get();
	}

	public void setAvailable_count(int available_count) {
		this.available_count.set(available_count);
	}

	public IntegerProperty available_countProperty() {
		return this.available_count;
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

	public int getRelease_year() {
		return release_year.get();
	}

	public void setRelease_year(int release_year) {
		this.release_year.set(release_year);
	}

	public StringBinding release_yearProperty() {
		return this.release_year.asString();
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
