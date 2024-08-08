package core.personnel.person;

public class Student extends Person {
	
	final static int MAX_BORROWING = 3;
	int current_borrowing;
	
	public Student(String name) {
		super(name);
		this.current_borrowing = 0;
	}
	
	public Boolean Borrow() {
		if (current_borrowing >= MAX_BORROWING) return false;
		
		
		return true;
	}

}
