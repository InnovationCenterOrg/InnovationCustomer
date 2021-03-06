package com.ibm.innovationcustomer.action;

import java.io.IOException;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.ibm.innovationcustomer.constants.CommonConstants;
import com.ibm.innovationcustomer.manager.EventManager;
import com.ibm.innovationcustomer.manager.ProfileUserManager;
import com.ibm.innovationcustomer.manager.RegisterEventManager;
import com.ibm.innovationcustomer.model.EventModel;
import com.ibm.innovationcustomer.model.ProfileUserModel;
import com.ibm.innovationcustomer.model.RegisterEventModel;


public class LoginAction extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8579213088672797881L;

	@Resource(lookup = "jdbc/dashDB-mf")
	DataSource ds;
	
	@EJB
	private ProfileUserManager profileUserManager;
	@EJB
	private EventManager eventManager;
	@EJB
	private RegisterEventManager registerEventManager;
	
	
	private static final Logger log = Logger.getLogger(LoginAction.class.getName()); 

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
		log.info("TEST DOGET");
		//request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		//Perform 3 steps
		//1) Get the event from id (in url)
		//2) Authentication and get the currentuser
		//3) Create the register event + Update Event Register User
		
		String eveId = request.getParameter("eveId");
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String forwardUrl = "";
		String message = "";
		log.info("EVENT ID: "+eveId);
		log.info("USERNAME: "+userId);
		log.info("CAST EVENT ID : "+eveId);
		EventModel event = null;
		//1
		try{
			event = eventManager.getEventById(Integer.parseInt(eveId));
		}catch(Exception e){
			//FAIL
			log.info("[LoginAction]  FAIL TO GET THE EVEN : "+e.getMessage());
			message = "Cannot found the event for registration. Please contact the staff.";
			request.setAttribute("message", message);
			forwardUrl = "/login.jsp";
			request.getRequestDispatcher(forwardUrl).forward(request, response);
		}
		
		//2
		ProfileUserModel currentUser = profileUserManager.authen(userId, password);
		try{
			log.info("[LoginAction] FOUND USER: "+currentUser.getProFullName());
			try{
				log.info("[LoginAction] FOUND EVENT : "+event.getEveName());
				
				//Check Duplicate
				RegisterEventModel regEve = null;
				regEve = registerEventManager.getRegisterEventByEveIdProId(event.getEveId(), currentUser.getProId());
				try{
					//Already create (skip)
					HttpSession session = request.getSession();
					session.setAttribute("registerEvent", regEve);
					session.setAttribute("currentUser", currentUser);
					session.setAttribute("event", event);
					log.info("[LoginAction] Lucky No. for "+currentUser.getProFullName()+" >> "+regEve.getReeLuckyNo());
					forwardUrl = "/view/home.jsp";
					request.getRequestDispatcher(forwardUrl).forward(request, response);
					
				}catch(NullPointerException e){
					//Need to create new Register Event
					//3
					String createReeResult = registerEventManager.createNewRegisterEvent(event.getEveId(), currentUser.getProId());
					if(createReeResult.equals(CommonConstants.RETURN_SUCCESS)){
						log.info("[LoginAction] CREATED REGISTER EVENT SUCCESS");
						regEve = registerEventManager.getRegisterEventByEveIdProId(event.getEveId(), currentUser.getProId());
						HttpSession session = request.getSession();
						session.setAttribute("registerEvent", regEve);
						session.setAttribute("currentUser", currentUser);
						session.setAttribute("event", event);
						forwardUrl = "/view/home.jsp";
						request.getRequestDispatcher(forwardUrl).forward(request, response);
						
					}else{
						//FAIL
						log.info("[LoginAction] FAIL TO CREATE REGISTER EVENT");
						message = "Cannot register this profile into this event.";
						request.setAttribute("message", message);
						forwardUrl = "/login.jsp";
						request.getRequestDispatcher(forwardUrl).forward(request, response);
						
					}
					
				}
				
			}catch(NullPointerException e){
				log.info("[LoginAction] NOT FOUND EVENT");
				message = "Event not found.";
				request.setAttribute("message", message);
				forwardUrl = "/login.jsp";
				request.getRequestDispatcher(forwardUrl).forward(request,response);
			}
			
		}catch(NullPointerException e){
			log.info("[LoginAction] NOT FOUND USER");
			message = "Login failed. Please try again.";
			request.setAttribute("message", message);
			forwardUrl = "/login.jsp";
			request.getRequestDispatcher(forwardUrl).forward(request, response);
			
		}
		
	}
		
}
