package com.gl.problem1;

import java.util.Scanner;
import java.util.Stack;

public class ConstructBuildingFloors {

	private static Scanner in = new Scanner(System.in);

	public void constructBuilding(int N) {

		Stack<Integer> floorStack = new Stack<Integer>();
		Stack<Integer> tempStack = new Stack<Integer>();
		int count = N;

		int[][] temp = new int[N][N];
		
		int i=0;
		int k = 0;

		for (i = 0; i < N; i++) {
			System.out.println("enter the floor size given on day : " + (i + 1));
			int size = in.nextInt();

			if (size > N || size < 1) {
				System.out.println("Invalid floor size");
				i--;
				continue;
			}
			
			if(tempStack.search(size)!=-1) {
				System.out.println("Size already present");
				i--;
				continue;
			}
			floorStack.push(size);
			tempStack.push(size);
			System.out.println("top -> " + floorStack.peek());
			k = 0;
			while (!floorStack.isEmpty() && count == floorStack.peek()) {
				count--;
				temp[i][k] = floorStack.pop();
				k++;

			}
			sort(temp[i]);
		}
		i--;
		while(!floorStack.isEmpty()) {
			temp[i][k++] = floorStack.pop();
		}
		sort(temp[i]);

//		for (i = 0; i < temp.length; i++) {
//		for (int j = 0; j < N; j++) {
//			System.out.print(temp[i][j]);
//		}
//		System.out.println();
//		}

		for (i = 0; i < N; i++) {
			System.out.println("\nDay: " + (i + 1));
			for (int val : temp[i]) {
				if (val != 0)
					System.out.print(val + " ");
			}
		}
		
		tempStack.clear();

	}

	public void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] < temp) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = temp;
		}
	}

	public void print(int[] arr) {
		for (int val : arr)
			System.out.print(val + " ");
	}

	public static void main(String[] args) {
		/*
		 * ConstructBuildingFloors obj = new ConstructBuildingFloors(); int[] arr =
		 * {5,7,9,3,1,4,2}; obj.sort(arr); obj.print(arr);
		 */
		ConstructBuildingFloors obj = new ConstructBuildingFloors();

		System.out.println("enter the total no of floors in the building");
		obj.constructBuilding(in.nextInt());

	}
}
