package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DatabaseSingleton {

	
	private static DatabaseSingleton ref;

	private Connection connection;

	public static DatabaseSingleton getDatabaseSingleton() {
		if (ref == null)
			ref = new DatabaseSingleton();
		return ref;
	}

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();

	}

	public Connection getConnection(boolean autoCommit) throws SQLException {
		if (connection == null || connection.isClosed()) {

			try {
				connection = DriverManager.getConnection(
						"jdbc:mysql://dt5.ehb.be/SP2Team11",
						"SP2Team11",
						"QJC48w");

			} catch (SQLException e) {
				System.out.println("SQLException: " + e.getMessage());

			}
		}

		return connection;
	}
}
