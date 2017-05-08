package domain;

public class Truck{

  private int truck_ID;
  private String truck_type;
  private String truck_status;
  private int truck_cost;

  public Truck(int truck_ID, String truck_type, String truck_status, String truck_cost){
    this.truck_ID = truck_ID;
    this.truck_type = truck_type; //"A001" "AA01" "B001" "BB01" "C001" "CC01" "CCC1" "K001"
    this.truck_status = truck_status; //"Ok" "Reparation" "Reserv" "Skada"
    this.truck_cost = truck_cost; //1000 1500 2000 2500 3000 3500 4000 6000
  }

  public int truck_ID(){ return truck_ID; }
  public String truck_type(){ return truck_type; }
  public String truck_status(){ return truck_status; }
  public int truck_cost(){ return truck_cost;}

  public void setTruckType(String truck_type){ this.truck_type = truck_type; }
  public void setTruckStatus(String truck_status){ this.truck_status = truck_status; }
  public void setTruckCost(int truck_cost){ this.truck_cost = truck_cost; }

  @Override
  public String toString(){
    return "TruckID: " + truck_ID + "\n" + "Truck Type: " + truck_type + "\n" +
            "Truck Status: " + truck_status + "\n" + "Truck Cost: " + truck_cost;
  }

  @Override
  public boolean equals(Object o){
    if (o instanceof Truck) {
      if (o.truck_ID() == this.truck_ID) {
            return true;
      }
    }
      return false;
  }
}
