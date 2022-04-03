package com.algorithms;

public class AdvancedBinarySearch {

	public static int binarySearch(int[] arr, int key, int low, int high) {
		
		//if key is not present
		if(low > high) {
			return -1;
		}
		
		//if key is present
		int mid = (low+high)/2;
		
		if(arr[mid] == key) {
			return mid;
		}
		
		//if left half is sorted
		if(arr[mid] >= arr[low]) {
			
			//if key is present in left-half
			if(arr[low] <= key && arr[mid] >= key) {
				return binarySearch(arr, key, low, mid-1);
			}
			// if key not present in left-half search in right half
			else {
				return binarySearch(arr, key, mid+1, high);
			}
		}
		
		//if right half is sorted
		else {
			//if key present in right-half
			if(arr[high] >= key && arr[mid] <= key) {
				return binarySearch(arr, key, mid+1, high);
			}
			
			//if key not present in right half search in left-half
			else {
				return binarySearch(arr, key, low, mid-1);
			}
		}
		
		
		
		
	}
	public static void main(String[] args) {
		int[] arr = {7,8,9,1,2,3,4};
		
		System.out.println(binarySearch(arr, 8, 0, arr.length-1));
	}

}
