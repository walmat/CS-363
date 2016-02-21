package Proj1B;
import java.sql.*;

public class DropTables {
	
	private static Connection connect = null;
	private static final int num_databases = 7;
	
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
		//drop tables
		drop_tables();
	}

	
	public static void drop_tables() throws SQLException{
		
		Statement stmt = null;
		String sql = "DROP TABLE";
		stmt = connect.createStatement();
		int x = 0;
		while (x < num_databases){
			switch (x){
			case 0:
				sql += "students ";
				break;
			case 1:
				sql += "departments ";
				break;
			case 2:
				sql += "degrees ";
				break;
			case 3:
				sql += "courses ";
				break;
			case 4:
				sql += "register ";
				break;
			case 5:
				sql += "major ";
				break;
			case 6:
				sql += "minor ";
				break;
			}
			stmt.executeUpdate(sql);
			x++;
		}
	}
}
