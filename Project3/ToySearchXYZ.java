package project3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ToySearchXYZ {

	public static void main(String[] args) throws IOException {
		
		Scanner s = new Scanner(System.in);
		System.out.println("Name of your table file (.txt)?: ");
		Table t;
		try {
			t = new Table(s.nextLine());
		} catch (FileNotFoundException e){
			System.out.println("No table at that location");
			s.close();
			return;
		}
		
		if (t.numRecords == 0) {
			System.out.println("Table is empty");
			s.close();
			return;
		}
		
		System.out.println("Enter your Query e.g. (Salary = 69080): ");
		String query = s.nextLine();
		
		if (!query.contains("=")){
			System.out.println("Invalid Query. Try again.");
			s.close();
			return;
		}
		
		String[] spl = query.trim().split("=");
		String attr = spl[0].trim();
		String search = spl[spl.length - 1].trim();
		
		
		int att_num = 0;
		boolean contains_att = false;
		
		for (int i = 0; i < t.numberOfAttributes; i++){
			if (!(t.attributes.get(i).name.equalsIgnoreCase(attr))){
				continue;
			}
			att_num = i;
			contains_att = true;
			break;
		}
		if (!contains_att){
			System.out.println("Table doesn't contain that attribute");
			s.close();
			return;
		}
		boolean contains_rec = false;
		
		for (int i = 0; i < t.numRecords; i++){
			String rec[] = t.records.get(i).getRecord(0);
			if (!rec[att_num].equalsIgnoreCase(search)){
				continue;
			}
			System.out.println();
			contains_rec = true;
			System.out.println("Record " + i);
			for (int j = 0; j < t.numberOfAttributes; j++){
				System.out.println(t.attributes.get(j).name + ": " + rec[j]);
			}
		}
		
		if (!contains_rec){
			System.out.println("No records contain that");
		}
		
		s.close();	
	}	
}
