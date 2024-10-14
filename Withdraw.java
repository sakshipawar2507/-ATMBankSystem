package BankSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {
    JButton withdrawBtn, back;
    JTextField amount;
    String pinnumber;

    Withdraw(String pinnumber) {
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
        JLabel text = new JLabel("<html>Enter the amount<br/>you want to Withdrwal</html>");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(300, 240, 400, 40);
        image.add(text);

        // Text field for amount
        amount = new JTextField();
        amount.setFont(new Font("Railway", Font.BOLD, 22));
        amount.setBounds(280, 300, 200, 30);
        image.add(amount);

        // withdraw button
        withdrawBtn = new JButton("Withdraw");
        withdrawBtn.setBounds(300, 350, 150, 20);
        withdrawBtn.addActionListener(this);
        image.add(withdrawBtn);

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
        new Withdraw("");
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdrawBtn) {
            String amount = this.amount.getText(); // Change variable to avoid confusion
            String date = new Date().toString(); // Format the date as needed
            String type = "Withdraw"; // This can be static or dynamic based on your needs

            if (amount.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to Deposit");
            } else {
                Conn conn = new Conn();
                String query = "INSERT INTO bank (pin, date, type, amount) VALUES ('" + pinnumber + "', '" + date + "', '" + type + "', '" + amount + "')";
                try {
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "RS " + amount + " Withdraw successfully!");
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