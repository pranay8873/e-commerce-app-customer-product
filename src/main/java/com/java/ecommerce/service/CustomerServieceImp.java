package com.java.ecommerce.service;

import com.java.ecommerce.Exceptions.CustomerExistsExc;
import com.java.ecommerce.Exceptions.CustomerNotFoundExc;
import com.java.ecommerce.model.Customer;
import com.java.ecommerce.repository.CustomerRepository;

import java.io.IOException;
import java.util.List;

public class CustomerServieceImp implements CustomerService{
    public final CustomerRepository Customerrepository;

    public CustomerServieceImp(CustomerRepository customerrepo) throws IOException {
        this.Customerrepository=customerrepo;
    }


    @Override
    public void register(Customer customer) throws CustomerExistsExc {
        if(Customerrepository.exists(customer.getEmail())){
            System.out.println("Customer already exists !!!");
        }else {
            Customerrepository.save(customer);
        }

    }

    @Override
    public Customer getcustomerbyid(int id) throws CustomerExistsExc{
        return Customerrepository.getCustomerbyid(id).orElseThrow(()->new CustomerExistsExc(STR."Customer with id \{id} is not present"));
    }

    @Override
    public Customer getbyemail(String email) {
        return Customerrepository.getCustomerByEmail(email).orElseThrow(()->new CustomerNotFoundExc(STR."customer with email : \{email}not found"));
    }

    @Override
    public List<Customer> getallcustomers() throws IOException {
        return Customerrepository.getCustomers();
    }

    @Override
    public void save(Customer customer) {
        Customerrepository.save(customer);
    }

    @Override
    public Customer updatecustomer(Customer customer) {
        Customer existing=Customerrepository.getCustomerbyid(customer.getId()).orElseThrow(()->new CustomerNotFoundExc("customer not found"));
        if(!existing.getEmail().equalsIgnoreCase(customer.getEmail())&&Customerrepository.exists(customer.getEmail())){
            throw new CustomerExistsExc(STR."Customer with e-mail : \{customer.getEmail()}already exists!!");
        }
        return Customerrepository.updateCustomer(customer).orElseThrow(()->new CustomerNotFoundExc("customer is not updated!!"));
        //return customer;
    }

    @Override
    public void deletecustomer(int id) {
        boolean deleted=Customerrepository.deletebyid(id);
        if (!deleted){
            throw new CustomerNotFoundExc(STR."customer not found with id \{id}");
        }

    }
}
