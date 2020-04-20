package com.examples.ezoo.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.examples.ezoo.dao.DAOUtilities;
import com.examples.ezoo.dao.FeedingScheduleDAO;
import com.examples.ezoo.model.FeedingSchedule;
/**
 * Servlet implementation class AddAnimalServlet
 */
@WebServlet("/addSchedule")
public class CreateFeedingScheduleServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("addSchedule.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get Parameters
		int schedule_id = Integer.parseInt(request.getParameter("schedule_id")); 
		String feeding_time = request.getParameter("feeding_time");
		String recurrence = request.getParameter("recurrence"); 
		String food = request.getParameter("food"); 
		String notes = request.getParameter("notes"); 
		
		//Create a Schedule object from the parameters
		FeedingSchedule scheduletosave = new FeedingSchedule(
				schedule_id,
				feeding_time,
				recurrence,
				food,
				notes); 
		
		FeedingScheduleDAO dao = DAOUtilities.getFeedingScheduleDAO();
		try {
			dao.addschedule(scheduletosave);
			request.getSession().setAttribute("message", "Schedule successfully created");
			request.getSession().setAttribute("messageClass", "alert-success");
			response.sendRedirect("animalCare");


		}catch (Exception e){
			e.printStackTrace();
			
			//change the message
			request.getSession().setAttribute("message", "There was a problem creating the schedule at this time");
			request.getSession().setAttribute("messageClass", "alert-danger");
			
			request.getRequestDispatcher("addSchedule.jsp").forward(request, response);

		}
		
		
	}

}