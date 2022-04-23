package com.elecgrid.crud.employeeManagement.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.elecgrid.crud.employeeManagement.services.emplyeeServices;

@Path("/employee")
public class employeeResources {

	emplyeeServices empServ = new emplyeeServices();
	
	//view all employees
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String viewAllEmp() {
		return empServ.viewEmp();
	}
	
	
	//Add new employee
	@POST
	@Path("/addEmp")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertEmp(@FormParam("e_name") String e_name, @FormParam("e_mobile") String e_mobile,
								@FormParam("designation") String designation) 
	{
		
		String output = empServ.insertEmp(e_name, e_mobile, designation);
		 return output;
	}
	
	//View Employee by ID
	@GET
	@Path("/{e_id}")
	@Produces(MediaType.TEXT_HTML)
	public String getCustomerById(@PathParam("e_id") int id){
		return empServ.getEmpById(id);
	}
	
	//Update Employee
	@PUT
	@Path("/updateEmp")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateEmp(@FormParam("e_name") String e_name, @FormParam("e_mobile") String e_mobile,
			@FormParam("designation") String designation, @FormParam("e_id") String e_id) {
			
		String output = empServ.updateEmp(e_id, e_name, e_mobile, designation);
		
		return output;
	}
	
	//Remove employee
	@DELETE
	@Path("/deleteCustomer")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteCustomer(String emp)
	{
		//Convert the input string to an XML document
		Document doc = Jsoup.parse(emp, "", Parser.xmlParser());
		
		//Read the value from the element <e_id>
		String e_id = doc.select("e_id").text();
		String output = empServ.deleteEmp(e_id);
	
	return output;
	}
	
	//Get customer by ID
	
	
}
