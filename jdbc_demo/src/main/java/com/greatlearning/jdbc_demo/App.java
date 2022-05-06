package com.greatlearning.jdbc_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws SQLException {

		Connection conn = null;
		Scanner in = new Scanner(System.in);

		try {
			// create Connection Object using DriverManager

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies", "root", "sayan");

			// create statement object

			Statement stmt = conn.createStatement();
			MoviesDAO mDao = new MoviesDAO();
			int input = 0;
			do {

				System.out.println("Movies DAO:");
				System.out.println("1. Display");
				System.out.println("2. Insert");
				System.out.println("3 Update");
				System.out.println("4 Delete");

				
				System.out.print("\n\nEnter your choice : ");
				input = in.nextInt();

				switch (input) {
				case 1:
					mDao.getAllMovies(stmt);
					break;
				case 2:
					mDao.saveData(conn);
					break;
				case 3:
					mDao.updateData(conn);
					break;
				case 4:
					mDao.deleteMovie(conn);
					break;
				case 0:
					System.out.println("Exiting...");
					break;
				default:
					System.out.println("Wrong choice.");
					break;

				}

			} while (input > 0);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Exited Successfully.");
			conn.close();
			in.close();
		}
	}
}
