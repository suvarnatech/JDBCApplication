package jdbcapplication.statement;

public class Test {

	public static void main(String[] args) throws Exception {

		Statements.create();
		Statements.insert();
		Statements.fetchAll();

//		new JDBCConnection();
//		Class clazz = Class.forName("jdbcapplication.connection.JDBCConnection");
//		Object ob=clazz.newInstance();
//		JDBCConnection obs= (JDBCConnection) ob;
//		System.out.println(obs);
	}
}
