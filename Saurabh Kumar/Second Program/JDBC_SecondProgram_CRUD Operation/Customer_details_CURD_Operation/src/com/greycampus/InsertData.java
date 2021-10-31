package com.greycampus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
	private static java.sql.Date getCurrentDate() {
		java.util.Date today = new java.util.Date();
		return new java.sql.Date(today.getTime());
	}

	public int Insert(Customer_details data) {
		Connection connection = null;
		PreparedStatement prepareStatement = null;
		int p = 0;
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##bms", "abc");
			prepareStatement = connection.prepareStatement(
					"insert into Customer_details (cid ,firstname ,lastname,street,city,state,zipcode, product_name,created_on ,created_by,update_on,updated_by) values (?,?,?,?,?,?,?,?,?,?,?,?)");
			prepareStatement.setInt(1, data.getCid());
			prepareStatement.setString(2, data.getFirstname());
			prepareStatement.setString(3, data.getLastname());
			prepareStatement.setString(4, data.getStreet());
			prepareStatement.setString(5, data.getCity());
			prepareStatement.setString(6, data.getState());
			prepareStatement.setInt(7, data.getZipcode());
			prepareStatement.setString(8, data.getProduct_name());
			prepareStatement.setDate(9, getCurrentDate());
			prepareStatement.setString(10, data.getCreated_by());
			prepareStatement.setString(11, null);
			prepareStatement.setString(12, null);
			int update = prepareStatement.executeUpdate();
			System.out.println(" successfully inserted .....");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				prepareStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return p;
	}

}
