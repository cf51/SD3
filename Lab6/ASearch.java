public class ASearch {


	private Entry[] catalogue;
	private int current;
	
	/*
	 * Assume 10 entries
	 */
	public ASearch(){
		catalogue = new Entry[10];
		current = 0;
	}
	
	/*
	 * Ignores adding if full (should really be handled by exception...)
	 */
	public void addEntry(Entry e){
		if(current < 10){
			catalogue[current++] = e;
		}
	}
	
	/*
	 * Part 2: complete implementation
	 */
	public int linearSearch(String name){
		
	int n = catalogue.length; //used to iterate through list 
	
		for (int i = 0; i < n; i++) {
		
			if (catalogue[i].getName().equals(name)) { //checking if the name appears in the catalogue 
				
				return catalogue[i].getNumber(); //Returns the phone number 
			}
		  
			else {
				return -1; //returns -1, if name is not in catalogue 
			}
			
		}
	
		return n; 
	
		
	}

	/*
	 * Part 4: complete implementation
	 */
	
	public int binarySearch(int first,int last,String name){
		
		
		if (last >= first) { //checks if the array has items in it 
			
			int mid = first + (last -1 )/2 ; //holds the index position of the middle of the array 
			
			if (catalogue[mid].getName().equals(name)) { //checks if the name is at the middle point 
			
				return catalogue[mid].getNumber(); //returns the phone number 
			}
			
			if (catalogue[mid].getName().compareTo(name) > 0 ) { //checks if name is on the right hand side of the array 
				
				 return binarySearch(first, mid -1, name); //if name isnt on left hand side, right is searched (between mid -1 and first index)
			}											   //returns the name 
			
			else {
			
				 return binarySearch(mid +1, last, name); //if name isnt on right hand side, left is searched (between mid +1 and last index)
			}											   //returns the name 
			 
			
			
				
		}
		
		return -1 ; 
	}
	

	// helper method
	public int bSearch(String name){
		return binarySearch(0,current,name);
	}
	
	
}
