/* DESCRIPTION: This class takes an array in from the controller 
 * 				and sorts it using the heap sort.  The sorted 
 * 				array can be retrieved by calling the getArray
 * 				method.
 * 
 * STUDENT: Nicholas Wojcik
 * CLASS: COSC 311
 * SECTION: 17720
 * DATE: 06 DEC 2017
 * VERSION: v1.0
 * 
 */

public class HeapSorter {
	
	//___________________________FIELDS__________________________
	String sortedArray[];
	int len;
	int countt;

	//_________________________CONSTRUCTOR_______________________
	//CALLS THE GETSORTED METHOD TO SORT THE ARRAY PARAMETER
	public HeapSorter(String[] arr) {
		len = arr.length;
		sortedArray = arr;
		
		getSorted(arr);
		sortedArray = arr;
		System.out.println(countt + " loop calls.");
	}
	
	//__________________________METHODS__________________________
	//PICKS THE ROOT AND HEAPIFIES USING LOOPS
	public void getSorted(String[] ar) {
		for(int k = len / 2 - 1; k >= 0; k--) {
			countt++;
			heapify(ar, len, k);
		}
		for(int j = len-1; j>=0; j--) {
			countt++;
			int temp = Integer.parseInt(ar[0]);
			ar[0] = ar[j];
			ar[j] = Integer.toString(temp);
			heapify(ar, j, 0);
		}
	}
	
	//RECURSIVE METHOD TO HEAPIFY AN ARRAY BEFORE REMOVING THE 
	//ROOT.
	public void heapify(String ar[], int n, int k) {
		int largest = k;
		int l = (2*k) + 1;
		int r = (2*k) + 2;
		
		if(l < n && Integer.parseInt(ar[l]) > Integer.parseInt(ar[largest])) {
			largest = l;
		}
		if(r < n && Integer.parseInt(ar[r]) > Integer.parseInt(ar[largest])) {
			largest = r;
		}
		if(largest != k) {
			int switcher = Integer.parseInt(ar[k]);
			ar[k] = ar[largest];
			ar[largest] = Integer.toString(switcher);
			
			heapify(ar, n, largest);
		}
	}
	
	//RETURNS THE SORTED ARRAY TO THE CONTROLLER
	public String[] getArray() {
		return sortedArray;
	}
	
}
