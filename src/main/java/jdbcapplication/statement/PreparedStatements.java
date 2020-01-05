package jdbcapplication.statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jdbcapplication.connection.JDBCConnection;

public class PreparedStatements {

	private static final String CREATE_TABLE = " create table Student(id number(30,2) primary key, name varchar2(40)) ";
	private static final String INSERT = " insert into Student(id, name) values(?, ?)";
	private static final String FETCH_ALL = " select * from Student ";
	private static final String DROP = " drop table Student";

	public static void create() {
		try {
			Connection connection = JDBCConnection.getConnection();

			try {
				connection.prepareStatement(DROP).execute();
			} catch (Exception e) {
			}
			connection.prepareStatement(CREATE_TABLE).execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void insert() {
		try {
			Connection connection = JDBCConnection.getConnection();

			for (int i = 1; i <= 5; i++) {
				PreparedStatement prepareStatement = connection.prepareStatement(INSERT);
				prepareStatement.setInt(1, i);// index starts from 1
				prepareStatement.setString(2, "Venkatesh" + i);
				prepareStatement.execute();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void fetchAll() {
		try {
			Connection connection = JDBCConnection.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(FETCH_ALL);
			ResultSet executeQuery = prepareStatement.executeQuery();
			System.out.println("Fetch All");
			while (executeQuery.next()) {
				System.out.println(executeQuery.getString("id") + "  " + executeQuery.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
