package com.ibm.innovationcustomer.action;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.innovationcustomer.util.InnovationBaseAction;

public class LogoutAction extends InnovationBaseAction  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1367331587375761456L;
	
	private static final Logger log = Logger.getLogger(LogoutAction.class.getName()); 

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		//request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().removeAttribute("currentUser");
		request.getSession().removeAttribute("event");
		request.getSession().removeAttribute("registerEvent");
		request.getSession().invalidate();
		
		String forwardUrl = "/login.jsp";
		request.getRequestDispatcher(forwardUrl).forward(request, response);
		
	}
}
