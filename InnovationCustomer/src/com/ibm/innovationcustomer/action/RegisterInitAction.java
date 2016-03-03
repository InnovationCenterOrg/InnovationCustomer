package com.ibm.innovationcustomer.action;

import java.io.Console;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class RegisterInitAction extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5203561364622843035L;
	
	private static final Logger log = Logger.getLogger(RegisterInitAction.class.getName()); 

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		log.info("TEST DOPOST");
		
		String forwardUrl = "/view/register.jsp";
		request.getRequestDispatcher(forwardUrl).forward(request, response);
	}
		
}
