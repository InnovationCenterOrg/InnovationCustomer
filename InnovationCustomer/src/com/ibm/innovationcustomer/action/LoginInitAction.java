package com.ibm.innovationcustomer.action;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInitAction extends HttpServlet {

		/**
	 * 
	 */
	private static final long serialVersionUID = -4429017033123925350L;
	private static final Logger log = Logger.getLogger(RegisterInitAction.class.getName()); 

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		log.info("TEST DOPOST");
		
		String forwardUrl = "/login.jsp";
		request.getRequestDispatcher(forwardUrl).forward(request, response);
	}
		
}
