package project3;

import java.io.IOException;
import java.util.Scanner;

public class ToyCreateXYZ {

	public static void main(String[] args) throws IOException {

		//create table for basis of the header
		Scanner s = new Scanner (System.in);
		System.out.println("Name of file?: ");
		Table t = new Table();
		t.tableSaveLoc = s.nextLine();
		System.out.println("File available");
		System.out.println();
				
		boolean break_loop = false;
		String answer, name;
		int type;

		while (!break_loop) {
			System.out.println("Attribute Name: ");
			name = s.nextLine();
			System.out.println("Select a type: | 1-integer | 2-double | 3-boolean | 4-string |");
			type = Integer.parseInt(s.nextLine());
			if (type == 1 || type == 2 || type == 3 || type == 4){
				t.attributes.add(new Attribute(name, type));
				System.out.println("More attributes? (y/n): ");
				answer = s.nextLine();
				if (answer.contains("n")) {
					break_loop = true;
					s.close();
				}
				t.numberOfAttributes++;
			}
			else {
				System.out.println("Couldn't recognize type, try again.");
			}
		}

		t.writeTableToFile(t);
	}
}
