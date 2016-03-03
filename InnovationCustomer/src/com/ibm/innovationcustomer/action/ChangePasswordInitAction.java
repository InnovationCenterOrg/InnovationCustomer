package com.ibm.innovationcustomer.action;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.innovationcustomer.util.InnovationBaseAction;

public class ChangePasswordInitAction extends InnovationBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 867499994721638890L;
	private static final Logger log = Logger.getLogger(ViewProfileInitAction.class.getName()); 

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		log.info("TEST DOPOST");
		
		String forwardUrl = "/view/changepassword.jsp";
		request.getRequestDispatcher(forwardUrl).forward(request, response);
	}
	
}
