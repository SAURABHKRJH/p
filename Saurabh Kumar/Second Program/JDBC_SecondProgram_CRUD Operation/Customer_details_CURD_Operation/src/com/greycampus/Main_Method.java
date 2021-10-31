package com.greycampus;

import java.util.Scanner;

public class Main_Method {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);
		System.out.println("which operation u want to perform:");
		System.out.println("1.CREATE the data");
		System.out.println("2.Update the data");
		System.out.println("3.Delete the data  ");
		System.out.println("4.Retreive the data  ");
		int n = scanner.nextInt();
		if (n == 1) {

			System.out.println("we are in Insert block");
			System.out.println("Enter eid:");
			int eid = scanner.nextInt();
			System.out.println("Enter First Name");
			String firstname = scanner.next();
			System.out.println("Enter Last Name");
			String lastname = scanner.next();
			System.out.println("Enter Street");
			String street = scanner.next();
			System.out.println("Enter City");
			String city = scanner.next();
			System.out.println("Enter state");
			String state = scanner.next();
			System.out.println("Enter zip code");
			int zipcode = scanner.nextInt();
			System.out.println("Enter Product name");
			String product_name = scanner.next();
			System.out.println("Enter created by");

			String created_by = scanner.next();
			Customer_details details = new Customer_details();
			details.setCid(eid);
			details.setCity(city);
			details.setCreated_by(created_by);
			details.setFirstname(firstname);
			details.setLastname(lastname);
			details.setProduct_name(product_name);
			details.setState(state);
			details.setStreet(street);
			details.setUpdated_by(created_by);
			details.setZipcode(zipcode);
			InsertData data = new InsertData();
			int insert = data.Insert(details);
			System.out.println("successfully inserted");

		}
		if (n == 2) {
			Customer_details details = new Customer_details();
			System.out.println("enter updated by ");
			String updated_by = scanner.next();
			System.out.println("write date on :MM/dd/yyyy format");
			String update = scanner.next();
			System.out.println("enter cid");
			int cid = scanner.nextInt();

			System.out.println("eneter which data u want to update");

			details.setCid(cid);
			details.setUpdated_by(updated_by);

			UpdateData updateData = new UpdateData();
			updateData.Add(details, update);
			System.out.println("success update");

		}
		if (n == 3) {
			Customer_details details = new Customer_details();
			System.out.println("Enter cid for delete the record");
			int cid = scanner.nextInt();
			details.setCid(cid);
			DeleteData delete = new DeleteData();
			delete.disp(details);

		}
		if (n == 4) {
			Retreive_Data data = new Retreive_Data();
			data.display();
			System.out.println("success");
		}
	}

}
