package com.elecgrid.crud.paymentManagement.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.elecgrid.crud.paymentManagement.model.paymentModel;

public class paymentServices {
	
	Connection con;
	String msgOutput;

	public paymentServices(){
		try {
			String url = String.format("jdbc:mysql://localhost:3306/elecgrid");
			String username = "root";
			String password = "";

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,username, password);
		} catch(Exception e) {

			System.out.println( e + "data connection is unsuccessful");
		}
	}

	//insert customer
	public paymentModel insertPayment(paymentModel pay) {

		String insertQuery = "insert into payment (pay_id, card_no, pay_type, amount) Values(?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(insertQuery);
			ps.setInt(1, pay.getPay_id());
			ps.setString(2, pay.getCard_no());
			ps.setString(3, pay.getPay_type());
			ps.setDouble(4, pay.getAmount());

			ps.execute();
			
			

		} catch(Exception e) {
			System.out.println(e +"data insertion is unsuccessful");
		}

		return pay;
	}

	//read payment
	public ArrayList<paymentModel> readPayment() throws SQLException {
//		
//		msgOutput = "<table border='1'><tr><th>Customer ID</th><th>Customer Name</th>" +
//				"<th></th>" +
//				"<th>Item Description</th>" +
//				"<th>Update</th><th>Remove</th></tr>";

		ArrayList<paymentModel> selData = new ArrayList<paymentModel>();

		String selectQuery = "Select * from payment";

		PreparedStatement ps = con.prepareStatement(selectQuery);
		ResultSet rst = ps.executeQuery();

		while(rst.next()) {

			paymentModel cm = new paymentModel();

			cm.setPay_id(rst.getInt("pay_id"));
			cm.setCard_no(rst.getString("card_no"));
			cm.setPay_type(rst.getString("pay_type"));
			cm.setAmount(rst.getInt("amount"));

			selData.add(cm);
		}

		return selData;
	}

	//update payment
	public paymentModel updatePayment(paymentModel pay) {

		String updateQuery = "update payment set pay_id=?,card_no=?, pay_type=?, amount=?, where pay_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(updateQuery);
			ps.setInt(1, pay.getPay_id());
			ps.setString(2, pay.getCard_no());
			ps.setString(3, pay.getPay_type());
			ps.setDouble(4, pay.getAmount());

			ps.executeUpdate();

		} catch(Exception e) {
			System.out.println(e +"data update is unsuccessful");
		}

		return pay;
	}
	
	//delete customer
	public int deletePayment(int bill_id) {

		String deleteQuery = "delete from bills where bill_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(deleteQuery);
			ps.setInt(1,bill_id);

			ps.executeUpdate();

		} catch(Exception e) {
			System.out.println(e +"data deletion is unsuccessful");
		}

		return bill_id;
	}
}
