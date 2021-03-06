package com.ibm.innovationcustomer.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.sql.DataSource;

import com.ibm.innovationcustomer.constants.CommonConstants;
import com.ibm.innovationcustomer.model.LuckyDrawModel;
import com.ibm.innovationcustomer.model.RegisterEventModel;

@Stateless
@LocalBean
public class LuckyDrawManager {
	private static final Logger log = Logger.getLogger(LuckyDrawManager.class.getName()); 
	
	@Resource(lookup = "jdbc/dashDB-mf")
	DataSource ds;

	Connection connection = null;
	PreparedStatement pstmt = null;
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public LuckyDrawManager(){

	}
	
	public String createNewLuckyDraw(RegisterEventModel reeObj, String lucStatus){
		String sql = "insert into lucky_draw (luc_eve_id, luc_lucky_no, luc_ree_id, luc_status, luc_create_date) values (?,?,?,?,?) ";
		
		try{
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setInt(1, reeObj.getReeEveId().intValue());
			pstmt.setInt(2, reeObj.getReeLuckyNo());
			pstmt.setInt(3, reeObj.getReeId().intValue());
			pstmt.setString(4, lucStatus);
			pstmt.setString(5, dateTimeFormat.format(new Date()));
			
			int result = pstmt.executeUpdate();
			connection.close();
			
			if(result > 0){
				return CommonConstants.RETURN_SUCCESS;
			}
			
		}catch(SQLException e1){
			log.info("SQL ERROR : "+e1.getMessage());
		}catch(Exception e2){
			log.info("ERROR : "+e2.getMessage());
		}
		return CommonConstants.RETURN_FAIL;
	}
	
//	public List<LuckyDrawModel> getListByEveId(Integer reeEveId){
//		List<LuckyDrawModel> resultList = null;
//		String sql = "";
//		try{
//			connection = ds.getConnection();
//			pstmt = connection.prepareStatement(sql);
//			
//			connection.close();
//			
//		}catch(SQLException e1){
//			log.info("SQL ERROR : "+e1.getMessage());
//		}catch(Exception e2){
//			log.info("ERROR : "+e2.getMessage());
//		}
//		
//		return resultList;
//		
//	}
	
}
