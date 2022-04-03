package com.algorithms;

public class TeamFormation {

	public static boolean isPossible(int[] teams, int T, int k) {

		// Store the sum of Array elements
		int sum = 0;

		// Traverse the array
		for (int i = 0; i < teams.length; i++) {
			sum += Math.min(T, teams[i]);
			System.out.println("sum = " + sum);
		}

		// required condition
		return (sum >= (T * k));
	}

	public static int countOfTeams(int[] teams, int N, int k) {
		// Lower and Upper Part of the range
		int lowerBound = 0;
		double upperBound = 10000;

		// Perform binary search

		while (lowerBound <= upperBound) {
			int mid = lowerBound + (int) (upperBound - lowerBound) / 2;
			System.out.println("mid -> " + mid);

			if (isPossible(teams, mid, k)) {

				if (!isPossible(teams, mid + 1, k)) {
					return mid;
				}

				else {
					lowerBound = mid + 1;
				}
			}

			else {
				upperBound = mid - 1;
			}

			System.out.println("mid -> " + mid);

		}
		return 0;
	}

	public static void main(String[] args) {

		int[] arr = { 2, 3, 4, 7 };
		int K = 2;
		int N = arr.length;
		System.out.println(countOfTeams(arr, N, K));
	}

}
