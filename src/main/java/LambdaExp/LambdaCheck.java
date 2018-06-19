package LambdaExp;

class Student{
	int id;
	String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
public class LambdaCheck {

	public static void main(String[] args) {
		
		Student  s= new Student ();
		s.setId(11); s.setName("Chirs");
		
		
	}
	
	
}
