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
public class ListEmployeeQuay{
  private Storage storage;
public ListEmployeeQuay(Storage storage){
  this.storage = storage;
  listShips();
}
public void listShips(){
  Stage window = new Stage();
  window.initModality(Modality.APPLICATION_MODAL);
  window.setTitle("Quay");
  window.setMinWidth(200);
  Label labelid = new Label("Enter Quay ID:");
  labelid.setId("alert-text");
  TextField idField = new TextField();
  Label labelshift = new Label("choose a shift:");
  ComboBox shiftBox = new ComboBox();
  shiftBox.getItems().add("08:00-16:00");
  shiftBox.getItems().add("16:00-00:00");
  shiftBox.getItems().add("00:00-08:00");
  Button okButton = new Button("ok");
  okButton.setOnAction( e ->{
    if(!(idField.getText().equals("")) && shiftBox.getValue() != null){
        int id = Integer.parseInt(idField.getText());
        String shift = shiftBox.getValue().toString();
       new QuayEmployeeList(storage, id, shift);
      }
      else{Alerts.display("Alert","Please enter all information required");}
    window.close();
  });
  Button noButton = new Button("cancel");
  noButton.setOnAction( e -> window.close());
  GridPane pane = new GridPane();
  pane.setVgap(10);
  pane.setHgap(10);
  pane.setPadding(new Insets(10,10,10,10));
  pane.setConstraints(labelid,0,0);
  pane.setConstraints(idField,1,0);
  pane.setConstraints(labelshift,0,1);
  pane.setConstraints(shiftBox,1,1);
  pane.setConstraints(okButton,0,2);
  pane.setConstraints(noButton,1,2);
    pane.getChildren().addAll(labelid,idField,labelshift,shiftBox,okButton,noButton);
  pane.setAlignment(Pos.CENTER);
  Scene scene = new Scene(pane);
  scene.getStylesheets().add("gui/style1.css");
  window.setScene(scene);
  window.showAndWait();
}
}
