package com.elecgrid.crud.paymentManagement.resource;

<<<<<<< HEAD
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
=======
import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
>>>>>>> 98241698c5f077dcdeb57a61efbf06be7a361c66
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
<<<<<<< HEAD
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.elecgrid.crud.paymentManagement.services.paymentServices;

@Path("/payments")
public class paymentResource {

	paymentServices payServ = new paymentServices();
	
	//View all payments
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String viewPayments(){
		return payServ.viewPayments();
	}
	
	//insert payments
	@POST
	@Path("/addPayment")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_HTML)
	public String insertPayDetails(@FormParam("pay_type") String pay_type, @FormParam("amount") String amount,
								@FormParam("cus_id") String cus_id, @FormParam("bill_id") String bill_id) 
	{
		
		String output = payServ.insertPayDetails(pay_type, amount, cus_id, bill_id);
		return output + "<h1>Your Payment is success..!</h1>";
	}
	
	@PUT
	@Path("/updatePayment")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateCustomer(@FormParam("pay_type") String pay_type, @FormParam("amount") String amount,
			@FormParam("pay_id") String pay_id) {
			
		String output = payServ.updatePayment(pay_id, pay_type, amount);
		
		return output;
	}
	
	
	//Delete payment
	@DELETE
	@Path("/removePayment")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteCustomer(String payments)
	{
		//Convert the input string to an XML document
		Document pdoc = Jsoup.parse(payments, "", Parser.xmlParser());
		
		//Read the value from the element customer id
		String pay_id = pdoc.select("pay_id").text();
		String output = payServ.deleteCustomer(pay_id);
	
	return output;
=======
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
>>>>>>> 98241698c5f077dcdeb57a61efbf06be7a361c66
	}
}
