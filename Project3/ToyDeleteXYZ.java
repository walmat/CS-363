package project3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ToyDeleteXYZ {

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
		
		//can't delete if there aren't any records
		if (t.numRecords == 0){
			System.out.println("Table empty");
			s.close();
			return;
		}
		
		int rid = 0;
		System.out.println("Which record index would you like to delete?");
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
		
		t.records.get(rid).value = null;
		
		//decrement numRecords
		t.numRecords--;
		
		t.writeTableToFile(t);
		
		s.close();
	}
}