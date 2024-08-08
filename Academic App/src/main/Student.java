package main;

public class Student {
	private String name;
	private int age;
	private float gpa;
	
	Student(String name, int age, float gpa) {
		this.name = name;
		this.age = age;
		this.gpa = gpa;
	}
	
	public void info() {
		System.out.printf("Name: %s\n", this.name);
		System.out.printf("Age: %d\n", this.age);
		System.out.printf("GPA: %.2f\n", this.gpa);
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}
}