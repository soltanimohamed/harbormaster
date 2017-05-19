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
  private Button searchButton;
  private Button okButton;
  private Button logginButton;
  private Menu fileMenu;
  private MenuItem addEmployee;
  private MenuItem deleteEmployee;
  private MenuItem addTruck;
  private MenuItem deleteTruck;
  private MenuItem modifyEmployee;
  private MenuItem modifyTruck;
  private MenuItem exitApplication;
  private MenuBar menu;
  private BorderPane mainPane;
  public static void main(String[] args) {
    launch(args);
  }
  public void start(Stage primaryStage) throws Exception{
    Storage storage = new DBStorage();
  primaryStage.setTitle("Harbor Master");
  mainPane = new BorderPane();
  logginButton = new Button("Sign in");
  mainPane.setRight(logginButton);
  okButton = new Button("ok");
  mainPane.setBottom(okButton);
  searchButton = new Button("search");
  mainPane.setLeft(searchButton);
  fileMenu = new Menu("File");
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
  fileMenu.getItems().add(exitApplication);
  menu = new MenuBar();
  menu.getMenus().addAll(fileMenu);
  mainPane.setTop(menu);
  Scene scene = new Scene(mainPane, 600,500);
  scene.getStylesheets().add("gui/style.css");
  primaryStage.setScene(scene);
  primaryStage.show();
}
}
