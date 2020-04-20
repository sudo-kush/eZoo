package com.examples.ezoo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.examples.ezoo.model.Animal;
import com.examples.ezoo.model.FeedingSchedule;


public class FeedingScheduleDAOImpl implements FeedingScheduleDAO{

	Connection connection = null; 
	PreparedStatement stmt = null; 

	public List<FeedingSchedule> getallschedules(){
		
		List<FeedingSchedule> schedule = new ArrayList<FeedingSchedule>(); 
		
		try {
			connection = DAOUtilities.getConnection();

			String sql = "SELECT * FROM FEEDING_SCHEDULES";
			
			stmt = connection.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				FeedingSchedule a = new FeedingSchedule();
				
				a.setschedule_ID(rs.getInt("schedule_ID"));
				a.setfeeding_time(rs.getString("feeding_time"));
				a.setrecurrence(rs.getString("recurrence"));
				a.setfood(rs.getString("food"));
				a.setnotes(rs.getString("notes"));
				
				schedule.add(a);
			}
			
			rs.close(); 

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// We need to make sure our statements and connections are closed, 
			// or else we could wind up with a memory leak
			closeResources();
		}
		
		return schedule;
	}
	
	public boolean addschedule(FeedingSchedule schedule) {
		
		try {
			connection = DAOUtilities.getConnection();
			
			String sql = "INSERT INTO FEEDING_SCHEDULES VALUES(?,?,?,?,?)";
			
			stmt = connection.prepareStatement(sql);

			stmt.setInt(1, schedule.getschedule_ID());
			stmt.setString(2, schedule.getfeeding_time()); 
			stmt.setString(3, schedule.getrecurrence());
			stmt.setString(4, schedule.getfood());
			stmt.setString(5, schedule.getnotes()); 
			
			if (stmt.executeUpdate() != 0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeResources();
		}
	}
	
	public boolean deleteschedule(FeedingSchedule schedule) {
		
		try {
			connection = DAOUtilities.getConnection();
			String sql = "DELETE FROM FEEDING_SCHEDULES WHERE schedule_ID=?";
			stmt = connection.prepareStatement(sql);

			stmt.setInt(1, schedule.getschedule_ID());
			
			if (stmt.executeUpdate() != 0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeResources();
		}
	}
	

	public FeedingSchedule getschedule(Animal animal) {
		FeedingSchedule a = null;

		try {
			connection = DAOUtilities.getConnection();
			String sql = "SELECT * FROM FEEDING_SCHEDULES WHERE schedule_ID = ?";
			stmt = connection.prepareStatement(sql);
			
			
			stmt.setInt(1, animal.getfeeding_schedule());
			
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				a = new FeedingSchedule();
				
				a.setschedule_ID(rs.getInt("schedule_ID"));
				a.setfeeding_time(rs.getString("feeding_time"));
				a.setrecurrence(rs.getString("recurrence"));
				a.setfood(rs.getString("food"));
				a.setnotes(rs.getString("notes"));		
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}
		
		return a;
	}

	public boolean setschedule(FeedingSchedule schedule, Animal animal) {
		try {
			connection = DAOUtilities.getConnection();
			String sql = "UPDATE Animals SET feeding_schedule=? WHERE animalid=?";
			stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, schedule.getschedule_ID());
			stmt.setLong(2, animal.getAnimalID()); 
			
			System.out.println(stmt);
			
			if (stmt.executeUpdate() != 0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeResources();
		}
		
	}
	
	
	public boolean removeschedule(Animal animal) {
		try {
			connection = DAOUtilities.getConnection();
			String sql = "UPDATE Animals SET feeding_schedule=? WHERE animalid=?";
			stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, 0);
			stmt.setLong(2, animal.getAnimalID()); 
			
			System.out.println(stmt);
			
			if (stmt.executeUpdate() != 0)
				return true;
			else
				return false;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			closeResources();
		}
		
	}

	private void closeResources() {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			System.out.println("Could not close statement!");
			e.printStackTrace();
		}
		
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			System.out.println("Could not close connection!");
			e.printStackTrace();
		}
	}
}
