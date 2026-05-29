package com.java.ecommerce.Controler;

import com.java.ecommerce.Exceptions.CustomerNotFoundExc;
import com.java.ecommerce.model.Customer;
import com.java.ecommerce.service.CustomerServieceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;

@Controller
public class CustomerControler {
    CustomerServieceImp custser;
    @Autowired
    public CustomerControler(CustomerServieceImp customerserviece){

        this.custser=customerserviece;
    }
    public Customer getCustomerByID(int id) throws CustomerNotFoundExc{
        return custser.getcustomerbyid(id);
    }
    public List<Customer> getAllCustomers() throws IOException {
        return custser.getallcustomers();
    }
    public Customer getCustomerByEmail(String email) throws CustomerNotFoundExc {
        return custser.getbyemail(email);
    }
    public Customer updateCustomer(Customer customer) throws Exception{
        return custser.updatecustomer(customer);
    }
    public void deleteCustomer(int id) throws Exception{
        custser.deletecustomer(id);
    }
}
