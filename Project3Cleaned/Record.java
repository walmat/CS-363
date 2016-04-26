package project3;

import java.util.ArrayList;

public class Record {

	ArrayList<String> value = new ArrayList<String>();
	
	public Record(String val){
		value.add(val);
	}
	
	public String[] getRecord(int index){		
		String rec = value.get(index);
		
		String n = "";
		for (int i = 0; i < rec.length() - 1; i++){
			if (rec.charAt(i) == '{') {
				continue;
			}
			else if (rec.charAt(i) == '}' || rec.charAt(i) == '|') {
				n += "#";
			}
			else {
				n += rec.charAt(i);
			}
		}
		String ret[] = n.split("#");
		return ret;
	}
	
	
	//IGNORE BELOW ----- TESTING PURPOSES ONLY
	
	
	/*
	 * Testing Purposes -- Needed to see getRecord() was working
	 * as it should
	 */
	public void printRecord(String[] r) {
		for (int i = 0; i < r.length; i++){
			System.out.println(r[i]);
		}
	}
	
	/*
	 * Needed for testing -- useless during application
	 */
	public int toInt(int index) {
		if (value.get(index) != null) {
			return Integer.parseInt(value.get(index));
		}
		return -1; // error case
	}

	/*
	 * Needed for testing -- useless during application
	 */
	public double toDouble(int index) {
		if (value.get(index) != null) {
			Double.parseDouble(value.get(index));
		}
		return -1; // error case
	}
}
