package project3;

import java.io.IOException;
import java.util.Scanner;

public class ToyDisplayXYZ {
	
	public static void main(String[] args) throws IOException {
		Scanner s = new Scanner(System.in);
		Table t = new Table();	
		t = t.createTableFromFile(s);
		
		if (t.TableIsEmpty(t)) {
			System.out.println("Table is empty");
			s.close();
			return;
		}
		int rid = t.parseRid(t, s);
		if (rid == Integer.MAX_VALUE){
			for (int i = 0; i < t.numRecords; i++){
				String[] rec = t.records.get(i).getRecord(0);
				System.out.println();
				for (int j = 0; j < t.numberOfAttributes; j++){
					System.out.println(t.attributes.get(j).name + ": " + rec[j]);
				}
			}
		}
		else {
			String[] rec = t.records.get(rid).getRecord(0);
			System.out.println();
			for (int i = 0; i < t.numberOfAttributes; i++){
				System.out.println(t.attributes.get(i).name + ": " + rec[i]);
			}
		}
		s.close();
	}
}
