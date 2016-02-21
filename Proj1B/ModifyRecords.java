package Proj1B;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ModifyRecords {
	
	private static Connection connect = null;

public static void setup() throws SQLException{
	
		try {
			Class.forName("com.mysql.jdbc.Driver"); //Set up connection parameters
			String userName = "dbu363mwall";
			String password = "9GCjNKtN8vG";
			String dbServer = "jdbc:mysql://mysql.cs.iastate.edu/db363mwall"; //Set up connection
			connect = DriverManager.getConnection(dbServer,userName,password);
		} catch(Exception e) {
			System.out.println("Couldn't connect to the database");
		}
		//modify statements
		modify1();
		modify2();
		modify3();
	}

	public static void modify1() throws SQLException{
		//change the name of the student with ssn = 746897816 to Scott
		Statement stmt = null;
		String sql = "";
		stmt = connect.createStatement();
		sql = "UPDATE students SET name = ‘Scott’ " +
			  "WHERE ssn = 746897816";
		stmt.executeUpdate(sql);
	}
	
	public static void modify2() throws SQLException{
		//change the major of the student with ssn = 746897816 to Computer Science, Master.
		Statement stmt = null;
		String sql = "";
		stmt = connect.createStatement();
		sql = "UPDATE students SET snum = 1005 " +
			  "WHERE ssn = 746897816";
		stmt.executeUpdate(sql);
	}
	
	public static void modify3() throws SQLException{
		//delete all registration records that were in “Spring2015”
		Statement stmt = null;
		String sql = "";
		stmt = connect.createStatement();
		sql = "DELETE FROM register " +
			  "WHERE when = 'Spring2015'";
		stmt.executeUpdate(sql);
	}
}
