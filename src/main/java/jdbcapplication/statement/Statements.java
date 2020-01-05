package jdbcapplication.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import jdbcapplication.connection.JDBCConnection;

public class Statements {

	private static final String CREATE_TABLE = " create table Employee(id number(30,2) primary key, name varchar2(40)) ";
	private static final String INSERT = " insert into Employee(id, name) values(1,'Venkatesh')";
	private static final String FETCH_ALL = " select * from Employee ";

	public static void create() {
		int check = 0;
		try {
			Connection connection = JDBCConnection.getConnection();
			Statement createStatement = connection.createStatement();
			createStatement.addBatch("drop table Employee");
			createStatement.addBatch(CREATE_TABLE);
			createStatement.executeBatch();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (check == 0) {
			System.out.println("Table cretated");
		} else {
			System.out.println("Table Not cretated ");
		}

	}

	public static void insert() {
		try {
			Connection connection = JDBCConnection.getConnection();
			Statement createStatement = connection.createStatement();
			for (int i = 1; i <= 5; i++) {
				String query = "insert into Employee(id, name) values(" + i + ",'Venkatesh')";
				createStatement.executeUpdate(query);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void fetchAll() {
		try {
			Connection connection = JDBCConnection.getConnection();
			Statement createStatement = connection.createStatement();
			ResultSet executeQuery = createStatement.executeQuery(FETCH_ALL);
			System.out.println("Fetch All");
			while (executeQuery.next()) {
				System.out.println(executeQuery.getString("id") + "  " + executeQuery.getString("name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
