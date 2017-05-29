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
import domain.*;
import javafx.stage.Modality;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
public class ExecutingModifyingEm{
  private Storage storage;
  private Employee em;
  public ExecutingModifyingEm(Storage storage, Employee em){
    this.storage = storage;
    this.em = em;
    createAview();
  }
  public  void createAview(){
    Stage window = new Stage();
    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle("Modify Employee");
    window.setMinWidth(250);
    Label  idLabel = new Label("Employee_ID:");
    TextField idField = new TextField();
    String em_ID = Integer.toString(em.employee_id());
    idField.setPromptText(em_ID);
    idField.setDisable(true);
    Label  firstNameLabel = new Label("First Name:");
    TextField firstNameField = new TextField();
    firstNameField.setPromptText(em.firstName());
    firstNameField.setDisable(true);
    Label  lastNameLabel = new Label("Last Name:");
    TextField lastNameField = new TextField();
    lastNameField.setPromptText(em.lastName());
    lastNameField.setDisable(true);
    Label sexLabel = new Label("Sex:");
    ComboBox sexBox = new ComboBox();
    sexBox.getItems().add("Male");
    sexBox.getItems().add("Female");
    sexBox.setDisable(true);
    sexBox.setPromptText(em.gender());
    Label driving_licenseLabel = new Label("driving_license_ID:");
    ComboBox drivingBox = new ComboBox();
    drivingBox.getItems().add("A");
    drivingBox.getItems().add("AA");
    drivingBox.getItems().add("B");
    drivingBox.getItems().add("BB");
    drivingBox.getItems().add("C");
    drivingBox.getItems().add("CC");
    drivingBox.getItems().add("CCC");
    drivingBox.getItems().add("K");
    drivingBox.setPromptText(getDriving(em.driving_license_ID()));
    drivingBox.setDisable(true);
    Label statusLabel = new Label("status_ID:");
    ComboBox statusBox = new ComboBox();
    statusBox.getItems().add("100%");
    statusBox.getItems().add("50%");
    statusBox.getItems().add("Sjuk");
    statusBox.getItems().add("VAB");
    statusBox.getItems().add("Studier");
    statusBox.getItems().add("Semester");
    Label scheduleLabel = new Label("schedule_ID:");
    ComboBox scheduleBox = new ComboBox();
    scheduleBox.getItems().add("MF");
    scheduleBox.getItems().add("LS");
    scheduleBox.getItems().add("S");
    Button submitButton = new Button("ok");
      submitButton.setOnAction( e ->{
     if(statusBox.getValue() == null || scheduleBox.getValue() == null){
    Alerts.display("Alert","Please choose a value for status and for schedule");
     }
       try{
         int statusID = getStatusID(statusBox.getValue().toString());
         int scheduleID = getScheduleID(scheduleBox.getValue().toString());
      storage.modifyEmployee(em.employee_id(), statusID, scheduleID);
    Alerts.display("Succeeded","Congratulation the employee has been modified");
    window.close();
    }
    catch(Exception ex){
      Alerts.display("Wrong" ,"Something went wrong");
    }
  });
    Button cancelButton = new Button("cancel");
    cancelButton.setOnAction( e ->{
      window.close();
    });
    GridPane pane = new GridPane();
    pane.setPadding(new Insets(5,5,5,5));
    pane.setVgap(8);
    pane.setHgap(10);
    pane.setConstraints(idLabel,0,0);
    pane.setConstraints(idField,1,0);
    pane.setConstraints(firstNameLabel,0,1);
    pane.setConstraints(firstNameField,1,1);
    pane.setConstraints(lastNameLabel,0,2);
    pane.setConstraints(lastNameField,1,2);
    pane.setConstraints(sexLabel,0,3);
    pane.setConstraints(sexBox,1,3);
    pane.setConstraints(driving_licenseLabel,0,4);
    pane.setConstraints(drivingBox,1,4);
    pane.setConstraints(statusLabel,0,5);
    pane.setConstraints(statusBox,1,5);
    pane.setConstraints(scheduleLabel,0,6);
    pane.setConstraints(scheduleBox,1,6);
    pane.setConstraints(submitButton,0,7);
    pane.setConstraints(cancelButton,1,7);

    pane.getChildren().addAll(idLabel,idField,firstNameLabel,
     firstNameField,lastNameLabel,lastNameField,sexLabel,sexBox,driving_licenseLabel,drivingBox,
     statusLabel,statusBox,scheduleLabel,scheduleBox,submitButton,cancelButton);
     Scene scene = new Scene(pane);
     scene.getStylesheets().add("gui/style1.css");
     window.setScene(scene);
     window.showAndWait();
  }
  public String getDriving(int drivingID){
    String driving = "";
    if(drivingID == 1){ driving = "A" ;}
    else if(drivingID == 2){ driving = "AA" ;}
    else if(drivingID == 3){ driving = "B" ;}
    else if(drivingID == 4){ driving = "BB" ;}
    else if(drivingID == 5){ driving = "C" ;}
    else if(drivingID == 6){ driving = "CC" ;}
    else if(drivingID == 7){ driving = "CCC" ;}
    else if (drivingID == 8) { driving = "K";}
    return driving ;
  }
  public int getStatusID(String status){
    int id = 0;
    if(status.equals("100%")){ id = 1;}
    else if(status.equals("50%")){ id = 2;}
    else if(status.equals("Sjuk")){ id = 3;}
    else if(status.equals("VAB")){ id = 4;}
    else if(status.equals("Studier")){ id = 5;}
    else if(status.equals("Semester")){ id = 6;}
    return id ;
  }
  public int getScheduleID(String schedule){
    int id = 0;
    if(schedule.equals("MF")){ id = 1;}
    else if(schedule.equals("LS")){ id = 2;}
    else if(schedule.equals("S")){ id = 3;}
    return id;
  }
}
