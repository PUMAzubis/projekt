package de.dpma.pumaz.bvs.model;

import java.util.logging.Logger;

public class User {

	private int id;
	private int identification_number;
	private String forename;
	private String surname;
	private String password;
	private int librarian;

	Logger log = Logger.getLogger(Book.class.getName());

	PasswordAuthentication pwauth = new PasswordAuthentication();

	public User() {

	}

	public User(int identification_number) {
		this.identification_number = identification_number;
	}

	public User(int identification_number, String forename, String surname, String password, int librarian) {
		this.identification_number = identification_number;
		this.forename = forename;
		this.surname = surname;
		this.password = password;
		this.librarian = librarian;
	}

	@SuppressWarnings("deprecation")
	public String hashPassword(String pw) {
		return pwauth.hash(pw);
	}

	@SuppressWarnings("deprecation")
	public boolean checkPassword(String pw, String hash) {
		return pwauth.authenticate(pw, hash);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdentification_number() {
		return identification_number;
	}

	public void setIdentification_number(int identification_number) {
		this.identification_number = identification_number;
	}

	public String getForename() {
		return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getLibrarian() {
		return librarian;
	}

	public void setLibrarian(int librarian) {
		this.librarian = librarian;
	}

	public Logger getLog() {
		return log;
	}
}