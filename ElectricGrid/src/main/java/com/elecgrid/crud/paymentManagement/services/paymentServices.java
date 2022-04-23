package com.elecgrid.crud.paymentManagement.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
<<<<<<< HEAD
import java.sql.Statement;

public class paymentServices {
	
	//connection
		private Connection connect() {
			Connection con = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				String url = String.format("jdbc:mysql://localhost:3306/elecgrid");
				String username = "root";
				String password = "";
				
				con = DriverManager.getConnection(url,username, password);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return con;
		}
		
		//insert payment details
		public String insertPayDetails(String pay_type, String amount, String cus_id, String bill_id) {
			
			String output = "";
			
			try {
				
				Connection con = connect();
				
				if(con == null)
				{return "Error while connecting to the database for inserting data";}
				
				String insertQuery = "insert into payment (`pay_id`, `pay_type`,`amount`, `cus_id`, `bill_id`)" + "values(?,?,?,?,?)";
				
				PreparedStatement ps = con.prepareStatement(insertQuery);
				ps.setInt(1, 0);
				ps.setString(2, pay_type);
				ps.setString(3, amount);
				ps.setString(4, cus_id);
				ps.setString(5, bill_id);

				ps.execute();
				con.close();

			} catch(Exception e) {
				output = "Payment does not go through.. somthing went wrong!.";
				System.err.println(e.getMessage());
			}
			
			return output;
		}
		
		//view all payments
		public String viewPayments() {
			
			String output ="";
			
			try {
				
				Connection con = connect();
				
				if (con==null)
				{ return "Error!! While connecting to the database for read the payments";}
				
				// Prepare the html table to be displayed
				output = "<table border='1'><tr><th>id</th><th>Payment Type</th>" +
				"<th>Amount (Rs.)</th>" +
				"<th>Update</th><th>Remove</th></tr>";
				
				String query = "select * from payment";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
				while(rs.next()) {
					
					String pay_id = Integer.toString(rs.getInt("pay_id"));
					String pay_type = rs.getString("pay_type");
					String amount = rs.getString("amount");
					
					// Add into the html table
					output += "<tr><td>" + pay_id + "</td>";
					output += "<td>" + pay_type + "</td>";
					output += "<td>" + amount + "</td>";
					
					// buttons
					output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>"
					+ "<td><form method='post' action='items.jsp'>"
					+ "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
					+ "<input name='cus_id' type='hidden' value='" + pay_id
					+ "'>" + "</form></td></tr>";
					
				}
				
				con.close();
				
				output += "</table>";
			} catch (Exception e) {
				output = "Error while reading payments";
				System.err.println(e.getMessage());
			}
			return output;
		}
		
		//update payment --> Payment update is unnecessary <--
		public String updatePayment(String pay_id, String pay_type, String amount) {
			
			String output="";
			
			try {
				
				Connection con = connect();
				
				if (con==null)
				{ return "Error!! While connecting to the database for updating the " + pay_id;}
				
				// create a prepared statement
				String query = "UPDATE payment SET pay_type=?, amount=?, WHERE cus_id=?";
				
				PreparedStatement preparedStmt = con.prepareStatement(query);
				
				// binding values
				preparedStmt.setString(1, pay_type);
				preparedStmt.setString(2, amount);
				preparedStmt.setInt(3,Integer.parseInt(pay_id));
				
				// execute the statement
				preparedStmt.execute();
				
				con.close();
				
				output = "Updated payment successfully";
				
			} catch (Exception e) {
				
				output = "Error while updating the " + pay_id;
				System.err.println(e.getMessage());
			}
			
			return output;
		}
		
		//delete
		public String deleteCustomer(String pay_id)
		{
			String output = "";
			try
			{
			Connection con = connect();
			
			if (con == null)
			{return "Error while connecting to the database for deleting."; }
			
			// create a prepared statement
			String query = "delete from payment WHERE pay_id=?";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(pay_id));
			
			// execute the statement
			preparedStmt.execute();
			
			con.close();
			output = "<h1>Deleted paymen detail successfully</h1>";
			}
			catch (Exception e)
			{
				output = "Error while deleting the payment detail.";
				System.err.println(e.getMessage());
			}
		return output;
		}
		
=======
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
>>>>>>> 98241698c5f077dcdeb57a61efbf06be7a361c66
}
