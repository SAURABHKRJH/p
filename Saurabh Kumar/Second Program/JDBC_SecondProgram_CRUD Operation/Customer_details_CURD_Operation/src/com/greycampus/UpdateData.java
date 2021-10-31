package com.greycampus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class UpdateData {
	public void Add(Customer_details data, String time) {
		Connection connection = null;
		PreparedStatement statement = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate localDate = LocalDate.parse(time, formatter);
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##bms", "abc");
			statement = connection
					.prepareStatement("update Customer_details set updated_by=? ,update_on=?  where cid=?");
			statement.setString(1, data.getUpdated_by());
			statement.setObject(2, localDate);
			statement.setInt(3, data.getCid());
			statement.executeUpdate();
			System.out.println("success update");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

}
