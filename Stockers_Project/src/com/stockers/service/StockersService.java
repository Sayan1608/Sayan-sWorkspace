package com.stockers.service;

import java.util.ArrayList;

import com.stockers.model.Company;

public class StockersService {

	public static void printCompanies(ArrayList<Company> companies) {

		for (int i = 0; i < companies.size(); i++) {
			System.out.println("stock price of Company " + (i + 1) + ": " + companies.get(i).getSharePrice());
//			System.out.println("Increasing stock : " + companies.get(i).isIncreasing());
		}
	}

	public static void displayRecordsInIncreasingOrder(ArrayList<Company> companies) {

		// perform merge sort in ascending order.
		
		System.out.println("\nViewing records in Increasing order\n");
		
		MergeSort.mergeSort(companies, 0, companies.size()-1, true);
	}

	public static void displayRecordsInDecreasingOrder(ArrayList<Company> companies) {
		
		// perform merge sort in decreasing order.
		
		System.out.println("\nViewing records in Decreasing order\n");

		MergeSort.mergeSort(companies, 0, companies.size()-1, false);
	}

	public static int noOfIncreasingStocks(ArrayList<Company> companies) {

		// display increasing stock prices
		
		int count = 0;
		
		for(Company com : companies) {
			if(com.isIncreasing()) {
				count++;
			}
		}
		
		return count;
		
	}

	public static int noOfDecreasingStocks(ArrayList<Company> companies) {

		// display decreasing stock prices
		
	int count = 0;
		
		for(Company com : companies) {
			if(!com.isIncreasing()) {
				count++;
			}
		}
		
		return count;
	}

	public static void searchStock(ArrayList<Company> companies, double price) {
		
//		System.out.println("inside searchStock");
		
		int pos = BinarySearch.search(companies, 0, companies.size()-1, price);
		
		if(pos > -1) {
			System.out.println("Stock of value "+ price +" is present.");
		}else {
			System.out.println("Stock of value "+ price +" is not present.");
		}

	}

}
