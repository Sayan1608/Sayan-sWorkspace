package com.algorithms;

import java.util.Scanner;

public class Driver {
	
	public static void print(int[] arr) {
		for(int e : arr) {
			System.out.print(e + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.print("Enter the size of the array :: ");
		int size = in.nextInt();

		int[] arr = new int[size];

		System.out.println("Enter the " + size + " elements ::");

		for (int i = 0; i < size; i++) {
			arr[i] = in.nextInt();
		}
		
		//Sort the array using merge sort :: 
		
		MergeSort.mergeSort(arr, 0, arr.length-1);
		System.out.println("Sorted Array ::");
		print(arr);
		
		//rotate the array
		RotateArray.rotate(arr, size);
		System.out.println("Rotated Array :: ");
		print(arr);
		
		System.out.println("Enter key element :: ");
		int key = in.nextInt();
		//search the key
		
		int pos = AdvancedBinarySearch.binarySearch(arr, key, 0, size-1); 
		if(pos != -1){
			System.out.println("Key found at position "+ pos );
		}else {
			System.out.println("Not Found.");
		}
	}
	
	

}
