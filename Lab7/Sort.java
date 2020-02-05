
public class Sort {

	/*
	 * Part 4: complete method
	 */
	public static void sort(int[] arr){
		
		int number = arr.length; //declaring new number 
		
		PriorityQueue p = new PriorityQueue(number); //creating new priority queue 
		
		for(int i = 0; i < number; i++) { //iterate through the array 
			
			int j = arr[i]; //holds value of index posistion i in array 
			
			p.insert(j); //insert the value in the index postion (priority queue) 
		}
		
		for(int i = 0; i < number; i++) { //iterates through the array 
			
			int y = p.removeMin(); //remove the smaller value in the priority queue 
			
			arr[i] = y ; //orders from smallest to biggest, whatever was at positon i, y is added to it 
		}
		
		
	}
	
	public static void main(String[] args){
		int[] arr = {53,3,5,2,4,67};
		Sort.sort(arr);
		// should be printed in order
		System.out.println(arr[0]);
		System.out.println(arr[1]);	
		System.out.println(arr[2]);
		System.out.println(arr[3]);	
		System.out.println(arr[4]);	
		System.out.println(arr[5]);	
	}
	
}
