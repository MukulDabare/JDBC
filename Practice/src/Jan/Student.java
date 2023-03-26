package Jan;

public class Student {
	private int sid;
	private String sname;
	static College college;
	public Student(int sid, String sname, College college) {
		
		this.sid = sid;
		this.sname = sname;
		this.college = college;
	}

	public int getSid() {
		return sid;
	}
	
	public String getSname() {
		return sname;
	}
	
	public static College getCollege() {
		return college;
	}

	
	
	

}
