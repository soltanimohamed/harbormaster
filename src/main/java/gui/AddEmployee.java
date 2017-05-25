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
import domain.Storage;
import domain.DBStorage;
import domain.Employee;
import domain.Truck;
import javafx.stage.Modality;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
public class AddEmployee{
  private Storage storage;

  public AddEmployee(Storage storage){
    this.storage = storage;
    createAview();
  }
  public  void createAview(){
    Stage window = new Stage();
    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle("Employee");
    window.setMinWidth(250);
    Label  idLabel = new Label("Employee_ID:");
    TextField idField = new TextField();
    Label  firstNameLabel = new Label("First Name:");
    TextField firstNameField = new TextField();
    Label  lastNameLabel = new Label("Last Name:");
    TextField lastNameField = new TextField();
    Label sexLabel = new Label("Sex:");
    ComboBox sexBox = new ComboBox();
    sexBox.getItems().add("Male");
    sexBox.getItems().add("Female");
    Label driving_licenseLabel = new Label("driving_license_ID:");
    //TextField driving_licenseField = new TextField();
    ComboBox drivingBox = new ComboBox();
    drivingBox.getItems().add("A");
    drivingBox.getItems().add("AA");
    drivingBox.getItems().add("B");
    drivingBox.getItems().add("BB");
    drivingBox.getItems().add("C");
    drivingBox.getItems().add("CC");
    drivingBox.getItems().add("CCC");
    drivingBox.getItems().add("K");
    Label statusLabel = new Label("status_ID:");
    ComboBox statusBox = new ComboBox();
    statusBox.getItems().add("100%");
    statusBox.getItems().add("50%");
    statusBox.getItems().add("Sjuk");
    statusBox.getItems().add("VAB");
    statusBox.getItems().add("Studier");
    statusBox.getItems().add("Semester");
    //TextField statusField = new TextField();
    Label scheduleLabel = new Label("schedule_ID:");
    ComboBox scheduleBox = new ComboBox();
    scheduleBox.getItems().add("MF");
    scheduleBox.getItems().add("LS");
    scheduleBox.getItems().add("S");
    //TextField scheduleField = new TextField();
    Button submitButton = new Button("ok");
    //  sexBox.getValue().toString(),
    submitButton.setOnAction( e ->{
      if(idField.equals("")  || firstNameField.getText().equals("") || lastNameField.getText().equals("") || sexBox.getValue() == null
       || drivingBox.getValue() == null || statusBox.getValue() == null || scheduleBox.getValue() == null){
    Alerts.display("Alert","Please enter all information required");  }
     else{
       try{

        /* String driving = drivingBox.getValue().toString();
         String status = statusBox.getValue().toString();
         String schedule = scheduleBox.getValue().toString(); */
         String sex = sexBox.getValue().toString();
         int drivingID = getDrivingID(drivingBox.getValue().toString());
         int statusID = getStatusID(statusBox.getValue().toString());
         int scheduleID = getScheduleID(scheduleBox.getValue().toString());
        Employee em = new Employee(Integer.parseInt(idField.getText()), firstNameField.getText(), lastNameField.getText(), sex,
      drivingID, statusID, scheduleID);
       System.out.println(em);
      storage.addEmployee(em);
    Alerts.display("Succeeded","Congratulation the employee has been added");
    window.close();}  catch(Exception ex){
      Alerts.display("Wrong" ,"date format incorrect");
    }}
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
  public int getDrivingID(String driving){
    int id = 0;
    if(driving.equals("A")){ id = 1 ;}
    else if(driving.equals("AA")){ id = 2 ;}
    else if(driving.equals("B")){ id = 3 ;}
    else if(driving.equals("BB")){ id = 4 ;}
    else if(driving.equals("C")){ id = 5 ;}
    else if(driving.equals("CC")){ id = 6 ;}
    else if(driving.equals("CCC")){ id = 7 ;}
    else if (driving.equals("K")) { id = 8;}
    return id ;
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
