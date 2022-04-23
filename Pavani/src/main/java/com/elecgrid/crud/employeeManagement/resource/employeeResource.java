package com.elecgrid.crud.employeeManagement.resource;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import com.elecgrid.crud.employeeManagement.model.employeeModel;
import com.elecgrid.crud.employeeManagement.services.employeeServices;



@Path("/elecGrid/employee")
public class employeeResource {

employeeServices services = new employeeServices();
	
	@Path("/addEmployee")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public employeeModel addCustomer(employeeModel eModel) {
		
		 return services.insertEmployee(eModel);
	}
	
	@Path("/retrieveEmployee")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<employeeModel> getCustomer() throws SQLException {
		
		return services.getEmployee();
	}
	
	@Path("/updateEmployee")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public employeeModel updateCustomer(employeeModel eModel) {
		
		 return services.updateEmployee(eModel);
	}
	
	@Path("/deleteEmp/{e_id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public int deleteCustomer(@PathParam("e_id") int e_id) {
		
		return services.deleteEmployee(e_id);
	}
}
