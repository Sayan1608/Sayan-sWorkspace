package com.algorithms;

public class MergeSort {

	public static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid + 1, right);
			merge(arr, left, mid, right);
		}
	}

	private static void merge(int[] arr, int left, int mid, int right) {

		int i = left;
		int j = mid + 1;
		int k = left;
		int[] temp = new int[arr.length];

		while (i <= mid && j<= right) {
			
			if(arr[i] <= arr[j]) {
				temp[k] = arr[i];
				i++;
			}else {
				temp[k] = arr[j];
				j++;
			}
			k++;
		}
		
		if(i > mid) {
			while(j<=right) {
				temp[k++] = arr[j++];
			}
		}
		
		if(j>right) {
			while(i<=mid) {
				temp[k++] = arr[i++];
			}
		}
		
		for(int z= left;z< k;z++) {
			arr[z] = temp[z];
		}
	}
	
	public static void print(int[] arr) {
		for(int e : arr) {
			System.out.print(e + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = {5,4,3,1,2,6};
		
		mergeSort(arr, 0, arr.length - 1);
		print(arr);
	}
}
