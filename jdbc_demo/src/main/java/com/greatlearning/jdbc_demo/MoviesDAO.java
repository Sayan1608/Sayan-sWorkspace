package com.greatlearning.jdbc_demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MoviesDAO {
	
	// Display Operation
	public void getAllMovies(Statement stmt) {
		String query = "select * from movie_details";
		try {
			ResultSet rs = stmt.executeQuery(query);
			System.out.println("\nData : ");
			while(rs.next()) {
				int id = rs.getInt("id");
				String movie_name = rs.getString("movie_name");
				String genre = rs.getString("genre");
				int rating = rs.getInt("rating");
				
				System.out.println("\nid: "+id + "\nMovie Name: "+movie_name
						+"\ngenre: "+genre
						+"\nrating: "+rating);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// Insertion Operation
	public void saveData(Connection conn) {
		String query = "insert into movie_details (id,movie_name,genre,rating) values(?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, 1001);
			pstmt.setString(2, "Deadpool");
			pstmt.setString(3, "Action, Comedy");
			pstmt.setInt(4, 9);
			int row = pstmt.executeUpdate();
			if(row > 0) {
				System.out.println("Insertion Successful");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateData(Connection conn) {
		String query = "update movie_details set id = ? where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, 106);
			pstmt.setInt(2, 1001);
			int row= pstmt.executeUpdate();
			
			if(row > 0) {
				System.out.println("Updated Successfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void deleteMovie(Connection conn) {
		String query = "delete from movie_details where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, 105);
			int row = pstmt.executeUpdate();
			
			if(row >0) {
				System.out.println("Deletion Successful");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
