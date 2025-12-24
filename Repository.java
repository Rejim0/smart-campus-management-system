package smart_campus_management_system;

import java.util.Collection;
import java.util.HashMap;

public class Repository<T> {
	
	private HashMap<Integer, T> data;
	
	Repository(){
		data = new HashMap<>();
	}
	
	
	public void add(int key, T item) {
		if(data.containsKey(key)) {
			System.out.println("Duplicate Error....");
		}else {
			data.put(key, item);
		}
			
	}
	
	public T get(int key) {
		return data.get(key);
	}
	
	public Collection<T> getAll(){
		return data.values();
		}
	
		
	

}
