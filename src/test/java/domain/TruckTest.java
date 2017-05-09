import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

public class TruckTest {
	Truck getterTruck;
	Truck setterTruck;
	
	public interface GetterTests{
		
	}
	
	public interface SetterTests{
		
	}
	
	public interface FunctionTests{
		
	}
	
	@Before
	public void createTruck(){
		getterTruck = new Truck(5, "A001", "Reserv", 1000);
		setterTruck = new Truck(1, null, null, 1);
	}
	
	@Category(GetterTests.class)
	@Test
	public void getTruckIdNotNull() {
		assertNotNull(getterTruck.truck_ID());
	}
	
	@Category(GetterTests.class)
	@Test
	public void getTruckIdCorrectValue(){
		assertEquals(getterTruck.truck_ID(), 5);
	}
	
	@Category(GetterTests.class)
	@Test
	public void getTruckTypeNotNull(){
		assertNotNull(getterTruck.truck_type());
	}
	
	@Category(GetterTests.class)
	@Test
	public void getTruckTypeCorrectValue(){
		assertEquals(getterTruck.truck_type(), "A001");
	}
	
	@Category(GetterTests.class)
	@Test
	public void getTruckStatusNotNull(){
		assertNotNull(getterTruck.truck_status());
	}
	
	@Category(GetterTests.class)
	@Test
	public void getTruckStatusCorrectValue(){
		assertEquals(getterTruck.truck_status(), "Reserv");
	}
	
	@Category(GetterTests.class)
	@Test
	public void getTruckCostNotNull(){
		assertNotNull(getterTruck.truck_cost());
	}
	
	@Category(GetterTests.class)
	@Test
	public void getTruckCostCorrectValue(){
		assertEquals(getterTruck.truck_cost(), 1000);
	}
	
	@Category(SetterTests.class)
	@Test
	public void setTruckType(){
		setterTruck.setTruckType("CCC1");
		
		assertEquals(setterTruck.truck_type(), "CCC1");
	}
	
	@Category(SetterTests.class)
	@Test
	public void setTruckCost(){
		setterTruck.setTruckCost(2500);
		
		assertEquals(setterTruck.truck_cost(), 2500);
	}
	
	@Category(SetterTests.class)
	@Test
	public void setTruckStatus(){
		setterTruck.setTruckStatus("Ok");
		
		assertEquals(setterTruck.truck_status(), "Ok");
	}
	
	@Category(FunctionTests.class)
	@Test
	public void testToString(){
		String string_of_getterTruck = "TruckID: " + 5 + "\n" + "Truck Type: " +
		"A001" + "\n" + "Truck Status: " + "Reserv" + "\n" +
		"Truck Cost: " + 1000;
		
		assertEquals(getterTruck.toString(), string_of_getterTruck);
	}
	
	@Category(FunctionTests.class)
	@Test
	public void testEqualsTrue(){
		Truck testTruck = new Truck(5, "B001", "Reparation", 1000);
		
		assertTrue(testTruck.equals(getterTruck));
	}
	
	@Category(FunctionTests.class)
	@Test
	public void testEqualsFalse(){
		Truck testTruck = new Truck(10, "CC01", "Ok", 6000);
		
		assertFalse(testTruck.equals(getterTruck));
	}
	
	@RunWith(Categories.class)
	@IncludeCategory(GetterTests.class)
	@SuiteClasses({
		TruckTest.class
	})
	public static class TestGetters{
		
	}
	
	@RunWith(Categories.class)
	@IncludeCategory(SetterTests.class)
	@SuiteClasses({
		TruckTest.class
	})
	public static class TestSetters{
		
	}
	
	@RunWith(Categories.class)
	@IncludeCategory(FunctionTests.class)
	@SuiteClasses({
		TruckTest.class
	})
	public static class TestFunctions{
		
	}
}
