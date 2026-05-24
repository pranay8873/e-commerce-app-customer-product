package com.java.ecommerce.Resources;

import com.java.ecommerce.model.Customer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Customercsv {
    public List<Customer> getcustomersfromcsv() throws IOException {
        File file = new File("C:\\Users\\USER\\Downloads\\customers_50.csv");
        BufferedReader br = new BufferedReader(new FileReader(file));

        List<Customer> customers = new ArrayList<>();

        // Skip Header Row
        br.readLine();

        String customerData;

        while ((customerData = br.readLine()) != null) {

            String[] data = customerData.split(",");

            Customer customer = new Customer();

            customer.setName(data[0]);
            customer.setGender(data[1]);
            customer.setId(Integer.parseInt(data[2]));
            customer.setAge(Byte.parseByte(data[3]));
            customer.setEmail(data[4]);
            customer.setPassword(data[5]);
            customer.setPhoneno(Long.parseLong(data[6]));
            customers.add(customer);
        }

        br.close();

        return customers;
    }

    static void main() throws IOException {
        Customercsv cu=new Customercsv();
        List<Customer> cust=cu.getcustomersfromcsv();
        System.out.println(cust);
    }
}
