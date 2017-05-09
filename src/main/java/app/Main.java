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
  System.out.println("8: exit");
  String answer = scan.nextLine();
  if(answer.equals("1")){
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
    else if(answer.equals("8")){
      System.exit(1);
    }
  }
}
