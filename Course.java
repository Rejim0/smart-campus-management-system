package smart_campus_management_system;

public class Course {
	
	private int courseId;
	private String title;
	private int credits;
	
	Course(int courseId, String title, int credits){
		this.courseId = courseId;
		this.title = title;
		this.credits = credits;
	}
	
	public int getCourseId() {
		return courseId;
	}
	public String getTitle() {
		return title;
	}
	public int getCredits() {
		return credits;
	}
	

}
