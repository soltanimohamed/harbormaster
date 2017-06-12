package domain;
import java.util.List;
import java.util.ArrayList;
public interface Storage{
  public void addEmployee(Employee e);
  public void deleteEmployee(int employee_id);
  public void showEmployeeProfile(int employee_id);
  public void addTruck(Truck t);
  public void deleteTruck(int truck_id);
  public boolean verifyEmployee(int employee_id);
  public Employee getEmployee(int employee_id);
  public void modifyEmployee(int employee_id, int status_id, int schedule_id);
  public List<Employee> showAllEmployee();
  public List<Employee> showQuayEmployee(int quayId, String shift);
  public Truck getTruck(int truck_id);
  public boolean verifyTruck(int truck_id);
  public void modifyTruck(int truck_id, String status);
  public List<Truck> showAllTruck();
  public List<Truck> showQuayTruck(int quayId);
  public int inlogg(String username, String password);
  public void addShip(Ship sh);
  public void modifyShip(int ship_id, String name, String company);
  public Ship getShip(int ship_id);
  public boolean verifyShip(int ship_id);
  public void deleteShip(int ship_id);
  public void addShipToQuayShift(int quayShift_ID , int ship_id, String shipName, String shiftH, String date, int quay_ID);
  public List<Ship> showAllShip();
  public List<String> showQuayShips(int quayId);
  //public void advanceTime();

}
