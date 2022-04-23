package com.elecgrid.crud.customerManagement.services;

import java.sql.*;

public class customerServices{

	//connection
	private Connection connect() {
		Connection con = null;
		try {
<<<<<<< HEAD
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = String.format("jdbc:mysql://localhost:3306/elecgrid");
=======
			String url = String.format("jdbc:mysql://localhost:3306/electricgrid");
>>>>>>> 98241698c5f077dcdeb57a61efbf06be7a361c66
			String username = "root";
			String password = "";
			
			con = DriverManager.getConnection(url,username, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	//insert customer
<<<<<<< HEAD
	public String insertCustomer(String cus_name, String cus_email, String cus_mobile) {
		
		String output = "";
=======
	public customerModel insertCustomer(customerModel cus) {

		String insertQuery = "insert into customer (cus_id, cus_name, unit, cus_email, cus_mobile) Values(?,?,?,?,?)";
>>>>>>> 98241698c5f077dcdeb57a61efbf06be7a361c66

		try {
			
			Connection con = connect();
			
			if(con == null)
			{return "Error while connecting to the database for inserting data";}
			
			String insertQuery = "insert into customer (`cus_id`, `cus_name`, `cus_email`, `cus_mobile`)" + "values(?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(insertQuery);
<<<<<<< HEAD
			ps.setInt(1, 0);
			ps.setString(2, cus_name);
			ps.setString(3, cus_email);
			ps.setString(4, cus_mobile);

			ps.execute();
			con.close();
			
			output = "Inserted Successfully";
=======
			ps.setInt(1, cus.getCus_id());
			ps.setString(2, cus.getCus_name());
			ps.setString(3, cus.getCus_email());
			ps.setString(4, cus.getCus_mobile());

			ps.execute();
>>>>>>> 98241698c5f077dcdeb57a61efbf06be7a361c66

		} catch(Exception e) {
			output = "Error While inserting the customer.";
			System.err.println(e.getMessage());
		}

		return output;
	}

<<<<<<< HEAD
	//view customer details
	public String viewCustomer() {
		
		String output ="";
		
		try {
			
			Connection con = connect();
			
			if (con==null)
			{ return "Error!! While connecting to the database for read the customers";}
			
			// Prepare the html table to be displayed
			output = "<table border='1'><tr><th>Name</th><th>Mobile</th>" +
			"<th>Email</th>" +
			"<th>Update</th><th>Remove</th></tr>";
			
			String query = "select * from customer";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				
				String cus_id = Integer.toString(rs.getInt("cus_id"));
				String cus_name = rs.getString("cus_name");
				String cus_mobile = rs.getString("cus_mobile");
				String cus_email = rs.getString("cus_email");
				
				// Add into the html table
				output += "<tr><td>" + cus_name + "</td>";
				output += "<td>" + cus_mobile + "</td>";
				output += "<td>" + cus_email + "</td>";
				
				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update'class='btn btn-secondary'></td>"
				+ "<td><form method='post' action='items.jsp'>"
				+ "<input name='btnRemove' type='submit' value='Remove'class='btn btn-danger'>"
				+ "<input name='cus_id' type='hidden' value='" + cus_id
				+ "'>" + "</form></td></tr>";
				
			}
			
			con.close();
			
			output += "</table>";
		} catch (Exception e) {
			output = "Error while reading customers";
			System.err.println(e.getMessage());
=======
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
>>>>>>> 98241698c5f077dcdeb57a61efbf06be7a361c66
		}
		return output;
	}
	
	//update customer details
	public String updateCustomer(String cus_id, String cus_name, String cus_mobile, String cus_email) {
		
		String output="";
		
		try {
			
			Connection con = connect();
			
			if (con==null)
			{ return "Error!! While connecting to the database for updating the " + cus_name;}
			
			// create a prepared statement
			String query = "UPDATE customer SET cus_name=?, cus_mobile=?, cus_email=? WHERE cus_id=?";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// binding values
			preparedStmt.setString(1, cus_name);
			preparedStmt.setString(2, cus_mobile);
			preparedStmt.setString(3, cus_email);
			preparedStmt.setInt(4,Integer.parseInt(cus_id));
			
			// execute the statement
			preparedStmt.execute();
			
			con.close();
			
			output = "Updated successfully";
			
		} catch (Exception e) {
			
			output = "Error while updating the " + cus_name;
			System.err.println(e.getMessage());
		}
		
		return output;
	}
	
	//delete Customer from db
	public String deleteCustomer(String cus_id)
	{
		String output = "";
		try
		{
		Connection con = connect();
		
		if (con == null)
		{return "Error while connecting to the database for deleting."; }
		
		// create a prepared statement
		String query = "delete from customer WHERE cus_id=?";
		
		PreparedStatement preparedStmt = con.prepareStatement(query);
		
		// binding values
		preparedStmt.setInt(1, Integer.parseInt(cus_id));
		
		// execute the statement
		preparedStmt.execute();
		
		con.close();
		output = "Deleted successfully";
		}
		catch (Exception e)
		{
			output = "Error while deleting the customer.";
			System.err.println(e.getMessage());
		}
	return output;
	}
	
	//get customer by id
	public String getCustomerById(int cus_id) {
		String output ="";
		
		try {
			
			Connection con = connect();
			
			if (con==null)
			{ return "Error!! While connecting to the database for read the customers";}
			
			
			
			String selquery = "select * from customer WHERE cus_id= " + cus_id;
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(selquery);
			
			while(rs.next()) {
				
				
				String cus_name = rs.getString("cus_name");
				String cus_mobile = rs.getString("cus_mobile");
				String cus_email = rs.getString("cus_email");
				
				// Add into the html table
				output += "Name: " + cus_name + "<br>" + "Mobile No: " + cus_mobile;
				output += "<br>Email: " + cus_email;
				
			}
			
			con.close();
			
		} catch (Exception e) {
			output = "Error while reading customer";
			System.err.println(e.getMessage());
		}
		return output;
	}
}
