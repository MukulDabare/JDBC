package Jan;

public class Test {
	
	public static void main(String[] args) {
		
		Course c=new Course();
		c.setCid(1);
		c.setCname("Java");
		 
		Faculty f=new Faculty();
		f.setFid(101);
		f.setFname("Dr.CPU");
		f.setCourse(c);
		
		Batch b=new Batch();
		b.setBid(201);
		b.setBname("Hackers");
		b.setFaculty(f);
		
		System.out.println("Batch name: "+b.getBname());
		System.out.println("Batch ID: "+b.getBid());
		System.out.println("Faculty name: "+b.getFaculty().getFname());
		System.out.println("Faculty ID: "+b.getFaculty().getFid());
		System.out.println("Faculty name: "+b.getFaculty().getCourse().getCname());
		System.out.println("Course ID: "+b.getFaculty().getCourse().getCid());
	}

}
