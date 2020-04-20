package com.examples.ezoo.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examples.ezoo.dao.AnimalDAO;
import com.examples.ezoo.dao.DAOUtilities;
import com.examples.ezoo.dao.FeedingScheduleDAO;
import com.examples.ezoo.model.Animal;
import com.examples.ezoo.model.FeedingSchedule;

public class AssignFeedingScheduleServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("assignSchedule.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get Parameters
		
		int schedule_ID = Integer.parseInt(request.getParameter("schedule_ID")); 
		long animal_ID = Long.parseLong(request.getParameter("animal_ID"));
		
		AnimalDAO Dao = DAOUtilities.getAnimalDao();
		List<Animal> animals = Dao.getAllAnimals(); 
		
		FeedingScheduleDAO dao = DAOUtilities.getFeedingScheduleDAO(); 
		List<FeedingSchedule> schedules = dao.getallschedules(); 
		
		request.getSession().setAttribute("schedules", schedules);
		
		
		try {
			for (FeedingSchedule a : schedules)
				for(Animal b: animals)
					if (a.getschedule_ID() == schedule_ID || b.getAnimalID() == animal_ID)
						dao.setschedule(a, b); 
			request.getSession().setAttribute("message", "Schedule has been assigned");
			request.getSession().setAttribute("messageClass", "alert-success");
			response.sendRedirect("animalCare");


		}catch (Exception e){
			e.printStackTrace();
			
			//change the message
			request.getSession().setAttribute("message", "There was a problem assigning the schedule at this time");
			request.getSession().setAttribute("messageClass", "alert-danger");
			
			request.getRequestDispatcher("assignSchedule.jsp").forward(request, response);

		}
}
}

