package domain;
public class Employee{
private int employee_id; //Unikt id-nr
private String firstName; //Förnamn
private String lastName; //Efternamn
private String gender; // Male,  Female
private int driving_license_ID; //1: A, 2: AA, 3: B, 4: BB, 5: C, 6: CC, 7: CCC, 8: K
private int status_ID; //1: 100%, 2: 50%, 3: Sjuk, 4: VAB, 5: Studier, 6: Semester
private int schedule_ID; // 1: MF, 2: LS, 3: S
private int shiftHours; // 1 : dag, 2: kväll, 3: natt

public Employee(int employee_id, String firstName, String lastName, String gender, int driving_license_ID, int status_ID, int schedule_ID, int shiftHours){
  this.employee_id = employee_id;
  this.firstName = firstName;
  this.lastName = lastName;
  this.gender = gender;
  this.driving_license_ID = driving_license_ID;
  this.status_ID = status_ID;
  this.schedule_ID = schedule_ID;
  this.shiftHours = shiftHours;
}

public int employee_id(){ return employee_id;}
public String firstName(){ return firstName;}
public String lastName(){ return lastName;}
public String gender(){ return gender;}
public int driving_license_ID(){ return driving_license_ID;}
public int status_ID(){ return status_ID;}
public int schedule_ID(){ return schedule_ID;}
public int shiftHours(){ return shiftHours;}

public void set_firstName(String firstName){this.firstName = firstName;}
public void set_lastName(String lastName){this.lastName = lastName;}
public void set_gender(String gender){this.gender = gender;}
public void set_driving_license_ID(int driving_license_ID){this.driving_license_ID = driving_license_ID;}
public void set_status_ID(int status_ID){this.status_ID = status_ID;}
public void set_schedule_ID(int schedule_ID){this.schedule_ID = schedule_ID;}
public void set_shiftHours(int shiftHours){this.shiftHours = shiftHours;}
@Override
public boolean equals(Object o){
  if( o instanceof Employee){
    Employee e = (Employee) o;
    if(this.employee_id() == e.employee_id){
      return true;
    }}
    return false;
  }
public String license(){
  String driving = "";
  if(driving_license_ID == 1){driving = "A";}
  else if(driving_license_ID == 2){driving ="AA";}
  else if(driving_license_ID == 3){driving ="B";}
  else if(driving_license_ID == 4){driving ="BB";}
  else if(driving_license_ID == 5){driving ="C";}
  else if(driving_license_ID == 6){driving ="CC";}
  else if(driving_license_ID == 7){driving ="CCC";}
  else {driving = "K";}
  return driving;
  }

  public String status(){
    String em_status = "";
    if(status_ID == 1){em_status = "100%";}
    else if(status_ID == 2){em_status ="50%";}
    else if(status_ID == 3){em_status ="Sjuk";}
    else if(status_ID == 4){em_status ="Vab";}
    else if(status_ID == 5){em_status ="Studier";}
    else if(status_ID == 6){em_status ="Semester";}
    return em_status;
    }

    public String schema(){
      String em_schema = "";
      if(schedule_ID == 1){em_schema = "Mon-Fry";}
      else if(schedule_ID == 2){em_schema ="Saturday";}
      else if(schedule_ID == 3){em_schema ="Sat-Sun";}
      return em_schema;
      }

      public String shift(){
        String em_schift = "";
        if(shiftHours == 1){em_schift = "Dag";}
        else if(shiftHours == 2){em_schift ="Kväll";}
        else if(shiftHours == 3){em_schift ="Natt";}
        return em_schift;
        }

    @Override
    public String toString(){
      return employee_id + "| " + firstName + "| " + lastName + "| " + gender +
       "| " + license() + "| " + status() + "| " + schema() + "| " + shift();
    }
}
