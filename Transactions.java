package BankSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {
    JButton deposite,withdraw,statement,pinchange,fastcash,balance,exit;
    String pinnumber;


    Transactions(String pinnumber){
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
        JLabel text=new JLabel("Please Select your Transcation");
        text.setBounds(270,230,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

         deposite=new JButton("Deposite");
        deposite.setBounds(270,270,110,30);
        deposite.setBackground(Color.yellow);
        deposite.setForeground(Color.black);
        deposite.addActionListener(this);
        image.add(deposite);
        //
         withdraw=new JButton("Withdraw");
        withdraw.setBounds(400,270,110,30);
        withdraw.setBackground(Color.yellow);
        withdraw.setForeground(Color.BLACK);
        withdraw.addActionListener(this);
        image.add(withdraw);
        //
        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(270,310,110,30);
        fastcash.setBackground(Color.yellow);
        fastcash.setForeground(Color.black);
        fastcash.addActionListener(this);
        image.add(fastcash);
        //
         statement=new JButton("Mini Statement");
        statement.setBounds(400,310,110,30);
        statement.setFont(new Font("Railway",Font.BOLD,11));
        statement.setBackground(Color.yellow);
        statement.setForeground(Color.black);
        statement.addActionListener(this);
        image.add(statement);
        //
         pinchange=new JButton("Change PIN");
        pinchange.setBounds(270,350,110,30);
        pinchange.setBackground(Color.yellow);
        pinchange.setForeground(Color.black);
        pinchange.addActionListener(this);
        image.add(pinchange);
        //
         balance=new JButton("Balance");
        balance.setBounds(400,350,110,30);
        balance.setBackground(Color.yellow);
        balance.setForeground(Color.black);
        balance.addActionListener(this);
        image.add(balance);
        //
        exit=new JButton("Exit");
        exit.setBounds(340,390,100,30);
        exit.setBackground(Color.yellow);
        exit.setForeground(Color.black);
        exit.addActionListener(this);
        image.add(exit);

        setSize(800,750);
        setLocation(200,20);
        setUndecorated(true);
        setVisible(true);
    }
    public static void main(String args[]){
        new Transactions(""); //class object
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==exit){
            System.exit(0);
        }else if(ae.getSource()==deposite){
            setVisible(false);
            new Deposite(pinnumber).setVisible(true);
        }else if(ae.getSource()==withdraw){
            setVisible(false);
            new Withdraw(pinnumber).setVisible(true);
        }else if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        }else if(ae.getSource()==pinchange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(ae.getSource()==balance){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource()==statement){
            new MiniStatement(pinnumber).setVisible(true);
        }

    }
}
