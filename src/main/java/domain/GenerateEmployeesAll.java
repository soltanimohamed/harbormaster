package domain;

import java.util.ArrayList;
import java.util.Random;

public class GenerateEmployeesAll {

	public static void main(String[] args) {
		Random random = new Random();
		int employeesQ1 = 165;
		int employeesQ2 = 195;
		int employeesQ3 = 240;
		
		
		int employeesTotal = employeesQ1 + employeesQ2 + employeesQ3;
		ArrayList<Employee> allEmployees = new ArrayList<Employee>();
		ArrayList<Employee> q1Employees = new ArrayList<Employee>();
		ArrayList<Employee> q2Employees = new ArrayList<Employee>();
		ArrayList<Employee> q3Employees = new ArrayList<Employee>();
		
		ArrayList<String> firstNames = GenerateEmployees.generateFirstNames(employeesTotal, random);
		ArrayList<String> lastNames = GenerateEmployees.generateLastNames(employeesTotal, random);
		ArrayList<String> genders = GenerateEmployees.generateGenders(firstNames);
		
		ArrayList<Integer> q1DrivingLicenses = GenerateEmployees.generateDrivingLicenseNumbers(employeesQ1, 1, random);
		ArrayList<Integer> q2DrivingLicenses = GenerateEmployees.generateDrivingLicenseNumbers(employeesQ2, 2, random);
		ArrayList<Integer> q3DrivingLicenses = GenerateEmployees.generateDrivingLicenseNumbers(employeesQ3, 3, random);
		ArrayList<Integer> allQuaysDrivingLicenses = new ArrayList<Integer>();
		allQuaysDrivingLicenses.addAll(q1DrivingLicenses);
		allQuaysDrivingLicenses.addAll(q2DrivingLicenses);
		allQuaysDrivingLicenses.addAll(q3DrivingLicenses);
		
		ArrayList<Integer> q1Shifts = GenerateEmployees.generateShiftNumbers(employeesQ1);
		ArrayList<Integer> q2Shifts = GenerateEmployees.generateShiftNumbers(employeesQ2);
		ArrayList<Integer> q3Shifts = GenerateEmployees.generateShiftNumbers(employeesQ3);
		ArrayList<Integer> allQuaysShifts = new ArrayList<Integer>();
		allQuaysShifts.addAll(q1Shifts);
		allQuaysShifts.addAll(q2Shifts);
		allQuaysShifts.addAll(q3Shifts);
		
		ArrayList<Integer> q1Schedules = GenerateEmployees.generateScheduleNumbers(employeesQ1);
		ArrayList<Integer> q2Schedules = GenerateEmployees.generateScheduleNumbers(employeesQ2);
		ArrayList<Integer> q3Schedules = GenerateEmployees.generateScheduleNumbers(employeesQ3);
		ArrayList<Integer> allQuaysSchedules = new ArrayList<Integer>();
		allQuaysSchedules.addAll(q1Schedules);
		allQuaysSchedules.addAll(q2Schedules);
		allQuaysSchedules.addAll(q3Schedules);
		
		ArrayList<Integer> q1Status = GenerateEmployees.generateStatusNumbersForQuay(employeesQ1);
		ArrayList<Integer> q2Status = GenerateEmployees.generateStatusNumbersForQuay(employeesQ2);
		ArrayList<Integer> q3Status = GenerateEmployees.generateStatusNumbersForQuay(employeesQ3);
		ArrayList<Integer> allQuaysStatus = new ArrayList<Integer>();
		allQuaysStatus.addAll(q1Status);
		allQuaysStatus.addAll(q2Status);
		allQuaysStatus.addAll(q3Status);
		
		//(employee_id, firstName, lastName, gender, driving_license_ID, status_ID, schedule_ID, shiftHours)
		Employee temp = null;
		String tempFirstName = null;
		String tempLastName = null;
		String tempGender = null;
		int tempDrivingLicense = 0;
		int tempShift = 0;
		int tempSchedule = 0;
		int tempStatus = 0;
		int tempID = 0;
		for(int i = 0; i < 600; i++){
			//Employee(employee_id, firstName, lastName, gender, driving_license_ID, status_ID, schedule_ID, shiftHours)
			tempFirstName = firstNames.get(i);
			tempLastName = lastNames.get(i);
			tempGender = genders.get(i);
			tempDrivingLicense = allQuaysDrivingLicenses.get(i);
			tempShift = allQuaysShifts.get(i);
			tempSchedule = allQuaysSchedules.get(i);
			tempStatus = allQuaysStatus.get(i);
			temp = new Employee(tempID, tempFirstName, tempLastName, tempGender, tempDrivingLicense, tempStatus, tempSchedule, tempShift);
			allEmployees.add(temp);
			/*
			if (i > (employeesQ1 + employeesQ2 - 1)){ //Kaj 3
				
			}
			else if (i > (employeesQ1 - 1)){ //Kaj 2
				
			}
			else { //Kaj 1
				
			}
			*/
		}
		
		for(int j = 0; j<allEmployees.size(); j++){
			if(j==0){
				System.out.println("Kaj 1:");
			}
			if(j==165){
				System.out.println("Kaj 2:");
			}
			if(j==(165+195)){
				System.out.println("Kaj 3");
			}
			System.out.println(allEmployees.get(j));
		}
		
	}

}
