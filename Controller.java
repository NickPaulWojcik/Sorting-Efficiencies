/* DESCRIPTION: This class controls the flow of this program.  It 
 * 				takes in the provided input from the user and creates 
 * 				the appropriate sorter object to handle it, and then 
 * 				writes out to file.
 * 
 * STUDENT: Nicholas Wojcik
 * CLASS: COSC 311
 * SECTION: 17720
 * DATE: 06 DEC 2017
 * VERSION: v1.0
 * 
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Time;

public class Controller {
	
	//__________________________FIELDS_____________________________
	double start, stop;
	private String[] ascender = new String[10000];
	private String[] descender = new String[10000];
	private String[] randomer = new String[10000];

	//________________________CONSTRUCTORS_________________________
	public Controller() {
		System.out.println("No input passed to Controller.java's"
				+ "constructor.");
	}
	public Controller(String userChoice, String userFileName) throws IOException {
		readFiles();
		sort(userChoice);
		outputToFile(ascender, userFileName + "_asc.txt");
		outputToFile(descender, userFileName + "_des.txt");
		outputToFile(randomer, userFileName + "_rand.txt");
	}
	
	//__________________________METHODS___________________________
	//PARSES THE USERS INPUT FROM THE CONTRUCTOR AND CREATES THE 
	//APPROPRIATE SORTER OBJECT TO SORT AND TIME.
	public void sort(String choice) {
		if(choice.equals("1")) {
			System.out.println("___________________________________");
			start = System.currentTimeMillis();
			QuickSorter asc = new QuickSorter(ascender);
			System.out.println("QuickSort\nascending\n" + 
					(System.currentTimeMillis() - start) + " ms\n"
					+ "___________________________________");
			ascender = asc.getArray();
			
			start = System.currentTimeMillis();
			QuickSorter des = new QuickSorter(descender);
			System.out.println("QuickSort\ndescending\n" + 
					(System.currentTimeMillis() - start) + " ms\n"
					+ "___________________________________");
			descender = des.getArray();
			
			start = System.currentTimeMillis();
			QuickSorter ran = new QuickSorter(randomer);
			System.out.println("QuickSort\nrandom\n" +  
					(System.currentTimeMillis() - start) + " ms\n"
					+ "___________________________________");
			randomer = ran.getArray();
		}else if(choice.equals("2")) {
			System.out.println("___________________________________");
			start = System.currentTimeMillis();
			HeapSorter asc = new HeapSorter(ascender);
			System.out.println("HeapSort\nascending\n" + 
					(System.currentTimeMillis() - start) + " ms\n"
					+ "___________________________________");
			ascender = asc.getArray();
			
			start = System.currentTimeMillis();
			HeapSorter des = new HeapSorter(descender);
			System.out.println("HeapSort\ndescending\n" + 
					(System.currentTimeMillis() - start) + " ms\n"
					+ "___________________________________");
			descender = des.getArray();
			
			start = System.currentTimeMillis();
			HeapSorter ran = new HeapSorter(randomer);
			System.out.println("HeapSort\nrandom\n" +  
					(System.currentTimeMillis() - start) + " ms\n"
					+ "___________________________________");
			randomer = ran.getArray();	
		}else if(choice.equals("3")) {
			System.out.println("___________________________________");
			start = System.currentTimeMillis();
			MergeSorter asc = new MergeSorter(ascender);
			System.out.println("MergeSort\nascending\n" + 
					(System.currentTimeMillis() - start) + " ms\n"
					+ "___________________________________");
			ascender = asc.getArray();
			
			System.out.println("___________________________________");
			start = System.currentTimeMillis();
			MergeSorter des = new MergeSorter(descender);
			System.out.println("MergeSort\ndescending\n" + 
					(System.currentTimeMillis() - start) + " ms\n"
					+ "___________________________________");
			ascender = des.getArray();
			
			System.out.println("___________________________________");
			start = System.currentTimeMillis();
			MergeSorter ran = new MergeSorter(randomer);
			System.out.println("MergeSort\nrandom\n" + 
					(System.currentTimeMillis() - start) + " ms\n"
					+ "___________________________________");
			ascender = ran.getArray();
		}else {
			System.out.println("Invalid choice.");
		}
	}
	//READS THE PROVIDED DATASET AND INSERTS INFORMATION INTO ARRAYS
	public void readFiles() throws IOException {
		File ascending = new File("ascending.txt");
		File descending = new File("descending.txt");
		File random = new File("random.txt");
		
		try {
			FileReader ascReader = new FileReader(ascending);
			FileReader desReader = new FileReader(descending);
			FileReader ranReader = new FileReader(random);
			
			BufferedReader ascended = new BufferedReader(ascReader);
			BufferedReader descended = new BufferedReader(desReader);
			BufferedReader randomed = new BufferedReader(ranReader);
			
			//READS TO ASCENDER ARRAY
			String line = ascended.readLine();
			int count = 0;
			while(line != null) {
				ascender[count] = line;
				count++;
				line = ascended.readLine();
			}
			//READS TO DESCENDER ARRAY
			line = descended.readLine();
			count = 0;
			while(line != null) {
				descender[count] = line;
				count++;
				line = descended.readLine();
			}
			//READS TO RANDOMER ARRAY
			line = randomed.readLine();
			count = 0;
			while(line != null) {
				randomer[count] = line;
				count++;
				line = randomed.readLine();
			}

			//CLEANUP VARIABLES AND STREAMS
			count = 0;
			ascended.close();
			descended.close();
			randomed.close();
			ascReader.close();
			desReader.close();
			ranReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//WRITES SORTED ARRAYS TO USER PROVIDED FILE
	public void outputToFile(String array[], String name){
		try {
			PrintWriter toFile = new PrintWriter(name);
			for(int i = 0; i < 10000; i++) {
				toFile.println(array[i]);
			}
			toFile.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
