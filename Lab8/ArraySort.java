import java.util.ArrayList;
import java.util.Iterator;

public class ArraySort {
	
	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int cur = arr[i];
			int j = i -1;
			while (j >= 0 && arr[j] > cur) {
				arr[j+1] = arr[j--];
				arr[j+1] = cur;
			}
		}
	}
	
	// Part 3: complete implementation
	public static void bubbleSort(int[] arr){

		boolean swaps = true; //setting boolean swaps to true 
		int l = arr.length; //varibale to hold the length of the array 

		while (swaps == true) { //goes through while swaps is true 

			swaps = false; //setting swaps to false 

			for(int i = 0; i < l-1; i++) { //iterates through the length of the array 
				
				if (arr[i + 1] < arr[i]) { //if the element on the right is less than the one on the left (54321)


					int temp = arr[i]; //holds the value of element at that index position 
					arr[i] = arr[i+1]; //swaps the elments over 
					arr[i+1] = temp;   //moves onto the next element 

					swaps = true; //as n-1, moves back and repeats to do the last element  

				}

			}
		}

	}

	
	// Part 5 : complete implementation
	public static void quickSort(ArrayList<Integer> S){
		
		if (S.isEmpty()) { //if empty just return itself 
			return; 
		}
		
		int pivot = S.get(S.size()-1); //creating a pivot point for the sort 
		
		ArrayList<Integer> L = new ArrayList<Integer>(); //Creating array list for Less than
		ArrayList<Integer> E = new ArrayList<Integer>(); //Creating array list for Equal than
		ArrayList<Integer> G = new ArrayList<Integer>(); //Creating array list for Greater than 
		
		while (!S.isEmpty()) { //run while the array list isn't empty 
			
			if (S.get(0)< pivot) { //if its less than the pivot, add less than 
				
				L.add(S.get(0)); //adds the less than 
				S.remove(0); //removes the elements at that index position 
			}
			else if(S.get(0) == pivot) { //if its equal to the pivot, add equal to 
				
				E.add(S.get(0));
				S.remove(0);
			}
			
			else if (S.get(0) > pivot) { //if its greater than the pivot point, add greater than 
				
				G.add(S.get(0));
				S.remove(0);
			}
			
			
		}
		
		if (!L.isEmpty()) { //if Less than isn't empty, call quick sort on less than 
			
			quickSort(L); //calls the quick sort for less than 
		}
		
		if (!G.isEmpty()) { //if Greater than isn't empty, call quick sort on greater than 
			
			quickSort(G); //calls quick sort for greater than 
		}
		
		S.addAll(L); //Shifting all of the elements to the right 
		S.addAll(E); //Shifting all of the elements to the right 
		S.addAll(G); //Shifting all of the elements to the right 
	}
	
	// predicate to check if array is sorted
	public static boolean isSorted(int[] arr){
		for(int i = 0; i < arr.length-1;i++)
			if(arr[i] > arr[i+1])
				return false;
		return true;
	}
	
	// predicate to check if arrayList is sorted
	public static boolean isSorted(ArrayList<Integer> ar){
		Iterator i = ar.iterator();
		int val;
		if(i.hasNext())
			val = (int) i.next();
		else
			return true;
		while(i.hasNext()){
			int nv = (int) i.next();
			if(val > nv)
				return false;
			val = nv;
		}
		return true;
	}
	
	
	/*
	 * Helper printing methods for testing
	 */
	private static void printIntArray(int[] arr){
		System.out.print("[ ");
		for(Integer i : arr){
			System.out.print(i + " ");
		}
		System.out.println(" ]");
	}

	private static void printIntArrayList(ArrayList<Integer> arr){
		System.out.print("[ ");
		for(Integer i : arr){
			System.out.print(i + " ");
		}
		System.out.println(" ]");
	}
	

	public static void main(String[] args){
		// testing part1
		int[] arr1 = {5,4,3,2,1};
		bubbleSort(arr1);
		printIntArray(arr1);
		
		// testing part2
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2.add(3);
		arr2.add(1);
		arr2.add(6);
		arr2.add(5);
		quickSort(arr2);		
		printIntArrayList(arr2);
		// {5,4,3,5,1};
				
	}
	
}
