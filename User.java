package smart_campus_management_system;

public abstract class User {
	private final int id;
	private final String name;
	private final UserRole role;
	
	User(int id, String name, UserRole role){
		this.id = id;
		this.name = name;
		this.role = role;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public UserRole getRole() {
		return role;
	}
	

}
