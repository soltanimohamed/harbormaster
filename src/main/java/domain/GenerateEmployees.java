package domain;

import java.util.ArrayList;
import java.util.Random;

public class GenerateEmployees {
	
	//DrivingLicenseID (1-8), StatusId (1-6; 1: 100%, 2: 50%, 3-6: Otillgänglig), ScheduleID (1-3), ShiftHours (1-3)
	
	Random random = new Random();
	double fullTimePercentage = 0.7;
	double halfTimePercentage = 0.2;
	double unavailablePercentage = 0.1;
	double shiftHourPercentage = 0.33;
	
	ArrayList<Employee> q1e = new ArrayList<Employee>(); //165 anställda, Körkort 1-2
	int q1eNumberOfEmployees = 165;
	double q1eFulltimeDouble = q1eNumberOfEmployees * fullTimePercentage;
	int q1eFulltimeInt = (int)Math.round(q1eFulltimeDouble);
	double q1eHalftimeDouble = q1eNumberOfEmployees * halfTimePercentage;
	int q1eHalftimeInt = (int)Math.round(q1eHalftimeDouble);
	double q1eUnavailableDouble = q1eNumberOfEmployees * unavailablePercentage;
	int q1eUnavailableInt = (int)Math.round(q1eUnavailableDouble);
	
	ArrayList<Integer> q1eUnavailableNumbers = generateNumbers(3, 6, q1eUnavailableInt, random); //Slumpade otillgängliga statusar
	ArrayList<Integer> q1eDrivingLicenses = generateNumbers(1, 2, q1eNumberOfEmployees, random);
	ArrayList<Integer> q1eShiftNumbers = generateShiftNumbers(q1eNumberOfEmployees);
	ArrayList<Integer> q1eScheduleNumbers = generateScheduleNumbers(q1eNumberOfEmployees);
	
	ArrayList<Employee> q2e = new ArrayList<Employee>(); //195 anställda, Körkort 3-5
	int q2eNumberOfEmployees = 195;
	double q2eFulltimeDouble = q2eNumberOfEmployees * fullTimePercentage;
	int q2eFulltimeInt = (int)Math.round(q2eFulltimeDouble);
	double q2eHalftimeDouble = q2eNumberOfEmployees * halfTimePercentage;
	int q2eHalftimeInt = (int)Math.round(q2eHalftimeDouble);
	double q2eUnavailableDouble = q2eNumberOfEmployees * unavailablePercentage;
	int q2eUnavailableInt = (int)Math.round(q2eUnavailableDouble);
	ArrayList<Integer> q2eUnavailableNumbers = generateNumbers(3, 6, q2eUnavailableInt, random);
	ArrayList<Integer> q2eDrivingLicenses = generateNumbers(3, 5, q2eNumberOfEmployees, random);
	ArrayList<Integer> q2eScheduleNumbers = generateScheduleNumbers(q2eNumberOfEmployees);
	ArrayList<Integer> q2eShiftNumbers = generateShiftNumbers(q2eNumberOfEmployees);
	
	ArrayList<Employee> q3e = new ArrayList<Employee>(); //240 anställda, Körkort 6-8
	int q3eNumberOfEmployees = 240;
	double q3eFulltimeDouble = q3eNumberOfEmployees * fullTimePercentage;
	int q3eFulltimeInt = (int)Math.round(q3eFulltimeDouble);
	double q3eHalftimeDouble = q3eNumberOfEmployees * halfTimePercentage;
	int q3eHalftimeInt = (int)Math.round(q3eHalftimeDouble);
	double q3eUnavailableDouble = q3eNumberOfEmployees * unavailablePercentage;
	int q3eUnavailableInt = (int)Math.round(q3eUnavailableDouble);
	ArrayList<Integer> q3eUnavailableNumbers = generateNumbers(3, 6, q3eUnavailableInt, random);
	ArrayList<Integer> q3eDrivingLicenses = generateNumbers(6, 8, q3eNumberOfEmployees, random);
	ArrayList<Integer> q3eScheduleNumbers = generateScheduleNumbers(q3eNumberOfEmployees);
	ArrayList<Integer> q3eShiftNumbers = generateShiftNumbers(q3eNumberOfEmployees);
	
	/*
	ArrayList<Integer> drivingLicenseNumbers = new ArrayList<Integer>();
	ArrayList<Integer> statusNumbers = new ArrayList<Integer>();
	ArrayList<Integer> shiftHourNumbers = new ArrayList<Integer>();
	ArrayList<Integer> scheduleIdNumbers = new ArrayList<Integer>();
	*/
	
