package domain;
import java.sql.*;
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
        System.out.println("Wrong something went wrong" + e.getMessage());
      }
    }
  }
  public void modifyEmployee(int employee_id){};
  public void deleteEmployee(int employee_id){};
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
        System.out.println("Wrong something went wrong" + e.getMessage());
      }
    }
  };
  public void modifyTruck(int truck_id){};
  public void deleteTruck(int truck_id){};

}
