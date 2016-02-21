package Proj1B;

import java.sql.*;
/**
 * 
 * @author Matt Wall
 *  -- CreateTables.java
 */
public class CreateTables {
	
	private static Connection connect = null;
	private final static int num_databases = 7;
	
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
		create();
	}
	
	
	//create tables with correct parameters
	public static void create() throws SQLException{
		
		Statement stmt = null;
		String sql = "";
		int x = 0;
		while (num_databases > x){
			stmt = connect.createStatement();
			switch(x){
				case 0: 
					sql = "CREATE TABLE students " +
			                "(snum INTEGER not NULL, " +
							"ssn INTEGER not NULL," +
			                "name VARCHAR(10)," +
			                "gender VARCHAR(1)," + 
			                "dob DATETIME," + 
			                "c_addr VARCHAR(20)," +
			                "c_phone VARCHAR(10)," +
			                "p_addr VARCHAR(20)," +
			                "p_phone VARCHAR(10)," +
			                "UNIQUE (snum)," +
			                " PRIMARY KEY ( ssn ))";
					break;
				case 1:
					sql = "CREATE TABLE departments " +
			                "(code INTEGER not NULL, " +
			                "name VARCHAR(50)," +
			                "phone VARCHAR(10)," +
			                "college VARCHAR(20)," +
			                "UNIQUE (name)," +
			                "PRIMARY KEY ( code ))";
					break;
				case 2:
					sql = "CREATE TABLE degrees " +
			                "name VARCHAR(50)," +
			                "level VARCHAR(5)," + 
			                "department_code INTEGER not NULL," + 
			                "FOREIGN KEY(department_code) REFERENCES departments(code)," + 
			                "PRIMARY KEY ( name, level))";
					break;
				case 3:
					sql = "CREATE TABLE courses " +
			                "(number INTEGER not NULL, " +
			                "name VARCHAR(50)," +
			                "description VARCHAR(50)," + 
			                "credithours INTEGER not NULL," + 
			                "level VARCHAR(20)," +
			                "department_code INTEGER not null," +
			                "UNIQUE (name)," +
			                "FOREIGN KEY (department_code) REFERENCES departments(code)," +
			                "PRIMARY KEY ( number ))";
					break;
				case 4:
					sql = "CREATE TABLE register " +
			                "(snum INTEGER not NULL, " +
							"course_number INTEGER not NULL," +
			                "when VARCHAR(20)," +
			                "grade INTEGER not NULL," + 
			                "FOREIGN KEY (snum) REFEERENCES students(snum)," +
			                "FOREIGN KEY (course_number) REFEERENCES courses(number)," +
			                "PRIMARY KEY ( snum, course_number ))";
					break;
				case 5:
					sql = "CREATE TABLE major " +
			                "(snum INTEGER not NULL, " +
			                "name VARCHAR(50)," +
			                "level VARCHAR(5)," + 
			                "FOREIGN KEY (snum) REFEERENCES students(snum)," +
			                "FOREIGN KEY (name,level) REFEERENCES degrees(name,level)," +
			                "PRIMARY KEY ( snum, name, level ))";
					break;
				case 6:
					sql = "CREATE TABLE minor " +
			                "(snum INTEGER not NULL, " +
			                "name VARCHAR(50)," +
			                "level VARCHAR(5)," + 
			                "FOREIGN KEY (snum) REFEERENCES students(snum)," +
			                "FOREIGN KEY (name,level) REFEERENCES degrees(name,level)," +
			                "PRIMARY KEY ( snum, name, level ))";
					break;
			}
		stmt.executeUpdate(sql);
		x++;
		}
	}
}
