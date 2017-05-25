package domain;

import java.util.ArrayList;

public class QuayShift {
	
	private int id;
	private Ship docked_ship; //Det skepp som ligger tillsatt
	private String shift_hours; //Skiftets timmar; "0:00-8:00" "8:00-16:00" "16:00-00:00"
	private ArrayList<Employee> active_workers; //De anställda som just nu jobbar på skeppet
	private String day; //Dagens datum
	
	public QuayShift(int id, String shift_hours){
		this.id = id;
		this.shift_hours = shift_hours;
		this.docked_ship = null;
		this.active_workers = new ArrayList<Employee>();
		this.day = null; //Skiftets datum tillsätts manuellt
	}
	
	public int id(){ return id; }
	public String shift_hours(){ return shift_hours; }
	public Ship docked_ship(){ return docked_ship; }
	public ArrayList<Employee> active_workers(){ return active_workers; }
	public String day(){ return day; }
	
	public void assignShip(Ship new_ship) { this.docked_ship = new_ship; }
	public void assignEmployee(Employee new_employee) { active_workers.add(new_employee); }
	public void chooseShiftDay(String day) { this.day = day; }

	@Override
	public boolean equals(Object o){
		if(o instanceof QuayShift){
			QuayShift temp = (QuayShift)o;
			if(temp.shift_hours().equals(this.shift_hours()) && 
					temp.day().equals(this.day())){
				return true;
			}
			else return false;
		}
		return false;
	}
}
