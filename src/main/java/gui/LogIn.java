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
public class LogIn{
  public static TextField userField;
  public static PasswordField passField;
  public static Button loginButton;
  public static Button cancelButton;
  public static void userLogin(Storage storage){
    Stage window = new Stage();
    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle("Login");
    window.setMinWidth(250);
    Label userLabel = new Label("Username:");
    Label passLabel = new Label("Password:");
    userField = new TextField();
    passField = new PasswordField();
    loginButton = new Button("Login");
    loginButton.setOnAction( e ->{
      if((userField.getText().equals("")) || (passField.getText().equals(""))){
        Alerts.display("Alert","Please enter username and password");}
        else{
        storage.inlogg(userField.getText(), passField.getText());
        if(storage.inlogg(userField.getText(), passField.getText()) != 0){
        window.close();
      }
          else{
            Alerts.display("Failed","Sorry the username and/or password incorrect");
            }
    }
  });
    cancelButton = new Button("Cancel");
    cancelButton.setOnAction( e -> window.close());
    GridPane pane = new GridPane();
    pane.setPadding(new Insets(5,5,5,5));
    pane.setVgap(8);
    pane.setHgap(10);
    pane.setConstraints(userLabel,0,0);
    pane.setConstraints(userField,1,0);
    pane.setConstraints(passLabel,0,1);
    pane.setConstraints(passField,1,1);
    pane.setConstraints(loginButton,0,2);
    pane.setConstraints(cancelButton,1,2);
    pane.getChildren().addAll(userLabel,userField,passLabel,
     passField,loginButton,cancelButton);
     Scene scene = new Scene(pane);
     scene.getStylesheets().add("gui/style.css");
     window.setScene(scene);
     window.showAndWait();
  }
}
