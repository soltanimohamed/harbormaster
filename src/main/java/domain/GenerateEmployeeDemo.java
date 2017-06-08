package domain;

import java.util.ArrayList;
import java.util.Random;

public class GenerateEmployeeDemo {

	public static void main(String[] args) {
		
		GenerateEmployees ge = new GenerateEmployees();
		
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
		
		ArrayList<Integer> q1eUnavailableNumbers = ge.generateNumbers(3, 6, q1eUnavailableInt, random); //Slumpade otillgängliga statusar
		ArrayList<Integer> q1eDrivingLicenses = ge.generateNumbers(1, 2, q1eNumberOfEmployees, random);
		ArrayList<Integer> q1eShiftNumbers = ge.generateShiftNumbers(q1eNumberOfEmployees);
		ArrayList<Integer> q1eScheduleNumbers = ge.generateScheduleNumbers(q1eNumberOfEmployees);
		
		System.out.println("q1e unavailable size: " + q1eUnavailableNumbers.size());
		int q1eTotalEmp = (q1eFulltimeInt + q1eHalftimeInt + q1eUnavailableNumbers.size());
		System.out.println("q1e total size: " + q1eTotalEmp);
		System.out.println("q1e driving license size: " + q1eDrivingLicenses.size());
		System.out.println("q1e schedule numbers size: " + q1eScheduleNumbers.size());
		System.out.println("q1e shift numbers: " + q1eShiftNumbers.size());
		System.out.println("------------");
		
		ArrayList<Employee> q2e = new ArrayList<Employee>(); //195 anställda, Körkort 3-5
		int q2eNumberOfEmployees = 195;
		double q2eFulltimeDouble = q2eNumberOfEmployees * fullTimePercentage;
		int q2eFulltimeInt = (int)Math.round(q2eFulltimeDouble);
		double q2eHalftimeDouble = q2eNumberOfEmployees * halfTimePercentage;
		int q2eHalftimeInt = (int)Math.round(q2eHalftimeDouble);
		double q2eUnavailableDouble = q2eNumberOfEmployees * unavailablePercentage;
		int q2eUnavailableInt = (int)Math.round(q2eUnavailableDouble);
		ArrayList<Integer> q2eUnavailableNumbers = ge.generateNumbers(3, 6, q2eUnavailableInt, random);
		ArrayList<Integer> q2eDrivingLicenses = ge.generateNumbers(3, 5, q2eNumberOfEmployees, random);
		ArrayList<Integer> q2eScheduleNumbers = ge.generateScheduleNumbers(q2eNumberOfEmployees);
		ArrayList<Integer> q2eShiftNumbers = ge.generateShiftNumbers(q2eNumberOfEmployees);
		
		System.out.println("q2e unavailable size: " + q2eUnavailableNumbers.size());
		int q2eTotalEmp = (q2eFulltimeInt + q2eHalftimeInt + q2eUnavailableNumbers.size());
		System.out.println("q2e total size: " + q2eTotalEmp);
		System.out.println("q2e driving license size: " + q2eDrivingLicenses.size());
		System.out.println("q2e schedule numbers size: " + q2eScheduleNumbers.size());
		System.out.println("q2e shift numbers: " + q2eShiftNumbers.size());
		System.out.println("------------");
		
		ArrayList<Employee> q3e = new ArrayList<Employee>(); //240 anställda, Körkort 6-8
		int q3eNumberOfEmployees = 240;
		double q3eFulltimeDouble = q3eNumberOfEmployees * fullTimePercentage;
		int q3eFulltimeInt = (int)Math.round(q3eFulltimeDouble);
		double q3eHalftimeDouble = q3eNumberOfEmployees * halfTimePercentage;
		int q3eHalftimeInt = (int)Math.round(q3eHalftimeDouble);
		double q3eUnavailableDouble = q3eNumberOfEmployees * unavailablePercentage;
		int q3eUnavailableInt = (int)Math.round(q3eUnavailableDouble);
		ArrayList<Integer> q3eUnavailableNumbers = ge.generateNumbers(3, 6, q3eUnavailableInt, random);
		ArrayList<Integer> q3eDrivingLicenses = ge.generateNumbers(6, 8, q3eNumberOfEmployees, random);
		ArrayList<Integer> q3eScheduleNumbers = ge.generateScheduleNumbers(q3eNumberOfEmployees);
		ArrayList<Integer> q3eShiftNumbers = ge.generateShiftNumbers(q3eNumberOfEmployees);
		
		System.out.println("q3e unavailable size: " + q3eUnavailableNumbers.size());
		int q3eTotalEmp = (q3eFulltimeInt + q3eHalftimeInt + q3eUnavailableNumbers.size());
		System.out.println("q3e total size: " + q3eTotalEmp);
		System.out.println("q3e driving license size: " + q3eDrivingLicenses.size());
		System.out.println("q3e schedule numbers size: " + q3eScheduleNumbers.size());
		System.out.println("q3e shift numbers: " + q3eShiftNumbers.size());
		System.out.println("------------");
		/*
		System.out.println("FirstNames test:");
		ArrayList<String> testFirstNames = ge.generateFirstNames(20, random);
		for(int i = 0; i < testFirstNames.size(); i++){
			System.out.println(testFirstNames.get(i));
		}
		System.out.println("------------");
		System.out.println("LastNames test:");
		ArrayList<String> testLastNames = ge.generateLastNames(20, random);
		for(int j = 0; j < testLastNames.size(); j++){
			System.out.println(testLastNames.get(j));
		}
		System.out.println("------------");
		*/
		System.out.println("For Quay 1:");
		ArrayList<Employee> q1Employees = new ArrayList<Employee>();
		ArrayList<String> q1FirstNames = ge.generateFirstNames(165, random);
		ArrayList<String> q1LastNames = ge.generateLastNames(165, random);
		for (int x = 0; x < q1eTotalEmp; x++){
			String tempFirstName = q1FirstNames.get(x);
			String tempGender;
			if(ge.femaleFirstNames().contains(q1FirstNames.get(x))){
				tempGender = "Female";
			}
			else tempGender = "Male";
			
			int statusTemp = 0;
			if(x<q1eFulltimeInt){
				statusTemp = 1;
			}
			else if(x<q1eHalftimeInt){
				statusTemp = 2;
			}
			else {
				int randomStatusNumber = random.nextInt((6-3)+3);
				statusTemp = randomStatusNumber;
				System.out.println(statusTemp);
			}
			Employee temp = new Employee(x, q1FirstNames.get(x), q1LastNames.get(x), tempGender,
										q1eDrivingLicenses.get(x), statusTemp, q1eScheduleNumbers.get(x),
										q1eShiftNumbers.get(x));
			q1Employees.add(temp);
		}
		
		System.out.println("------------");
		System.out.println("Q1 Employees:");
		for(int y = 0; y<q1Employees.size(); y++){
			//System.out.println(q1Employees.get(y));
			System.out.println("ID: " + q1Employees.get(y).employee_id());
			System.out.println("FirstName " + q1Employees.get(y).firstName());
			System.out.println("LastName " + q1Employees.get(y).lastName());
			System.out.println("Gender " + q1Employees.get(y).gender());
			System.out.println("StatusID " + q1Employees.get(y).status());
			System.out.println("Schedule " + q1Employees.get(y).schema());
			System.out.println("Shift " + q1Employees.get(y).shift());
			System.out.println("DrivingLicense " + q1Employees.get(y).driving_license_ID());
			System.out.println("------------");
		}
		/*
		System.out.println("------------");
		System.out.println("Q1 DL:");
		for(int t = 0; t<q1eDrivingLicenses.size(); t++){
			System.out.println(q1eDrivingLicenses.get(t));
		}
		System.out.println("------------");
		System.out.println("Q2 DL:");
		for(int q = 0; q<q2eDrivingLicenses.size(); q++){
			System.out.println(q2eDrivingLicenses.get(q));
		}
		System.out.println("------------");
		System.out.println("Q3 DL:");
		for(int b = 0; b<q3eDrivingLicenses.size(); b++){
			System.out.println(q3eDrivingLicenses.get(b));
		}
		*/
		/*
		ArrayList<Employee> q2Employees = new ArrayList<Employee>();
		for (int u = 0; u < q1eTotalEmp; u++){
			String tempFirstName = q1FirstNames.get(u);
			String tempGender;
			if(ge.femaleFirstNames().contains(q2FirstNames.get(u))){
				tempGender = "Female";
			}
			else tempGender = "Male";
			
			int statusTemp = 0;
			if(u<q2eFulltimeInt){
				statusTemp = 1;
			}
			else if(u<q2eHalftimeInt){
				statusTemp = 2;
			}
			else {
				int randomStatusNumber = random.nextInt((6-3)+3);
				statusTemp = randomStatusNumber;
			}
			Employee temp = new Employee(u, q2FirstNames.get(u), q2LastNames.get(u), tempGender,
										(q2eDrivingLicenses.get(u)-1), statusTemp, q2eScheduleNumbers.get(u),
										q2eShiftNumbers.get(u));
			q1Employees.add(temp);
		}
		*/
	}

}
