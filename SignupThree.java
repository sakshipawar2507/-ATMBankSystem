package BankSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1;
    JCheckBox c2;
    JCheckBox c3;
    JCheckBox c4;
    JCheckBox c5;
    JCheckBox c6;
    JCheckBox c7;
    JButton submit,cancel;
    String formno;
    SignupThree(String formno){
        this.formno=formno;
        setLayout(null);
        getContentPane().setBackground(Color.PINK);
        JLabel l1=new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Railway",Font.BOLD, 22));
        l1.setBounds(220,40,400,40);
        add(l1);
        //Acount type
        JLabel type=new JLabel("Account Type");
        type.setFont(new Font("Railway",Font.BOLD, 22));
        type.setBounds(100,140,200,30);
        add(type);
        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Railway",Font.BOLD,16));
        r1.setBackground(Color.PINK);
        r1.setBounds(100,180,200,20);
        add(r1);

        r2=new JRadioButton("Fixed BankSystem.Deposite Account");
        r2.setFont(new Font("Railway",Font.BOLD,16));
        r2.setBackground(Color.PINK);
        r2.setBounds(300,180,300,20);
        add(r2);
        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Railway",Font.BOLD,16));
        r3.setBackground(Color.PINK);
        r3.setBounds(100,220,200,20);
        add(r3);
        r4=new JRadioButton("Recurring BankSystem.Deposite Account");
        r4.setFont(new Font("Railway",Font.BOLD,16));
        r4.setBackground(Color.PINK);
        r4.setBounds(300,220,300,20);
        add(r4);

        //button group
        ButtonGroup groupaccount = new ButtonGroup();
        groupaccount.add(r1);
        groupaccount.add(r2);
        groupaccount.add(r3);
        groupaccount.add(r4);

        //card no
        JLabel card=new JLabel("Card Number");
        card.setFont(new Font("Railway",Font.BOLD, 22));
        card.setBounds(100,270,200,30);
        add(card);
        //number
        JLabel number=new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Railway",Font.BOLD, 16));
        number.setBounds(310,273,300,30);
        add(number);

        JLabel pin=new JLabel("PIN");
        pin.setFont(new Font("Railway",Font.BOLD, 22));
        pin.setBounds(100,320,200,30);
        add(pin);
        //number
        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Railway",Font.BOLD, 16));
        pnumber.setBounds(310,320,300,30);
        add(pnumber);

        //services
        JLabel services=new JLabel("Services Required");
        services.setFont(new Font("Railway",Font.BOLD, 22));
        services.setBounds(100,370,300,30);
        add(services);
        c1 =new JCheckBox("ATM card");
        c1.setBackground(Color.PINK);
        c1.setFont(new Font("Railway" ,Font.BOLD,16));
        c1.setBounds(100,410,200,30);
        add(c1);
        //
        c2 =new JCheckBox("Internet Banking");
        c2.setBackground(Color.PINK);
        c2.setFont(new Font("Railway" ,Font.BOLD,16));
        c2.setBounds(300,410,300,30);
        add(c2);
        //
        c3 =new JCheckBox("Mobile Banking");
        c3.setBackground(Color.PINK);
        c3.setFont(new Font("Railway" ,Font.BOLD,16));
        c3.setBounds(100,440,200,30);
        add(c3);
        //
        c4 =new JCheckBox("Email/SMS Alerts");
        c4.setBackground(Color.PINK);
        c4.setFont(new Font("Railway" ,Font.BOLD,16));
        c4.setBounds(300,440,300,30);
        add(c4);
        //
        c5 =new JCheckBox("Cheque Book");
        c5.setBackground(Color.PINK);
        c5.setFont(new Font("Railway" ,Font.BOLD,16));
        c5.setBounds(100,470,200,30);
        add(c5);
        //
        c6 =new JCheckBox("E-Statement");
        c6.setBackground(Color.PINK);
        c6.setFont(new Font("Railway" ,Font.BOLD,16));
        c6.setBounds(300,470,300,30);
        add(c6);
        //
        c7 =new JCheckBox("I hearby declares that the above entered deatils are correct ");
        c7.setBackground(Color.PINK);
        c7.setFont(new Font("Railway" ,Font.BOLD,12));
        c7.setBounds(100,500,500,30);
        add(c7);

        //submit button
        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Railway",Font.BOLD,14));
        submit.setBounds(200,600,100,30);
        submit.addActionListener(this);
        add(submit);

        //submit button
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Railway",Font.BOLD,14));
        cancel.setBounds(350,600,100,30);
        cancel.addActionListener(this);
        add(cancel);

        setSize(800,750);
        setLocation(300,30);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit) {
            String accounttype = null;
            if (r1.isSelected()) {
                accounttype = "Saving Account";
            } else if (r2.isSelected()) {
                accounttype = "Fixed BankSystem.Deposite";
            } else if (r3.isSelected()) {
                accounttype = "Current Account";
            } else if (r4.isSelected()) {
                accounttype = "Reccuring BankSystem.Deposite Account";
            }

            Random random = new Random();
            String cardnumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pinnumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            String facility = "";
            if (c1.isSelected()) {
                facility = facility + "ATM Card ";
            }
            if (c2.isSelected()) {
                facility = facility + "Internet Banking ";
            }
            if (c3.isSelected()) {
                facility = facility + "Mobile Banking ";
            }
            if (c4.isSelected()) {
                facility = facility + "Email/SMS Alerts ";
            }
            if (c5.isSelected()) {
                facility = facility + "Cheque Book ";
            }
            if (c6.isSelected()) {
                facility = facility + "E-Statement ";
            }

            try {
                if (accounttype == null) {
                    JOptionPane.showMessageDialog(null, "Account type is required");
                } else if (!c7.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Please declare the details as correct");
                } else {
                    Conn conn = new Conn();
                    String query = "INSERT INTO signupthree (formno, AccountType, CardNo, pin, Facility) VALUES ('" + formno + "', '" + accounttype + "', '" + cardnumber + "', '" + pinnumber + "', '" + facility + "')";
                    String query2 = "INSERT INTO login VALUES ('" + formno + "', '" + cardnumber + "', '" + pinnumber + "')";

                    conn.s.executeUpdate(query);
                    conn.s.executeUpdate(query2);
                    //JOptionPane.showMessageDialog(null, "Account Created Successfully!");
                    JOptionPane.showMessageDialog(null,"card Number:"+ cardnumber + "\n Pin Number:"+pinnumber);
                    setVisible(false);
                    //new BankSystem.Login().setVisible(true); // Assuming the next page is BankSystem.Login
                }
                //submit
                setVisible(false);
                new Deposite(pinnumber).setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main (String args[]){
        new SignupThree("");

    }
}
