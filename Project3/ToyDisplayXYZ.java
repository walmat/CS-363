package project3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ToyDisplayXYZ {
	
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
		
		int rid = 0;
		System.out.println("Which record index would you like to access?");
		try {
			rid = Integer.parseInt(s.nextLine());
		} catch (InputMismatchException e) {
			System.out.println("Please input a number.");
			s.close();
			return;
		}
		
		if (rid < 0 || rid > t.numRecords){
			System.out.println("No record at that index");
			s.close();
			throw new IndexOutOfBoundsException();
		}
		
		String[] rec = t.records.get(rid).getRecord(rid);
		
		for (int i = 0; i < t.numberOfAttributes; i++){
			System.out.println(t.attributes.get(i).name + ": " + rec[i]);
		}
		
		s.close();
	}

}
