package domain;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class TimeFunctionsTest {
	public interface NotNull{}
	public interface Getters{}
	
	@Category(NotNull.class)
	@Test
	public void testTimeFunctionNotNull() throws Exception {
		TimeFunctions tf = new TimeFunctions(2017, 05, 17, "20:20");

		assertNotNull(tf);
	}
	@Category(Getters.class)
	@Test
	public void testGetTimeFunctions() throws Exception {
		TimeFunctions tf = new TimeFunctions(2017, 05, 17, "20:20");
		assertEquals(2017, tf.year());
		assertEquals(05, tf.month());
		assertEquals(17, tf.day());
		assertEquals("20:20", tf.clockTime());
	}
	@Test
	public void testlongMonths() {
		ArrayList<Integer> lm = new ArrayList<Integer>();
		lm.add(1);
		lm.add(3);
		lm.add(5);
		lm.add(7);
		lm.add(8);
		lm.add(10);
		lm.add(12);
		assertEquals(Arrays.asList(1,3,5,7,8,10,12), lm);
	}
	@Test
	public void testshortMonths() {
		ArrayList<Integer> sm = new ArrayList<Integer>();
		sm.add(4);
		sm.add(6);
		sm.add(9);
		sm.add(11);
		assertEquals(Arrays.asList(4,6,9,11), sm);
	}
	@Test
	public void testdaysOfWeek() {
		ArrayList<String> dow = new ArrayList<String>();
		dow.add("Monday");
		dow.add("Tuesday");
		dow.add("Wednesday");
		dow.add("Thursday");
		dow.add("Friday");
		dow.add("Saturday");
		dow.add("Sunday");
		assertEquals(Arrays.asList("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"), dow);
	}
	
	
}	
