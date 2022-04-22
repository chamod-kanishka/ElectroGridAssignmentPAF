package com.elecgrid.crud.employeeManagement.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.elecgrid.crud.employeeManagement.model.employeeModel;

public class employeeServices {

	Connection con;

	public employeeServices(){
		try {
			String url = String.format("jdbc:mysql://localhost:3306/customer");
			String username = "root";
			String password = "";

			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username, password);
		} catch(Exception e) {

			System.out.println( e + "data connection is unsuccessful");
		}
	}

	//insert employee
	public employeeModel insertEmployee(employeeModel emp) {

		String insertQuery = "insert into employee_details(E_id, E_name,E_email, E_mobile) Values(?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(insertQuery);
			ps.setInt(1, emp.getE_ID());
			ps.setString(2, emp.getE_name());
			ps.setString(3, emp.getE_email());
			ps.setString(4, emp.getE_Mobile());


			ps.execute();

		} catch(Exception e) {
			System.out.println(e +"data insertion is unsuccessful");
		}

		return emp;
	}
	
	//get the list of the employee
	public ArrayList<employeeModel> getEmployee() throws SQLException {

		ArrayList<employeeModel> selData = new ArrayList<employeeModel>();

		String selectQuery = "Select * from employee_details";

		PreparedStatement ps = con.prepareStatement(selectQuery);
		ResultSet rst = ps.executeQuery();

		while(rst.next()) {

			employeeModel em = new employeeModel();

			em.setE_ID(rst.getInt("E_id"));
			em.setE_name(rst.getString("E_name"));
			em.setE_email(rst.getString("E_email"));
			em.setE_Mobile(rst.getString("E_Mobile"));

			selData.add(em);
		}

		return selData;
	}
	
	//update employee
	public employeeModel updateEmployee(employeeModel emp) {

		String updateQuery = "update employee_details set E_id=?,E_name=?,E_email=?,E_mobile=? where E_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(updateQuery);
			ps.setInt(1, emp.getE_ID());
			ps.setString(2, emp.getE_name());
			ps.setString(3, emp.getE_email());
			ps.setString(4, emp.getE_Mobile());

			ps.executeUpdate();

		} catch(Exception e) {
			System.out.println(e +"data update is unsuccessful");
		}

		return emp;
	}
	
	//delete employee
	public int deleteEmployee(int E_id) {

		String deleteQuery = "delete from employee_details where E_id=?";

		try {
			PreparedStatement ps = con.prepareStatement(deleteQuery);
			ps.setInt(1,E_id);

			ps.executeUpdate();

		} catch(Exception e) {
			System.out.println(e +"data deletion is unsuccessful");
		}

		return E_id;
	}
}
