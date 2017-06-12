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
public class AddShipToQuay{
  private Storage storage;
 private Ship ship;
 private String shiftH;
 private String date;
 private int shiftQuayId = 0;
 private String shipName;
  public AddShipToQuay(Ship ship, Storage storage ,String shiftH, String date){
    this.storage = storage;
    this.ship = ship;
    this.shiftH = shiftH;
    this.date = date;
    createAview();
  }
  public  void createAview(){
    int shiftHour = 0;
    int quayId = 0;
    int shipId = ship.id();
  if(shiftH.equals("08-16")){shiftQuayId = 1;}
  else if(shiftH.equals("16-00")){shiftQuayId = 2;}
  else if(shiftH.equals("00-08")){shiftQuayId = 3;} 
  shipName = ship.name();
  if(ship.volume_type().equals("A005") || ship.volume_type().equals("AA07")){ quayId = 1;}
  else if(ship.volume_type().equals("B005") || ship.volume_type().equals("BB07") || ship.volume_type().equals("C005")){ quayId = 2;}
  else { quayId = 3;}
  storage.addShipToQuayShift(shiftQuayId , shipId, shipName, shiftH, date, quayId);
  }
}
