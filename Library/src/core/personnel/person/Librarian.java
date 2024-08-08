package core.personnel.person;

public class Librarian extends Person {
	
	private int salary;
	public Librarian(String name, int salary) {
		super(name);
		this.salary = salary;
	}
	
	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
}
