package project3;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ToyInsertXYZ {

	public static void main(String[] args) throws IOException {
		
		Scanner s = new Scanner(System.in);
		Table t = new Table();	
		t = t.createTableFromFile(s);
		
		String rec = "{";
		for (int i = 0; i < t.numberOfAttributes; i++){
			System.out.println(t.attributes.get(i).name + ": ");
			String input = s.nextLine();
			switch(t.attributes.get(i).type) {
			case 1: //integer
				try {
					rec += Integer.parseInt(input);
				} catch (InputMismatchException e){
					System.out.println("Item must be an int");
					s.close();
					return;
				}
				break;
			case 2: //double
				try {
					rec += Double.parseDouble(input);
				} catch (InputMismatchException e){
					System.out.println("Item must be a double");
					s.close();
					return;
				}
				break;
			case 3: //boolean
				try {
					if (input.equalsIgnoreCase("T") || input.equalsIgnoreCase("F")){
						rec += input;
					}
					else {
						throw new InputMismatchException();
					}
				} catch (InputMismatchException e){
					System.out.println("Item must be a boolean");
					s.close();
					return;
				}
				break;
			case 4: //string
				try {
					rec += input;
				} catch (InputMismatchException e){
					//should never happen
					System.out.println("Item must be a string");
					s.close();
					return;
				}
				break;
			}
			if (i < t.numberOfAttributes - 1){
				rec += "|";
			}
		}
		rec += "}";		
		t.records.add(t.numRecords, new Record(rec));
		t.addNumRecord(t);		
		t.writeTableToFile(t);
		
		s.close();
	}
}