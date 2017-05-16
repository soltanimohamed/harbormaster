package domain;
public class Employee{
private int employee_id; //Unikt id-nr
private String firstName; //Förnamn
private String lastName; //Efternamn
private String gender; // Male,  Female
private int driving_license_ID; //1: A, 2: AA, 3: B, 4: BB, 5: C, 6: CC, 7: CCC, 8: K
private int status_ID; //1: 100%, 2: 50%, 3: Sjuk, 4: VAB, 5: Studier, 6: Semester
private int schedule_ID; // 1: MF, 2: LS, 3: S

public Employee(int employee_id, String firstName, String lastName, String gender, int driving_license_ID, int status_ID, int schedule_ID){
  this.employee_id = employee_id;
  this.firstName = firstName;
  this.lastName = lastName;
  this.gender = gender;
  this.driving_license_ID = driving_license_ID;
  this.status_ID = status_ID;
  this.schedule_ID = schedule_ID;
}

public int employee_id(){ return employee_id;}
public String firstName(){ return firstName;}
public String lastName(){ return lastName;}
public String gender(){ return gender;}
public int driving_license_ID(){ return driving_license_ID;}
public int status_ID(){ return status_ID;}
public int schedule_ID(){ return schedule_ID;}

public void set_firstName(String firstName){this.firstName = firstName;}
public void set_lastName(String lastName){this.lastName = lastName;}
public void set_gender(String gender){this.gender = gender;}
public void set_driving_license_ID(int driving_license_ID){this.driving_license_ID = driving_license_ID;}
public void set_status_ID(int status_ID){this.status_ID = status_ID;}
public void set_schedule_ID(int schedule_ID){this.schedule_ID = schedule_ID;}

@Override
public boolean equals(Object o){
  if( o instanceof Employee){
    Employee e = (Employee) o;
    if(this.employee_id() == e.employee_id){
      return true;
    }}
    return false;}

@Override
public String toString(){
  return employee_id + "," + firstName + "," + lastName + "," + gender + "," + driving_license_ID + "," + status_ID + "," + schedule_ID;
}

}
