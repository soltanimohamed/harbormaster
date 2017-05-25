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
public class AddTruck{
  private Storage storage;

  public AddTruck(Storage storage){
    this.storage = storage;
    createAview();
  }
  public  void createAview(){
    Stage window = new Stage();
    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle("Truck");
    window.setMinWidth(250);
    Label  idLabel = new Label("Truck_ID:");
    TextField idField = new TextField();
    Label  typeLabel = new Label("Truck Type:");
    ComboBox typeBox = new ComboBox();
    typeBox.getItems().add("A001");
    typeBox.getItems().add("AA01");
    typeBox.getItems().add("B001");
    typeBox.getItems().add("BB01");
    typeBox.getItems().add("C001");
    typeBox.getItems().add("CC01");
    typeBox.getItems().add("CCC1");
    typeBox.getItems().add("K001");
    Label  statusLabel = new Label("Truck Status:");
    ComboBox statusBox = new ComboBox();
    statusBox.getItems().add("Ok");
    statusBox.getItems().add("Reparation");
    statusBox.getItems().add("Reserv");
    statusBox.getItems().add("Skada");
    Button submitButton = new Button("ok");
    submitButton.setOnAction( e ->{
      if(idField.equals("")  ||  typeBox.getValue() == null|| statusBox.getValue() == null){
    Alerts.display("Alert","Please enter all information required");  }
     else{
       try{
         String type = typeBox.getValue().toString();
         String status = statusBox.getValue().toString();
        //String costString = (costBox.getValue()).toString();
        //int cost = Integer.parseInt(costString);
         int cost = 0;
          if(type.equals("A001")){cost = 1000;}
          else if(type.equals("AA01")){cost = 1500;}
          else if(type.equals("B001")){cost = 2000;}
          else if(type.equals("BB01")){cost = 2500;}
          else if(type.equals("C001")){cost = 3000;}
          else if(type.equals("CC01")){cost = 3500;}
          else if(type.equals("CCC1")){cost = 4000;}
          else {cost = 6000;}
        Truck tr = new Truck(Integer.parseInt(idField.getText()), type, status, cost);
       System.out.println(tr);
      storage.addTruck(tr);
    Alerts.display("Succeeded","Congratulation the truck has been added");
    window.close();}  catch(Exception ex){
      Alerts.display("Wrong" ,"Something went wrong");
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
    pane.setConstraints(typeLabel,0,1);
    pane.setConstraints(typeBox,1,1);
    pane.setConstraints(statusLabel,0,2);
    pane.setConstraints(statusBox,1,2);
    pane.setConstraints(submitButton,0,3);
    pane.setConstraints(cancelButton,1,3);

    pane.getChildren().addAll(idLabel,idField,typeLabel,typeBox,statusLabel,statusBox,
    submitButton,cancelButton);
     Scene scene = new Scene(pane);
     scene.getStylesheets().add("gui/style1.css");
     window.setScene(scene);
     window.showAndWait();
}
}
