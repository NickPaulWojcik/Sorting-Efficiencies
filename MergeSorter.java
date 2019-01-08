/* DESCRIPTION: This class accepts an array from the controller 
 * 				and uses the merge sort to sort it.  The 
 * 				sorted array can be retrieved by calling the 
 * 				getArray method.
 * 
 * STUDENT: Nicholas Wojcik
 * CLASS: COSC 311
 * SECTION: 17720
 * DATE: 06 DEC 2017
 * VERSION: v1.0
 * 
 */

public class MergeSorter {
	
	//__________________________FIELDS_________________________
	private String sortedArray[];
	private int countt = 0;
	private String nums[];
	private String temp[];
	private int number;
	
	//________________________CONSTRUCTOR______________________
	//CALLS THE GETSORTED METHOD TO SORT THE ARRAY PARAMETER.
	public MergeSorter(String arr[]) {
		this.nums = arr;
		number = arr.length;
		temp = new String[number];
		
		getSorted(0, number - 1);
		sortedArray = nums;
		System.out.println(countt + " loop calls.");
	}
	
	//_________________________METHODS_________________________
	//SORTS THE ARRAY USING THE MERGE SORT RECURSIVELY AND
	//CALLS THE MERGE METHOD.
	public void getSorted(int low, int high) {
		if(low < high) {
			int middle = low + (high-low)/2;
			getSorted(low, middle);
			getSorted(middle+1, high);
			merge(low, middle, high);	
		}
	}
	
	//MERGES THE SPLIT ARRAY BACK TOGETHER AFTER IT HAS BEEN 
	//SORTED BY THE GETSORTED METHOD.
	public void merge(int low, int middle, int high) {
		for(int i = low; i <= high; i++) {
			countt++;
			temp[i] = nums[i];
		}
		int i = low;
		int j = middle + 1;
		int k = low;
		
		while(i <= middle && j <= high) {
			countt++;
			if(Integer.parseInt(temp[i]) <= Integer.parseInt(temp[j])) {
				nums[k] = temp[i];
				i++;
			}else {
				nums[k] = temp[j];
				j++;
			}
			k++;
		}
		while(i <= middle) {
			countt++;
			nums[k] = temp[i];
			k++;
			i++;
		}
	}
	
	//RETURNS THE SORTED ARRAY TO THE CONTROLLER
	public String[] getArray() {
		return sortedArray;
	}
	
}
