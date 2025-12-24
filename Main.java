package smart_campus_management_system;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Repository<User> user = new Repository<>();
		Repository<Course> course = new Repository<>();
		ArrayList<Enrollment> enrollment = new ArrayList<>();
		
		boolean isRunning = true;
		Scanner scanner = new Scanner(System.in);
		
		
		while(isRunning) {
			System.out.println("-----------------------");
			System.out.println("Jamunbari Public School");
			System.out.println("-----------------------");
			System.out.println("1. Add User");
			System.out.println("2. Add Course");
			System.out.println("3. Enroll Student");
			System.out.println("4. View Enrollments");
			System.out.println("5. Make Payment");
			System.out.println("6. Save & Exit");
			System.out.print("Enter your choice: ");
			String choice = scanner.nextLine();
			int option;
		
			try {
				option = Integer.parseInt(choice);
			}catch(NumberFormatException e) {
				System.out.println("Something went wrong...");
				continue;
			}
		
		
			switch(option) {
			
			case 1:
				System.out.println("Enter ID: ");
				int id = scanner.nextInt();
				scanner.nextLine();
				
				System.out.println("Enter Name: ");
				String name = scanner.nextLine();
				
				System.out.println("Enter Role: ");
				String role = scanner.nextLine().toUpperCase();
				UserRole role1;
				
				try {
					role1 = UserRole.valueOf(role);
				}catch(IllegalArgumentException e) {
					System.out.println("Invalid role. Please enter STUDENT or STAFF.");
					continue;
				}
				
				if(role1 == UserRole.STUDENT){
					System.out.print("Enter Student Major: ");
					String major = scanner.nextLine();
					System.out.println("Enter Starting Balance: ");
					int balance = scanner.nextInt();
					scanner.nextLine();
					user.add(id, new Student(major, balance, id, name));
				}
				else if(role1 == UserRole.STAFF) {
					System.out.print("Enter Department: ");
					String department = scanner.nextLine();
					user.add(id, new Staff(department,id, name));
					
				}
				break;
				
			case 2:
				System.out.print("Enter Course ID: ");
				int courseid = scanner.nextInt();
				scanner.nextLine();
				
				System.out.print("Enter Course Title: ");
				String coursetitle = scanner.nextLine();
				
				System.out.print("Enter Credit Hours: ");
				int credithours = scanner.nextInt();
				scanner.nextLine();
				
				course.add(courseid, new Course(courseid, coursetitle, credithours));
					
				break;
				
			case 3:
				System.out.println("Enter Student ID: ");
				int studentid = scanner.nextInt();
				scanner.nextLine();
				
				System.out.println("Enter Course ID: ");
				int courseidS = scanner.nextInt();
				scanner.nextLine();
				
				User u = user.get(studentid);
				if(u == null) {
					System.out.println("Student not found...");
					break;
				}
				if(!(u instanceof Student)) {
					System.out.println("User is not a student.");
			        break;
				}
				
				Student student = (Student) u;
				
				Course c = course.get(courseidS);
				if (c == null) {
			        System.out.println("Course not found.");
			        break;
			    }
				
				System.out.println("Enter Today's DATE (mm/dd/yyyy): ");
				String date = scanner.nextLine();
				
				LocalDate inputdate;
				try {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
					inputdate = LocalDate.parse(date, formatter);
				}catch(DateTimeParseException e) {
					 System.out.println("Invalid date format.");
				        break;
				}
				
				enrollment.add(new Enrollment(studentid, courseidS, inputdate));
			    System.out.println("Student enrolled successfully!");
				break;
				
			case 4:
				if(enrollment.isEmpty()) {
					System.out.println("No Records found...");
					break;
				}
				
				System.out.println("******* Enrollment List *****");
				
				for(Enrollment e: enrollment){
					
					User sid = user.get(e.getStudentId());
					Course cid = course.get(e.getCourseId());
					
					String studentname = (sid != null) ? sid.getName(): "Unknown Student";
					String courseTitle = (cid != null) ? cid.getTitle(): "Unknown Course";
					
					System.out.println(
				            "Student: " + studentname +
				            " | Course: " + courseTitle +
				            " | Date: " + e.getDate()
				        );
					
				}	
				break;
				
			case 5:
				System.out.print("Enter ID: ");
				int paymentid = scanner.nextInt();
				
				User spay = user.get(paymentid);
				if(spay == null) {
					System.out.println("No record found...");
					break;
				}
				if(!(spay instanceof Student)) {
					System.out.println("Not a student...");
					break;
				}
				
				Student paybalance = (Student) spay;
				
				System.out.println("Enter the amount: ");
				double amount = scanner.nextDouble();
			    scanner.nextLine();
			    
			    if(amount <= 0) {
			    	System.out.println("Invalid payment amount.");
			        break;
			    }
			    paybalance.addBalance(amount);
			    System.out.println("Payment successful!");
			    System.out.println("Updated Balance: $" + paybalance.getBalance());
				
				break;
				
			case 6:
				isRunning = false;
				break;
			
			
			
			}
		
		
		}
		scanner.close();

	}

}
