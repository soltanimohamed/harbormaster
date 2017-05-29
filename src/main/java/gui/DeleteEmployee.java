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
public class DeleteEmployee{
  private Storage storage;
public DeleteEmployee(Storage storage){
  this.storage = storage;
  deleteEm();
}
public void deleteEm(){
  Stage window = new Stage();
  window.initModality(Modality.APPLICATION_MODAL);
  window.setTitle("Delete Employee");
  window.setMinWidth(200);
  Label label = new Label("Enter Employee's ID:");
  label.setId("alert-text");
  TextField idField = new TextField();
  Button okButton = new Button("ok");
  okButton.setOnAction( e ->{
    if(!(idField.getText().equals(""))){
      int id = Integer.parseInt(idField.getText());
      storage.deleteEmployee(id);
      Alerts.display("Succeeded"," Employee has been removed");
      window.close();
    }
  });
  Button noButton = new Button("cancel");
  noButton.setOnAction( e -> window.close());
  GridPane pane = new GridPane();
  pane.setVgap(10);
  pane.setHgap(10);
  pane.setPadding(new Insets(10,10,10,10));
  pane.setConstraints(label,0,0);
  pane.setConstraints(idField,1,0);
  pane.setConstraints(okButton,0,1);
  pane.setConstraints(noButton,1,1);
    pane.getChildren().addAll(label,idField,okButton,noButton);
  pane.setAlignment(Pos.CENTER);
  Scene scene = new Scene(pane);
  scene.getStylesheets().add("gui/style1.css");
  window.setScene(scene);
  window.showAndWait();
}
}
