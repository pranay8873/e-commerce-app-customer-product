package com.java.ecommerce.main;

import com.java.ecommerce.Controler.CustomerControler;
import com.java.ecommerce.repository.CustomerRepository;
import com.java.ecommerce.service.CustomerServieceImp;

import java.io.IOException;
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
                    cusctlr.getCustomerByID(id);
                case 2:
                    cusctlr.getAllCustomers();
                case 3:
                    System.out.println("Enter Email : ");
                    String email = sc.nextLine();
                    cusctlr.getCustomerByEmail(email);
                case 4:
                    System.out.println("update later");
                case 5:
                    System.out.println("Enter customer id : ");
                    int id2 = sc.nextInt();
                    cusctlr.deleteCustomer(id2);
                default:
                    System.out.println("invalid input!!");

        }
    }
}