	/*
	 * *Quay1 165E
	 * **Status (70% 1, 20% 2, 10% 3-6)
	 * **Arbetsdagar (70% MF, 20% LS, 10% S)
	 * **Körkort (1-2)
	 * **Skift (1/3 0-8, 1/3 8-16, 1/3 16-0)
	 * *Quay2 195E
	 * **Status (70% 1, 20% 2, 10% 3-6)
	 * **Arbetsdagar (70% MF, 20% LS, 10% S)
	 * **Körkort (3-5)
	 * **Skift (1/3 0-8, 1/3 8-16, 1/3 16-0)
	 * *Quay3 240E
	 * **Status (70% 1, 20% 2, 10% 3-6)
	 * **Arbetsdagar (70% MF, 20% LS, 10% S)
	 * **Körkort (6-8)
	 * **Skift (1/3 0-8, 1/3 8-16, 1/3 16-0)
	 */
	
	public static ArrayList<String> maleFirstNames(){
		ArrayList<String> possibleMaleNames = new ArrayList<String>();
		
		//11 st (0-10)
		possibleMaleNames.add("Henrik"); possibleMaleNames.add("Rikard"); possibleMaleNames.add("Kristian");
		possibleMaleNames.add("Anders"); possibleMaleNames.add("Johan"); possibleMaleNames.add("Markus");
		possibleMaleNames.add("Mohammed"); possibleMaleNames.add("Naser"); possibleMaleNames.add("Jonas");
		possibleMaleNames.add("Jonathan"); possibleMaleNames.add("Niklas");
		
		return possibleMaleNames;
	}
	
	public static ArrayList<String> femaleFirstNames(){
		ArrayList<String> possibleFemaleNames = new ArrayList<String>();
		
		//11 st (0-10)
		possibleFemaleNames.add("Sofia"); possibleFemaleNames.add("Mikaela"); possibleFemaleNames.add("Linnea");
		possibleFemaleNames.add("Anna"); possibleFemaleNames.add("Anna-Lena"); possibleFemaleNames.add("Sara");
		possibleFemaleNames.add("Julia"); possibleFemaleNames.add("Miranda"); possibleFemaleNames.add("Monika");
		possibleFemaleNames.add("Maria"); possibleFemaleNames.add("Hanni");
		
		return possibleFemaleNames;
	}
	
	public static ArrayList<String> lastNames(){
		ArrayList<String> possibleLastNames = new ArrayList<String>();
		
		//14 st (0-13)
		possibleLastNames.add("Nilsson"); possibleLastNames.add("Andersson"); possibleLastNames.add("Soltani");
		possibleLastNames.add("Fritzell"); possibleLastNames.add("Pierre"); possibleLastNames.add("Lindberg");
		possibleLastNames.add("Saleh"); possibleLastNames.add("Henriksson"); possibleLastNames.add("Jonsson");
		possibleLastNames.add("Larsson"); possibleLastNames.add("Modig"); possibleLastNames.add("Svärd");
		possibleLastNames.add("Ström"); possibleLastNames.add("Holgersson");
		
		return possibleLastNames;
	}
	
	//DrivingLicenseID (1-8), StatusId (1-6; 1: 100%, 2: 50%, 3-6: Otillgänglig), ScheduleID (1-3), ShiftHours (1-3)
	public static ArrayList<Integer> generateNumbers(int lowest, int highest, int numberOfInts, Random random){
		//int tempHighest = highest - 1;
		//int tempLowest = lowest - 1;
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		int randomNumber;
		for (int i = 0; i<numberOfInts; i++){
			randomNumber = random.nextInt((highest+1) - lowest) + lowest;
			numbers.add(randomNumber);
		}
		return numbers;
	}
	
	public static ArrayList<Integer> generateShiftNumbers(int numberOfEmployees){
		ArrayList<Integer> shiftNumbers = new ArrayList<Integer>();
		int shiftCounter = 1;
		for(int i = 0; i< numberOfEmployees; i++){
			if(shiftCounter == 1){
				shiftNumbers.add(1);
				shiftCounter++;
			}
			else if(shiftCounter == 2){
				shiftNumbers.add(2);
				shiftCounter++;
			}
			else{
				shiftNumbers.add(3);
				shiftCounter = 1;
			}
		}
		return shiftNumbers;
	}
	
	public static ArrayList<Integer> generateScheduleNumbers(int numberOfEmployees){
		ArrayList<Integer> scheduleNumbers = new ArrayList<Integer>();
		for(int i = 0; i< numberOfEmployees; i++){
			if(i<(int)Math.round((numberOfEmployees*0.7))){
				scheduleNumbers.add(1);
			}
			else if(i<(int)Math.round((numberOfEmployees*0.9))){
				scheduleNumbers.add(2);
			}
			else{
				scheduleNumbers.add(3);
			}
		}
		return scheduleNumbers;
	}
	
