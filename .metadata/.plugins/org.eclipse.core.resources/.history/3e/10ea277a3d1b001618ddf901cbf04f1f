package com.ibm.innovationcustomer.action;

import java.io.IOException;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.ibm.innovationcustomer.constants.CommonConstants;
import com.ibm.innovationcustomer.manager.EventManager;
import com.ibm.innovationcustomer.manager.ProfileUserManager;
import com.ibm.innovationcustomer.manager.RegisterEventManager;
import com.ibm.innovationcustomer.model.RegisterEventModel;
import com.ibm.innovationcustomer.util.InnovationBaseAction;

public class GenerateLuckyNoAction extends InnovationBaseAction  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -484489136950357204L;

	@Resource(lookup = "jdbc/SQL Database-4o")
	DataSource ds;
	
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
		//1 Gerneate LuckyNo
		//2 Update in RegisterEvent`
		
		RegisterEventModel regEvent = (RegisterEventModel) request.getSession().getAttribute("registerEvent");
		String forwardUrl = "";
		int luckyNo = registerEventManager.generateLuckyNo();
		log.info("Gen Lucky No: "+luckyNo);
		while(registerEventManager.isDuplicateLuckyNo(regEvent.getReeEveId(), luckyNo)){
			//duplicate
			log.info("Duplicate LuckyNo -> Re-Generate");
			luckyNo = registerEventManager.generateLuckyNo();
		}
		log.info("Get the unique one : "+luckyNo);
		String updateResult = registerEventManager.updateRegisterEventLuckyNo(regEvent.getReeId(), luckyNo);
		
		if(updateResult.equals(CommonConstants.RETURN_SUCCESS)){
			//Success
			regEvent = registerEventManager.getRegisterEventById(regEvent.getReeId());
			request.getSession().setAttribute("registerEvent", regEvent);
			request.setAttribute("myluckyno", luckyNo);
			forwardUrl = "/view/home.jsp";
			request.getRequestDispatcher(forwardUrl).forward(request, response);
		}else{
			//Fail
			forwardUrl = "/view/home.jsp";
			request.getRequestDispatcher(forwardUrl).forward(request, response);
		}
	}
}
