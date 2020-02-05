import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Collection {
	private Person[] collection;
	private static int MAX_SIZE = 200;
	private int size;
	
	// filenames
	private static String FROMFNAME = "people.txt";
	private static String TOFNAME = "print_people.txt";
    // optional part (writing objects)
	private static String OBJFNAME = "people.ser";
	
	public Collection(int max){
		collection = new Person[max];
		size = 0;
	}
	
	public Collection(){
		this(MAX_SIZE);
	}
	
	public Person[] getCollection(){
		return collection;
	}
	
	public int getSize(){
		return size;
	}
	
	public void addPerson(String fname,String lname,int age){
		collection[size++] = new Person(fname,lname,age); 
	}
	
	
	public int maxAge(){
		
		int largestAge = -1  ; // Declaring new int variable for maxAge() to be passed into
		
		for (int i = 0; i <= collection.length -1; i++) { //for loop iterates through the collection 
			
			if (collection[i] == null ) //if the collection is empty then it exits the loop 
				break;
			else 
				if (collection[i].getAge() > largestAge) //if the  collection larger than the variable largestAge 
					largestAge = collection[i].getAge(); //it sets it to the largestAge variable 
		
		}
		
		return largestAge ; // returning the maximum age from the collection 
	}
	
	// PART 3: complete the implementation
	public void readFromFile(){
		 
		try {
		
			
		FileReader fr = new FileReader(FROMFNAME); //File reader accepts the path name of the file 'FROMFNAME' to be read  
		BufferedReader br = new BufferedReader(fr); //Using a buffer reader to read through the file line by line 
		
		String line; // initializes line  
		
		while (br.ready()) { //While loop is used to read through all of the lines in the file 
			
			line = br.readLine(); //returns the complete line from the text file 
			
			String []	names = line.split(";"); //creates a string array by splitting the text each time a ; is encountered 
			
			//Element 0 of the string is the first name, the white space at the ends are trimmed, element 1 of the array is the second name 
			//with the white space trimmed at each end, we miss out element 2 as its the height, element 3 is age which is an integer so we must 
			//convert to a string using 'parseInt' and trim the ends.
			addPerson(names[0].trim(), names [1].trim(), Integer.parseInt(names[3].trim()));
			
		}
		
		br.close(); //end of the try clause 
		
		} catch(IOException e) { //catching any exceptions using the sub class of exception 'IOException'
			System.out.println(e.getMessage()); //'getMessage' returns a string with the details of the exception 
		}
				
	}
	

	public void writeToFile(){
		StringBuffer val = new StringBuffer("\nMaximum age: " + maxAge());
		for (int i = 0; i < size; i++)
			val.append(collection[i].toString() + "\n");
		try{
			FileWriter wr = new FileWriter(TOFNAME);
			BufferedWriter bw = new BufferedWriter(wr);
			bw.write(val.toString());
			bw.close();
			System.out.println("file written to " + TOFNAME);
		  }catch(Exception e){
			  System.out.println(e.getMessage());
		  }
	}
	
	/*
	 *  Optional part
	 */
	public void writeObjects(){
	
	}
	
	public void readObjects(){

	}
	
	/*
	 *  main method - NOT REQUIRED - you should use JUnit instead...
	 */
	public static void main(String args[]){
		Collection col = new Collection();
		col.readFromFile();
		col.writeToFile();
	}
}
