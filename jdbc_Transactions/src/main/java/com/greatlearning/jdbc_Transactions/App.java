package com.greatlearning.jdbc_Transactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws SQLException {
		Connection conn = null;
		Savepoint savepoint1 = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/movies", "root", "sayan");
			Statement stmt = conn.createStatement();
			
			conn.setAutoCommit(false);
			savepoint1 = conn.setSavepoint("Save Point1");
			System.out.println("Savepoint1");
			
			String sql = "insert into movie_details (id,movie_name,genre,rating) values(115,'Joker','Crime, Thriller',9)";
			int row = stmt.executeUpdate(sql);
			
			savepoint1 = conn.setSavepoint("Save Point2");
			System.out.println("Savepoint2");
			
			sql = "insert into movie_details (id,movie_name,genre,rating) values(116,'The Dark Knight Rises','Action, Sci-Fi',8)";
			row = stmt.executeUpdate(sql);
			
			savepoint1 = conn.setSavepoint("Save Point3");
			System.out.println("SavePoint3");
			
			sql = "update movie_details set movie_name = 'Satyanweshi Byomkesh' where id = 112";
			row = stmt.executeUpdate(sql);
			
			conn.commit();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Roll Back");
			conn.rollback(savepoint1);
//			e.printStackTrace();
		}finally {
			conn.close();
		}
	}
}
