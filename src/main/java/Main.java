import JDBC.Customer;
import JDBC.CustomerService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        CustomerService customerService = new CustomerService();

        List<Customer> customers = customerService.getAllCustomers();
        customers.forEach(System.out::println);
    }
}


