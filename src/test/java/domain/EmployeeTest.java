package domain;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmployeeTest {
	public static Employee em;
	@BeforeClass
	public static void start(){
		em = new Employee(1,"Alan","Shearer",1,1,1);
	}
	@Test
	public void testset_firstName() {
		String result = em.firstName();
		assertEquals("Alan", result);
	}
	@Test
	public void testset_lastName() {
		String result = em.lastName();
		assertEquals("Shearer", result);
	}
	@Test
	public void testset_driving_license() {
		int result = em.driving_license_ID();
		assertNotEquals(2, result);
	}
	@Test
	public void testset_status_ID() {
		int result = em.status_ID();
		assertEquals(1, result);
	}
	@Test
	public void testset_schedule_ID() {
		int result = em.schedule_ID();
		assertEquals(1, result);
	}
}
