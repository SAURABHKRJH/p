package com.greycampus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Retreive_Data {
	public void display() {
		Connection connection = null;
		Statement statement = null;
		ResultSet query = null;
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##bms", "abc");
			statement = connection.createStatement();
			query = statement.executeQuery("SELECT * FROM Customer_details");
			System.out.println(
					"cid    firstname  lastname  street  city  state  zipcode  product_name  created_on created_by pdate_on updated_by");
			while (query.next()) {
				int cid = query.getInt("cid");
				String firstname = query.getString("firstname");
				String lastname = query.getString("lastname");
				String street = query.getString("street");
				String city = query.getString("city");
				String state = query.getString("state");
				int zipcode = query.getInt("zipcode");
				String product_name = query.getString("product_name");
				String created_on = query.getString("created_on");
				String created_by = query.getString("created_by");
				String update_on = query.getString("update_on");
				String updated_by = query.getString("updated_by");
				System.out.println(cid + "    " + firstname + "   " + lastname + "   " + street + "    " + city + "   "
						+ state + "    " + zipcode + "   " + product_name + "   " + created_on + "     " + created_by
						+ "      " + update_on + "        " + updated_by);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				query.close();
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
	}

}
