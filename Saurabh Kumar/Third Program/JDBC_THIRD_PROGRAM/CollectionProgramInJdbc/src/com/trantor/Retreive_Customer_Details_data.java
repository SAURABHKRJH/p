package com.trantor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Retreive_Customer_Details_data {
	public ArrayList<Customer_Details> getAllData() {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ArrayList<Customer_Details> emplist = null;
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##bms", "abc");
			statement = connection.createStatement();
			resultSet = statement.executeQuery("select * from Customer_details");
			emplist = new ArrayList<Customer_Details>();
			while (resultSet.next()) {

				Customer_Details employee = new Customer_Details();
				employee.setCid(resultSet.getInt("cid"));
				employee.setFirstname(resultSet.getString("firstname"));
				employee.setLastname(resultSet.getString("lastname"));
				employee.setStreet(resultSet.getString("street"));
				employee.setCity(resultSet.getString("city"));
				employee.setState(resultSet.getString("state"));
				employee.setZipcode(resultSet.getInt("zipcode"));
				employee.setProduct_name(resultSet.getString("product_name"));
				employee.setCreated_on(resultSet.getString("created_on"));
				employee.setCreated_by(resultSet.getString("created_by"));
				employee.setUpdate_on(resultSet.getString("update_on"));
				employee.setUpdated_by(resultSet.getString("updated_by"));

				emplist.add(employee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return emplist;
	}

}