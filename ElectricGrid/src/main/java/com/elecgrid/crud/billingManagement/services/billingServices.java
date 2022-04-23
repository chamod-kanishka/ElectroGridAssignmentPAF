package com.elecgrid.crud.billingManagement.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class billingServices {
		
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
		
		//add billing
		public String insertBill(String bill_no, String bill_desc, String bill_type,String unit, String cus_id) {
			
			String output = "";

			try {
				
				Connection con = connect();
				
				if(con == null)
				{return "Error while connecting to the database for inserting data";}
				
				String insertQuery = "insert into bills (`bill_no`, `bill_desc`, `bill_type`, `unit`, `cus_id`)" + "values(?,?,?,?,?)";
				
				PreparedStatement ps = con.prepareStatement(insertQuery);
				
				ps.setString(1, bill_no);
				ps.setString(2, bill_desc);
				ps.setString(3, bill_type);
				ps.setString(4, unit);
				ps.setString(5, cus_id);

				ps.execute();
				con.close();
				
				output = "Inserted Successfully";

			} catch(Exception e) {
				output = "Error While inserting the bill.";
				System.err.println(e.getMessage());
			}

			return output;
		}
		
		//update billing
		public String updateBill(String bill_id, String bill_no, String bill_type, String bill_desc,String unit ) {
			
			String output="";
			
			try {
				
				Connection con = connect();
				
				if (con==null)
				{ return "Error!! While connecting to the database for updating the " + bill_id;}
				
				// create a prepared statement
				String query = "UPDATE bills SET bill_no=?, bill_type=?, bill_desc=?, unit=? WHERE cus_id=?";
				
				PreparedStatement preparedStmt = con.prepareStatement(query);
				
				// binding values
				preparedStmt.setString(1, bill_no);
				preparedStmt.setString(2, bill_type);
				preparedStmt.setString(3, bill_desc);
				preparedStmt.setString(4, unit);
				preparedStmt.setInt(5,Integer.parseInt(bill_id));
				
				// execute the statement
				preparedStmt.execute();
				
				con.close();
				
				output = "Updated successfully";
				
			} catch (Exception e) {
				
				output = "Error while updating the " + bill_no;
				System.err.println(e.getMessage());
			}
			
			return output;
		}
		
		//view Billing
		public String viewBill(int cus_id) {
			
			String output ="";
			
			try {
				
				Connection con = connect();
				
				if (con==null)
				{ return "Error!! While connecting to the database for read the bill";}
				
				String query = "select * from bills b, customer c where b.cus_id= " + cus_id + "&& c.cus_id = b.cus_id";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
				while(rs.next()) {
					
					String cusid = Integer.toString(rs.getInt("cus_id"));
					String cName = rs.getString("cus_name");
					String bill_no = rs.getString("bill_no");
					String curdate = rs.getString("curr_date");
					String units = rs.getString("unit");
					
					int unit = rs.getInt("unit");
					double curr_amount = 0;
					
					if(unit<=60) {
						curr_amount = (double) (unit * 7.85);
					}else if(unit>60 && unit<=90){
						curr_amount = (double) ((double) (60 * 7.85) + (unit - 60) * 10.00);
					}else if(unit>90 && unit<=120){
						curr_amount = (double) ((double) (60 * 7.85) + (30 * 10.00) + (unit - 90) * 27.75);
					}else if(unit>120 && unit<=180){
						curr_amount = (double) ((double) (60 * 7.85) + (30 * 10.00) + (30 *27.75) + (unit - 120) * 32.75);
					}else {
						curr_amount = (double) ((double) (60 * 7.85) + (30 * 10.00) + (30 * 27.75) + (60 * 32.75) + (unit - 180) * 45.00);
					}
					
					// Add into the html table
					output = "Customer ID - " + cusid + "<br>Name: " +cName + "<br>Bill No- "+bill_no+ "<br>Units- "+ units + "<br>Date- " + curdate + "<br>Amount - Rs. " +  curr_amount;
					
				}
				
				con.close();
				
				output += "</table>";
			} catch (Exception e) {
				output = "Error while reading bill";
				System.err.println(e.getMessage());
			}
			return output;
		}
		
		
		//Delete billing
		public String deleteBill(String billId)
		{
			String output = "";
			try
			{
			Connection con = connect();
			
			if (con == null)
			{return "Error while connecting to the database for deleting."; }
			
			// create a prepared statement
			String query = "delete from bills WHERE bill_id=?";
			
			PreparedStatement preparedStmt = con.prepareStatement(query);
			
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(billId));
			
			// execute the statement
			preparedStmt.execute();
			
			con.close();
			output = "Deleted successfully";
			}
			catch (Exception e)
			{
				output = "Error while deleting the bill.";
				System.err.println(e.getMessage());
			}
		return output;
		}
}
