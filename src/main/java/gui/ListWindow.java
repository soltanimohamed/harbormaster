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
import java.util.List;
import java.util.ArrayList;
public class ListWindow{
  private ListView<String> list;
  private BorderPane mainPane;
  private Storage storage;
  private GridPane pane1;
  private Button clearButton;
  private Button addButton;
  public ListWindow(Storage storage){
    this.storage = storage;
    createAview();
  }
  public void createAview(){
    Stage window = new Stage();
    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle("List");
    window.setMinWidth(400);
    list = new ListView<>();
    List<Employee> allEmployee = storage.showAllEmployee();
      List<String> employee = new ArrayList<>();
      int i = 1;
      for(Employee e : allEmployee){
        employee.add(e.toString());
        i++;
      }
      list.getItems().clear();
      for(String s : employee){
        list.getItems().add(s);
      }
      addButton = new Button("Add Employee");
      clearButton = new Button("Clear result");
      clearButton.setOnAction( e ->list.getItems().clear());
      pane1 = new GridPane();
      pane1.setVgap(10);
      pane1.setHgap(10);
      pane1.setPadding(new Insets(10,10,10,250));
      pane1.setConstraints(addButton,0,0);
      pane1.setConstraints(clearButton,1,0);
      pane1.getChildren().addAll(addButton,clearButton);
  mainPane = new BorderPane();
  mainPane.setCenter(list);
  mainPane.setBottom(pane1);
  Scene scene = new Scene(mainPane);
  scene.getStylesheets().add("gui/style1.css");
  window.setScene(scene);
  window.showAndWait();
}
public void getAllEmployee(){

}
}
