package com.examples.ezoo.dao;

import java.util.List;

import com.examples.ezoo.model.Animal;
import com.examples.ezoo.model.FeedingSchedule;

public class TestFeedingScheduleDAO {

	
	public static void main(String[] args) {
		FeedingScheduleDAO dao = new FeedingScheduleDAOImpl();
	    List<FeedingSchedule> list = dao.getallschedules();

	    for (int i = 0; i < list.size(); i++){
	      FeedingSchedule f = list.get(i);
	      System.out.println(f);
	    }
	}
}
