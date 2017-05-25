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
        Statement stm ;
        int employee_id = em.employee_id();
        String firstName = em.firstName();
        String lastName = em.lastName();
        String gender = em.gender();
        int driving_license_ID = em.driving_license_ID();
        int status_ID = em.status_ID();
        int schedule_ID = em.schedule_ID();
        	String sql = "INSERT INTO employee(Employee_id,FirstName,LastName, Gender, Driving_license_ID, Status_ID, Schedule_ID) VALUES(" + employee_id +
        	        ",'" + firstName + "','"+ lastName + "','" + gender + "'," + driving_license_ID + ","+ status_ID + "," + schedule_ID +   ")";
        	System.out.println(sql);
        	stm = con.createStatement();
        	stm.executeUpdate(sql);
        	System.out.println("the employee " + firstName + " has been successfully added");

      }catch(SQLException e){
        System.out.println("Something went wrong when adding employee: " + e.getMessage());
      }
    }
  }
  public boolean verifyEmployee(int employee_id){
      boolean exist = false;
      if (hasConnection()) {
      try {
        String sql = "SELECT Employee_ID FROM employee WHERE Employee_ID ="+employee_id;
        ResultSet rs = con.createStatement().executeQuery(sql);
        if(rs.next()){
          exist = true;
        }
      }catch (SQLException e) {
        System.out.println("Something went wrong: " + e.getMessage());
      }
      }
      System.out.println(exist);
      return exist;
  }

  public boolean verifyTruck(int truck_id){
      boolean exist = false;
      if (hasConnection()) {
      try {
        String sql = "SELECT Truck_ID FROM truck WHERE Truck_ID ="+truck_id;
        ResultSet rs = con.createStatement().executeQuery(sql);
        if(rs.next()){
          exist = true;
        }
      }catch (SQLException e) {
        System.out.println("Something went wrong: " + e.getMessage());
      }
      }
      System.out.println(exist);
      return exist;
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
  public Employee getEmployee(int employee_id){
    Employee em = null;
    if(hasConnection()){
      try{
        Statement stm = null;
        String sql = "SELECT * FROM employee WHERE Employee_ID="+employee_id;
        ResultSet rs = con.createStatement().executeQuery(sql);
        if(rs.next()){
        em = new Employee(rs.getInt("Employee_ID"), rs.getString("FirstName"), rs.getString("LastName"),
                        rs.getString("Gender"), rs.getInt("Driving_license_ID"), rs.getInt("Status_ID"), rs.getInt("Schedule_ID"));
        }
      }catch (SQLException e) {
        System.out.println("Problem printing employees profile: " + e.getMessage());
      }
    }
   return em;
  }

  public Truck getTruck(int truck_id){
    Truck tr = null;
    if(hasConnection()){
      try{
        Statement stm = null;
        String sql = "SELECT * FROM truck WHERE Truck_id="+truck_id;
        ResultSet rs = con.createStatement().executeQuery(sql);
        if(rs.next()){
        tr = new Truck(rs.getInt("Truck_id"), rs.getString("Truck_type"), rs.getString("Truck_status"),
                        rs.getInt("Truck_cost"));
        }
      }catch (SQLException e) {
        System.out.println("Problem printing truck info: " + e.getMessage());
      }
    }
   return tr;
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
                        rs.getString("Gender"), rs.getInt("Driving_license_ID"), rs.getInt("Status_ID"), rs.getInt("Schedule_ID"));
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
public void modifyEmployee(int employee_id, int status_id, int schedule_id){
  if (hasConnection()) {
    String sql = "";
    Statement stm;
    try {
        sql = "UPDATE employee SET Status_ID=" + status_id + " ,Schedule_ID=" + schedule_id + " WHERE Employee_id="+employee_id;
      System.out.println(sql);
      stm = con.createStatement();
      stm.executeUpdate(sql);
      //System.out.println("The truck " + truck_id + " has been deleted from the database");
    }catch (SQLException e) {
      System.out.println("Problem modifying employee: " + e.getMessage());
    }
  }
}

public void modifyTruck(int truck_id, String status){
  if (hasConnection()) {
    String sql = "";
    Statement stm;
    try {
        sql = "UPDATE truck SET Truck_status='" + status + "' WHERE Truck_id="+truck_id;
      System.out.println(sql);
      stm = con.createStatement();
      stm.executeUpdate(sql);
    }catch (SQLException e) {
      System.out.println("Problem modifying truck's status: " + e.getMessage());
    }
  }
}


public int inlogg(String username, String password){
    int result = 0;
    try{
      String sql="SELECT admin_ID FROM admin WHERE username='" + username+
      "' AND password='" + password + "'";
      ResultSet rs = con.createStatement().executeQuery(sql);
      if(rs.next()){
      result = rs.getInt("admin_ID");
        //System.out.println(result);
    /*  }
      else{
        result = false;
        System.out.println(result);
      } */
      }
    }catch(SQLException|NullPointerException e){
      //System.err.println("Error :" + e.getMessage());
      System.err.println("there is an error");
    }
    return result;
  }

	public void addShip(String name, String company, String volume_type){
		if(hasConnection()){
			Statement stm;
			try{
				String SQL = "INSERT INTO ship () VALUES('"+name+"', '"+company+"', '"+volume_type+"')";
				stm = con.createStatement();
				stm.executeQuery(SQL);
				System.out.println("Ship " + name + " added");
			}catch(SQLException sqle){
				System.err.println("Error adding ship" + sqle.getStackTrace());
			}
		}
	}

}
