package com.ibm.innovationcustomer.util;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;


import com.ibm.innovationcustomer.model.ProfileUserModel;

public abstract class InnovationBaseAction extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1324143999349434727L;
	private static final Logger log = Logger.getLogger(InnovationBaseAction.class.getName()); 
	
	private ProfileUserModel currentUser = null;
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		log.info("Perform Base Action : ");
		log.info("Base Action : Session id "+request.getSession().getId());
		
		try{
			currentUser = (ProfileUserModel) request.getSession().getAttribute("currentUser");
			log.info("   >> "+currentUser.getProFullName());
			doPost(request, response);
			 
		}catch(Exception e){
			log.info("ERROR on getting currentUser in BaseAction : "+e.getMessage());
			String errorUrl = "/view/anonymous.jsp";
			request.getRequestDispatcher(errorUrl).forward(request, response);
		}
		
	   
	}
	
	protected abstract void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
//	
//	
//	public InnovationBaseAction() {
//		// TODO Auto-generated constructor stub
//		log.info("InnovationBaseAction Constructor Class");
////		doGet(req, resp);
//		
//		
//		
//	}
//	
//	protected void doPost(HttpServletRequest request,
//			HttpServletResponse response) throws ServletException, IOException {
//		log.info("Perform InnovationBaseAction");
//		try{
//			if(!(request.getSession().getAttribute("currentUser") instanceof ProfileUserModel)) {
//				//Not instance of ProfileUser --> Anonymous
//				String forwardUrl = "/view/anonymous.jsp";
//				request.getRequestDispatcher(forwardUrl).forward(request, response);
//			}else{
//				log.info("BASE ACTION PASSED");
//			}
//			
//		}catch(Exception e){
//			log.info("ERROR on BASE ACTION : "+e.getMessage());
//		}
//	}
	
}
