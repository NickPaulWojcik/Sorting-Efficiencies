/* DESCRIPTION: This class contains the main method, and uses prompts to 
 * 				gather the preferred sort and the file to output to.  It 
 * 				uses a Controller object.
 * 
 * STUDENT: Nicholas Wojcik
 * CLASS: COSC 311
 * SECTION: 17720
 * DATE: 06 DEC 2017
 * VERSION: v1.0
 * 
 */

import java.io.IOException;
import java.util.Scanner;

public class Runner {
	static Controller control;

	//**************************MAIN METHOD****************************
	public static void main(String[] args) throws IOException {
		
		//_______________________FIELDS________________________________
		String userChoice = "";
		String userFileName = "";
		Scanner keyboard = new Scanner(System.in);
		
		//_____________________USER PROMPT_____________________________
		while(true) {
			System.out.println("\nWelcome to the integer sorter.\n"
					+ "Please enter the sort to implement.\n"
					+ "1. QuickSort\n"
					+ "2. HeapSort\n"
					+ "3. MergeSort\n"
					+ "4. Quit\n"
					+ "___________________________________");
			
			userChoice = keyboard.next();
			if(userChoice.equals("4")) {
				break;
			}
			System.out.println("Please enter a file name for output.  "
								+ "(extensions used: _asc, _des, _rand).");
			userFileName = keyboard.next();
			control = new Controller(userChoice, userFileName);
		}
		keyboard.close();
	}
}
