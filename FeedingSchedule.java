package com.examples.ezoo.model;

public class FeedingSchedule {

	private int schedule_ID;
	private String feeding_time = ""; 
	private String recurrence = ""; 
	private String food = "";
	private String notes = ""; 
	
	public FeedingSchedule() {}
	
	public FeedingSchedule(int schedule_ID, String feeding_time, String recurrence, String food, String notes) {
		super();
		this.schedule_ID = schedule_ID; 
		this.feeding_time = feeding_time; 
		this.recurrence = recurrence; 
		this.food = food; 
		this.notes = notes; 
	}
	
	public int getschedule_ID() {
		return schedule_ID; 
	}
	
	public void setschedule_ID(int schedule_ID) {
		this.schedule_ID = schedule_ID; 
	}
	
	public String getfeeding_time() {
		return feeding_time; 
	}
	
	public void setfeeding_time(String feeding_time) {
		this.feeding_time = feeding_time; 
	}
	
	public String getrecurrence() {
		return recurrence; 
	}
	
	public void setrecurrence(String recurrence) {
		this.recurrence = recurrence; 
	}
	
	public String getfood() {
		return food;
	}
	
	public void setfood(String food) {
		this.food = food; 
	}
	
	public String getnotes() {
		return notes; 
	}
	
	public void setnotes(String notes) {
		this.notes = notes; 
	}
	
	public String toString() {
		return "Feeding Schedule [schedule_ID = "+schedule_ID+", feeding_time = "+feeding_time+
								", recurrence = "+recurrence+", food = "+food+", notes = "+notes+" ]"; 
	}
}

