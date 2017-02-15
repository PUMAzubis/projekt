package de.dpma.pumaz.bvs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.dpma.pumaz.bvs.model.User;

public class UserDAO {
	final String INSERT_USER = "INSERT INTO `books` (`name`, `author`, `release_year`, `isbn`, `id_categorys`) VALUES (?, ?, ?, ?, ?)";

	final String DELETE_USER = "DELETE FROM `books` WHERE `id` = ?";

	final String UPDATE_USER = "UPDATE `books` SET `name` = ?, `author` = ?, `release_year` = ?, `isbn` = ?, `id_categorys` = ? WHERE `id` = ?";

	// SELECT_BUCH ohne ALL Noch nicht implementiert
	final String SELECT_USER = "SELECT *, (SELECT COUNT(*) FROM `books_single` WHERE b.`id` = 1) as count, (SELECT COUNT(*) FROM `books_single` WHERE b.`id` = 1 AND `available` = 1) as available_count FROM `books` b WHERE `id` = ?";

	private final Connection con;

	public UserDAO(Connection con) {
		this.con = con;
	}

	public User insertBuch(User b) throws SQLException {
		PreparedStatement stat = con.prepareStatement(INSERT_BUCH);
		stat.setString(1, b.getName());
		stat.setString(2, b.getAuthor());
		stat.setInt(3, b.getRelease_year());
		stat.setString(4, b.getISBN());
		stat.setInt(5, b.getId_categorys());
		stat.executeUpdate();
		return b;
	}

	public User insertBuchInstanz(User b) throws SQLException {
		PreparedStatement stat = con.prepareStatement(INSERT_BUCH_INSTANZ);
		stat.setInt(1, b.getUsers_single_id_books());
		stat.setInt(2, b.getUsers_single_id_borrower());
		stat.setInt(3, b.getUsers_single_available());
		stat.executeUpdate();
		return b;
	}

	public User updateBuch(User b) throws SQLException {
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

	public User updateBuchInstanz(User b) throws SQLException {
		PreparedStatement stat = con.prepareStatement(UPDATE_BUCH_INSTANZ);
		stat.setInt(1, b.getUsers_single_id_books());
		stat.setInt(2, b.getUsers_single_id_borrower());
		stat.setInt(3, b.getUsers_single_available());
		stat.setInt(4, b.getUsers_single_id());
		stat.executeUpdate();
		return b;
	}

	public User deleteBuch(User b) throws SQLException {
		PreparedStatement stat = con.prepareStatement(DELETE_BUCH);
		stat.setInt(1, b.getId());
		stat.executeUpdate();
		return b;
	}

	public User deleteBuchInstanz(User b) throws SQLException {
		PreparedStatement stat = con.prepareStatement(DELETE_BUCH_INSTANZ);
		stat.setInt(1, b.getUsers_single_id());
		stat.executeUpdate();
		return b;
	}

	public List<User> alleBuecher() throws SQLException {
		PreparedStatement stat = con.prepareStatement(SELECT_BUCH_ALL);
		ResultSet result = stat.executeQuery();

		ArrayList<User> Buecher = new ArrayList<>();
		while (result.next()) {
			User User = new User();
			User.setCount(result.getInt("count"));
			User.setAvailable_count(result.getInt("available_count"));

			User.setId(result.getInt("id"));
			User.setName(result.getString("name"));
			User.setAuthor(result.getString("author"));
			User.setRelease_year(result.getInt("release_year"));
			User.setISBN(result.getString("isbn"));
			User.setId_categorys(result.getInt("id_categorys"));
			Buecher.add(User);
		}
		return Buecher;
	}

	public List<User> alleBuecherInstanz() throws SQLException {
		PreparedStatement stat = con.prepareStatement(SELECT_BUCH_ALL_INSTANZ);
		ResultSet result = stat.executeQuery();

		ArrayList<User> Buecher = new ArrayList<>();
		while (result.next()) {
			User User = new User();
			User.setUsers_single_id(result.getInt("single_id"));
			User.setUsers_single_id_books(result.getInt("id_books"));
			User.setUsers_single_id_borrower(result.getInt("id_borrower"));
			User.setUsers_single_available(result.getInt("available"));
			Buecher.add(User);
		}
		return Buecher;
	}

	public List<User> alleBuecherTogether() throws SQLException {
		PreparedStatement stat = con.prepareStatement(SELECT_BUCH_ALL_INSTANZ);
		ResultSet result = stat.executeQuery();

		ArrayList<User> Buecher = new ArrayList<>();
		while (result.next()) {
			User User = new User();
			User.setId(result.getInt("id"));
			User.setName(result.getString("name"));
			User.setAuthor(result.getString("author"));
			User.setRelease_year(result.getInt("release_year"));
			User.setISBN(result.getString("isbn"));
			User.setId_categorys(result.getInt("id_categorys"));

			User.setUsers_single_id(result.getInt("single_id"));
			User.setUsers_single_id_books(result.getInt("id_books"));
			User.setUsers_single_id_borrower(result.getInt("id_borrower"));
			User.setUsers_single_available(result.getInt("available"));
			Buecher.add(User);
		}
		return Buecher;
	}

}
