package domain;
public interface Storage{
  public void addEmployee(Employee e);
  public void deleteEmployee(int employee_id);
  public void showEmployeeProfile(int employee_id);
  public void addTruck(Truck t);
  public void deleteTruck(int truck_id);
  public boolean verifyEmployee(int employee_id);
  public Employee getEmployee(int employee_id);
  public void modifyEmployee(int employee_id, int status_id, int schedule_id);
  public Truck getTruck(int truck_id);
  public boolean verifyTruck(int truck_id);
  public void modifyTruck(int truck_id, String status);
  public int inlogg(String username, String password);
  public void addShip(String name, String company, String volume_type);
}
