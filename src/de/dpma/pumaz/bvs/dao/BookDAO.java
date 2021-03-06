package de.dpma.pumaz.bvs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import de.dpma.pumaz.bvs.MainApp;
import de.dpma.pumaz.bvs.model.Book;

public class BookDAO {
	final String INSERT_BUCH = "INSERT INTO `books` (`name`, `author`, `release_year`, `isbn`, `id_categorys`) VALUES (?, ?, ?, ?, ?)";
	final String INSERT_BUCH_INSTANCE = "INSERT INTO `books_single` (`id_books`) VALUES (?)";

	final String DELETE_BUCH = "DELETE FROM `books` WHERE `id` = ?";
	final String DELETE_BUCH_INSTANCE = "DELETE FROM `books_single` WHERE `id_books` = ? AND `available` = 1 LIMIT ?";

	final String UPDATE_BUCH = "UPDATE `books` SET `name` = ?, `author` = ?, `release_year` = ?, `isbn` = ?, `id_categorys` = ? WHERE `id` = ?";
	final String UPDATE_BUCH_INSTANCE = "UPDATE `books_single` SET `id_books` = ?, `id_borrower` = ?, `available` = ? WHERE `single_id` = ?";

	// final String SELECT_BUCH = "SELECT *, (SELECT COUNT(*) FROM
	// `books_single` WHERE b.`id` = 1) as count, (SELECT COUNT(*) FROM
	// `books_single` WHERE b.`id` = 1 AND `available` = 1) as available_count
	// FROM `books` b WHERE `id` = ?";
	// final String SELECT_BUCH_INSTANCE = "SELECT * FROM `books_single` WHERE
	// `id` = ?";
	// final String SELECT_BUCH_TOGETHER = "SELECT * FROM `books` b1 JOIN
	// `books_single` b2 ON b2.`id_books` = b1.`id` WHERE b2.`id` = ?";

	final String SELECT_BUCH_ALL = "SELECT *, (SELECT `name` FROM `categorys` WHERE `id` = b1.`id_categorys`) as categoryname, (SELECT COUNT(*) FROM `books_single` WHERE b1.`id` = `id_books`) as count, (SELECT COUNT(*) FROM `books_single` WHERE b1.`id` = `id_books` AND `available` = 1) as available_count FROM `books` b1";
	// final String SELECT_BUCH_ALL_INSTANCE = "SELECT * FROM `books_single`";
	// final String SELECT_BUCH_ALL_TOGETHER = "SELECT * FROM `books` b1 JOIN
	// `books_single` b2 ON b2.`id_books` = b1.`id`";

	final String SELECT_BUCH_SEARCH = "SELECT *, (SELECT `name` FROM `categorys` WHERE `id` = b1.`id_categorys`) as categoryname, (SELECT COUNT(*) FROM `books_single` WHERE b1.`id` = `id_books`) as count, (SELECT COUNT(*) FROM `books_single` WHERE b1.`id` = `id_books` AND `available` = 1) as available_count FROM `books` b1 WHERE LOWER(b1.`name`) LIKE ? OR LOWER(b1.`author`) LIKE ? OR LOWER(b1.`release_year`) LIKE ? OR LOWER(b1.`isbn`) LIKE ? OR (SELECT LOWER(`name`) FROM `categorys` WHERE `id` = b1.`id_categorys`) LIKE ?";

	final String SELECT_BUCH_CATEGORY_ID = "SELECT `id` FROM `categorys` WHERE `name` = ?";

	final String SELECT_BUCH_LAST_ID = "SELECT `id` FROM `books` ORDER BY `add_time` DESC LIMIT 1";

	private int id;

	private final Connection con;

	Logger log = Logger.getLogger(MainApp.class.getName());

	public BookDAO(Connection con) {
		this.con = con;
	}

	public Book insertBook(Book b) throws SQLException {
		PreparedStatement stat = con.prepareStatement(INSERT_BUCH);
		stat.setString(1, b.getName());
		stat.setString(2, b.getAuthor());
		stat.setString(3, b.getRelease_year());
		stat.setString(4, b.getISBN());
		stat.setInt(5, b.getId_categorys());
		stat.executeUpdate();
		return b;
	}

	public Book insertBookInstance(Book b) throws SQLException {
		PreparedStatement stat = con.prepareStatement(INSERT_BUCH_INSTANCE);
		stat.setInt(1, b.getBooks_single_id_books());
		stat.executeUpdate();
		return b;
	}

	public Book updateBook(Book b) throws SQLException {
		PreparedStatement stat = con.prepareStatement(UPDATE_BUCH);
		stat.setString(1, b.getName());
		stat.setString(2, b.getAuthor());
		stat.setString(3, b.getRelease_year());
		stat.setString(4, b.getISBN());
		stat.setInt(5, b.getId_categorys());
		stat.setInt(6, b.getId());
		stat.executeUpdate();
		log.info("asdsaadsdaasd");
		return b;
	}

	public Book updateBookInstance(Book b) throws SQLException {
		PreparedStatement stat = con.prepareStatement(UPDATE_BUCH_INSTANCE);
		stat.setInt(1, b.getBooks_single_id_books());
		stat.setInt(2, b.getBooks_single_id_borrower());
		stat.setInt(3, b.getBooks_single_available());
		stat.setInt(4, b.getBooks_single_id());
		stat.executeUpdate();
		return b;
	}

