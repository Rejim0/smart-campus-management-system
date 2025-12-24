package smart_campus_management_system;

import java.time.LocalDate;

public class Enrollment {

	private int studentId;
	private int courseId;
	private LocalDate date;
	
	Enrollment(int studentId, int courseId, LocalDate date){
		this.studentId = studentId;
		this.courseId = courseId;
		this.date = date;
	}
	
	public int getStudentId() {
		return studentId;
	}
	public int getCourseId() {
		return courseId;
	}
	public LocalDate getDate() {
		return date;
	}
	
	
}
