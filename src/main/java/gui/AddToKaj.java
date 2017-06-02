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
public class AddToKaj{
  private Storage storage;
  private Truck tr;
  public AddToKaj(Storage storage){
    this.storage = storage;
    createAview();
  }
  public  void createAview(){
    Stage window = new Stage();
    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle("Add to Quay");
    window.setMinWidth(250);
    Label  shiftLabel = new Label("choose Shift:");
    ComboBox shiftBox = new ComboBox();
    shiftBox.getItems().add("Day 08-16");
    shiftBox.getItems().add("Evening 16-00");
    shiftBox.getItems().add("Night 00-08");
    Label  datumLabel = new Label("date:");
    TextField datumField = new TextField();

    Button submitButton = new Button("ok");
  /*   submitButton.setOnAction( e ->{
     if(shiftBox.getValue() == null || idField.equals("") ){
    Alerts.display("Alert","Please enter shift and date");
     }
       try{
         String shift = shiftBox.getValue().toString();
      storage.modifyTruck(tr.truck_ID(), status);
    Alerts.display("Succeeded","truck's status has been modified");
    window.close();
    }
    catch(Exception ex){
      Alerts.display("Wrong" ,"Something went wrong");
    }
  }); */
    Button cancelButton = new Button("cancel");
    cancelButton.setOnAction( e ->{
      window.close();
    });
    GridPane pane = new GridPane();
    pane.setPadding(new Insets(5,5,5,5));
    pane.setVgap(8);
    pane.setHgap(10);
    pane.setConstraints(shiftLabel,0,0);
    pane.setConstraints(shiftBox,1,0);
    pane.setConstraints(datumLabel,0,1);
    pane.setConstraints(datumField,1,1);
    pane.setConstraints(submitButton,0,2);
    pane.setConstraints(cancelButton,1,2);

    pane.getChildren().addAll(shiftLabel,shiftBox,datumLabel,datumField,submitButton,cancelButton);
     Scene scene = new Scene(pane);
     scene.getStylesheets().add("gui/style1.css");
     window.setScene(scene);
     window.showAndWait();
  }
}
