package Jan;

public class Test1 {
	
	public static void main(String[] args) {
		
		College c=new College(101, "JMU");
		Student s=new Student(201, "Manik", c);
		 c=new College(s);
		
		System.out.println("\n++++++++++  By College Object ++++++++++++++++++++\n");
		System.out.println("College Id: "+c.getCid());
		System.out.println("College Name: "+c.getCname());
		System.out.println("Student ID: "+c.getStudent().getSid());
        System.out.println("Student Name: "+c.getStudent().getSname());
        System.out.println("\n++++++++++  By Student Object ++++++++++++++++++++\n");
        System.out.println(s.getSname());
        System.out.println(s.getSid());
        System.out.println(s.getCollege().getCid());
        System.out.println(s.getCollege().getCname());
      }

}
