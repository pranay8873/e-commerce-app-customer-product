package com.java.ecommerce.repository;

import com.java.ecommerce.Resources.Customercsv;
import com.java.ecommerce.model.Customer;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class CustomerRepository {
 public final Customercsv customercsv = new Customercsv();
public  List<Customer> customers=customercsv.getcustomersfromcsv();


    public CustomerRepository() throws IOException {
    }
    public CustomerRepository(List<Customer> customers) throws IOException {
        this.customers=customers;
    }

    public Customer addcustomer(Customer customer){
        customers.add(customer);
        return customer;
    }


    public List<Customer> getCustomers() throws IOException {
        return customers;
    }


    public Optional<Customer> getCustomerbyid(int id){
        return customers.stream().filter(c -> c.getId()==id).findFirst();

    }


    public Optional<Customer> updateCustomer(Customer updatedcustomer){
        Optional<Customer> existing=getCustomerbyid(updatedcustomer.getId());
        existing.ifPresent(customer -> {
            customer.setName(updatedcustomer.getName());
            customer.setAge(updatedcustomer.getAge());
            customer.setPhoneno(updatedcustomer.getPhoneno());
            customer.setPassword(updatedcustomer.getPassword());
            customer.setEmail(updatedcustomer.getEmail());
            customer.setGender(updatedcustomer.getGender());
            customer.setId(updatedcustomer.getId());
        });
        return existing;
    }


    public boolean deletebyid(int id){
        return customers.removeIf(customer -> customer.getId()==id);
    }


    public Optional<Customer> getCustomerByEmail(String email){
        return customers.stream().filter(c-> Objects.equals(c.getEmail(), email)).findFirst();
    }


    public boolean exists(String email){
        return customers.stream().anyMatch(c->(c.getEmail()).equalsIgnoreCase(email));    }




}
