package com.revature.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
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



    @Test
    void getFirstname() throws Exception{
        Customer cmr =new Customer("solomon","kahsai","solomeda","password",11122333,5678,new Customer("solomon", "kahsai", "solomeda", "password", 11122333, 5678, new Customer()));
        assertEquals("solomon",cmr.getFirstname());
    }

    @Test
    void setFirstname() throws Exception{
        Customer cmr =new Customer("solomon","kahsai","solomeda","password",11122333,5678,new Customer("solomon", "kahsai", "solomeda", "password", 11122333, 5678, new Customer()));
        cmr.setFirstname("solomon");
        assertEquals("solomon",cmr.getFirstname());
    }

    @Test
    void getLastname() throws Exception{
        Customer cmr =new Customer("solomon","kahsai","solomeda","password",11122333,5678,new Customer("solomon", "kahsai", "solomeda", "password", 11122333, 5678, new Customer()));
        assertEquals("kahsai",cmr.getFirstname());

    }

    @Test
    void setLastname() throws Exception{
        Customer cmr =new Customer("solomon","kahsai","solomeda","password",11122333,5678,new Customer("solomon", "kahsai", "solomeda", "password", 11122333, 5678, new Customer()));
    cmr.setLastname("kahsai");
    assertEquals("kahsai",cmr.getLastname());

    }

    @Test
    void getUsername() throws Exception{
        Customer cmr =new Customer("solomon","kahsai","solomeda","password",11122333,5678,new Customer("solomon", "kahsai", "solomeda", "password", 11122333, 5678, new Customer()));
    assertEquals("solomeda",cmr.getUsername());

    }

    @Test
    void setUsername()throws Exception {
        Customer cmr =new Customer("solomon","kahsai","solomeda","password",11122333,5678,new Customer("solomon", "kahsai", "solomeda", "password", 11122333, 5678, new Customer()));
    cmr.setUsername("solomeda");
    assertEquals("solomeda",cmr.getUsername());
    }

    @Test
    void getPassword() throws Exception{
        Customer cmr =new Customer("solomon","kahsai","solomeda","password",11122333,5678,new Customer("solomon", "kahsai", "solomeda", "password", 11122333, 5678, new Customer()));
      assertEquals("password",cmr.getPassword("password"));
    }

    @Test
    void setPassword() throws Exception{
        Customer cmr =new Customer("solomon","kahsai","solomeda","password",11122333,5678,new Customer("solomon", "kahsai", "solomeda", "password", 11122333, 5678, new Customer()));
      cmr.setPassword("password");
      assertEquals("password",cmr.getPassword("password"));
    }

    @Test
    void getAccount_num()throws Exception {
        Customer cmr =new Customer("solomon","kahsai","solomeda","password",11122333,5678,new Customer("solomon", "kahsai", "solomeda", "password", 11122333, 5678, new Customer()));
        assertEquals(11122333,cmr.getAccount_num());
    }

    @Test
    void setAccount_num() throws Exception{
        Customer cmr =new Customer("solomon","kahsai","solomeda","password",11122333,5678,new Customer("solomon", "kahsai", "solomeda", "password", 11122333, 5678, new Customer()));
   cmr.setAccount_num(11122333);
   assertEquals(11122333,cmr.getAccount_num());
    }

    @Test
    void getBalance()throws Exception {
        Customer cmr =new Customer("solomon","kahsai","solomeda","password",11122333,5678,new Customer());
        assertEquals(5678, cmr.getBalance());
    }
    @Test
    void setBalance()throws Exception {
        Customer cmr =new Customer("solomon",
                "kahsai",
                "solomeda",
                "password",
                11122333,
                5678,
                new Customer());
cmr.setBalance(5678);
assertEquals(5678,cmr.getBalance());
    }
}