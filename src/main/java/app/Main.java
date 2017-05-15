package app;
import domain.*;
import java.sql.*;
import java.util.Scanner;
public class Main{
  public static void main(String[] args) {
  Storage storage = new DBStorage();
  Scanner scan = new Scanner(System.in);
  Scanner scan1 = new Scanner(System.in);
  System.out.println("1: Add  Employee: ");
  System.out.println("2: Add  Truck: ");
  System.out.println("3: Delete Employee");
  System.out.println("4: Delete Truck");
  System.out.println("5: Modify Employee (change status)");
  System.out.println("6: Modify Truck (change status)");
  System.out.println("7: Show Employee profile");
  System.out.println("8: exit");
  String answer = scan.nextLine();
  if(answer.equals("1")){ //Add employee
    System.out.println("Enter Employee_ID: ");
     int id = scan.nextInt();
     System.out.println("Enter firstName: ");
     String first = scan1.nextLine();
     System.out.println("Enter lastName: ");
     String last = scan1.nextLine();
     System.out.println("Enter driving_license_ID: ");
      int driving = scan.nextInt();
      System.out.println("Enter status_ID: ");
       int status = scan1.nextInt();
       System.out.println("Enter schedule_ID: ");
        int schedule = scan.nextInt();
     storage.addEmployee(new Employee(id, first, last, driving, status, schedule));
     //System.out.println("Congratulations:the employee has been added");
    }
    if(answer.equals("2")){ //Add truck
      System.out.println("Enter truck_ID: ");
       int id = scan.nextInt();
       System.out.println("Enter truck_type: ");
       String type = scan1.nextLine();
       System.out.println("Enter truck_status: ");
       String status = scan1.nextLine();
       System.out.println("Enter truck_cost: ");
        int cost = scan.nextInt();
       storage.addTruck(new Truck(id, type, status, cost));
     }
     if (answer.equals("3")) { //Delete employee
       System.out.println("Enter employee id:");
       Scanner option3 = new Scanner(System.in);
       int id = option3.nextInt();
       storage.deleteEmployee(id);
     }
     if (answer.equals("4")) { //Delete truck
       System.out.println("Enter truck id:");
       Scanner option4 = new Scanner(System.in);
       int id = option4.nextInt();
       storage.deleteTruck(id);
     }
     if (answer.equals("5")) { //Modify employee
       Scanner option5 = new Scanner(System.in);
       System.out.println("Enter employee id:");
       int id = option5.nextInt();
       storage.modifyEmployee(id);
     }
     if (answer.equals("6")) { //Modify truck
       Scanner option6 = new Scanner(System.in);
       System.out.println("Enter truck ID:");
       int id = option6.nextInt();
       storage.modifyTruck(id);
     }
     if(answer.equals("7")){
       Scanner option7 = new Scanner(System.in);
       System.out.println("Enter employee ID:");
       int id = option7.nextInt();
       storage.showEmployeeProfile(id);
     }
    else if(answer.equals("8")){
      System.exit(1);
    }
  }
}
