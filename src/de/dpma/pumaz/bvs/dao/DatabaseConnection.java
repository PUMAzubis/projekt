package de.dpma.pumaz.bvs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DatabaseConnection {
	
	public Connection con = null;
	
	Logger log = Logger.getLogger(DatabaseConnection.class.getName());
	
	public DatabaseConnection() throws ClassNotFoundException, SQLException {
		log.info("Die verbindung zur Datenbank wird gestartet");
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://192.168.111.144:3306/bvs?" + "user=root&password=Kekskuchen");
		log.info("Verbindung erfolgreich");
	}
	
	public Connection getConnection() {
		
		log.info("Die Datenbankverbindung wird hergestellt");
		return this.con;
	}
	
	public void closeConnection() throws SQLException {
		
		log.info("Die Datenbankverbindung wird geschlossen");
		con.close();
	}
}
