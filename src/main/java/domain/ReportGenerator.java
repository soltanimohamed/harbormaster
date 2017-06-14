package domain;

import java.io.File;
import java.io.FileWriter;
import java.net.URI;
import java.net.URISyntaxException;

public class ReportGenerator {
	
	private TimeFunctions tf;
	private FileWriter fw;
	private int dayCounter;
	private String activeDay;
	
	public ReportGenerator(TimeFunctions tf){
		this.tf = tf;
		this.dayCounter = 0;
	}
	
	public void generateReport(){
		
	}
	
	public void advanceTime(TimeFunctions tf){
		this.tf = tf;
	}
	
	public void updateDayCounter(){
		this.dayCounter++;
		
	}
	
	public String activeDay(){
		return activeDay;
	}
	
	public File generateReport(int dateModifier){
		String fileLocation = "./files";
		if(dateModifier==1){
			fileLocation = fileLocation + "/day/";
		}
		else if(dateModifier==2){
			fileLocation = fileLocation + "/week/";
		}
		
		File report = null;
		try{
			URI filePathway = new URI(fileLocation);
			report = new File(filePathway);
		}catch (URISyntaxException use){
			System.out.println("Problem creating pathway for report: " + use.getMessage());
		}
		
		return report;
	}
}
