package de.dpma.pumaz.bvs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import de.dpma.pumaz.bvs.model.User;

public class UserDAO {
	final String INSERT_USER = "INSERT INTO `users` (`identification_number`, `forename`, `surname`, `password`, `librarian`) VALUES (?, ?, ?, ?, ?)";

	final String DELETE_USER = "DELETE FROM `users` WHERE `id` = ?";

	final String UPDATE_USER = "UPDATE `users` SET `identification_number` = ?, `forename` = ?, `surname` = ?, `password` = ?, `librarian` = ? WHERE `id` = ?";

	final String SELECT_USER = "SELECT * FROM `users` WHERE `identification_number` = ?";
	final String SELECT_USER_ALL = "SELECT * FROM `users`";

	private final Connection con;

	public UserDAO(Connection con) {
		this.con = con;
	}

	public User insertUser(User u) throws SQLException {
		PreparedStatement stat = con.prepareStatement(INSERT_USER);
		stat.setInt(1, u.getIdentification_number());
		stat.setString(2, u.getForename());
		stat.setString(3, u.getSurname());
		stat.setString(4, u.hashPassword(u.getPassword()));
		stat.setInt(5, u.getLibrarian());
		stat.executeUpdate();
		return u;
	}

	public User updateUser(User u) throws SQLException {
		PreparedStatement stat = con.prepareStatement(UPDATE_USER);
		stat.setInt(1, u.getIdentification_number());
		stat.setString(2, u.getForename());
		stat.setString(3, u.getSurname());
		stat.setString(4, u.hashPassword(u.getPassword()));
		stat.setInt(5, u.getLibrarian());
		stat.setInt(6, u.getId());
		stat.executeUpdate();
		return u;
	}

	public User deleteUser(User u) throws SQLException {
		PreparedStatement stat = con.prepareStatement(DELETE_USER);
		stat.setInt(1, u.getId());
		stat.executeUpdate();
		return u;
	}

	public User findUser(User u) throws SQLException {
		PreparedStatement stat = con.prepareStatement(SELECT_USER);
		stat.setInt(1, u.getIdentification_number());
		ResultSet result = stat.executeQuery();

		User User = new User();
		User.setId(result.getInt("id"));
		User.setIdentification_number(result.getInt("identification_number"));
		User.setForename(result.getString("forename"));
		User.setSurname(result.getString("surname"));
		User.setPassword(result.getString("password"));
		User.setLibrarian(result.getInt("librarian"));
		return User;

	}

	public List<User> alleUser() throws SQLException {
		PreparedStatement stat = con.prepareStatement(SELECT_USER_ALL);
		ResultSet result = stat.executeQuery();

		ArrayList<User> Users = new ArrayList<>();
		while (result.next()) {
			User User = new User();
			User.setId(result.getInt("id"));
			User.setIdentification_number(result.getInt("identification_number"));
			User.setForename(result.getString("forename"));
			User.setSurname(result.getString("surname"));
			User.setPassword(result.getString("password"));
			User.setLibrarian(result.getInt("librarian"));
			Users.add(User);
		}
		return Users;
	}

}
