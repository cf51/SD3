import javax.print.attribute.standard.RequestingUserName;

class StackException extends RuntimeException{    
		public StackException() {
			super();
		}
}

public class Stack {
	 
	private class Node{
		
		int element;
		Node next;
		
		
		public Node(int e, Node n){
			element = e;
			next = n;
		}
	}
	
	private Node top;
	private int size;
	
	public Stack(){
		top = null;
		size = 0;
	}
	
	public boolean isEmpty(){
		return top == null;
	}
	
	public int size(){
		return size; 
	}
	
	// pushs an element to the stack 
	public void push(int o){
		
	
		Node node = new Node(o, top); //Declaring new node 

		if (top == null) {		//if the top element is null
			top = node; 		
			
		}
		
		else {
			node.next = top; //making the next node the top 
			top = node; 	
			
		}
		size++;	//incrementing size by 1 
		
	}
	
	
	/**
	 * @return popped element 
	 * @throws StackException
	 */
	
	// pops an element from the stack 
	public int pop() throws StackException{ 
		
		if (top == null) 	{			//if the stack is empty it throws an exception 
		throw new StackException();
		}
		
		else {
			int element = top.element;      //setting element to the top element 
			top = top.next; 				//setting top to the next top 
			size --; 						//decreasing size by 1 
			return element; 				//returning, as pop() returns the element it popped
		} 	
	}
	
	
	
	/**
	 * @return top element 
	 * @throws StackException
	 */
	
	// checks the top element of the stack 
	public int top() throws StackException{
		
		if (top == null) {					//if the top is empty a stack exception is thrown 
			throw new StackException(); 
		}
			
		return top.element; 				//if its not empty then the top element is returned 
	}
	
	
	

}