	public Book deleteBook(Book b) throws SQLException {
		PreparedStatement stat = con.prepareStatement(DELETE_BUCH);
		stat.setInt(1, b.getId());
		stat.executeUpdate();
		return b;
	}

	public void deleteBookInstance(int id, int amount) throws SQLException {
		PreparedStatement stat = con.prepareStatement(DELETE_BUCH_INSTANCE);
		stat.setInt(1, id);
		stat.setInt(2, amount);
		stat.executeUpdate();
	}

	public List<Book> allBooks() throws SQLException {
		PreparedStatement stat = con.prepareStatement(SELECT_BUCH_ALL);
		ResultSet result = stat.executeQuery();

		ArrayList<Book> Books = new ArrayList<>();
		while (result.next()) {
			Book Book = new Book();
			Book.setCount(result.getString("count"));
			Book.setAvailable_count(result.getString("available_count"));
			Book.setCategoryName(result.getString("categoryname"));

			Book.setId(result.getInt("id"));
			Book.setName(result.getString("name"));
			Book.setAuthor(result.getString("author"));
			Book.setRelease_year(result.getString("release_year"));
			Book.setISBN(result.getString("isbn"));
			Book.setId_categorys(result.getInt("id_categorys"));
			Books.add(Book);
		}
		return Books;
	}

	// public List<Book> allBooksInstance() throws SQLException {
	// PreparedStatement stat = con.prepareStatement(SELECT_BUCH_ALL_INSTANCE);
	// ResultSet result = stat.executeQuery();
	//
	// ArrayList<Book> Books = new ArrayList<>();
	// while (result.next()) {
	// Book Book = new Book();
	// Book.setBooks_single_id(result.getInt("single_id"));
	// Book.setBooks_single_id_books(result.getInt("id_books"));
	// Book.setBooks_single_id_borrower(result.getInt("id_borrower"));
	// Book.setBooks_single_available(result.getInt("available"));
	// Books.add(Book);
	// }
	// return Books;
	// }
	//
	// public List<Book> allBooksTogether() throws SQLException {
	// PreparedStatement stat = con.prepareStatement(SELECT_BUCH_ALL_TOGETHER);
	// ResultSet result = stat.executeQuery();
	//
	// ArrayList<Book> Books = new ArrayList<>();
	// while (result.next()) {
	// Book book = new Book();
	// System.out.println(result.getInt("id"));
	// book.setId(result.getInt("id"));
	// book.setName(result.getString("name"));
	// book.setAuthor(result.getString("author"));
	// System.out.println(result.getString("release_year"));
	// book.setRelease_year(result.getString("release_year"));
	// book.setISBN(result.getString("isbn"));
	// book.setId_categorys(result.getInt("id_categorys"));
	//
	// book.setBooks_single_id(result.getInt("single_id"));
	// book.setBooks_single_id_books(result.getInt("id_books"));
	// book.setBooks_single_id_borrower(result.getInt("id_borrower"));
	// book.setBooks_single_available(result.getInt("available"));
	// Books.add(book);
	// }
	// return Books;
	// }

	public List<Book> searchBooks(String searchString) throws SQLException {
		PreparedStatement stat = con.prepareStatement(SELECT_BUCH_SEARCH);
		stat.setString(1, ("%" + searchString + "%").toLowerCase());
		stat.setString(2, ("%" + searchString + "%").toLowerCase());
		stat.setString(3, ("%" + searchString + "%").toLowerCase());
		stat.setString(4, ("%" + searchString + "%").toLowerCase());
		stat.setString(5, ("%" + searchString + "%").toLowerCase());
		ResultSet result = stat.executeQuery();

		ArrayList<Book> Books = new ArrayList<>();
		while (result.next()) {
			Book Book = new Book();
			Book.setCount(result.getString("count"));
			Book.setAvailable_count(result.getString("available_count"));
			Book.setCategoryName(result.getString("categoryname"));
			System.out.println(result.getString("categoryname"));
			Book.setId(result.getInt("id"));
			Book.setName(result.getString("name"));
			Book.setAuthor(result.getString("author"));
			Book.setRelease_year(result.getString("release_year"));
			Book.setISBN(result.getString("isbn"));
			Book.setId_categorys(result.getInt("id_categorys"));
			Books.add(Book);
		}
		return Books;
	}

	public int getCategoryId(String string) throws SQLException {
		PreparedStatement stat = con.prepareStatement(SELECT_BUCH_CATEGORY_ID);
		stat.setString(1, string);
		ResultSet result = stat.executeQuery();

		while (result.next()) {
			id = result.getInt("id");
		}
		return id;

	}

	public int getLastBookId() throws SQLException {
		PreparedStatement stat = con.prepareStatement(SELECT_BUCH_LAST_ID);
		ResultSet result = stat.executeQuery();

		while (result.next()) {
			id = result.getInt("id");
		}
		System.out.println(id);
		return id;

	}

	// public String getBookCategoryString(Book b) throws SQLException {
	//
	// PreparedStatement stat = con.prepareStatement(SELECT_BUCH_CATEGORY);
	// stat.setInt(1, b.getId_categorys());
	// ResultSet result = stat.executeQuery();
	//
	// while (result.next()) {
	// cat = result.getString("name");
	// }
	// return cat;
	//
	// }

}
