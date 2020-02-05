import java.util.Comparator;

public class AdvancedJava {

	private GenericSort<String> gs = new GenericSort<String>();
	private GenericSort<Integer> gi = new GenericSort<Integer>();
	
	// Optional generics
	public void optionalGenerics(){
		String[] strs = {"D","E","X","A"};
		Integer[] ints = {4,5,6,1,12,23};
		
		
		/*
		 * Sort both strs and ints using gs and gi respectively
		 *   You should use an anonymous instantce of the Comparator as illustrated in the lecture
		 */
		
		printIntArray(ints);
		printStringArray(strs);
	}
	
	// Optional lambda
	public void optionalLambda(){
		String[] strs = {"D","E","X","A"};
		Integer[] ints = {4,5,6,1,12,23};
				
		/*
		 * Sort both strs and ints using gs and gi respectively
		 *   You should use lambda expressions as illustrated in the lecture
		 */		

		printIntArray(ints);
		printStringArray(strs);		
	}
	
	
	private static void printIntArray(Integer[] arr){
		System.out.print("[ ");
		for(Integer i : arr){
			System.out.print(i + " ");
		}
		System.out.println(" ]");
	}
	private static void printStringArray(String[] arr){
		System.out.print("[ ");
		for(String i : arr){
			System.out.print(i + " ");
		}
		System.out.println(" ]");
	}

	
	public static void main(String[] args){
		AdvancedJava adv = new AdvancedJava();
		adv.optionalGenerics();
		adv.optionalLambda();
	}

}
