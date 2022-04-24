package com.elecgrid.crud.paymentManagement.resource;

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

import com.elecgrid.crud.paymentManagement.model.paymentModel;
import com.elecgrid.crud.paymentManagement.services.paymentServices;

public class paymentResource {
	
paymentServices services = new paymentServices();
	
	@Path("/addPaymentDetails")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public paymentModel addCustomer(paymentModel pModel) {
		
		 return services.insertPayment(pModel);
	}
	
	@Path("/retrievePayments")
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public ArrayList<paymentModel> getCustomer() throws SQLException {
		
		return services.readPayment();
	}
	
	@Path("/updatePayment")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public paymentModel updateCustomer(paymentModel pModel) {
		
		 return services.updatePayment(pModel);
	}
	
	@Path("/deletePayment/{pay_id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public int deleteCustomer(@PathParam("pay_id") int pay_id) {
		
		return services.deletePayment(pay_id);
	}
}
