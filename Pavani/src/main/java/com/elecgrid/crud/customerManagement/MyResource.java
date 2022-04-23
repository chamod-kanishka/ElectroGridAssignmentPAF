package com.elecgrid.crud.customerManagement;

import javax.ws.rs.Path;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("/myresource")
public class MyResource extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		      throws ServletException, IOException {
		      
		      // Set response content type
		      response.setContentType("text/html");

		      // Actual logic goes here.
		      PrintWriter out = response.getWriter();
		      out.println("got it");
		   }

}