	public static ArrayList<String> generateFirstNames(int numberOfEmployees, Random random){
		ArrayList<String> firstNames = new ArrayList<String>();
		for(int i = 0; i < numberOfEmployees; i++){
			int randomNumber = random.nextInt((10 - 0) + 0);
			if(i % 2 != 0){
				firstNames.add(femaleFirstNames().get(randomNumber));
			}
			else {
				firstNames.add(maleFirstNames().get(randomNumber));
			}
		}
		return firstNames;
	}
	
	public static ArrayList<String> generateLastNames(int numberOfEmployees, Random random){
		ArrayList<String> lastNames = new ArrayList<String>();
		for (int i = 0; i< numberOfEmployees; i++){
			int randomNumber = random.nextInt((13 - 0) + 0);
			lastNames.add(lastNames().get(randomNumber));
		}
		return lastNames;
	}
	
	public static ArrayList<String> generateGenders(ArrayList<String> firstNames){
		ArrayList<String> genders = new ArrayList<String>();
		for(int  i = 0; i < firstNames.size(); i++){
			if(GenerateEmployees.femaleFirstNames().contains(firstNames.get(i))){
				genders.add("Female");
			}
			else{
				genders.add("Male");
			}
		}
		return genders;
	}
	
	public static ArrayList<Integer> generateDrivingLicenseNumbers(int quayEmployeesNr, int quayNr, Random random){
		ArrayList<Integer> drivingLicenseNumbers = new ArrayList<Integer>();
		if(quayNr == 1){
			drivingLicenseNumbers = GenerateEmployees.generateNumbers(1, 2, quayEmployeesNr, random);
		}
		else if(quayNr == 2){
			drivingLicenseNumbers = GenerateEmployees.generateNumbers(3, 5, quayEmployeesNr, random);
		}
		else if(quayNr == 3){
			drivingLicenseNumbers = GenerateEmployees.generateNumbers(6, 8, quayEmployeesNr, random);
		}
		return drivingLicenseNumbers;
	}
	
