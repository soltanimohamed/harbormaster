package domain;

import java.util.ArrayList;

public class Quay {

	private int id;
	private String name;
	private ArrayList<String> available_volumes; //Möjliga fartygsvolymer; "A005" "AA07" "B005" "BB07" "C005" "CC07" "CCC5" "K007"
	private ArrayList<QuayShift> shifts; //Möjliga skiftens timmar; "0:00-8:00" "8:00-16:00" "16:00-00:00"
	private QuayShift current_shift; //Det aktiva skiftet

	public Quay(int id) throws Exception{
		this.id = id; //ID-numret
		this.name = "KAJ " + id + "01"; //Namnet baseras på ID-numret, så t.ex. id 1 blir "KAJ 101"
		this.current_shift = null; //Aktivt shift måste tillsättas senare
		this.available_volumes = new ArrayList<String>(); //
		if(id == 3){ //De tre största volymerna
			available_volumes.add("CC07");
			available_volumes.add("CCC5");
			available_volumes.add("K007");
		}
		else if (id == 2){ //De tre volymerna i mitten
			available_volumes.add("B005");
			available_volumes.add("BB07");
			available_volumes.add("C005");
		}
		else if (id == 1){ //De två minsta volymerna
			available_volumes.add("A005");
			available_volumes.add("AA07");
		}
		else{ //Avbryter om kajen har ett ID som är mindre än 1 eller mer än 3
			throw new Exception("Quay has invalid ID number; must be 1, 2 or 3");
		}

		this.shifts = new ArrayList<QuayShift>(); //Tre möjliga skift skapas och läggs till
		QuayShift morning = new QuayShift(1, "0:00-8:00");
		QuayShift day = new QuayShift(2, "8:00-16:00");
		QuayShift night = new QuayShift(3, "16:00-00:00");
		shifts.add(morning);
		shifts.add(day);
		shifts.add(night);
		this.current_shift = null;
	}

	public int id(){ return id; }
	public String name(){ return name; }
	public ArrayList<String> available_volumes(){ return available_volumes; }

	public void chooseShift(String shift_hours) throws Exception{
		if(shifts.contains(shift_hours)){ //Kollar att skiften innehåller ett med den angivna shifttids-stringen
			for(int i = 0; i<3; i++){
				if(shifts.get(i).shift_hours().equals(shift_hours)){
					this.current_shift = shifts.get(i);
				}
			}
		}
		else throw new Exception("Problem assigning shift to quay " + name);
	}

	public void assignQuayShift(QuayShift qs){
		this.current_shift = qs;
	}

	public void assignEmployee(Employee new_employee){
		boolean validDrivingLicense = false;
		if((this.id()==1 && new_employee.driving_license_ID() == 1) || (this.id() == 1 && new_employee.driving_license_ID() == 2)
				|| (this.id()==2 && new_employee.driving_license_ID()==3) ||(this.id()==2 && new_employee.driving_license_ID()==4)
				|| (this.id()==2 && new_employee.driving_license_ID()==5) ||(this.id()==3 && new_employee.driving_license_ID() == 6
				|| (this.id()==3 && new_employee.driving_license_ID()==7)) || (this.id()==3 && new_employee.driving_license_ID()==8)){
			validDrivingLicense = true;
		}
		if(validDrivingLicense){
			this.current_shift.assignEmployee(new_employee);
		}
	}

	public void assignShip(Ship new_ship) throws Exception{
		if(available_volumes.contains(new_ship.volume_type())){
			current_shift.assignShip(new_ship);
		}
		else throw new Exception("Problem assigning ship to quay" + name);
	}

}
