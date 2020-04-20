package com.examples.ezoo.dao;

import java.util.List;

import com.examples.ezoo.model.Animal;
import com.examples.ezoo.model.FeedingSchedule;

public interface FeedingScheduleDAO {
	
	List<FeedingSchedule> getallschedules(); 
	
	boolean addschedule(FeedingSchedule schedule);
	boolean deleteschedule(FeedingSchedule schedule); 
	FeedingSchedule getschedule(Animal animal);
	boolean setschedule(FeedingSchedule schedule, Animal animal);
	boolean removeschedule(Animal animal);

	
}
