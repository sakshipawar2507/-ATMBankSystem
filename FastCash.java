package BankSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

public class FastCash extends JFrame implements ActionListener {
    JButton back,deposite,withdraw,statement,pinchange,fastcash,balance,exit;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        //image
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("BankSystem/img_4.png"));
        Image i2=i1.getImage().getScaledInstance(800,750,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,800,700);
        add(image);
        //
        JLabel text=new JLabel("Select Withdraw Amount");
        text.setBounds(280,230,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,18));
        image.add(text);

        deposite=new JButton("RS 100");
        deposite.setBounds(270,270,90,30);
        deposite.setBackground(Color.yellow);
        deposite.setForeground(Color.black);
        deposite.addActionListener(this);
        image.add(deposite);
        //
        withdraw=new JButton("Rs.500");
        withdraw.setBounds(400,270,90,30);
        withdraw.setBackground(Color.yellow);
        withdraw.setForeground(Color.BLACK);
        withdraw.addActionListener(this);
        image.add(withdraw);
        //
        fastcash=new JButton("Rs 1000");
        fastcash.setBounds(270,310,90,30);
        fastcash.setBackground(Color.yellow);
        fastcash.setForeground(Color.black);
        fastcash.addActionListener(this);
        image.add(fastcash);
        //
        statement=new JButton("Rs 2000");
        statement.setBounds(400,310,90,30);
        statement.setBackground(Color.yellow);
        statement.setForeground(Color.black);
        statement.addActionListener(this);
        image.add(statement);
        //
        pinchange=new JButton("Rs 5000");
        pinchange.setBounds(270,350,90,30);
        pinchange.setBackground(Color.yellow);
        pinchange.setForeground(Color.black);
        pinchange.addActionListener(this);
        image.add(pinchange);
        //
        balance=new JButton("RS 10,000");
        balance.setBounds(400,350,90,30);
        balance.setBackground(Color.yellow);
        balance.setForeground(Color.black);
        balance.addActionListener(this);
        image.add(balance);
        //
        back=new JButton("Back");
        back.setBounds(340,390,100,30);
        back.setBackground(Color.yellow);
        back.setForeground(Color.black);
        back.addActionListener(this);
        image.add(back);

        setSize(800,750);
        setLocation(200,20);
        setUndecorated(true);
        setVisible(true);
    }
    public static void main(String args[]){
        new FastCash(""); //class object
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else {
            String amount = ((JButton) ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try {
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
                int balance = 0;
                while (rs.next()) {
                    if (rs.getString("type").equals(("Deposit")))
                    {
                        //balance intger ahe convert kel integer mdhe
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else
                    {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource()!=exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient balance");
                    return;
                }
                Date date=new Date();
                String query = "INSERT INTO bank (pin, date, type, amount) VALUES ('" + pinnumber + "', '" + date + "', 'Withdraw', '" + amount + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs."+ amount + " Debited Successfully");
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }
}
