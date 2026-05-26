package com.java.ecommerce.main;

import com.java.ecommerce.Controler.CustomerControler;
import com.java.ecommerce.model.Customer;
import com.java.ecommerce.repository.CustomerRepository;
import com.java.ecommerce.service.CustomerServieceImp;

import java.util.List;
import java.util.Scanner;

public class CustomerMainMet {
    private static final String CUSTOMER_FORMAT = "%-5s %-22s %-8s %-5s %-32s %-12s%n";

    public CustomerMainMet() throws Exception {

            CustomerRepository repository = new CustomerRepository();
            CustomerServieceImp Service = new CustomerServieceImp(repository);

            CustomerControler cusctlr = new CustomerControler(Service);
            int choice;
            Scanner sc = new Scanner(System.in);
            System.out.println("""
                    Enter your choice:
                    1. Get customer by ID
                    2. Get all customers
                    3. Get customer by email
                    4. Update customer
                    5. Delete customer
                    """);
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter id : ");
                    int id = sc.nextInt();
                    Customer cu=cusctlr.getCustomerByID(id);
                    printCustomer(cu);
                    break;
                case 2:
                    List<Customer> customerList=cusctlr.getAllCustomers();
                    printCustomers(customerList);
                    break;
                case 3:
                    sc.nextLine();
                    System.out.println("Enter Email : ");
                    String email = sc.nextLine();
                    Customer customer=cusctlr.getCustomerByEmail(email);
                    printCustomer(customer);
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

    private static void printCustomers(List<Customer> customers) {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }

        System.out.printf(CUSTOMER_FORMAT, "ID", "Name", "Gender", "Age", "Email", "Phone");
        System.out.println("--------------------------------------------------------------------------------------");
        for (Customer customer : customers) {
            printCustomerRow(customer);
        }
    }

    private static void printCustomer(Customer customer) {
        System.out.printf(CUSTOMER_FORMAT, "ID", "Name", "Gender", "Age", "Email", "Phone");
        System.out.println("--------------------------------------------------------------------------------------");
        printCustomerRow(customer);
    }

    private static void printCustomerRow(Customer customer) {
        System.out.printf(
                CUSTOMER_FORMAT,
                customer.getId(),
                customer.getName(),
                customer.getGender(),
                customer.getAge(),
                customer.getEmail(),
                customer.getPhoneno()
        );
    }
}
