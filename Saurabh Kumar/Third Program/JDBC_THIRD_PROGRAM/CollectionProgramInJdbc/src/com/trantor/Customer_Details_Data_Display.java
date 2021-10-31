package com.trantor;

import java.util.ArrayList;

public class Customer_Details_Data_Display {
	public static void main(String[] args) {

		Retreive_Customer_Details_data retreiveData = new Retreive_Customer_Details_data();

		ArrayList<Customer_Details> employeesData = retreiveData.getAllData();

		employeesData.forEach(p -> {

			System.out.println("cid:" + p.getCid());
			System.out.println("first name:" + p.getFirstname());
			System.out.println("last name:" + p.getLastname());
			System.out.println("street:" + p.getStreet());
			System.out.println("city:" + p.getCity());
			System.out.println("state:" + p.getState());
			System.out.println("zipcode:" + p.getZipcode());
			System.out.println("Product_name:" + p.getProduct_name());
			System.out.println("Created_on:" + p.getCreated_on());
			System.out.println("Created_by:" + p.getCreated_by());
			System.out.println("tUpdate_on:" + p.getUpdate_on());
			System.out.println("tUpdate_by:" + p.getUpdated_by());

			System.out.println();

		});

	}
}
