package project3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class Table {
	
	int numberOfAttributes, numRecords = 0;
	String tableSaveLoc = "";
	ArrayList<Attribute> attributes = new ArrayList<Attribute>();
	ArrayList<Record> records = new ArrayList<Record>();
	
	public Table() {
		
	}
	
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
	
	public void writeTableToFile(Table t) throws FileNotFoundException, UnsupportedEncodingException{
		
		File f = new File (t.tableSaveLoc);
		
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

}
