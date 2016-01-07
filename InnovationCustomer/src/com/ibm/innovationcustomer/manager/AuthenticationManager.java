package com.ibm.innovationcustomer.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.sql.DataSource;

@Stateless
@LocalBean
public class AuthenticationManager {

	private static final Logger log = Logger.getLogger(AuthenticationManager.class.getName()); 
	
	@Resource(lookup = "jdbc/InnovationDatabase")
	DataSource ds;

	Connection connection = null;
	PreparedStatement pstmt = null;
	
	public AuthenticationManager(){
		
	}
	
	//Sample
	public String authen(){
		log.info("Authentication Method");
		String sql = "select pro_fullname from profile_user where pro_id = 1";
		String fullName = null;
		try {
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(sql);
			
			ResultSet rset = pstmt.executeQuery();
			log.info("Start Perform SQL Statement");
			while(rset.next()){
				
				fullName = rset.getString("pro_fullname");	
				log.info("FOUND!! ");
			}
			log.info("Finish Perform SQL Statement");
			pstmt.close();
			if(fullName!=null){
				System.out.println("Profile Name is "+fullName);
			}else{
				System.out.println("Profile not found");
			}
		} catch (SQLException e) {
			
		}
		return "";
	}
	
}
