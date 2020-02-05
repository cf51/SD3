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
