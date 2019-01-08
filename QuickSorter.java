/* DESCRIPTION: This class takes in an array from the Controller 
 * 				and sorts it, the sorted array can be retrieved 
 * 				by calling its getArray method.
 * 
 * STUDENT: Nicholas Wojcik
 * CLASS: COSC 311
 * SECTION: 17720
 * DATE: 06 DEC 2017
 * VERSION: v1.0
 * 
 */

public class QuickSorter {
	
	 //_______________________FIELDS_________________________
	int low, high;
	String sortedArray[];
	int countt = 0;
	
	//______________________CONSTRUCTOR______________________
	//CALLS THE SORTING METHOD
	public QuickSorter(String ar[]) {
		high = ar.length - 1;
		low = 0;
		
		getSorted(low, high, ar);
		sortedArray = ar;
		System.out.println(countt + " loop calls.");
	}
	
	//_______________________METHODS_________________________
	//SORTS THE ARRAY USING THE MIDDLE VALUE AS A PIVOT FOR
	//THE QUICKSORT METHOD.
	public void getSorted(int low, int high, String arr[]) {
		if(arr == null || arr.length == 0)
			return;
		if (low >= high)
			return;
		
		int middle = low + ((high - low) /2);
		int pivot = Integer.parseInt(arr[middle]);
		
		int i = low;
		int j = high;
		
		while(i <= j) {
			countt++;
			while (Integer.parseInt(arr[i]) < pivot) {
				countt++;
				i++;
			}
			while(Integer.parseInt(arr[j]) > pivot) {
				countt++;
				j--;
			}
			if(i <= j) {
				int temp = Integer.parseInt(arr[i]);
				arr[i] = arr[j];
				arr[j] = Integer.toString(temp);
				i++;
				j--;
			}
		}
		if(low < j)
			getSorted(low, j, arr);
		if(high > i)
			getSorted(i, high, arr);
	}
	
	//RETURNS SORTED ARRAY TO THE CONTROLLER
	public String[] getArray() {
		return sortedArray;
	}
}
