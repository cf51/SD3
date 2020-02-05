public class Recursion {

	// Recursive sum of numbers (returns the sum of numbers up to (n) number)
	public static int sum(int n){
		
		if (n == 1) {	//As the sum of 1 is 1, if n is 1 then the number is just returned 
			return n; 	//returns the number to the user 
		}
		else {
			return sum(n-1)+n;	//returns the positive sum of numbers up to n 
		}						
	}

	// Recursive multiply method (returns the sum of two  multiplied number using addition) 
	public static int multiply(int m, int n){
		

		if  (m == 0  || n == 0){
			return 0; 		  //returns the number back to the user (0 * by any number is 0)
		}
		
		else if (n > 0 ) {						//if n is > 0 then it returns the first number from the user + the first
			return m + multiply(m , n -1); 		//number * by 1- the second number 
		}										//ie. m=7, n=3 (returns 7 + (7*2) = 21 
		
		else {
			return -m + multiply(m ,n +1);		//works the same but for the negative numbers 
		}
	}
	
	//Fibonacci sequence (returns the fibonacci sequence given a number n) 
	public static int Fibonacci(int n){
		
		if (n < 2 ) {	//As the number before 1 in the sequence is just 1, the number is returned to the user
			return n; 
		}
		else {
			return Fibonacci(n-1) + Fibonacci(n-2); //takes the first number and subtracts 1, then subtracts 2 from 
		}											//the second number. 
			
			
	}


}
