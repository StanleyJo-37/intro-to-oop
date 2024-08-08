package main;

class Course {

    final static int MAX_ENROLLED_STUDENT = 75;
    
    private String courseID, courseName;
    private int studentCount = 0;
    Student[] enrolledStudents;
    
    Course(String courseID, String courseName) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.enrolledStudents = new Student[MAX_ENROLLED_STUDENT];
    }
    
    public void info() {
    	System.out.printf("Course ID: %s\n", courseID);
    	System.out.printf("Course Name: %s\n", courseName);
    }
    
    public void addStudent(Student newStudent) {
	      /* Authentication flow to ensure the correct user is accessing this. */
	    if (this.studentCount < MAX_ENROLLED_STUDENT) 	{
	    	this.enrolledStudents[studentCount] = newStudent;
	    	++this.studentCount;	    	
	    }
    }
    
}