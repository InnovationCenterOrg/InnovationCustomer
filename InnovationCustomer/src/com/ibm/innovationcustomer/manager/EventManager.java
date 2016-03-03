package com.ibm.innovationcustomer.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.sql.DataSource;

import com.ibm.innovationcustomer.constants.CommonConstants;
import com.ibm.innovationcustomer.model.EventModel;

@Stateless
@LocalBean
public class EventManager {

	
	private static final Logger log = Logger.getLogger(EventManager.class.getName()); 
	
	@Resource(lookup = "jdbc/InnovationDatabase")
	DataSource ds;

	Connection connection = null;
	PreparedStatement pstmt = null;
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public EventManager(){
		
	}
	
	//Create
	public String createNewEvent(String eveName, String eveDescription, String eveLocation, Date eveStartDate, Date eveEndDate, String evePicturePath, String eveStatus){
		String sql = "insert into event (eve_name, eve_description, eve_location, eve_start_date, eve_end_date, eve_picture_path, eve_status, eve_create_date, eve_update_date) values(?,?,?,?,?,?,?,?,?)";
		Date currentDateTime = new Date();
		try{
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, eveName);
			pstmt.setString(2, eveDescription);
			pstmt.setString(3, eveLocation);
			pstmt.setString(4, dateTimeFormat.format(eveStartDate));
			pstmt.setString(5, dateTimeFormat.format(eveEndDate));
			pstmt.setString(6, evePicturePath);
			pstmt.setString(7, eveStatus);
			pstmt.setString(8, dateTimeFormat.format(currentDateTime));
			pstmt.setString(9, dateTimeFormat.format(currentDateTime));
			
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
	
	//Update Information
	public String updateEvent(Integer eveId, String eveName, String eveDescription, String eveLocation, Date eveStartDate, Date eveEndDate, String evePicturePath, String eveStatus){
		String sql = "update event set eve_name=?, eve_description=?, eve_location=?, eve_start_date=?, eve_end_date=?, eve_picture_path=?, eve_status=?, eve_update_date=? where eve_id=?";
		Date currentDateTime = new Date();
		try{
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(sql);

			pstmt.setString(1, eveName);
			pstmt.setString(2, eveDescription);
			pstmt.setString(3, eveLocation);
			pstmt.setString(4, dateTimeFormat.format(eveStartDate));
			pstmt.setString(5, dateTimeFormat.format(eveEndDate));
			pstmt.setString(6, evePicturePath);
			pstmt.setString(7, eveStatus);
			pstmt.setString(8, dateTimeFormat.format(currentDateTime));
			pstmt.setInt(9, eveId.intValue());
			
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
	
	public String updateStatus(Integer eveId, String eveStatus){
		String sql = "update event set eve_status=?, eve_update_date=? where eve_id=?";
		Date currentDateTime = new Date();
		try{
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, eveStatus);
			pstmt.setString(2, dateTimeFormat.format(currentDateTime));
			pstmt.setInt(3, eveId.intValue());
			
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
	
	//Unused --> Move to RegisterEventManager Class
	public EventModel updateRegisterUser(Integer eveId, Integer currentRegisterUser){
		String updateSql = "update event set eve_register_user = ? where eve_id = ? ";
		Integer toBeRegisterUser = currentRegisterUser+1;
		try{
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(updateSql);
			pstmt.setInt(1, toBeRegisterUser);
			pstmt.setInt(2, eveId);
			
			int result = pstmt.executeUpdate();
			
			if(result > 0){
				//Success
				String querySql = "select * from event where eve_id = ? ";
				EventModel event = null;
				try{
					PreparedStatement pstmtQuery = connection.prepareStatement(querySql);
					pstmtQuery.setInt(1, eveId.intValue());
					ResultSet results = pstmtQuery.executeQuery();
					
					while(results.next()){
						event = new EventModel();
						event.setEveId(results.getInt("eve_id"));
						event.setEveName(results.getString("eve_name"));
						event.setEveDescription(results.getString("eve_description"));
						event.setEveLocation(results.getString("eve_location"));
						event.setEveStartDate(dateTimeFormat.parse(results.getString("eve_start_date")));
						event.setEveEndDate(dateTimeFormat.parse(results.getString("eve_end_date")));
						event.setEveRegisterUser(results.getInt("eve_register_user"));
						event.setEvePicturePath(results.getString("eve_picture_path"));
						event.setEveStatus(results.getString("eve_status"));
						event.setEveCreateDate(dateTimeFormat.parse(results.getString("eve_create_date")));
						event.setEveUpdateDate(dateTimeFormat.parse(results.getString("eve_update_date")));
						
					}
					
					connection.close();
					return event;
					
				}catch(Exception e0){
					connection.close();
					throw new Exception();
				}
			}else{
				connection.close();
				return null;
			}

		}catch(SQLException e1){
			log.info("SQL ERROR : "+e1.getMessage());
		}catch(Exception e2){
			log.info("ERROR : "+e2.getMessage());
		}
		return null;
	}
	
	
	//Search by crietria (eventName, eventStartDate, eventStatus)
	public List<EventModel> getEventList(String eveName, Date eveStartDate, String eveStatus){
		List<EventModel> resultList = null;
		StringBuffer sqlBuffer = new StringBuffer();
		log.info("1");
		sqlBuffer.append("select * from event where eve_id <> 0 ");
		log.info("2");
		if(eveName != null && !eveName.equals("")){
			sqlBuffer.append("and eveName like ? ");
		}
		
		if(eveStartDate != null){
			sqlBuffer.append("and eveStartDate like ? ");
		}
		
		if(eveStatus != null && !eveStatus.equals("")){
			sqlBuffer.append("and eveStatus = ? ");
		}
		
		sqlBuffer.append("order by eveName, eveStartDate ");
		
		try{
			log.info("3");
			connection = ds.getConnection();
			log.info("4");
			pstmt = connection.prepareStatement(sqlBuffer.toString());
			int runningParam = 1;
			
			if(eveName != null && !eveName.equals("")){
				pstmt.setString(runningParam, "%"+eveName+"%");
				runningParam += 1;
			}
			if(eveStartDate != null){
				pstmt.setString(runningParam, "%"+dateFormat.format(eveStartDate));
				runningParam += 1;
			}
			
			if(eveStatus != null && !eveStatus.equals("")){
				pstmt.setString(runningParam, eveStatus);
			}
			
			ResultSet results = pstmt.executeQuery();
			EventModel event = null;
			resultList = new ArrayList();
			while(results.next()){
				event = new EventModel();
				event.setEveId(results.getInt("eve_id"));
				event.setEveName(results.getString("eve_name"));
				event.setEveDescription(results.getString("eve_description"));
				event.setEveLocation(results.getString("eve_location"));
				event.setEveStartDate(dateTimeFormat.parse(results.getString("eve_start_date")));
				event.setEveEndDate(dateTimeFormat.parse(results.getString("eve_end_date")));
				event.setEvePicturePath(results.getString("eve_picture_path"));
				event.setEveStatus(results.getString("eve_status"));
				event.setEveCreateDate(dateTimeFormat.parse(results.getString("eve_create_date")));
				event.setEveUpdateDate(dateTimeFormat.parse(results.getString("eve_update_date")));
				
				resultList.add(event);
				
			}
			
			connection.close();
			
			return resultList;
			
		}catch(SQLException e1){
			log.info("SQL ERROR : "+e1.getMessage());
		}catch(Exception e2){
			log.info("ERROR : "+e2.getMessage());
		}
		
		return resultList;
	}
	
	public EventModel getEventById(Integer eveId){
		String sql = "select * from event where eve_id = ? ";
		EventModel event = null;
		try{
			connection = ds.getConnection();
			pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, eveId.intValue());
			log.info("QUERY: "+pstmt.toString());
			ResultSet results = pstmt.executeQuery();
			while(results.next()){
				log.info("FOUND EVENT");
				event = new EventModel();
				event.setEveId(results.getInt("eve_id"));
				event.setEveName(results.getString("eve_name"));
				event.setEveDescription(results.getString("eve_description"));
				event.setEveLocation(results.getString("eve_location"));
				event.setEveStartDate(dateTimeFormat.parse(results.getString("eve_start_date")));
				event.setEveEndDate(dateTimeFormat.parse(results.getString("eve_end_date")));
				event.setEveRegisterUser(results.getInt("eve_register_user"));
				event.setEvePicturePath(results.getString("eve_picture_path"));
				event.setEveStatus(results.getString("eve_status"));
				event.setEveCreateDate(dateTimeFormat.parse(results.getString("eve_create_date")));
				event.setEveUpdateDate(dateTimeFormat.parse(results.getString("eve_update_date")));
				log.info("FOUND EVENT : "+event.getEveName());
				
			}
			log.info("END QUERY");
			connection.close();
			return event;
			
		}catch(SQLException e1){
			log.info("SQL ERROR : "+e1.getMessage());
		}catch(Exception e2){
			log.info("ERROR : "+e2.getMessage());
		}
		return event;
		
	}
	
	
	
}
