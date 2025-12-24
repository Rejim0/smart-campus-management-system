package smart_campus_management_system;

public class Student extends User {

	private String major;
	private double balance;
	
	Student(String major, double balance, int id, String name){
		super(id, name,UserRole.STUDENT);
		this.major = major;
		this.balance = balance;
	}
	
	public String getMajor() {
		return major;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double addBalance(double amount) {
		if(amount <= 0) {
			System.out.println("Amount can't be negative or zero...");
		}else {
			return balance += amount;
		}	
		return balance;
	}
	
	public double deductBalance(double amount) {
		if(amount <= 0) {
			System.out.println("Amount can't be negative or zero...");
		}else if(amount > balance){
			System.out.println("Amount can't be greater than balance...");
		}else {
			return balance -= amount;
		}
		return balance;
	}
	
	
	
	
}
