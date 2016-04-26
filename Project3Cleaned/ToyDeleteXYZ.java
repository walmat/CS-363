package project3;

import java.io.IOException;
import java.util.Scanner;

public class ToyDeleteXYZ {

	public static void main(String[] args) throws IOException {
		
		Scanner s = new Scanner(System.in);
		Table t = new Table();	
		t = t.createTableFromFile(s);
		
		//can't delete if there aren't any records
		if (t.TableIsEmpty(t)){
			System.out.println("Table is empty");
			s.close();
			return;
		}
		int rid = t.parseRid(t, s);
		t.records.get(rid).value = null;
		t.minusNumRecord(t);		
		t.writeTableToFile(t);
		s.close();
	}
}