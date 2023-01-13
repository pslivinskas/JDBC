import JDBC.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/classicmodels",
                    "root",
                    "root");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customers");

            List<Customer> customers = new ArrayList<>();

            while (resultSet.next()) {

                Customer customer = new Customer(
                        resultSet.getInt("customerNumber"),
                        resultSet.getString("customerName"),
                        resultSet.getString("phone"),
                        resultSet.getString("city")
                );
                customers.add(customer);


            }

            customers.forEach(System.out::println);

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
