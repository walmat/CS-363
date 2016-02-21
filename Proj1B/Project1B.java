package Proj1B;

import java.util.Scanner;

public class Project1B {

	public static void main(String[] args) {
		//Run databases
		Scanner s = new Scanner(System.in);
		while (true) {
			
			System.out.println("What would you like to do?\n");
			System.out.println("1: Create Tables\n");
			System.out.println("2: Insert Records\n");
			System.out.println("3: Modify Records\n");
			System.out.println("4: Query\n");
			System.out.println("5: Drop Tables\n");
			System.out.println("6: Exit\n");
			
			int choice = s.nextInt();
			
			switch (choice){
			case 1:
				//create tables
				break;
			case 2:
				//insert records
				break;
			case 3:
				//modify records
				break;
			case 4:
				//query
				break;
			case 5:
				//drop tables
				break;
			case 6:
				//exit
				s.close();
				System.exit(0);
				break;
			}
		}
	}

}
