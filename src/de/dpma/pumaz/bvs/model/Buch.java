package de.dpma.pumaz.bvs.model;

import java.util.logging.Logger;

public class Buch {

	private int id;
	private String name;
	private String author;
	private int release_year;
	private String ISBN;
	private int id_categorys;

	Logger log = Logger.getLogger(Buch.class.getName());

	public Buch(int id, String name, String author, int release_year, String ISBN, int id_categorys) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.release_year = release_year;
		this.ISBN = ISBN;
		this.id_categorys = id_categorys;
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
