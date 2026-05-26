package com.java.ecommerce;

import com.java.ecommerce.model.Customer;
import com.java.ecommerce.repository.CustomerRepository;
import com.java.ecommerce.service.CustomerServieceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class CustomerTest {
    private CustomerRepository cusrep;
    private List<Customer> customerList;
    @BeforeEach
    public void setup() throws IOException {
        customerList= new ArrayList<>(List.of(Customer.builder().id(1).age(20).email("pranay[uvvati@gmail.com").gender("male").phoneno(8919836703L).password("pranay@123").build(),
                Customer.builder().name("vaishnavi").id(2).email("vaishnavichepri@gmail.com").phoneno(89387484889L).gender("female").password("vaishnavi@123").build()));
        cusrep = new CustomerRepository(customerList);
    }
    @Test
    @DisplayName("Save Customer When Details Are Valid")
    void shouldaddchuoldwhendataisvalid() throws IOException {
        Customer cust=new Customer("samuel","male",3,25,"samuelsam@gmail.com","samuelsam123",829383938393L);
        Customer addedcustomer=cusrep.addcustomer(cust);
        assertEquals("Samuel",addedcustomer.getName(),"customer name should be samuel");
        assertEquals(3,cusrep.getCustomers().size(),"size should be 3");
    }


}
