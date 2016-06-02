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

import com.ibm.innovationcustomer.constants.CommonConstants;
import com.ibm.innovationcustomer.manager.ProfileUserManager;
import com.ibm.innovationcustomer.model.ProfileUserModel;


public class RegisterAction extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4010347086022282960L;
	
	@Resource(lookup = "jdbc/SQL Database-4o")
	DataSource ds;
	
	@EJB
	private ProfileUserManager profileUserManager;
	
	private static final Logger log = Logger.getLogger(LoginAction.class.getName()); 

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		//request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		String result = profileUserManager.createNewProfileUser(request.getParameter("title"), request.getParameter("firstName"), request.getParameter("lastName"), request.getParameter("firstName")+" "+request.getParameter("lastName"), request.getParameter("companyName"), request.getParameter("contactNo"), request.getParameter("email"), request.getParameter("username"), request.getParameter("password"), CommonConstants.PROFILE_USER_ROLE_CUSTOMER);
		log.info("CREATE PROFILE RESULT : "+result);
		ProfileUserModel currentUser = null;
		
//		String tmp = profileUserManager.updateProfileUserById(1, "Pannray", "Samanphanchai", "Pannray Samanphanchai", "IBMSD", "0867059235", "p.joyjung@gmail.com", "pannrays", "P@ssw0rd");
//		ProfileUserModel user = profileUserManager.getProfileUserById(1);
//		if(user != null){
//			log.info("FOUND USER");
//			log.info("FULLNAME : "+user.getProFullName());
//			log.info("COMPANY NAME : "+user.getProCompanyName());
//		}
//		log.info("RESULT DUPLICATE : "+profileUserManager.isDuplicateUsername("pannrays"));
		
		//		String tmp = profileUserManager.createNewProfileUser("Pannray", "Samanphanchai", "Pannray Samanphanchai", "IBMSD", "0867059235", "p.joyjung@gmail.com", "pannrays", "P@ssw0rd", "Customer");
		String forwardUrl = "/login.jsp";
//		if(currentUser != null){
//			forwardUrl = "/home.jsp?test="+currentUser.getProFullName();
//		}

		request.getRequestDispatcher(forwardUrl).forward(request, response);
	}
		
}
