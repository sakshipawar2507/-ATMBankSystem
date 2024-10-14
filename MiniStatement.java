package BankSystem;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame {

    MiniStatement(String pinnumber) {

        setTitle("Mini Statement");
        setLayout(null);

        // Using JLabel to display the bank name
        JLabel bank = new JLabel("Bank Of India");
        bank.setBounds(120, 20, 200, 30);
        add(bank);

        // Displaying card number
        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        // Displaying balance
        JLabel balance = new JLabel();
        balance.setBounds(20, 600, 300, 30);
        add(balance);

        // Creating a JLabel to hold transaction history with HTML formatting
        JLabel mini = new JLabel();
        mini.setBounds(20, 120, 360, 400);
        mini.setVerticalAlignment(SwingConstants.TOP); // Ensure text appears from top
        add(mini);

        try {
            // Fetch card number
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '" + pinnumber + "'");
            if (rs.next()) {
                card.setText("Card Number: " + rs.getString("CardNumber").substring(0, 4) + "XXXXXXXX" + rs.getString("CardNumber").substring(12));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            Conn c = new Conn();
            int bal = 0;

            // Start building the HTML content
            StringBuilder miniStatementContent = new StringBuilder("<html>");

            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
            while (rs.next()) {
                miniStatementContent.append(rs.getString("date")).append("&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(rs.getString("type")).append("&nbsp;&nbsp;&nbsp;&nbsp;")
                        .append(rs.getString("amount")).append("<br><br>");

                // Updating balance based on transaction type
                if (rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                } else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }

            // Close the HTML content and set it to the JLabel
            miniStatementContent.append("</html>");
            mini.setText(miniStatementContent.toString());

            // Display current balance
            balance.setText("Your current account balance is Rs: " + bal);
        } catch (Exception e) {
            System.out.println(e);
        }

        setSize(400, 700);
        setLocation(30, 30);
        getContentPane().setBackground(Color.PINK);
        setVisible(true);
    }

    public static void main(String[] args) {
        // Prompting user to input pin number using a dialog box
        String pinNumber = JOptionPane.showInputDialog(null, "Enter your PIN number:");

        if (pinNumber != null && !pinNumber.trim().isEmpty()) {
            new MiniStatement(pinNumber);  // Pass the user input pin number
        } else {
            JOptionPane.showMessageDialog(null, "PIN number cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
