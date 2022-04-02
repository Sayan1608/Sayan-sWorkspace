package com.practice.sorting;

import java.util.Arrays;

public class RadixSort {

	public static int findMax(int[] arr) {
		int max = arr[0];

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}

	public static void countingSort(int[] arr, int exp) {
		int[] result = new int[arr.length];
		int[] count = new int[10];
		Arrays.fill(count, 0);

		for (int i = 0; i < arr.length; i++) {
			count[(arr[i] / exp) % 10]++;
		}

		for (int i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			result[count[(arr[i] / exp) % 10] - 1] = arr[i];
			count[(arr[i] / exp) % 10]--;
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = result[i];
		}
	}

	public static void radixSort(int[] arr) {
		int max = findMax(arr);

		for (int exp = 1; max / exp > 0; exp *= 10) {
			countingSort(arr, exp);
		}
	}

	public static void print(int[] arr) {

		for (int e : arr) {
			System.out.print(e + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = { 120, 23, 44, 95, 180, 555, 476, 299 };
		System.out.println("Before Sorting");
		print(arr);

		radixSort(arr);
		System.out.println("After Radix Sort ::");
		print(arr);

	}

}
