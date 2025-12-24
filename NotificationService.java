package smart_campus_management_system;

public class NotificationService implements Runnable{
	
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(5000);
				System.out.println("Reminder: Check enrollments or balances.");
			} catch (InterruptedException e) {
				System.out.println("Error");
				
			}
			
		}
		
	}

}
