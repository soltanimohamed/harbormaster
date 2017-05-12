package domain;
import java.sql.*;
import java.util.Scanner;
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
        int employee_id = em.employee_id();
        String firstName = em.firstName();
        String lastName = em.lastName();
        int driving_license_ID = em.driving_license_ID();
        int status_ID = em.status_ID();
        int schedule_ID = em.schedule_ID();
        String sql = "INSERT INTO employee(Employee_id,FirstName,LastName, Driving_license_ID, Status_ID, Schedule_ID) VALUES(" + employee_id +
        ",'" + firstName + "','"+ lastName + "'," + driving_license_ID + ","+ status_ID + "," + schedule_ID +   ")";
        System.out.println(sql);
        stm = con.createStatement();
        stm.executeUpdate(sql);
        System.out.println("the employee " + firstName + " has been successfully added");
      }catch(SQLException e){
        System.out.println("Something went wrong when adding employee: " + e.getMessage());
      }
    }
  }
  public void modifyEmployee(int employee_id){
    if (hasConnection()) {
      try {
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
        Statement stm = null;
        String sql = "UPDATE employee SET Status_ID="+new_employee_status+" WHERE Employee_id="+employee_id;
        System.out.println(sql);
        stm = con.createStatement();
        stm.executeUpdate(sql);
        System.out.println("Employee successfully modified");
      }catch (SQLException e) {
        System.out.println("Something went wrong modifying employee: " + e.getMessage());
      }
    }
  };
  public void deleteEmployee(int employee_id){
    try {
      Statement stm = null;
      String sql = "DELETE FROM employee WHERE Employee_id="+employee_id;
      System.out.println(sql);
      stm = con.createStatement();
      stm.executeUpdate(sql);
      System.out.println("The employee " + employee_id + "has been deleted from the database");
    }catch (SQLException e) {
      System.out.println("Problem deleting the employee: " + e.getMessage());
    }
  };
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
  };
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
  };
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
  };

}
