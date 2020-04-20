package com.examples.ezoo.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.examples.ezoo.dao.DAOUtilities;
import com.examples.ezoo.dao.FeedingScheduleDAO;
import com.examples.ezoo.model.FeedingSchedule;

public class DeleteFeedingScheduleServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("deleteSchedule.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get Parameters
		
		int schedule_ID = Integer.parseInt(request.getParameter("schedule_ID")); 
		
		FeedingScheduleDAO dao = DAOUtilities.getFeedingScheduleDAO(); 
		List<FeedingSchedule> schedules = dao.getallschedules(); 
		
		request.getSession().setAttribute("schedules", schedules);
		
		
		try {
			for (FeedingSchedule a : schedules) {
				if (a.getschedule_ID() == schedule_ID)
					dao.deleteschedule(a); 
			}
			request.getSession().setAttribute("message", "Schedule deleted succesfully");
			request.getSession().setAttribute("messageClass", "alert-success");
			response.sendRedirect("animalCare");


		}catch (Exception e){
			e.printStackTrace();
			
			//change the message
			request.getSession().setAttribute("message", "There was a problem deleting the schedule at this time");
			request.getSession().setAttribute("messageClass", "alert-danger");
			
			request.getRequestDispatcher("deleteSchedule.jsp").forward(request, response);

		}
}
}