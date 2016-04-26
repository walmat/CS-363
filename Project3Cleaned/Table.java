package project3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class Table {
	
	
	/*
	 * globals
	 */
	int numberOfAttributes, numRecords = 0;
	String tableSaveLoc = "";
	ArrayList<Attribute> attributes = new ArrayList<Attribute>();
	ArrayList<Record> records = new ArrayList<Record>();
	
	
	/*
	 * empty table constructor
	 */
	public Table() {
		
	}
	
	/*
	 * constructs a new table based on a given file
	 */
	public Table(String fileName) throws IOException {
		tableSaveLoc = fileName;
		File f = new File (tableSaveLoc);
		Scanner s = new Scanner(f);
		
		String header = s.nextLine().trim();
		String parsed_data = "";
		
		for (int i = 0; i < header.length(); i++){
			if (header.charAt(i) == '[') {
				continue;
			}
			else if (header.charAt(i) == ']') {
				parsed_data += "#";
			}
			else {
				parsed_data += header.charAt(i);
			}
		}
		parsed_data = parsed_data.trim();
		String[] data = parsed_data.split("#");
		
		numberOfAttributes = Integer.parseInt(data[0]);
		numRecords = Integer.parseInt(data[data.length - 1]);
		
		for (int i = 1; i < numberOfAttributes + 1; i++){
			char[] type = data[i].toCharArray();
			String name_str = "";
			int t_int = 0;
			for (int j = 0; j < type.length; j++) {
				if (type[j] == ':'){
					t_int = Integer.parseInt("" + type[j+1]);
					break;
				}
				else {
					name_str += type[j];
				}
			}
			attributes.add(i-1, new Attribute(name_str, t_int));
		}

		String recs = "";
		while (s.hasNextLine()){
			recs += s.nextLine().trim() + "\n";
		}
		recs = recs.trim();
		String[] recs_split = recs.split("\n");
		
		for (int i = 0; i < recs_split.length; i++){
			records.add(new Record(recs_split[i]));
		}
		s.close();
	}
	
	/*
	 * Terribly inefficient. Will probably change to use a Java RAF soon
	 * instead of copying the entire file in and rewriting it.
	 * 
	 * -- Will be fine if the file isn't too large --
	 */
	public void writeTableToFile(Table t) throws FileNotFoundException, UnsupportedEncodingException{
		
		File f = new File (t.getTableName(t));
		
		PrintWriter pw = new PrintWriter(f);
		
		/*
		 * output header to file
		 */
		pw.print("[" + t.numberOfAttributes + "]");
		for (int i = 0; i < t.numberOfAttributes; i++) {
			pw.print("[");
			pw.print(t.attributes.get(i).name + ":" + t.attributes.get(i).type);
			pw.print("]");
		}
		pw.print("[" + t.numRecords + "]");
		
		/*
		 * output records to file
		 * need StringBuilder to get rid of '[ ]' surrounding the ArrayList
		 */
		for (int i = 0; i < t.numRecords; i++){
			if (t.records.get(i).value != null){
				pw.println();
				StringBuilder sb = new StringBuilder();
				for (String value : t.records.get(i).value){
					sb.append(value);
				}
				pw.print(sb.toString());
			}
		}
		pw.close();
	}
	
	/*
	 * A way of checking in display/delete/search
	 * if the table is empty. 
	 */
	public boolean TableIsEmpty(Table t){
		return t.numRecords == 0 || t.equals(null);
	}
	
	/*
	 * checks to see if the String provided contains:
	 * 1. an equals sign
	 * 2. the length of the provided string is two (minus '=')
	 */
	public boolean validQuery(String query){
		String[] spl = query.trim().split("=");
		return query.contains("=") && spl.length == 2;
	}
	
	/*
	 * splits query based on the '=' sign
	 */
	public String[] splitQuery(String query){
		return query.trim().split("=");
	}

	/*
	 * Access to a member level is fine, just for clarity in reading
	 */
	public String getTableName(Table t){
		return t.tableSaveLoc;
	}
	
	/*
	 * increment numRecords
	 */
	public int addNumRecord(Table t){
		return t.numRecords++;
	}
	/*
	 * decrement numRecords
	 */
	public int minusNumRecord(Table t){
		return t.numRecords--;
	}
	
	/*
	 * Getting the table of access in search, delete, display, insert, and header
	 */
	@SuppressWarnings("resource")
	public Table createTableFromFile(Scanner s) throws IOException{
		
		s = new Scanner(System.in);
		System.out.println("Name of your table file (.txt)?: ");
		Table t;
		try {
			t = new Table(s.nextLine());
		} catch (FileNotFoundException e){
			System.out.println("No table at that location");
			return null;
		}
		return t;
	}
	
	/*
	 * returns the number for the record to access
	 * -- added in functionality to display all records
	 */
	public int parseRid(Table t, Scanner s){
		int rid;
		String all;
		System.out.println("Which record index would you like to access? ('all' for all records)");
		String input = s.nextLine();

		try {
			rid = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			all = input;
			if (all.equalsIgnoreCase("all")){
				rid = Integer.MAX_VALUE;
				return rid;
			}
			else {
				System.out.println("Please input a number or 'all' for all records");
				s.close();
				return -1;
			}
		}
		
		if (rid < 0 || rid > t.numRecords){
			System.out.println("No record at that index");
			s.close();
			return -1;
		}
		
		return rid;
	}
	
	/*
	 * Checks the table for a specified query
	 */
	public int containsAttribute(Table t, String query){
		int att_num = 0;
		boolean contains_att = false;
		for (int i = 0; i < t.numberOfAttributes; i++){
			if (!(t.attributes.get(i).name.equalsIgnoreCase(t.splitQuery(query)[0].trim()))){
				continue;
			}
			att_num = i;
			contains_att = true;
			break;
		}
		if (!contains_att){
			return -1;
		}
		return att_num;
	}
	
	/*
	 * prints records where the record at att_num matches the record at the query provided
	 * -- wanted to do a containsIgnoreCase() but no such method exists so for now it's only
	 * if the whole string provided is in the record, kind of dumb in my honest opinion --
	 */
	public void printRecords(Table t, String query, int att_num){
		boolean contains_rec = false;
		
		for (int i = 0; i < t.numRecords; i++){
			String rec[] = t.records.get(i).getRecord(0);
			if (!rec[att_num].equalsIgnoreCase(t.splitQuery(query)[t.splitQuery(query).length - 1].trim())){
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
	}
	
}
