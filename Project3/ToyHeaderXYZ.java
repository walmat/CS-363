package project3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ToyHeaderXYZ {
	
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
		
		System.out.println(t.numberOfAttributes + " attributes");
		
		for (int i = 0; i < t.numberOfAttributes; i++){
			switch (t.attributes.get(i).type){
			case 1: //Integer
				System.out.println("Attribute " + (i+1) + ": " + t.attributes.get(i).name + ", " + "Integer");
				break;
			case 2: //Double
				System.out.println("Attribute " + (i+1) + ": " + t.attributes.get(i).name + ", " + "Double");
				break;
			case 3: //Boolean
				System.out.println("Attribute " + (i+1) + ": " + t.attributes.get(i).name + ", " + "Boolean");
				break;
			case 4: //String
				System.out.println("Attribute " + (i+1) + ": " + t.attributes.get(i).name + ", " + "String");
				break;
			}
		}
		
		//print out # records
		System.out.println(t.numRecords + " records");
		
		s.close();
		
	}
	
}
