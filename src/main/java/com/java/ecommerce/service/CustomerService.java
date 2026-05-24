package com.java.ecommerce.service;

import com.java.ecommerce.model.Customer;

import java.io.IOException;
import java.util.List;

public interface CustomerService {
//    Customer customer=new Customer();
    // create
      void register(Customer customer);
      //READ
      Customer getcustomerbyid(int id);
      Customer getbyemail(String email);
      List<Customer> getallcustomers() throws IOException;
      void save(Customer customer);
      //UPDATE
      Customer updatecustomer(Customer customer);
      // DELETE
      void deletecustomer(int id);







}
