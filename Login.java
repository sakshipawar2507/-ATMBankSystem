package BankSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton login,signup,clear;
    JTextField cardText;
    JPasswordField PinText;
    Login()
    {
        setTitle("ATM");
        setLayout(null);
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("BankSystem/logo.jpg"));
        Image i2= i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label =new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        getContentPane().setBackground(Color.pink);
       // getContentPane().setBackground(b);
        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Monospaced",Font.BOLD,30));
        text.setBounds(200,40,500,40);
        add(text);

        JLabel cardno=new JLabel("User Card no:");
        cardno.setFont(new Font("Railway",Font.BOLD,23));
        cardno.setBounds(120,150,250,40);
        add(cardno);
        cardText =new JTextField();
        cardText.setBounds(300,154,200,30);
        cardText.setFont(new Font("Arial",Font.BOLD,16));
        add(cardText);

        JLabel pin=new JLabel("User PIN:");
        pin.setFont(new Font("Railway",Font.BOLD,23));
        pin.setBounds(120,230,150,40);
        add(pin);
         PinText =new JPasswordField();
        PinText.setBounds(300,240,200,30);
        PinText.setFont(new Font("Arial",Font.BOLD,16));
        add(PinText);

        //button
        login=new JButton("Sign in");
        login.setBounds(315,300,80,30);
       login.setBackground(Color.black);
       login.setForeground(Color.white);
       login.addActionListener(this);
        add(login);

        clear=new JButton("Clear");
        clear.setBounds(400,300,80,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signup=new JButton("Sign Up");
        signup.setBounds(335,350,120,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);

        setSize(800,480);
        setVisible(true);
        setLocation(300,200);
    }
    public void actionPerformed(ActionEvent ae){ // overide method
        // used to give button click info
        if(ae.getSource()==clear){
            cardText.setText("");
            PinText.setText("");
        }else if(ae.getSource()==login){
            Conn conn=new Conn();
            String cardnumber=cardText.getText();
            String pinnumber=PinText.getText();
            //ddl
            String query="select * from login where CardNumber = '"+cardnumber+"' and pin= '"+pinnumber+"' ";
            try{
                ResultSet rs=conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect card no /pin");
                }
            }catch (Exception e){
                System.out.println(ae);
            }
        }
        else if (ae.getSource()==signup){
            setVisible(false); // for closing current login page
            new SignupOne().setVisible(true); // onclick signup it shows signup page.



        }
    }
    public  static void main(String args[]){
        new Login();

    }

}
