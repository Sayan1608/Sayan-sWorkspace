package com.stockers.main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import com.stockers.model.Company;
import com.stockers.service.StockersService;

public class Main {
	static ArrayList<Company> companies;

	static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		insertCompanyRecords();
//		printCompanyRecords();
		
		System.out.println("\n --------------------------------------------");
		showOptions();
		System.out.println("\n --------------------------------------------");

	}

	private static void printCompanyRecords() {
		System.out.println("\n --------------------------------------------");
		StockersService.printCompanies(companies);
		System.out.println("\n --------------------------------------------");
	}

	private static void insertCompanyRecords() {
		System.out.println("enter the no of companies ");
		int N = in.nextInt();

		// defining a List of Companies :
		companies = new ArrayList<Company>(N);

		// inserting the records for all the companies

		for (int i = 0; i < N; i++) {

			System.out.println("Enter the stock price of Company " + (i + 1));

			double price = in.nextDouble();

			Random r = new Random();

			boolean b = r.nextBoolean();

			System.out.println("Whether company's stock price rose today compare to yesterday? " + b+"\n");

			companies.add(new Company(price, b));

		}

//		System.out.println("there");

	}

	public static void showOptions() {

		int choice = 0;

		do {

			System.out.println("1. Display the companies stock prices in ascending order\n"
					+ "2. Display the companies stock prices in descending order\n"
					+ "3. Display the total no of companies for which stock prices rose today\n"
					+ "4. Display the total no of companies for which stock prices declined today\n"
					+ "5. Search a specific stock price.\n" + "0. Exit");

			choice = in.nextInt();

			switch (choice) {
			case 1:
				// display stock prices in ascending order;

				StockersService.displayRecordsInIncreasingOrder(companies);
				printCompanyRecords();

				break;
			case 2:
				// display stock prices in descending order;

				StockersService.displayRecordsInDecreasingOrder(companies);
				printCompanyRecords();

				break;
			case 3:
				// display no of companies for which stock prices went up today

				int inc = StockersService.noOfIncreasingStocks(companies);
				
				System.out.println("\nNo of Companies for which stock price rose today :: "+inc);

				break;
			case 4:
				// display no of companies for which stock prices declined today

				int dec = StockersService.noOfDecreasingStocks(companies);
				
				System.out.println("\nNo of Companies for which stock price declined today :: "+dec);

				break;
			case 5:
				// search for a specific stock price

				System.out.println("Enter price : ");
				double price = in.nextDouble();
				StockersService.searchStock(companies, price);

				break;
			case 0:
			default:
				// exit

				System.out.println("exiting...");
			}

		} while (choice != 0);

		System.out.println("Exited Successfully");

	}

}
