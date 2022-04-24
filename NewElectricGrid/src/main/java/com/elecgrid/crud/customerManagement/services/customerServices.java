package com.elecgrid.crud.customerManagement.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.elecgrid.crud.customerManagement.model.customerModel;

public class customerServices {

	Connection con;
	String msgOutput;

	public customerServices(){
		try {
			String url = String.format("jdbc:mysql://localhost:3306/electricgrid");
			String username = "root";
			String password = "";

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username, password);
		} catch(Exception e) {

			System.out.println( e + "data connection is unsuccessful");
		}
	}

	//insert customer
	public customerModel insertCustomer(customerModel cus) {

		String insertQuery = "insert into customer (cus_id, cus_name, unit, cus_email, cus_mobile) Values(?,?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(insertQuery);
			ps.setInt(1, cus.getCus_id());
			ps.setString(2, cus.getCus_name());
			ps.setString(3, cus.getCus_email());
			ps.setString(4, cus.getCus_mobile());

			ps.execute();

		} catch(Exception e) {
			System.out.println(e +"data insertion is unsuccessful");
		}

		return cus;
	}

	//get the list of the customer
	public ArrayList<customerModel> getCustomer() throws SQLException {

		ArrayList<customerModel> selData = new ArrayList<customerModel>();

		String selectQuery = "Select * from customer";

		PreparedStatement ps = con.prepareStatement(selectQuery);
		ResultSet rst = ps.executeQuery();

		while(rst.next()) {

			customerModel cm = new customerModel();

			cm.setCus_id(rst.getInt("cus_id"));
			cm.setCus_name(rst.getString("cus_name"));
			cm.setCus_email(rst.getString("cus_email"));
			cm.setCus_mobile(rst.getNString("cus_mobile"));

			selData.add(cm);
		}

		return selData;
	}

	//update customer
	public customerModel updateCustomer(customerModel cus) {

		String updateQuery = "update customer set cus_id=?,cus_name=?, unit=?, cus_email=?, cus_mobile=? where cus_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(updateQuery);
			ps.setInt(1, cus.getCus_id());
			ps.setString(2, cus.getCus_name());
			ps.setString(4, cus.getCus_email());
			ps.setString(5, cus.getCus_mobile());
			ps.setInt(6, cus.getCus_id());

			ps.executeUpdate();

		} catch(Exception e) {
			System.out.println(e +"data update is unsuccessful");
		}

		return cus;
	}
	
	//delete customer
	public int deleteCustomer(int cus_id) {

		String deleteQuery = "delete from customer_details where cus_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(deleteQuery);
			ps.setInt(1,cus_id);

			ps.executeUpdate();

		} catch(Exception e) {
			System.out.println(e +"data deletion is unsuccessful");
		}

		return cus_id;
	}
}
