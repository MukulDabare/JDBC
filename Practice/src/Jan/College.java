package Jan;

public class College {
	private int cid;
	private String cname;
	static Student student;
	public College(int id, String name ) {
		
		this.cid = id;
		this.cname = name;
		
	}
	public int getCid() {
		return cid;
	}

	public String getCname() {
		return cname;
	}
	
	public static Student getStudent() {
		return student;
	}

	
	public College(Student stu)
	{
		this.student=stu;
	}
	
}



