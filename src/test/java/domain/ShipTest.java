package domain;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import domain.EmployeeTest.Setters;

public class ShipTest {
	public interface NotNull{}
	public interface Getters{}
	public interface Setters{}
	
		
	@Category(NotNull.class)
	@Test
	public void testShipNotNull() {
		Ship a = new Ship(1,"Ocean","Trade","A005");
		
		assertNotNull(a);
	}
	
	@Category(Getters.class)
	@Test
	public void testGetShip() {
		Ship a = new Ship(1,"Ocean","Trade","A005");
		assertEquals(1,a.id());
		
	}
	public static Ship a;
	@BeforeClass
	public static void start(){
		a = new Ship(1,"Aida","Volvo","A005");
	}
	@Category(Setters.class)
	@Test
	public void testSetShip(){
		Ship b = new Ship(2,null,null,null);
		b.changeName("Lea");
		assertEquals("Lea", b.name());
		b.changeCompany("Saab");
		assertEquals("Saab", b.company());
		
	}
	@Test
	public void testset_name() {
		String result = a.name();
		assertEquals("Aida", result);
	}
	@Test
	public void testset_company() {
		String result = a.company();
		assertEquals("Volvo", result);
	}
}	

