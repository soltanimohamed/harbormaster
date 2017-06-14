package domain;

import java.util.ArrayList;

public class TimeFunctions {
	
	private String currentDate; //Utskrift av alla datum (för rapporten och ev. GUI)
	private int year;
	private int month;
	private int day;
	private String weekDay;
	private String clockTime;
	
	//Konstruktorn
	public TimeFunctions(int year, int month, int day, String clockTime) throws Exception{
		
		checkDayMonthYear(day, month, year); //kollar efter grundläggande fel i datumen; se nedan
		
		String yearString = Integer.toString(year);
		this.year = year;
		this.month = month;
		this.day = day;
		this.clockTime = clockTime;
		this.weekDay = daysOfTheWeek().get(0); //Börjar på "Monday"
		this.currentDate = yearString + "/" + convertDayOrMonthToString(month) + "/" +
							convertDayOrMonthToString(day) + " " + this.weekDay +
							" Time: " + clockTime;	//Skapar utskrift av variablerna
	}
	
	public int day(){ return day; }
	public String weekDay(){ return weekDay; }
	public int month(){ return month; }
	public int year(){ return year; }
	public String clockTime(){ return clockTime; }
	public String currentDate(){ return currentDate; }
	public static ArrayList<Integer> longMonths(){ //ArrayList för månader med 31 dagar
		ArrayList<Integer> longMonthList = new ArrayList<Integer>();
		longMonthList.add(1); longMonthList.add(3); longMonthList.add(5);
		longMonthList.add(7); longMonthList.add(8); longMonthList.add(10);
		longMonthList.add(12);
		
		return longMonthList;
	}
	public static ArrayList<Integer> shortMonths(){ //ArrayList för månader med 30 dagar (februari kollas för sig)
		ArrayList<Integer> shortMonthList = new ArrayList<Integer>();
		shortMonthList.add(4); shortMonthList.add(6); shortMonthList.add(9); shortMonthList.add(11);
		
		return shortMonthList;
	}
	public static ArrayList<String> daysOfTheWeek(){
		ArrayList<String> week = new ArrayList<String>();
		week.add("Monday"); week.add("Tuesday"); week.add("Wednesday"); week.add("Thursday");
		week.add("Friday"); week.add("Saturday"); week.add("Sunday");
		return week;
	}
	
	public void advanceTime(){ //hoppar fram 8 timmar i tiden och ställer in år, månad, dag och klocka som nödvändigt
		int newClock = this.advanceClock();
		int newDay = this.advanceDay(newClock);
		int newMonth = this.advanceMonth(newDay);
		int newYear = this.advanceYear(newMonth);
		
		updateCurrentDate(this.day(), this.month(), this.year(), this.clockTime());
	}
	
	public static void checkDayMonthYear(int day, int month, int year) throws Exception{
		//Kollar om dag-siffran är möjlig
		if(day < 1 || day > 31){
			throw new Exception("Improper day value");
		}
		
		//Kollar om månadssiffran är möjlig
		if(month < 1 || month > 12){
			throw new Exception("Improper month value");
		}
		
		//Kollar om årssiffran är alldeles för tidig
		if(year < 2010){
			throw new Exception("Improper year value");
		}
		
		//Kollar om februari har för många dagar
		if(day > 29 && month == 2){
			throw new Exception("February never has that many days");
		}
		
		//Kollar om februari har för många dagar för ett icke-skottår
		if(day == 29 && month == 2 && year % 4 != 0 ){
			throw new Exception("Not a leap year");
		}
		
		//Kollar att månaden kan ha upp till 31 dagar
		if(day > 30 && longMonths().contains(month)==false){
			throw new Exception("The month doesn't have that many days");
		}
		
		//Kollar att månaden kan ha upp till 30 dagar
//		if(day > 29 && shortMonths().contains(month)==false){
//			throw new Exception("The month doesn't have that many days");
//		}
	}
	
	public String convertDayOrMonthToString(int date){
		//Lägger till en nolla i utskriften av dagen eller månaden
		if(date > 9){
			return Integer.toString(date);
		}
		return "0" + Integer.toString(date);
	}
	
	//Uppdaterar utskriften av det nuvarande datumet och klockslaget
	public void updateCurrentDate(int day, int month, int year, String clockTime){
		this.currentDate = Integer.toString(year) + "/" + convertDayOrMonthToString(month) + "/" +
				convertDayOrMonthToString(day) + " " + this.weekDay() + " Time: " + clockTime;
	}
	
	//Tar fram klockan till nästa skift och meddelar advanceDay om det ska bli ny dag
	public int advanceClock(){
		if(this.clockTime().equals("00:00")){
			this.clockTime = "08:00";
		}
		else if(this.clockTime().equals("08:00")){
			this.clockTime = "16:00";
		}
		else if(this.clockTime().equals("16:00")){
			this.clockTime = "00:00";
			advanceWeekDay(); //Ny veckodag
			return 1; //Ny dag
		}
		return 0; //Inte ny dag
	}
	
	//Tar fram dagen till nästa dag och meddelar advanceMonth om det ska bli ny månad
	public int advanceDay(int dayModifier){
		if((this.day() + dayModifier) > 28 && this.month() == 2 && this.year() % 4 != 0){
			this.day = 1; //Ny dag efter sista februari; inte skottår
			return 1;
		}
		else if(this.day() + dayModifier > 29 && this.month() == 2 && this.year() % 4 == 0){
			this.day = 1; //Ny dag efter sista februari; skottår
			return 1;
		}
		else if(this.day() + dayModifier > 30 && shortMonths().contains(this.month())){
			this.day = 1;
			return 1;
		}
		else if(this.day() + dayModifier > 31 && longMonths().contains(this.month())){
			this.day = 1;
			return 1;
		}
		this.day = this.day() + dayModifier;
		return 0;
	}
	
	public void advanceWeekDay(){ //Ändrar namnet på veckodagen till veckodagen efter den nuvarande
		int currentWeekDay = daysOfTheWeek().indexOf(weekDay());
		if((currentWeekDay+1)>6){
			this.weekDay = daysOfTheWeek().get(0);
		}
		else this.weekDay = daysOfTheWeek().get(currentWeekDay+1);
	}
	
	//Tar fram månaden till nästa månad och meddelar advanceYear om det ska bli nytt år
	public int advanceMonth(int monthModifier){
		if((this.month() + monthModifier) > 12){
			this.month = 1;
			return 1;
		}
		this.month= this.month() + monthModifier;
		return 0;
	}
	
	//Tar fram året till nästa år
	public int advanceYear(int yearModifier){
		this.year = this.year() + yearModifier;
		return this.year;
	}
}
