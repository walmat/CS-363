package project3;

import java.io.IOException;
import java.util.Scanner;

public class ToySearchXYZ {

	public static void main(String[] args) throws IOException {
		
		Scanner s = new Scanner(System.in);
		Table t = new Table();	
		t = t.createTableFromFile(s);

		if (t.TableIsEmpty(t)){
			System.out.println("Table is empty");
			s.close();
			return;
		}
		
		System.out.println("Enter your Query e.g. (Salary = 69080): ");
		String query = s.nextLine();

		if (!t.validQuery(query)){
			System.out.println("Invalid Query. Try again.");
			s.close();
			return;
		}

		int att_num = t.containsAttribute(t, query);
		if (att_num < 0){
			System.out.println("Table doesn't contain that attribute");
			s.close();
			return;
		}
		t.printRecords(t, query, att_num);	
		s.close();	
	}	
}