	public static ArrayList<Integer> generateStatusNumbersForQuay(int quayEmployees){ //Genererar statusnummer för kajer
		ArrayList<Integer> statusNumbers = new ArrayList<Integer>();
		double fiveDayDouble = quayEmployees * 0.8;
		double twoDayDouble = quayEmployees * 0.15;
		double oneDayDouble = quayEmployees * 0.05;
		int fiveDayInt = (int)Math.round(fiveDayDouble);
		int twoDayInt = (int)Math.round(twoDayDouble);
		int oneDayInt = (int)Math.round(oneDayDouble);
		
		if((fiveDayInt + twoDayInt + oneDayInt)!=quayEmployees){ //Kontrollerar att avrundningen inte ökade eller minskade antalet kajanställda
			if((fiveDayInt + twoDayInt + oneDayInt)>quayEmployees){ //Om avrundningen blev högre...
				while((fiveDayInt + twoDayInt + oneDayInt)>quayEmployees){
					fiveDayInt--; //Tar bort MF-anställda tills summan matchar
				}
			}
			else if((fiveDayInt + twoDayInt + oneDayInt)<quayEmployees){ //Om avrundningen blev lägre
				while((fiveDayInt + twoDayInt + oneDayInt)<quayEmployees){
					oneDayInt++; //Lägger till S-anställda tills summan matchar
				}
			}
		}
		
		int fiveDayShifts = fiveDayInt / 3;
		int fiveDayMorning = fiveDayShifts;
		int fiveDayEvening = fiveDayShifts;
		int fiveDayNight = fiveDayShifts;
		if((fiveDayMorning + fiveDayEvening + fiveDayNight)!=fiveDayInt){ //Kontrollerar att avrundningen inte ökade eller minskade antalet kajanställda
			if((fiveDayMorning + fiveDayEvening + fiveDayNight)>fiveDayInt){ //Om avrundningen blev högre...
				while((fiveDayMorning + fiveDayEvening + fiveDayNight)>fiveDayInt){
					fiveDayEvening--;
				}
			}
			else if((fiveDayMorning + fiveDayEvening + fiveDayNight)<fiveDayInt){ //Om avrundningen blev lägre
				while((fiveDayMorning + fiveDayEvening + fiveDayNight)<fiveDayInt){
					fiveDayNight++;
				}
			}
		}
		
		int twoDayShifts = twoDayInt / 3;
		int twoDayMorning = twoDayShifts;
		int twoDayEvening = twoDayShifts;
		int twoDayNight = twoDayShifts;
		if((twoDayMorning + twoDayEvening + twoDayNight)!=twoDayInt){ //Kontrollerar att avrundningen inte ökade eller minskade antalet kajanställda
			if((twoDayMorning + twoDayEvening + twoDayNight)>twoDayInt){ //Om avrundningen blev högre...
				while((twoDayMorning + twoDayEvening + twoDayNight)>twoDayInt){
					twoDayEvening--;
				}
			}
			else if((twoDayMorning + twoDayEvening + twoDayNight)<twoDayInt){ //Om avrundningen blev lägre
				while((twoDayMorning + twoDayEvening + twoDayNight)<twoDayInt){
					twoDayNight++;
				}
			}
		}
		
		int oneDayShifts = oneDayInt / 3;
		int oneDayMorning = oneDayShifts;
		int oneDayEvening = oneDayShifts;
		int oneDayNight = oneDayShifts;
		if((oneDayMorning + oneDayEvening + oneDayNight)!=oneDayInt){ //Kontrollerar att avrundningen inte ökade eller minskade antalet kajanställda
			if((oneDayMorning + oneDayEvening + oneDayNight)>oneDayInt){ //Om avrundningen blev högre...
				while((oneDayMorning + oneDayEvening + oneDayNight)>oneDayInt){
					oneDayEvening--;
				}
			}
			else if((oneDayMorning + oneDayEvening + oneDayNight)<oneDayInt){ //Om avrundningen blev lägre
				while((oneDayMorning + oneDayEvening + oneDayNight)<oneDayInt){
					oneDayNight++;
				}
			}
		}
		ArrayList<Integer> fiveDayMorningStatus = generateStatusNumberForShift(fiveDayMorning);
		ArrayList<Integer> fiveDayEveningStatus = generateStatusNumberForShift(fiveDayEvening);
		ArrayList<Integer> fiveDayNightStatus = generateStatusNumberForShift(fiveDayNight);
		
		ArrayList<Integer> twoDayMorningStatus = generateStatusNumberForShift(twoDayMorning);
		ArrayList<Integer> twoDayEveningStatus = generateStatusNumberForShift(twoDayEvening);
		ArrayList<Integer> twoDayNightStatus = generateStatusNumberForShift(twoDayNight);
		
		ArrayList<Integer> oneDayMorningStatus = generateStatusNumberForShift(oneDayMorning);
		ArrayList<Integer> oneDayEveningStatus = generateStatusNumberForShift(oneDayEvening);
		ArrayList<Integer> oneDayNightStatus = generateStatusNumberForShift(oneDayNight);
		
		statusNumbers.addAll(fiveDayMorningStatus);
		statusNumbers.addAll(fiveDayEveningStatus);
		statusNumbers.addAll(fiveDayNightStatus);
		statusNumbers.addAll(twoDayMorningStatus);
		statusNumbers.addAll(twoDayEveningStatus);
		statusNumbers.addAll(twoDayNightStatus);
		statusNumbers.addAll(oneDayMorningStatus);
		statusNumbers.addAll(oneDayEveningStatus);
		statusNumbers.addAll(oneDayNightStatus);
		
		return statusNumbers;
	}
	
	public static ArrayList<Integer> generateStatusNumberForShift(int numberOfWorkers){
		ArrayList<Integer> shiftStatus = new ArrayList<Integer>();
		double fullTimeDouble = numberOfWorkers * 0.7;
		double halfTimeDouble = numberOfWorkers * 0.2;
		double unavailableDouble = numberOfWorkers * 0.1;
		int fullTimeInt = (int)Math.round(fullTimeDouble);
		int halfTimeInt = (int)Math.round(halfTimeDouble);
		int unavailableInt = (int)Math.round(unavailableDouble);
		if((fullTimeInt + halfTimeInt + unavailableInt) != numberOfWorkers){
			if((fullTimeInt + halfTimeInt + unavailableInt)>numberOfWorkers){
				while((fullTimeInt + halfTimeInt + unavailableInt)>numberOfWorkers){
					fullTimeInt--;
				}
			}
			else if((fullTimeInt + halfTimeInt + unavailableInt)<numberOfWorkers){
				while((fullTimeInt + halfTimeInt + unavailableInt)<numberOfWorkers){
					fullTimeInt++;
				}
			}
		}
		
		Random random = new Random();
		ArrayList<Integer> fullTimeStatus = new ArrayList<Integer>();
		ArrayList<Integer> halfTimeStatus = new ArrayList<Integer>();
		ArrayList<Integer> unavilableStatus = generateNumbers(3, 6, unavailableInt, random);
		for(int i = 0; i<fullTimeInt; i++){
			fullTimeStatus.add(1);
		}
		for(int j = 0; j<halfTimeInt; j++){
			halfTimeStatus.add(2);
		}
		shiftStatus.addAll(fullTimeStatus);
		shiftStatus.addAll(halfTimeStatus);
		shiftStatus.addAll(unavilableStatus);
		return shiftStatus;
	}
}
