package domain;
public interface Storage{
  public void addEmployee(Employee e);
  public void modifyEmployee(int employee_id);
  public void deleteEmployee(int employee_id);
  public void addTruck(Truck t);
  public void modifyTruck(int truck_id);
  public void deleteTruck(int truck_id);
}
