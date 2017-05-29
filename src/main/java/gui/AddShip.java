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
public class AddShip{
  private Storage storage;

  public AddShip(Storage storage){
    this.storage = storage;
    createAview();
  }
  public  void createAview(){
    Stage window = new Stage();
    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle("Ship");
    window.setMinWidth(250);
    Label  idLabel = new Label("Ship_ID:");
    TextField idField = new TextField();
    Label  nameLabel = new Label("Name:");
    TextField nameField = new TextField();
    Label  companyLabel = new Label("Company:");
    TextField companyField = new TextField();
    Label volymeLabel = new Label("Volume:");
    ComboBox volumeBox = new ComboBox();
    volumeBox.getItems().add("A005");
    volumeBox.getItems().add("AA07");
    volumeBox.getItems().add("B005");
    volumeBox.getItems().add("BB07");
    volumeBox.getItems().add("C005");
    volumeBox.getItems().add("CC07");
    volumeBox.getItems().add("CCC5");
    volumeBox.getItems().add("K007");
    Button submitButton = new Button("ok");
    //  sexBox.getValue().toString(),
    submitButton.setOnAction( e ->{
      if(idField.equals("")  || nameField.getText().equals("") || companyField.getText().equals("")
      || volumeBox.getValue() == null){
    Alerts.display("Alert","Please enter all information required");  }
     else{
       try{
         String volume = volumeBox.getValue().toString();
         int id = Integer.parseInt(idField.getText());
         Ship sh = new Ship(id, nameField.getText(), companyField.getText(), volume);
       System.out.println(sh);
      storage.addShip(sh);
    Alerts.display("Succeeded","Congratulation the ship has been added");
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
    pane.setConstraints(nameLabel,0,1);
    pane.setConstraints(nameField,1,1);
    pane.setConstraints(companyLabel,0,2);
    pane.setConstraints(companyField,1,2);
    pane.setConstraints(volymeLabel,0,3);
    pane.setConstraints(volumeBox,1,3);
    pane.setConstraints(submitButton,0,4);
    pane.setConstraints(cancelButton,1,4);

    pane.getChildren().addAll(idLabel,idField,nameLabel,
     nameField,companyLabel,companyField,volymeLabel,volumeBox,submitButton,cancelButton);
     Scene scene = new Scene(pane);
     scene.getStylesheets().add("gui/style1.css");
     window.setScene(scene);
     window.showAndWait();
  }
}
