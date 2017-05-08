package domain;

public class Employee{
private int employee_id;
private String firstName;
private String lastName;
private int driving_license_ID;
private int status_ID;
private int schedule_ID;

public Employee(int employee_id, String firstName, String lastName, int driving_license_ID, int status_ID, int schedule_ID){
  this.employee_id = employee_id;
  this.firstName = firstName;
  this.lastName = lastName;
  this.driving_license_ID = driving_license_ID;
  this.status_ID = status_ID;
  this.schedule_ID = schedule_ID;
}

public int employee_id(){ return employee_id;}
public String firstName(){ return firstName;}
public String lastName(){ return lastName;}
public int driving_license_ID(){ return driving_license_ID;}
public int status_ID(){ return status_ID;}
public int schedule_ID(){ return schedule_ID;}

public void set_firstName(String firstName){this.firstName = firstName;}
public void set_lastName(String lastName){this.lastName = lastName;}
public void set_driving_license_ID(int driving_license_ID){this.driving_license_ID = driving_license_ID;}
public void set_status_ID(int status_ID){this.status_ID = status_ID;}
public void set_schedule_ID(int schedule_ID){this.schedule_ID = schedule_ID;}



}
