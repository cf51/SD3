import java.util.ArrayList;
import java.util.List; 


public class ReverseStack {

	private List<String> list; 
	
	public ReverseStack(){
		
		list = new ArrayList<String>(); 
	}
	
	public String pop() {
		
		if (!list.isEmpty()) {
			String Top = list.get(0); 
			
			for(int i = 0; i < list.size()-1; i++) {
				
				list.set(i, list.get(i+1)); 
			}
			
			list.remove(list.size()-1);
				return Top; 
			}
		
		else {
			return null; 
		}

	}
	
	private void push(Object pop) {
		list.add((String) pop); 
		
	}
	
	
	public String top() {
		if (!list.isEmpty()) {
			return list.get(0); 
		}
		
		else {
			return null; 
		}
		
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	
	public static void reverseStack(Stack st){  
		
		ReverseStack queue = new ReverseStack(); 
		
		while(!st.isEmpty()) {
			queue.push(st.pop());
		}
		
		while(!queue.isEmpty()) {
			st.push(queue.pop());
		}


	
	
	
	}

}
