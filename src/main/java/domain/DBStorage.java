package domain;
import java.sql.*;
import java.util.Scanner;
import java.util.ArrayList;
public class DBStorage implements Storage{
  private final static String DB_CON="jdbc:sqlite:harborDB";
  private static Connection con;
  static{
    try{
      Class.forName("org.sqlite.JDBC");
      con = DriverManager.getConnection(DB_CON);
    }catch(ClassNotFoundException | SQLException e){
      System.err.println("Error getting connection to the database " + e.getMessage());
    }
  }
  public boolean hasConnection(){
    return con != null;
  }
  public void addEmployee(Employee em){
    if(hasConnection()){
      try{
        Statement stm = null;
        boolean firstName_ok = false;
        boolean lastName_ok = false;
        boolean gender_ok = false;
        boolean drivingLicenseID_ok = false;
        boolean statusID_ok = false;
        boolean scheduleID_ok = false;

        int employee_id = em.employee_id();
        String firstName = em.firstName();
        String lastName = em.lastName();
        int gender_ID = em.gender_ID();
        int driving_license_ID = em.driving_license_ID();
        int status_ID = em.status_ID();
        int schedule_ID = em.schedule_ID();
        if(firstName.length()>0){
        	firstName_ok = true;
        }
        if(lastName.length()>0){
        	lastName_ok = true;
        }
        if (gender_ID > 0 && gender_ID < 4) {
          gender_ok = true;
        }
        if(driving_license_ID > 0 && driving_license_ID < 9){
        	drivingLicenseID_ok = true;
        }
        if(status_ID > 0 && status_ID < 7){
        	statusID_ok = true;
        }
        if(schedule_ID > 0 && schedule_ID < 4){
        	scheduleID_ok = true;
        }
        if(firstName_ok && lastName_ok && gender_ok && statusID_ok && scheduleID_ok && drivingLicenseID_ok){
        	String sql = "INSERT INTO employee(Employee_id,FirstName,LastName, Gender_ID, Driving_license_ID, Status_ID, Schedule_ID) VALUES(" + employee_id +
        	        ",'" + firstName + "','"+ lastName + "'," + gender_ID + "," + driving_license_ID + ","+ status_ID + "," + schedule_ID +   ")";
        	System.out.println(sql);
        	stm = con.createStatement();
        	stm.executeUpdate(sql);
        	System.out.println("the employee " + firstName + " has been successfully added");
        }
        else{
        	System.out.println("Incorrect values entered. No employee added");
        }

      }catch(SQLException e){
        System.out.println("Something went wrong when adding employee: " + e.getMessage());
      }
    }
  }
  public void modifyEmployee(int employee_id){
    int id = employee_id;
    String sql = "";
    if (hasConnection()) {
      try {
        System.out.println("What do you want to change:");
        System.out.println("1: Status");
        System.out.println("2: Schedule");
        System.out.println("3: Exit");
        Scanner scan = new Scanner(System.in);
        int value = 0;
        do {
          value = scan.nextInt();
        } while (value<1 || value>3);
        if(value == 1){
          sql = modifyStatusEmployee(id);
        }
        else if(value == 2){
          sql = modifySchemaEmployee(id);
        }
        else{
          System.exit(1);
        }
        Statement stm = null;
        System.out.println(sql);
        stm = con.createStatement();
        stm.executeUpdate(sql);
        System.out.println("Employee successfully modified");
      }catch (SQLException e) {
        System.out.println("Something went wrong modifying employee: " + e.getMessage());
      }
    }
  }
  public void deleteEmployee(int employee_id){
    try {

    	String checkSql = "SELECT Employee_ID FROM employee";
        ResultSet rs = con.createStatement().executeQuery(checkSql);
        ArrayList<Integer> existing_IDs = new ArrayList<Integer>();
        while(rs.next()){
        	existing_IDs.add(rs.getInt("Employee_ID"));
        }
        if(existing_IDs.contains(employee_id) == true){
        	Statement stm = null;
            String sql = "DELETE FROM employee WHERE Employee_id="+employee_id;
            System.out.println(sql);
            stm = con.createStatement();
            stm.executeUpdate(sql);
            System.out.println("The employee " + employee_id + " has been deleted from the database");
        }
        else {
        	System.out.println("No employee with given ID number");
        }

    }catch (SQLException e) {
      System.out.println("Problem deleting the employee: " + e.getMessage());
    }
  }
  public void addTruck(Truck t){
    if(hasConnection()){
      try{
        Statement stm = null;
        int truck_id = t.truck_ID();
        String truck_type = t.truck_type();
        String truck_status = t.truck_status();
        int truck_cost = t.truck_cost();
        String sql = "INSERT INTO truck(Truck_id,Truck_type,Truck_status, Truck_cost) VALUES(" + truck_id +
        ",'" + truck_type + "','"+ truck_status + "'," + truck_cost + ")";
        System.out.println(sql);
        stm = con.createStatement();
        stm.executeUpdate(sql);
        System.out.println("the truck " + truck_id + " has been successfully added");
      }catch(SQLException e){
        System.out.println("Something went wrong when adding truck: " + e.getMessage());
      }
    }
  }
  public void modifyTruck(int truck_id){
    if (hasConnection()) {
      try {
        System.out.println("Choose a new status for the truck:");
        System.out.println("1: Ok");
        System.out.println("2: Reparation");
        System.out.println("3: Reserv");
        System.out.println("4. Skada");
        Scanner truck_status_scanner = new Scanner(System.in);
        int truck_status_choice = 0;
        do {
          truck_status_choice = truck_status_scanner.nextInt();
        } while (truck_status_choice>4 || truck_status_choice<1);
        String new_truck_status = null;
        if (truck_status_choice == 1) {
          new_truck_status = "Ok";
        }
        else if (truck_status_choice == 2) {
          new_truck_status = "Reparation";
        }
        else if (truck_status_choice == 3) {
          new_truck_status = "Reserv";
        }
        else if (truck_status_choice == 4) {
          new_truck_status = "Skada";
        }
        Statement stm = null;
        String sql = "UPDATE truck SET Truck_status='"+new_truck_status+"' WHERE Truck_id="+truck_id;
        System.out.println(sql);
        stm = con.createStatement();
        stm.executeUpdate(sql);
        System.out.println("the truck " + truck_id + " has been successfully modified");
      }catch (SQLException e) {
        System.out.println("Problem modifying truck: " + e.getMessage());
      }
    }
  }
  public void showEmployeeProfile(int employee_id){
    String profile = "";
    if(hasConnection()){
      try{
        Statement stm = null;
        String sql = "SELECT * FROM employee WHERE Employee_ID="+employee_id;
        ResultSet rs = con.createStatement().executeQuery(sql);
        if(rs.next()){
        Employee  em = new Employee(rs.getInt("Employee_ID"), rs.getString("FirstName"), rs.getString("LastName"),
                        rs.getInt("Gender_ID"), rs.getInt("Driving_license_ID"), rs.getInt("Status_ID"), rs.getInt("Schedule_ID"));
          profile =  em.toString();
        }
      }catch (SQLException e) {
        System.out.println("Problem printing employees profile: " + e.getMessage());
      }
    }
   System.out.print(profile);
  }
  public void deleteTruck(int truck_id){
    if (hasConnection()) {
      try {
        Statement stm = null;
        String sql = "DELETE FROM truck WHERE Truck_id="+truck_id;
        System.out.println(sql);
        stm = con.createStatement();
        stm.executeUpdate(sql);
        System.out.println("The truck " + truck_id + " has been deleted from the database");
      }catch (SQLException e) {
        System.out.println("Problem deleting truck: " + e.getMessage());
      }
    }
  }
public String modifySchemaEmployee(int employee_id){
      System.out.println("Choose a new schema for the employee:");
      System.out.println("1: MF");
      System.out.println("2: LS");
      System.out.println("3: S");
      Scanner employee_schedule_choice = new Scanner(System.in);
      int new_employee_status = 0;
      do {
        new_employee_status = employee_schedule_choice.nextInt();
      } while (new_employee_status<1 || new_employee_status>3);
      return "UPDATE employee SET Schedule_ID="+new_employee_status+" WHERE Employee_id="+employee_id;
}
public String modifyStatusEmployee(int employee_id){
      System.out.println("Choose a new status for the employee:");
      System.out.println("1: 100%");
      System.out.println("2: 50%");
      System.out.println("3: Sjuk");
      System.out.println("4: VAB");
      System.out.println("5: Studier");
      System.out.println("6: Semester");
      Scanner employee_status_choice = new Scanner(System.in);
      int new_employee_status = 0;
      do {
        new_employee_status = employee_status_choice.nextInt();
      } while (new_employee_status<1 || new_employee_status>6);
      return "UPDATE employee SET Status_ID="+new_employee_status+" WHERE Employee_id="+employee_id;
}
}
