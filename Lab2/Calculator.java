// exception used for Q5
class CalculateException extends RuntimeException{    
	public CalculateException(String err) {
		super(err);
	}
}

public class Calculator {

	/*
	 *  Methods for Part 3
	 *  
	 *  
	 */
	
	private static Reverse r; //Calling the reverse class from the package 
	
	public static int calculate(String [] cmds){
		Stack pstack = new Stack(100);
		
		
			r.reverse(cmds); //reversing through the stack using the reverse class 
		
			for(int i = 0; i < cmds.length; i++) { //iterating through the elements in the stack 
			
				if(isNumber(cmds[i])) { //If it is a number then it gets pushed to the stack 
				
					pstack.push(cmds[i]);
					}
			
				else {		// If it's not a number then it must be a operator so the last 2 elements are popped 
							// from the stack and the calculation is done 
					
					        // The numbers are currently integers so they must be cast to string in order for applyOp
							// to receive 3 string arguments 
					
					pstack.push(Integer.toString(applyOp((String) pstack.pop(), cmds[i], (String) pstack.pop())));
					
					} 
					
			}
			return convert((String) pstack.pop());	//Returns the last popped value (the answer to the calculation) 
	}

	public static int convert(String s) throws NumberFormatException{
		
