package domain;

import java.util.ArrayList;

public class TimeFunctions {
	
	private String currentDate;
	private String year;
	private String month;
	private String day;
	private String clockTime;
	
	public TimeFunctions(int yearInt, int monthInt, int dayInt, String clockTime) throws Exception{
		checkDayMonthYear(dayInt, monthInt, yearInt);
		String monthString = Integer.toString(monthInt);
		String dayString = Integer.toString(dayInt);
		String yearString = Integer.toString(yearInt);
		this.year = yearString;
		if(monthInt > 9){
			this.month = monthString;
		}
		else{
			this.month = "0" + monthString;
		}
		
		if(dayInt > 9){
			this.day = dayString;
		}
		else{
			this.day = "0" + dayString;
		}
		this.clockTime = clockTime;
		this.currentDate = yearString + "/" + monthString + "/" + yearString + " Time: " + clockTime;	
	}
	
	public String day(){ return day; }
	public String month(){ return month; }
	public String year(){ return year; }
	public String clockTime(){ return clockTime; }
	public String currentDate(){ return currentDate; }
	
	public void advanceTime(){
		if(clockTime().equals("16:00")){
			
		}
	}
	
	public static void checkDayMonthYear(int day, int month, int year) throws Exception{
		if(day < 1 || day > 31){
			throw new Exception("Improper day value");
		}
		
		if(month < 1 || month > 12){
			throw new Exception("Improper month value");
		}
		
		if(year < 1900){
			throw new Exception("Improper year value");
		}
		
		if(day > 29 && month == 2){
			throw new Exception("February never has that many days");
		}
		
		if(day == 29 && month == 2 && year % 4 != 0 ){
			throw new Exception("Not a leap year");
		}
		
		ArrayList<Integer> longMonths = new ArrayList<Integer>();
		longMonths.add(1); longMonths.add(3); longMonths.add(5);
		longMonths.add(7); longMonths.add(8); longMonths.add(10);
		longMonths.add(12);
		if(day > 30 && longMonths.contains(month)==false){
			throw new Exception("The month doesn't have that many days");
		}
	}

}
