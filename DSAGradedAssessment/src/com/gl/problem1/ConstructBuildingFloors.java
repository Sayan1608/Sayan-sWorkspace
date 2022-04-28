package com.gl.problem1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class ConstructBuildingFloors {

	private static Scanner in = new Scanner(System.in);
	static ArrayList<Integer> tempList = new ArrayList<Integer>();
	
	/*
	 * Algorithm:
	 * 
	 * 1)Take 2 stacks one is main stack where both push and pop operations would be performed
	 * and a temp stack where we will only push the values (for checking duplicates)
	 * 
	 * 2)Push the floor size available on each day onto the main stack.(Arrange in ascending
	 * order and push again in stack so that greatest size floor will be on top.
	 * 3)Define a var counter which will keep track of the no of floors constructed
	 * 
	 * 4)Pop from stack if top of stack equals the counter value and store the values
	 * inside a 2D temp array, descrement counter by 1 parallely when this condition is hit.
	 * 
	 * 5)Sort the floor sizes for each day in descending order.
	 * 
	 * 6)Pop all the elements from the stack till its empty and add to the temp array's last day
	 * 
	 * 7)Now iterate through the temp array and print the values for each day only for non zero values.
	 * 
	 * 
	 */

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
			
			while(!floorStack.isEmpty()) {
				tempList.add(floorStack.pop());
			}
			
			Collections.sort(tempList);
			
			for(int val : tempList) {
				floorStack.push(val);
			}
			tempList.clear();
			
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
