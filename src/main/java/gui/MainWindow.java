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
import javafx.collections.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.Desktop;
import java.net.*;
import domain.*;
public class MainWindow extends Application{
  private TextField searchField;
  private Button searchButton;
  //private Button okButton;
  private Button logginButton;
  private Button loggoutButton;
  private Menu fileMenu;
  private MenuItem addEmployee;
  private MenuItem deleteEmployee;
  private MenuItem addTruck;
  private MenuItem deleteTruck;
  private MenuItem modifyEmployee;
  private MenuItem modifyTruck;
  private MenuItem addShip;
  private MenuItem modifyShip;
  private MenuItem deleteShip;
  private MenuItem exitApplication;
  private Menu listMenu;
  private MenuItem listEmployee;
  private MenuItem listTruck;
  private MenuItem listShip;
  private Menu quayMenu;
  private MenuItem listQuayShip;
  private MenuItem listQuayEmployees;
  private MenuItem listQuayTrucks;
  private MenuBar menu;
  private BorderPane mainPane;
  private GridPane pane2;
  private GridPane pane3;
  public static void main(String[] args) {
    launch(args);
  }
  public void start(Stage primaryStage) throws Exception{
    Storage storage = new DBStorage();
  primaryStage.setTitle("Harbor Master");
  mainPane = new BorderPane();
  pane2 = new GridPane();
  pane3 = new GridPane();
  logginButton = new Button("Sign in");
  logginButton.setOnAction( e ->{
    LogIn.userLogin(storage);
    if(storage.inlogg(LogIn.userField.getText(), LogIn.passField.getText()) != 0){
      loggoutButton.setDisable(false);
      logginButton.setDisable(true);
      fileMenu.setDisable(false);
      listMenu.setDisable(false);
      quayMenu.setDisable(false);
  }
  });
  loggoutButton = new Button("Sign out");
  loggoutButton.setDisable(true);
  loggoutButton.setOnAction( e ->{
    Alerts.display("Confirmation","you are now signed out");
    logginButton.setDisable(false);
    loggoutButton.setDisable(true);
     fileMenu.setDisable(true);
     listMenu.setDisable(true);
     quayMenu.setDisable(true);

  });
  pane2.setPadding(new Insets(10,10,10,10));
  pane2.setVgap(8);
  pane2.setHgap(10);
  pane2.setConstraints(logginButton,0,0);
  pane2.setConstraints(loggoutButton,0,1);
  pane2.getChildren().addAll(logginButton,loggoutButton);
  mainPane.setRight(pane2);
  pane3.setPadding(new Insets(10,10,10,10));
  pane3.setVgap(8);
  pane3.setHgap(10);
  searchField = new TextField();
  searchButton = new Button("search");
  mainPane.setLeft(pane3);
  pane3.setConstraints(searchField, 0, 0);
  pane3.setConstraints(searchButton, 0, 1);
  pane3.getChildren().addAll(searchField,searchButton);
  fileMenu = new Menu("File");
  fileMenu.setDisable(true);
  addEmployee = new MenuItem("Add new Employee...");
  addEmployee.setOnAction( e ->{
    new AddEmployee(storage);
  });
  modifyEmployee = new MenuItem("Modify Employee...");
  modifyEmployee.setOnAction( e ->{
    new ModifyEmployee(storage);
  });
  deleteEmployee = new MenuItem("Delete Employee...");
  deleteEmployee.setOnAction( e ->{
    new DeleteEmployee(storage);
  });
  addTruck = new MenuItem("Add new Truck...");
  addTruck.setOnAction( e ->{
    new AddTruck(storage);
  });
  modifyTruck = new MenuItem("Modify Truck...");
  modifyTruck.setOnAction( e ->{
    new ModifyTruck(storage);
  });
  deleteTruck = new MenuItem("Delete Truck");
  deleteTruck.setOnAction( e ->{
    new DeleteTruck(storage);
  });
  addShip = new MenuItem("Add New Ship");
  addShip.setOnAction( e ->{
    new AddShip(storage);
  });
  modifyShip = new MenuItem("Modify Ship");
  modifyShip.setOnAction( e ->{
    new ModifyShip(storage);
  });
  deleteShip = new MenuItem("Delete Ship");
  deleteShip.setOnAction( e ->{
    new DeleteShip(storage);
  });
  exitApplication = new MenuItem("Exit");
  exitApplication.setOnAction( e -> primaryStage.close());
  fileMenu.getItems().add(addEmployee);
  fileMenu.getItems().add(modifyEmployee);
  fileMenu.getItems().add(deleteEmployee);
  fileMenu.getItems().add(new SeparatorMenuItem());
  fileMenu.getItems().add(addTruck);
  fileMenu.getItems().add(modifyTruck);
  fileMenu.getItems().add(deleteTruck);
  fileMenu.getItems().add(new SeparatorMenuItem());
  fileMenu.getItems().add(addShip);
  fileMenu.getItems().add(modifyShip);
  fileMenu.getItems().add(deleteShip);
  fileMenu.getItems().add(new SeparatorMenuItem());
  fileMenu.getItems().add(exitApplication);
  listMenu = new Menu("list");
  listMenu.setDisable(true);
  listEmployee = new MenuItem("show all Employee...");
 listEmployee.setOnAction( e ->{
     new ListWindow(storage);
  });
  listTruck = new MenuItem("show all trucks...");
  listTruck.setOnAction( e ->{
    new ListTruck(storage);
  });
  listShip = new MenuItem("Show all ship ...");
  listShip.setOnAction( e ->{
    new ListShip(storage);
  });
  listMenu.getItems().add(listEmployee);
  listMenu.getItems().add(listTruck);
  listMenu.getItems().add(listShip);
  quayMenu = new Menu("Quay");
  quayMenu.setDisable(true);
  listQuayShip = new MenuItem("Show ships in quay");
  listQuayShip.setOnAction( e ->{
    new ListShipsInQuay(storage);
  });
  listQuayEmployees = new MenuItem("List Of Employees");
  listQuayTrucks = new MenuItem("List of Trucks");
  listQuayTrucks.setOnAction( e ->{
    new ListTrucksQuay(storage);
  });
  quayMenu.getItems().add(listQuayShip);
  quayMenu.getItems().add(listQuayEmployees);
  listQuayEmployees.setOnAction( e ->{
    new ListEmployeeQuay(storage);
  });
  quayMenu.getItems().add(listQuayTrucks);
  menu = new MenuBar();
  menu.getMenus().addAll(fileMenu);
  menu.getMenus().addAll(listMenu);
  menu.getMenus().addAll(quayMenu);
  mainPane.setTop(menu);
  Scene scene = new Scene(mainPane, 600,500);
  scene.getStylesheets().add("gui/style.css");
  primaryStage.setScene(scene);
  primaryStage.show();
}
}
