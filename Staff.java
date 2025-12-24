package smart_campus_management_system;

public class Staff extends User{
	
	private String department;
	
	Staff(String department, int id, String name){
		super(id, name, UserRole.STAFF);
		this.department = department;
	}
	
	public String getDepartment() {
		return department;
	}
	
}
