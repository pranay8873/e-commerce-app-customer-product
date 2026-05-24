package com.java.ecommerce.repository;

import com.java.ecommerce.Resources.Customercsv;
import com.java.ecommerce.model.Customer;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class CustomerRepository {
 public final Customercsv customercsv = new Customercsv();

 public final List<Customer> customers=customercsv.getcustomersfromcsv();

    public CustomerRepository() throws IOException {
    }
    public void save(Customer customer){
        customers.add(customer);
    }


    public List<Customer> getCustomers() throws IOException {
        return customercsv.getcustomersfromcsv();
    }

    public Optional<Customer> getCustomerbyid(int id){
        return customers.stream().filter(c -> c.getId()==id).findFirst();

    }



}
