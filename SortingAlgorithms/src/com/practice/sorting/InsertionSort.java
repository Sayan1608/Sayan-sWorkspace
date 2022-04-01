package com.practice.sorting;

public class InsertionSort {

	public void insertionSort(int[] arr) {

		int i = 1;
		int partition = 1;

		while (partition < arr.length) {
			System.out.println("Pass " + (i) + ":");
			int j = i - 1;
			int temp = arr[i];

			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;
			partition++;
			i++;
			print(arr);
		}
	}

	public void print(int[] arr) {

		for (int e : arr) {
			System.out.print(e + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 95, 72, 56, 45, 32, 36, 23 };
		InsertionSort ob = new InsertionSort();
		System.out.println("Before Sorting :: ");
		ob.print(arr);
		ob.insertionSort(arr);
		System.out.println("After Insertion Sort :: ");
		ob.print(arr);

	}

}
