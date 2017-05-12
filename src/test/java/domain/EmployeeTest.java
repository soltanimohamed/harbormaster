package domain;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;
public class EmployeeTest {
	public interface NotNull{}
	public interface Getters{}
  public interface Setters{}
	public interface Stringers{}

	@Category(NotNull.class)
	@Test
	public void testEmployeeNotNull() {
		Employee em = new Employee(1,"jonas","lindberg",1,1,1);

		assertNotNull(em);
	}
	@Category(Getters.class)
	@Test
	public void testGetEmployee() {
		Employee em = new Employee(1,"jonas","lindberg",1,1,1);
		assertEquals(1, em.employee_id());
		assertEquals("jonas", em.firstName());
		assertEquals("lindberg", em.lastName());
		assertEquals(1, em.driving_license_ID());
		assertEquals(1, em.status_ID());
		assertEquals(1, em.schedule_ID());
	}
	@Category(Setters.class)
	@Test
	public void testSetEmployee(){
		Employee e = new Employee(2,null,null,0,0,0);
		e.set_firstName("Jonathan");
		assertEquals("Jonathan", e.firstName());
		e.set_lastName("pieer");
		assertEquals("pieer", e.lastName());
		e.set_driving_license_ID(2);
		assertEquals(2, e.driving_license_ID());
		e.set_status_ID(1);
		assertEquals(1, e.status_ID());
		e.set_schedule_ID(1);
		assertEquals(1, e.schedule_ID());
	}
	@Category(Stringers.class)
	@Test
	public void  testToString(){
		Employee e = new Employee(2,"mohamed","soltani",2,3,2);
    String result = "2,mohamed,soltani,2,3,2";
		assertEquals(result, e.toString());
	}
	@Test
	public void testEqualsTrue(){
		Employee e = new Employee(3,"naser","saleh",3,2,1);
		Employee e1 = new Employee(3,"naser","saleh",3,2,1);
	assertTrue(e.equals(e1));
}
@RunWith(Categories.class)
@IncludeCategory(NotNull.class)
@SuiteClasses({
	EmployeeTest.class
})
public static class NotNullSuite{}
@RunWith(Categories.class)
	@IncludeCategory(Getters.class)
	@SuiteClasses({
		EmployeeTest.class
	})
	public static class GettersSuite{}
    @RunWith(Categories.class)
	  @IncludeCategory(Setters.class)
	  @SuiteClasses({
	  	EmployeeTest.class
	  })
	  public static class SettersSuite{}

			@RunWith(Categories.class)
			@IncludeCategory(Stringers.class)
			@SuiteClasses({
				EmployeeTest.class
			})
			public static class StringersSuite{}
}
