package com.algorithms;

public class RotateArray {

	public static void rotate(int[] arr, int size) {
		int mid = (size - 1) / 2;
		int temp = 0;

		for (int i = 0; i <= mid; i++) {
			temp = arr[0];
//			System.out.println("temp -> " + temp);

			for (int j = 1; j < arr.length; j++) {
				arr[j - 1] = arr[j];
//				print(arr);
			}

			arr[size - 1] = temp;
//			print(arr);

		}
	}
	
	public static void rotate1(int[] arr, int size,int mid) {
		
		if(mid < 0) {
			return;
		}
		
		int temp = arr[0];
		for (int j = 1; j < arr.length; j++) {
			arr[j - 1] = arr[j];
			
		}
		
		arr[size -1] = temp;
		print(arr);
		
		mid--;
		rotate1(arr, size,mid);
		
	}

	public static void print(int[] arr) {
		for (int e : arr) {
			System.out.print(e + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5,6,7, 8, 9 };
		rotate1(arr, arr.length,(arr.length-1)/2);
//		print(arr);
	}

}
