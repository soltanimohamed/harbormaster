package domain;

public class Ship {
	
	private int id;
	private String name;
	private String company;
	private String volume_type; //"A005" "AA07" "B005" "BB07" "C005" "CC07" "CCC5" "K007"
	
	public Ship(int id, String name, String company, String volume_type){
		this.id = id;
		this.name = name;
		this.company = company;
		this.volume_type = volume_type;
	}
	
	public int id(){ return id; }
	public String name() { return name; }
	public String company() { return company; }
	public String volume_type() { return volume_type; }
	
	public void changeName(String new_name) { this.name = new_name; }
	public void changeCompany(String new_company) { this.company = new_company; }

}
