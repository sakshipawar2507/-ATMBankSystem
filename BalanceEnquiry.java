package BankSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JButton back;
    String pinnumber;
   // String balanceenquiry;
    BalanceEnquiry(String pinnumber){
       this.pinnumber= pinnumber;
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("BankSystem/img_4.png"));
        Image i2=i1.getImage().getScaledInstance(800,750,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,800,700);
        add(image);

       back=new JButton("BACK");
       back.setBounds(400,430,110,40);
       back.addActionListener(this);
       image.add(back);

       //balance enquiry. retrive data from all tables.
        Conn c=new Conn();
        int balance = 0;
        try {

            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");

            while (rs.next()) {
                if (rs.getString("type").equals(("Deposit"))) {
                    //balance intger ahe convert kel integer mdhe
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }
        JLabel text=new JLabel("<html>Your Current account <br>balance is  Rs."+ balance);
        text.setForeground(Color.white);
        text.setFont(new Font("Railway",Font.BOLD,20));
        text.setBounds(270,260,600,70);
        image.add(text);


        setSize(800,750);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);

    }

    public static void main(String args[]){
        new BalanceEnquiry(" ");
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinnumber).setVisible(true);
    }
}
