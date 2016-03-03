package com.ibm.innovationcustomer.action;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.innovationcustomer.util.InnovationBaseAction;

public class ViewProfileInitAction extends InnovationBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4659540151478778804L;
	private static final Logger log = Logger.getLogger(ViewProfileInitAction.class.getName()); 

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		log.info("ViewProfileInitAction TEST DOPOST");
		try{
			
			String forwardUrl = "/view/viewprofile.jsp";
			log.info("View Init Action : Session id "+request.getSession().getId());
			request.getRequestDispatcher(forwardUrl).forward(request, response);
			
		}catch(Exception e){
			
			log.info("ERROR : "+e.getMessage());
		}
	}

//	@Override
//	protected void doService(HttpServletRequest request,
//			HttpServletResponse response) {
//		// TODO Auto-generated method stub
//		log.info("View Profile Init Action ");
//		
//	}
		
}
