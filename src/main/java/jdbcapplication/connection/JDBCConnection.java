package jdbcapplication.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	private static Connection connection;

	static {
		if (connection == null) {//lazy instantiation

			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbc", "jdbc");
				System.out.println("Database object created");
			} catch (ClassNotFoundException | SQLException e) {
				System.err.println("Error Occured while creating connection object" + e);
			}
		}
	}

	public static Connection getConnection() {
		return connection;
	}

}
