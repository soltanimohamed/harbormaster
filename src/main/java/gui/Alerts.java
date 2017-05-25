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
public class Alerts{
  public static void display(String title, String message){
    Stage window = new Stage();
    window.initModality(Modality.APPLICATION_MODAL);
    window.setTitle(title);
    window.setMinWidth(300);
    Label label = new Label(message);
    label.setId("alert-text");
    Button button = new Button("ok");
    button.setOnAction( e -> window.close());
    VBox pane = new VBox(10);
    pane.getChildren().addAll(label,button);
    pane.setAlignment(Pos.CENTER);
    Scene scene = new Scene(pane);
    scene.getStylesheets().add("gui/style1.css");
    window.setScene(scene);
    window.showAndWait();
  }
/*  public static void openWebpage(URI uri) {
    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
        try {
            desktop.browse(uri);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
  } */

/*  public static void openWebpage(URL url) {
    try {
        openWebpage(url.toURI());
    } catch (URISyntaxException e) {
        e.printStackTrace();
    }
  } */
}
