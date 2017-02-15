package de.dpma.pumaz.bvs.model;

import java.util.logging.Logger;

public class Book {

	private int id;
	private String name;
	private String author;
	private int release_year;
	private String ISBN;
	private int id_categorys;

	private int count;
	private int available_count;

	private int books_single_id;
	private int books_single_id_books;
	private int books_single_id_borrower;
	private int books_single_available;

	Logger log = Logger.getLogger(Book.class.getName());

	// Constructor um in BuchDAO Select ein Buch zu erstellen und dieses mit
	// Daten zu f�llen
	public Book() {

	}

	// Standard Buch Constructor
	public Book(String name, String author, int release_year, String ISBN, int id_categorys) {
		this.name = name;
		this.author = author;
		this.release_year = release_year;
		this.ISBN = ISBN;
		this.id_categorys = id_categorys;
	}

	// Standard Buch Constructor mit Anzahlangaben
	public Book(String name, String author, int release_year, String ISBN, int id_categorys, int count,
			int available_count) {
		this.name = name;
		this.author = author;
		this.release_year = release_year;
		this.ISBN = ISBN;
		this.id_categorys = id_categorys;
		this.count = count;
		this.available_count = available_count;
	}

	// Single Buch Constructor
	public Book(int books_single_id_books, int books_single_id_borrower, int books_single_available) {
		this.books_single_id_books = books_single_id_books;
		this.books_single_id_borrower = books_single_id_borrower;
		this.books_single_available = books_single_available;
	}

	public int getBooks_single_id() {
		return books_single_id;
	}

	public void setBooks_single_id(int books_single_id) {
		this.books_single_id = books_single_id;
	}

	public int getBooks_single_id_books() {
		return books_single_id_books;
	}

	public void setBooks_single_id_books(int books_single_id_books) {
		this.books_single_id_books = books_single_id_books;
	}

	public int getBooks_single_id_borrower() {
		return books_single_id_borrower;
	}

	public void setBooks_single_id_borrower(int books_single_id_borrower) {
		this.books_single_id_borrower = books_single_id_borrower;
	}

	public int getBooks_single_available() {
		return books_single_available;
	}

	public void setBooks_single_available(int books_single_available) {
		this.books_single_available = books_single_available;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getAvailable_count() {
		return available_count;
	}

	public void setAvailable_count(int available_count) {
		this.available_count = available_count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getRelease_year() {
		return release_year;
	}

	public void setRelease_year(int release_year) {
		this.release_year = release_year;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public int getId_categorys() {
		return id_categorys;
	}

	public void setId_categorys(int id_categorys) {
		this.id_categorys = id_categorys;
	}

	public Logger getLog() {
		return log;
	}

	public void setLog(Logger log) {
		this.log = log;
	}

}