package com.revature;

import com.revature.model.Customer;
import org.junit.*;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerTest {
    @BeforeClass
    public static void BeforeClassTest() throws Exception {
        System.out.println("This will test before anything else");
    }

    @AfterClass
    public static void AfterClassTest() throws Exception {
        System.out.println("This will test after ");
    }
    @Before
    public void setup() throws Exception{
   /* we can use MockitoAnnotations.openMocks() to essentially allow mocking in our test class.
   So we need to import the Mockito reference from maven repository online and
   past inside dependency*/

        System.out.println("this test before every test method");
        MockitoAnnotations.openMocks(this);
    }
    @After
    public void tearDown() throws Exception{
        System.out.println("This runs after every test");
    }

    /*---------------------------------------------------------------*/
    // we use @Test annotation to mark test at JUnit

    @Test
    public void getFirstName() {
        Customer cmr = new Customer("solomon", "kahsai", 34, "Dayton,Ohio");
        assertEquals("solomon", cmr.getFirstName());
    }
    @Test
    public void getLastName() {
        Customer cmr = new Customer("solomon", "kahsai", 34, "Dayton,Ohio");
        assertEquals("kahsai", cmr.getLastName());
    }
    @Test
    public void getAge() {
        Customer cmr = new Customer("solomon", "kahsai", 34, "Dayton,Ohio");
        assertEquals( 34, cmr.getAge());
    }
    @Test
    public void getAddress() {
        Customer cmr = new Customer("solomon", "kahsai", 34, "Dayton,Ohio");
        assertEquals( "Dayton,Ohio", cmr.getAddress());
    }
    @Test
    public void setAddress() {
        Customer cmr = new Customer("solomon", "kahsai", 34, "Dayton,Ohio");
        cmr.setAddress("Dayton,Ohio");
        assertEquals( "Dayton,Ohio", cmr.getAddress());
    }
    @Test
    public void setAge() {

        Customer cmr = new Customer("solomon", "kahsai", 34, "Dayton,Ohio");
        cmr.setAge(34);
        assertEquals( 34, cmr.getAge());
    }
    @Test
    public void setFirstName() {
        Customer cmr = new Customer("solomon", "kahsai", 34, "Dayton,Ohio");
        cmr.setFirstName("solomon");
        assertEquals( "solomon", cmr.getFirstName());
    }
    // we can use @Ignore if we want to ignore any test  for some reason,
    // then it will ignore that specified test
    @Ignore
    @Test
    public void setLastName() {
        Customer cmr = new Customer("solomon", "kahsai", 34, "Dayton,Ohio");
        cmr.setLastName("kahsai");
        assertEquals( "kahsai", cmr.getLastName());
    }
}
