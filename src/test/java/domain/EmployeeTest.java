package domain;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmployeeTest {
	public static Employee em;
	@BeforeClass
	public static void start(){
		em = new Employee(1,"jonas","lindberg",1,1,1);
	}
	@Test
	public void testset_firstName() {
		String result = em.firstName();
		assertEquals("jonas", result);
	}
}
