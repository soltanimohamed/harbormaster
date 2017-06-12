package gui;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.text.*;
import javafx.geometry.*;
import javafx.stage.Modality;
import java.awt.Desktop;
import java.net.*;
import java.util.List;
import java.util.ArrayList;
import domain.*;
public class AddEmployeeToQuay{
  private Storage storage;
  private Employee em;
  private QuayShift shift;
  private Quay kaj;
public AddEmployeeToQuay(Employee em, Storage storage){
  this.storage = storage;
  this.em = em;
 addEmployee();
}
public void addEmployee(){
   int kajID = 0;
   String shiftStr = "";
try{
  if(em.driving_license_ID() == 1 || em.driving_license_ID() == 2){
    kajID = 1;
  }
  else if(em.driving_license_ID() == 3 || em.driving_license_ID() == 4 || em.driving_license_ID() == 5){
    kajID = 2;
  }
  else{ kajID = 3;}

  if(em.shiftHours() == 1){
    shiftStr = "00:00-8:00";
  }
  else if(em.shiftHours() == 2){
    shiftStr = "8:00-16:00";
  }
  else{shiftStr = "16:00-00:00"; }
 shift = new QuayShift(em.shiftHours(), shiftStr);
 kaj = new Quay(kajID);
kaj.assignEmployee(em);
for(Employee employee : shift.active_workers()){
  System.out.println(employee);
}
//System.out.println(shift.active_workers());

} catch(Exception e){}

}
}
