package com.ibm.innovationcustomer.action;

import java.io.IOException;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.innovationcustomer.constants.CommonConstants;
import com.ibm.innovationcustomer.manager.ProfileUserManager;
import com.ibm.innovationcustomer.model.ProfileUserModel;
import com.ibm.innovationcustomer.util.InnovationBaseAction;

public class SaveProfileAction extends InnovationBaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3077967640157489567L;
	private static final Logger log = Logger.getLogger(SaveProfileAction.class.getName()); 
	
	@EJB
	private ProfileUserManager profileUserManager;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		log.info("TEST DOPOST");
		
		ProfileUserModel currentUser = (ProfileUserModel) request.getSession().getAttribute("currentUser");
		String result = "";
		String profileMessage = "";
		String forwardUrl = "";
		try{
			result = profileUserManager.updateProfileUserById(
					request.getParameter("title"), 
					currentUser.getProId(), 
					request.getParameter("firstname"), 
					request.getParameter("lastname"), 
					request.getParameter("firstname").concat(" ").concat(request.getParameter("lastname")), 
					request.getParameter("companyName"), 
					request.getParameter("contactNo"), 
					request.getParameter("email"));
			
		}catch(Exception e){
			log.info("ERROR : "+e.getMessage());
		}
		
		if(result.equals(CommonConstants.RETURN_SUCCESS)){
			//Update SUCCESS
			profileMessage = "Update Profile Information Successful.";
			forwardUrl = "/view/viewprofile.jsp";
			
			
		}else{
			//Update FAIL
			profileMessage ="Update Profile Information Fail.";
			forwardUrl = "/view/editprofile.jsp";
			
		}
		request.setAttribute("profileMessage", profileMessage);
		request.getRequestDispatcher(forwardUrl).forward(request, response);
		
		
	}
	
}
