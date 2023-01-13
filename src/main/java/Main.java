import JDBC.Customer;
import JDBC.Repository;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {

        Repository repository = new Repository();

        try (Connection connection = repository.getConnection()) {

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
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


