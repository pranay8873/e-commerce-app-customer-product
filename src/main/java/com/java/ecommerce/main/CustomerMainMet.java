package com.java.ecommerce.main;

import com.java.ecommerce.Controler.CustomerControler;
import com.java.ecommerce.model.Customer;
import com.java.ecommerce.repository.CustomerRepository;
import com.java.ecommerce.service.CustomerServieceImp;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CustomerMainMet {
    public CustomerMainMet() throws Exception {

            CustomerRepository repository = new CustomerRepository();
            CustomerServieceImp Serviece = new CustomerServieceImp(repository);

            CustomerControler cusctlr = new CustomerControler(Serviece);
            int choice;
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your choice :" +
                    "\n1.Get customer By ID" +
                    "\n2.Get all customers" +
                    "\n3.Get customer By email" +
                    "\n4.Update Customer" +
                    "\n5.Delete Customer");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter id : ");
                    int id = sc.nextInt();
                    Customer cu=cusctlr.getCustomerByID(id);
                    System.out.println(STR."customer with id :\{id}is : "+cu);
                    break;
                case 2:
                    List<Customer> customerList=cusctlr.getAllCustomers();
                    System.out.println(customerList);
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("Enter Email : ");
                    String email = sc.nextLine();
                    Customer customer=cusctlr.getCustomerByEmail(email);
                    System.out.println(STR."customer with email \{email} is : \{customer}");
                    break;
                case 4:
                    System.out.println("update later");
                    break;
                case 5:
                    System.out.println("Enter customer id : ");
                    int id2 = sc.nextInt();
                    cusctlr.deleteCustomer(id2);
                    System.out.println("customer deleted succesfully");
                    break;
                default:
                    System.out.println("invalid input!!");

        }
    }
}
