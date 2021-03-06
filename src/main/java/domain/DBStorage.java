package domain;
import java.sql.*;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;
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
        int shiftHours = em.shiftHours();
        if(status_ID == 1 || status_ID == 2){
        if ((driving_license_ID==1 || driving_license_ID==2)) {
        em.set_quay_id(1);
        }
        else if (driving_license_ID==3 || driving_license_ID==4 || driving_license_ID==5) {
        em.set_quay_id(2);
        }
        else if (driving_license_ID==6 || driving_license_ID==7 || driving_license_ID==8){
          em.set_quay_id(3);
        }
      }
        else{
          em.set_quay_id(0);
        }

        	String sql = "INSERT INTO employee(Employee_id,FirstName,LastName, Gender, Driving_license_ID, Status_ID, Schedule_ID, ShiftHours, QUAY_ID) VALUES(" + employee_id +
        	        ",'" + firstName + "','"+ lastName + "','" + gender + "'," + driving_license_ID + ","+ status_ID + "," + schedule_ID + "," + shiftHours +"," + em.quay_ID() + ")";
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
                        rs.getString("Gender"), rs.getInt("Driving_license_ID"), rs.getInt("Status_ID"), rs.getInt("Schedule_ID"), rs.getInt("ShiftHours"));
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

  public boolean verifyShip(int ship_id){
      boolean exist = false;
      if (hasConnection()) {
      try {
        String sql = "SELECT Ship_id FROM ship WHERE Ship_id ="+ship_id;
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

  public void showEmployeeProfile(int employee_id){
    String profile = "";
    if(hasConnection()){
      try{
        Statement stm = null;
        String sql = "SELECT * FROM employee WHERE Employee_ID="+employee_id;
        ResultSet rs = con.createStatement().executeQuery(sql);
        if(rs.next()){
        Employee  em = new Employee(rs.getInt("Employee_ID"), rs.getString("FirstName"), rs.getString("LastName"),
                        rs.getString("Gender"), rs.getInt("Driving_license_ID"), rs.getInt("Status_ID"), rs.getInt("Schedule_ID"), rs.getInt("ShiftHours"));
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
public void addShip(Ship sh){
  if(hasConnection()){
    try{
      Statement stm = null;
      int ship_id = sh.id();
      String name = sh.name();
      String company = sh.company();
      String volume_type= sh.volume_type();
      String sql = "INSERT INTO ship(Ship_id, Ship_name, Company, Volume_type)  VALUES(" + ship_id +  ",'" + name + "','"+ company + "','" + volume_type + "')";
      System.out.println(sql);
      stm = con.createStatement();
      stm.executeUpdate(sql);
      System.out.println("the ship " + ship_id + " has been successfully added");
    }catch(SQLException e){
      System.out.println("Something went wrong when adding truck: " + e.getMessage());
    }
  }
}
public Ship getShip(int ship_id){
  Ship sh = null;
  if(hasConnection()){
    try{
      Statement stm = null;
      String sql = "SELECT * FROM ship WHERE ship_id="+ship_id;
      ResultSet rs = con.createStatement().executeQuery(sql);
      if(rs.next()){
      sh = new Ship(rs.getInt("Ship_id"), rs.getString("Ship_name"), rs.getString("Company"),
                      rs.getString("Volume_type"));
      }
    }catch (SQLException e) {
      System.out.println("Problem printing truck info: " + e.getMessage());
    }
  }
 return sh;
}

public void modifyShip(int ship_id, String name, String company){
  if (hasConnection()) {
    String sql = "";
    Statement stm;
    try {
        sql = "UPDATE ship SET Ship_name='" + name + "', Company='" + company + "' WHERE Ship_id="+ship_id;
      System.out.println(sql);
      stm = con.createStatement();
      stm.executeUpdate(sql);
    }catch (SQLException e) {
      System.out.println("Problem modifying truck's status: " + e.getMessage());
    }
  }
}

public void deleteShip(int ship_id){
  if (hasConnection()) {
    try {
      Statement stm = null;
      String sql = "DELETE FROM ship WHERE Ship_id="+ship_id;
      System.out.println(sql);
      stm = con.createStatement();
      stm.executeUpdate(sql);
      System.out.println("The ship " + ship_id + " has been deleted from the database");
    }catch (SQLException e) {
      System.out.println("Problem deleting truck: " + e.getMessage());
    }
  }
}

public void addShipToQuayShift(int quayShift_ID , int ship_id, String shipName, String shiftH, String date, int quay_ID){
  if(hasConnection()){
    try{
      Statement stm = null;
      String sql = "INSERT INTO quay_shift(QuayShift_ID, Ship_id, Ship_name, ShiftHours, ShiftDay, Quay_ID)  VALUES(" + quayShift_ID +  "," + ship_id + ",'" + shipName +"','"+ shiftH + "','" + date + "'," + quay_ID + ")";
      System.out.println(sql);
      stm = con.createStatement();
      stm.executeUpdate(sql);
      System.out.println("the ship " + ship_id + " has been successfully added to the Quay");
    }catch(SQLException e){
      System.out.println("Something went wrong when adding truck: " + e.getMessage());
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
      }
    }catch(SQLException|NullPointerException e){
      //System.err.println("Error :" + e.getMessage());
      System.err.println("there is an error");
    }
    return result;
  }

/*	public void assignShipToQuay(Quay q, Ship s, int hours, String date){
		//'A005','AA07','B005','BB07','C005','CC07','CCC5','K007'
		if(hasConnection()){
			Statement stm;
			boolean valid = false;
			if((q.id()==1 && s.volume_type().equals("A005")) || (q.id() == 1 && s.volume_type().equals("AA07"))
					|| (q.id()==2 && s.volume_type().equals("B005")) ||(q.id()==2 && s.volume_type().equals("BB07"))
					|| (q.id()==2 && s.volume_type().equals("C005")) ||(q.id()==3 && s.volume_type().equals("CC07")
					|| (q.id()==3 && s.volume_type().equals("CCC5"))) || (q.id()==3 && s.volume_type().equals("K007"))){
				valid = true;
			}
			if(valid){
				try{
					String SQL = "INSERT INTO quay_shift (Quay_ID, Ship_id, ShiftHours, ShiftDay) VALUES("+q.id()+", "+
									s.id() + ", " + hours + ", " + date +")";
					stm = con.createStatement();
					stm.executeQuery(SQL);
					System.out.println("Ship " + s.id() + " assigned to quay " + q.name());
				}catch(SQLException sqle){
					System.err.println("Error assigning ship to quay: " + sqle.getMessage());
				}
			}

		}
	} */

	public void assignEmployeeToQuayShift(Employee e, QuayShift qs){
		if(hasConnection()){
			Statement stm;
			try{
				//Kommer inte att fungera eftersom Employee inte har någon Quay_ID
				String SQL = "UPDATE employee SET Quay_ID="+qs.id()+" WHERE Employee_id ="+e.employee_id();
				stm = con.createStatement();
				stm.executeQuery(SQL);
				System.out.println("Employee nr " + e.employee_id() + " has been assigned to ship " + qs.docked_ship().name() +
									" during quay shift " + qs.id() + " during " + qs.shift_hours());
			}catch (SQLException sqle){
				System.err.println("Error assigning employee to quay shift: " + sqle.getMessage());
			}
		}
	}

  public List<Employee> showAllEmployee(){
    List<Employee> allEmployee = new ArrayList<>();
    try{
      String sql = "SELECT * from employee";
      ResultSet rs = con.createStatement().executeQuery(sql);
      while(rs.next()){
        Employee e = new Employee(rs.getInt("Employee_id"),  rs.getString("FirstName"),
        rs.getString("LastName"), rs.getString("Gender"), rs.getInt("Driving_license_ID"),
        rs.getInt("Status_ID"), rs.getInt("Schedule_ID"), rs.getInt("ShiftHours"));
        allEmployee.add(e);
      }
    }catch(Exception e){
      System.err.println("Error: " + e.getMessage());
    }
    return allEmployee;
  }

public List<Employee> showQuayEmployee(int quayId, String shift){
  List<Employee> allEmployeeQuay = new ArrayList<>();
  int shiftid = 0;
  if(shift.equals("08:00-16:00")){shiftid = 1;}
  else if(shift.equals("16:00-00:00")){shiftid = 2;}
  else { shiftid = 3;}
  try{
    String sql = "SELECT * from employee WHERE shiftHours ="+ shiftid +" AND QUAY_ID =" + quayId + " AND Status_ID IN (1, 2)" ;
    System.out.println(sql);
    ResultSet rs = con.createStatement().executeQuery(sql);
    while(rs.next()){
      Employee e = new Employee(rs.getInt("Employee_id"),  rs.getString("FirstName"),
      rs.getString("LastName"), rs.getString("Gender"), rs.getInt("Driving_license_ID"),
      rs.getInt("Status_ID"), rs.getInt("Schedule_ID"), rs.getInt("ShiftHours"));
      allEmployeeQuay.add(e);
    }
  }catch(Exception e){
    System.err.println("Error: " + e.getMessage());
  }
  return allEmployeeQuay;
}
  public List<Truck> showAllTruck(){
    List<Truck> allTruck = new ArrayList<>();
    try{
      String sql = "SELECT * from truck";
      ResultSet rs = con.createStatement().executeQuery(sql);
      while(rs.next()){
        Truck tr = new Truck(rs.getInt("Truck_id"),  rs.getString("Truck_type"),
        rs.getString("Truck_status"), rs.getInt("Truck_cost"));
        allTruck.add(tr);
      }
    }catch(Exception e){
      System.err.println("Error: " + e.getMessage());
    }
    return allTruck;
  }

public List<Truck> showQuayTruck(int quayId){
  List<Truck> allTruckQuay = new ArrayList<>();
  String sql = " ";
  if(quayId == 1){sql = "SELECT * from truck WHERE Truck_status = 'Ok' AND Truck_type IN ('A001','AA01')";}
  else if(quayId == 2){sql = "SELECT * from truck WHERE Truck_status = 'Ok' AND Truck_type IN ('B001','BB01','C001')";}
  else{sql = "SELECT * from truck WHERE Truck_status = 'Ok' AND Truck_type IN ('CC01','CCC1','K001')"; }
  try{
    ResultSet rs = con.createStatement().executeQuery(sql);
    while(rs.next()){
      Truck tr = new Truck(rs.getInt("Truck_id"),  rs.getString("Truck_type"),
      rs.getString("Truck_status"), rs.getInt("Truck_cost"));
      allTruckQuay.add(tr);
    }
  }catch(Exception e){
    System.err.println("Error: " + e.getMessage());
  }
  return allTruckQuay;
}

  public List<Ship> showAllShip(){
    List<Ship> allShip = new ArrayList<>();
    try{
      String sql = "SELECT * from ship";
      ResultSet rs = con.createStatement().executeQuery(sql);
      while(rs.next()){
        Ship sh = new Ship(rs.getInt("Ship_id"),  rs.getString("Ship_name"),
        rs.getString("Company"), rs.getString("Volume_type"));
        allShip.add(sh);
      }
    }catch(Exception e){
      System.err.println("Error: " + e.getMessage());
    }
    return allShip;
  }

  public List<String> showQuayShips(int quayId){
    List<String> quayShips = new ArrayList<>();
      String result = " ";
    try{
      String sql = "SELECT Ship_name, ShiftHours, ShiftDay from quay_shift WHERE Quay_ID = " + quayId + "";
      ResultSet rs = con.createStatement().executeQuery(sql);
      while(rs.next()){
        String name = " ";
        String hours = " ";
        String day = " ";
         name = rs.getString("Ship_name");
         hours = rs.getString("ShiftHours");
         day = rs.getString("ShiftDay");
         result = name + " | " + hours + " | " + day;
        quayShips.add(result);
        result =" ";
      }
    }catch(Exception e){
      System.err.println("Error: " + e.getMessage());
    }
    return quayShips;
  }

  public List<String> getAllQuayVolumeTypes(){
	  List<String> quayVolumeTypes = new ArrayList<String>();
	  try{
		  String sql = "SELECT * FROM quays_volume_types";
		  ResultSet rs = con.createStatement().executeQuery(sql);
		  while(rs.next()){
			  String volumeType = rs.getString("Volume_type");
			  quayVolumeTypes.add(volumeType);
		  }
	  }catch(SQLException sqle){
		  System.err.println("Error getting quay volume types: " + sqle.getMessage());
	  }
	  return quayVolumeTypes;
  }
}
