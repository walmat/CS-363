package project3;

public class RecordTest {

	public static void main(String[] args) {
		Table t = new Table();
		Record r = new Record("{123456789|Scott John|89076|T}");
		t.records.add(r);
		
		String[] rec = r.getRecord(0);
		r.printRecord(rec);
		
		
		
	}
}
