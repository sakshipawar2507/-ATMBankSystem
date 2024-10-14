package BankSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Deposite extends JFrame implements ActionListener {
    JButton depositBtn, back;
    JTextField amount;
    String pinnumber;

    Deposite(String pinnumber) {
        this.pinnumber = pinnumber;
        setLayout(null);

        // Image setup
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BankSystem/img_4.png"));
        Image i2 = i1.getImage().getScaledInstance(800, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 700);
        add(image);

        // Label for deposit prompt
        JLabel text = new JLabel("<html>Enter the amount<br/>you want to deposit</html>");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(300, 240, 400, 40);
        image.add(text);

        // Text field for amount
        amount = new JTextField();
        amount.setFont(new Font("Railway", Font.BOLD, 22));
        amount.setBounds(280, 300, 200, 30);
        image.add(amount);

        // Deposit button
        depositBtn = new JButton("Deposit");
        depositBtn.setBounds(300, 350, 150, 20);
        depositBtn.addActionListener(this);
        image.add(depositBtn);

        // Back button
        back = new JButton("Back");
        back.setBounds(300, 380, 150, 20);
        back.addActionListener(this);
        image.add(back);

        setSize(800, 750);
        setLocation(300, 30);
        setVisible(true);
    }

    public static void main(String args[]) {
        new Deposite("");
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == depositBtn) {
            String amount = this.amount.getText(); // Change variable to avoid confusion
            String date = new Date().toString(); // Format the date as needed
            String type = "Deposit"; // This can be static or dynamic based on your needs

            if (amount.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to Deposit");
            } else {
                Conn conn = new Conn();
                String query = "INSERT INTO bank (pin, date, type, amount) VALUES ('" + pinnumber + "', '" + date + "', '" + type + "', '" + amount + "')";
                try {
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "RS " + amount + " Deposited successfully!");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                } catch (SQLException e) {
                    e.printStackTrace(); // Print stack trace for debugging
                }
            }
        } else if (ae.getSource() == back) {
            new Transactions(pinnumber);
        }
    }
}