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
public class TruckModifying{
  private Storage storage;
  private Truck tr;
  public TruckModifying(Storage storage, Truck tr){
    this.storage = storage;
    this.tr = tr;
    createAview();
  }
  public  void createAview(){
    Stage window = new Stage();
    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle("Modify Truck's Status'");
    window.setMinWidth(250);
    String truck_id  = Integer.toString(tr.truck_ID());
    System.out.print(truck_id);
    Label  idLabel = new Label("Truck_ID:");
    TextField idField = new TextField();
    idField.setPromptText(truck_id);
    idField.setDisable(true);
    Label  statusLabel = new Label("Truck Status:");
    ComboBox statusBox = new ComboBox();
    statusBox.getItems().add("Ok");
    statusBox.getItems().add("Reparation");
    statusBox.getItems().add("Reserv");
    statusBox.getItems().add("Skada");
    Button submitButton = new Button("ok");
     submitButton.setOnAction( e ->{
     if(statusBox.getValue() == null){
    Alerts.display("Alert","Please choose a value from status");
     }
       try{
         String status = statusBox.getValue().toString();
      storage.modifyTruck(tr.truck_ID(), status);
    Alerts.display("Succeeded","truck's status has been modified");
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
    pane.setConstraints(statusLabel,0,1);
    pane.setConstraints(statusBox,1,1);
    pane.setConstraints(submitButton,0,2);
    pane.setConstraints(cancelButton,1,2);

    pane.getChildren().addAll(idLabel,idField,statusLabel,statusBox,submitButton,cancelButton);
     Scene scene = new Scene(pane);
     scene.getStylesheets().add("gui/style1.css");
     window.setScene(scene);
     window.showAndWait();
  }
}
