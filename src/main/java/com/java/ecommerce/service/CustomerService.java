package com.java.ecommerce.service;

import com.java.ecommerce.model.Customer;

import java.util.List;

public interface CustomerService {
//    Customer customer=new Customer();
    // create
      void register(Customer customer);
      //READ
      Customer getcustomerbyid(int id);
      Customer getbyemail(Customer customer);
      List<Customer> getallcustomers();
      void save(Customer customer);
      //UPDATE
      Customer updatecustomer(Customer customer);
      // DELETE
      void deletecustomer(int id);







}
