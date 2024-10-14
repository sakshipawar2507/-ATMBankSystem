package BankSystem;

import java.sql.*;

public class Conn {
    Connection c;  // Global object for connection
    Statement s;

    public Conn() {  // Constructor
        try {
            // Step 1: Register MySQL JDBC driver (Optional for newer JDBC versions)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Step 2: Create the connection
            String url = "jdbc:mysql://localhost:3306/bankmanagementsystem"; // Corrected JDBC URL
            String username = "root";  // Your MySQL username
            String password = "sakshipawar";  // Your MySQL password
            c = DriverManager.getConnection(url, username, password);

            // Step 3: Create a statement
            s = c.createStatement();
            System.out.println("Connection successful!");

        } catch (ClassNotFoundException e) {
            // Handle exception if JDBC Driver is not found
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            // Handle SQL exceptions (connection errors)
            System.out.println("SQL Exception: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
