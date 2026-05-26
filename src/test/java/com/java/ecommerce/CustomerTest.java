package com.java.ecommerce;

import com.java.ecommerce.Exceptions.CustomerExistsExc;
import com.java.ecommerce.model.Customer;
import com.java.ecommerce.repository.CustomerRepository;
import com.java.ecommerce.service.CustomerServieceImp;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {
    private CustomerServieceImp cussev;
    private List<Customer> customerList;

    @BeforeEach
    public void setup() throws IOException {
        customerList = new ArrayList<>(List.of(Customer.builder().name("pranay").id(1).age(20).email("pranaypuvvati@gmail.com").gender("male").phoneno(8919836703L).password("pranay@123").build(),
                Customer.builder().name("vaishnavi").id(2).email("vaishnavichepri@gmail.com").phoneno(89387484889L).gender("female").password("vaishnavi@123").build()));
        CustomerRepository cusrep=new CustomerRepository(customerList);
        cussev = new CustomerServieceImp(cusrep);
    }
    @Test
    @DisplayName("Save Customer When Details Are Valid")
    void shouldaddcustomerwhendataisvalid() throws IOException {
        Customer cust=new Customer("samuel","male",3,25,"samuelsam@gmail.com","samuelsam123",8293838393L);
        Customer addedcustomer=cussev.save(cust);
        assertEquals("samuel",addedcustomer.getName(),"customer name should be samuel");
        assertEquals(3,cussev.getallcustomers().size(),"size should be 3");
    }
     @Test
     @DisplayName("Should throw exception when adding customer with duplicate ID")
     void shouldThrowExceptionWhenAddingDuplicateCustomer() throws IOException {
         Customer duplicate = new Customer("pranay","male",1,20,"pranaypuvaati@gmail.com","pranay@123",8919836703L);

         assertThrows(CustomerExistsExc.class,
         ()->cussev.save(duplicate),"customer with duplicate ID should not be added");

         assertEquals(2, cussev.getallcustomers().size(),"customer list should have 2 customers");
     }
     @Test
    @DisplayName("Should return customer when valid datils are provided")
    void shouldreturncustomerwhenidisvalid(){
        Customer addedcus=cussev.getcustomerbyid(1);
        assertNotNull(addedcus,"customer should not be null");
        assertEquals("pranay",addedcus.getName());
     }
     @Test
     @DisplayName("Should return all customers in the list")
     void shouldReturnAllCustomers() throws IOException {
         List<Customer> allCustomers = cussev.getallcustomers();
         assertNotNull(allCustomers, "customer list should not be null");
         assertEquals(2, allCustomers.size(), "should return 2 customers from initial setup");
         assertTrue(allCustomers.stream().anyMatch(c -> c.getName().equals("pranay")), "list should contain pranay");
         assertTrue(allCustomers.stream().anyMatch(c -> c.getName().equals("vaishnavi")), "list should contain vaishnavi");
     }
     @AfterEach
    public void reset(){
        cussev=null;
        customerList=null;
     }




}
