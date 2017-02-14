package de.dpma.pumaz.bvs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.dpma.pumaz.bvs.model.Buch;

public class BuchDAO {
	final String INSERT_BUCH = "INSERT INTO `books` (`name`, `author`, `release_year`, `isbn`, `id_category`) VALUES (?, ?, ?, ?, ?)";
	final String INSERT_BUCH_INSTANZ = "INSERT INTO `books_single` (`id_books`, `id_borrower`, `available`) VALUES (?, ?, ?)";

	final String DELETE_BUCH = "DELETE FROM `books` WHERE `id` = ?";
	final String DELETE_BUCH_INSTANZ = "DELETE FROM `books_single` WHERE `single_id` = ?";

	final String UPDATE_BUCH = "UPDATE `books` SET `name` = ?, `author` = ?, `release_year` = ?, `isbn` = ?, `id_category` = ? WHERE `id` = ?";
	final String UPDATE_BUCH_INSTANZ = "UPDATE `books_single` SET `id_books` = ?, `id_borrower` = ?, `available` = ? WHERE `single_id` = ?";

	// SELECT_BUCH ohne ALL Noch nicht implementiert
	final String SELECT_BUCH = "SELECT *, (SELECT COUNT(*) FROM `books_single` WHERE b.`id` = 1) as count, (SELECT COUNT(*) FROM `books_single` WHERE b.`id` = 1 AND `available` = 1) as available_count FROM `books` b WHERE `id` = ?";
	final String SELECT_BUCH_INSTANZ = "SELECT * FROM `books_single` WHERE `id` = ?";
	final String SELECT_BUCH_TOGETHER = "SELECT * FROM `books` b1 JOIN `books_single` b2 ON b2.`id_books` = b1.`id` WHERE b2.`id` = ?";

	final String SELECT_BUCH_ALL = "SELECT *, (SELECT COUNT(*) FROM `books_single` WHERE b.`id` = 1) as count, (SELECT COUNT(*) FROM `books_single` WHERE b.`id` = 1 AND `available` = 1) as available_count FROM `books` b";
	final String SELECT_BUCH_ALL_INSTANZ = "SELECT * FROM `books_single`";
	final String SELECT_BUCH_ALL_TOGETHER = "SELECT * FROM `books` b1 JOIN `books_single` b2 ON b2.`id_books` = b1.`id`";

	private final Connection con;

	public BuchDAO(Connection con) {
		this.con = con;
	}

	public Buch insertBuch(Buch b) throws SQLException {
		PreparedStatement stat = con.prepareStatement(INSERT_BUCH);
		stat.setString(1, b.getName());
		stat.setString(2, b.getAuthor());
		stat.setInt(3, b.getRelease_year());
		stat.setString(4, b.getISBN());
		stat.setInt(5, b.getId_categorys());
		stat.executeUpdate();
		return b;
	}

	public Buch insertBuchInstanz(Buch b) throws SQLException {
		PreparedStatement stat = con.prepareStatement(INSERT_BUCH_INSTANZ);
		stat.setInt(1, b.getBooks_single_id_books());
		stat.setInt(2, b.getBooks_single_id_borrower());
		stat.setInt(3, b.getBooks_single_available());
		stat.executeUpdate();
		return b;
	}

	public Buch updateBuch(Buch b) throws SQLException {
		PreparedStatement stat = con.prepareStatement(UPDATE_BUCH);
		stat.setString(1, b.getName());
		stat.setString(2, b.getAuthor());
		stat.setInt(3, b.getRelease_year());
		stat.setString(4, b.getISBN());
		stat.setInt(5, b.getId_categorys());
		stat.setInt(6, b.getId());
		stat.executeUpdate();
		return b;
	}

	public Buch updateBuchInstanz(Buch b) throws SQLException {
		PreparedStatement stat = con.prepareStatement(UPDATE_BUCH_INSTANZ);
		stat.setInt(1, b.getBooks_single_id_books());
		stat.setInt(2, b.getBooks_single_id_borrower());
		stat.setInt(3, b.getBooks_single_available());
		stat.setInt(4, b.getBooks_single_id());
		stat.executeUpdate();
		return b;
	}

	public Buch deleteBuch(Buch b) throws SQLException {
		PreparedStatement stat = con.prepareStatement(DELETE_BUCH);
		stat.setInt(1, b.getId());
		stat.executeUpdate();
		return b;
	}

	public Buch deleteBuchInstanz(Buch b) throws SQLException {
		PreparedStatement stat = con.prepareStatement(DELETE_BUCH_INSTANZ);
		stat.setInt(1, b.getBooks_single_id());
		stat.executeUpdate();
		return b;
	}

	public List<Buch> alleBuecher() throws SQLException {
		PreparedStatement stat = con.prepareStatement(SELECT_BUCH_ALL);
		ResultSet result = stat.executeQuery();

		ArrayList<Buch> Buecher = new ArrayList<>();
		while (result.next()) {
			Buch Buch = new Buch();
			Buch.setCount(result.getInt("count"));
			Buch.setAvailable_count(result.getInt("available_count"));

			Buch.setId(result.getInt("id"));
			Buch.setName(result.getString("name"));
			Buch.setAuthor(result.getString("author"));
			Buch.setRelease_year(result.getInt("release_year"));
			Buch.setISBN(result.getString("isbn"));
			Buch.setId_categorys(result.getInt("id_categorys"));
			Buecher.add(Buch);
		}
		return Buecher;
	}

	public List<Buch> alleBuecherInstanz() throws SQLException {
		PreparedStatement stat = con.prepareStatement(SELECT_BUCH_ALL_INSTANZ);
		ResultSet result = stat.executeQuery();

		ArrayList<Buch> Buecher = new ArrayList<>();
		while (result.next()) {
			Buch Buch = new Buch();
			Buch.setBooks_single_id(result.getInt("single_id"));
			Buch.setBooks_single_id_books(result.getInt("id_books"));
			Buch.setBooks_single_id_borrower(result.getInt("id_borrower"));
			Buch.setBooks_single_available(result.getInt("available"));
			Buecher.add(Buch);
		}
		return Buecher;
	}

	public List<Buch> alleBuecherTogether() throws SQLException {
		PreparedStatement stat = con.prepareStatement(SELECT_BUCH_ALL_INSTANZ);
		ResultSet result = stat.executeQuery();

		ArrayList<Buch> Buecher = new ArrayList<>();
		while (result.next()) {
			Buch Buch = new Buch();
			Buch.setId(result.getInt("id"));
			Buch.setName(result.getString("name"));
			Buch.setAuthor(result.getString("author"));
			Buch.setRelease_year(result.getInt("release_year"));
			Buch.setISBN(result.getString("isbn"));
			Buch.setId_categorys(result.getInt("id_categorys"));

			Buch.setBooks_single_id(result.getInt("single_id"));
			Buch.setBooks_single_id_books(result.getInt("id_books"));
			Buch.setBooks_single_id_borrower(result.getInt("id_borrower"));
			Buch.setBooks_single_available(result.getInt("available"));
			Buecher.add(Buch);
		}
		return Buecher;
	}

}
