package com.stockers.service;

import java.util.ArrayList;

import com.stockers.model.Company;

public class MergeSort {

	public static void mergeSort(ArrayList<Company> companies, int low, int high, boolean b) {

		if (low < high) {
			int mid = (low + high) / 2;
			mergeSort(companies, low, mid, b);
			mergeSort(companies, mid + 1, high, b);
			if (b) {
				mergeIncreasing(companies, low, mid, high);
			} else {
				mergeDecreasing(companies, low, mid, high);
			}

		}
	}

	private static void mergeDecreasing(ArrayList<Company> companies, int low, int mid, int high) {

		int i = low;
		int j = mid + 1;
		int k = low;
		ArrayList<Company> temp = new ArrayList<Company>(companies.size());
		while (i <= mid && j <= high) {

			if (companies.get(i).getSharePrice() <= companies.get(j).getSharePrice()) {
				temp.add(companies.get(j));
				j++;
			} else {
				temp.add(companies.get(i));
				i++;
			}
			k++;
		}

		if (i > mid) {
			while (j <= high) {
				temp.add(companies.get(j++));
				k++;
			}
		}

		if (j > high) {
			while (i <= mid) {
				temp.add(companies.get(i++));
				k++;
			}
		}

		for (int z = low; z < k; z++) {
			companies.set(z, temp.get(z));
		}
	}

	private static void mergeIncreasing(ArrayList<Company> companies, int low, int mid, int high) {
		
		int i = low;
		int j = mid + 1;
		int k = low;
		ArrayList<Company> temp = new ArrayList<Company>(companies.size());
		while (i <= mid && j <= high) {

			if (companies.get(i).getSharePrice() <= companies.get(j).getSharePrice()) {
				temp.add(companies.get(i));
				i++;
			} else {
				temp.add(companies.get(j));
				j++;
			}
			k++;
		}

		if (i > mid) {
			while (j <= high) {
				temp.add(companies.get(j++));
				k++;
			}
		}

		if (j > high) {
			while (i <= mid) {
				temp.add(companies.get(i++));
				k++;
			}
		}

		for (int z = low; z < k; z++) {
			companies.set(z, temp.get(z));
		}
	}

}
