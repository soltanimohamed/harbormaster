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
public class ShipModifier{
  private Storage storage;
  private Ship sh;
  public ShipModifier(Storage storage, Ship sh){
    this.storage = storage;
    this.sh = sh;
    createAview();
  }
  public  void createAview(){
    Stage window = new Stage();
    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle("Modify Ship Info'");
    window.setMinWidth(250);
    String ship_id  = Integer.toString(sh.id());
    System.out.print(ship_id);
    Label  idLabel = new Label("Ship_ID:");
    TextField idField = new TextField();
    idField.setPromptText(ship_id);
    idField.setDisable(true);
    Label  nameLabel = new Label("Ship Name:");
    TextField nameField = new TextField();
    Label  companyLabel = new Label("Company Name:");
    TextField companyField = new TextField();
    Button submitButton = new Button("ok");
     submitButton.setOnAction( e ->{
     if(nameField.getText().equals("") || companyField.getText().equals("")){
    Alerts.display("Alert","Please enter all the information required");
     }
       try{
      storage.modifyShip(sh.id(), nameField.getText(), companyField.getText());
    Alerts.display("Succeeded"," Ship information changed");
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
    pane.setConstraints(nameLabel,0,1);
    pane.setConstraints(nameField,1,1);
    pane.setConstraints(companyLabel,0,2);
    pane.setConstraints(companyField,1,2);
    pane.setConstraints(submitButton,0,3);
    pane.setConstraints(cancelButton,1,3);

    pane.getChildren().addAll(idLabel,idField,nameLabel,nameField,companyLabel,companyField,submitButton,cancelButton);
     Scene scene = new Scene(pane);
     scene.getStylesheets().add("gui/style1.css");
     window.setScene(scene);
     window.showAndWait();
  }
}
