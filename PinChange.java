package BankSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.ImageGraphicAttribute;

public class PinChange extends JFrame implements ActionListener {
    JPasswordField pin,repin;
    JButton change,back;
    String pinnumber;
    PinChange(String pinnumber) {
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("BankSystem/img_4.png"));
        Image i2 = i1.getImage().getScaledInstance(800, 750, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 800, 750);
        add(image);

        JLabel text=new JLabel("Change your pin");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(310,270,200,30);
        image.add(text);

        //pintext
        JLabel pintext=new JLabel("New PIN");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setBounds(330,300,200,30);
        image.add(pintext);
        //textfield
        pin=new JPasswordField();
        pin.setFont(new Font("Railway",Font.BOLD,14));
        pin.setBounds(290,330,180,30);
        image.add(pin);
        //repin
        JLabel repintext=new JLabel("Re-Enter New pin");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setBounds(310,360,200,30);
        image.add(repintext);
        //
         repin= new JPasswordField();
        repin.setFont(new Font("Railway",Font.BOLD,14));
        repin.setBounds(290,390,180,30);
        image.add(repin);

        //change
        change=new JButton("CHANGE");
        change.setBounds(250,460,100,30);
        change.addActionListener(this);
        image.add(change);
        //
        back=new JButton("BACK");
        back.setBounds(403,460,100,30);
        back.addActionListener(this);
        image.add(back);

        setSize(800,750);
        setLocation(300,0);
        setVisible(true);
    }

        public static void main (String args[]){
            new PinChange("").setVisible(true);
        }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==change){
        try{
           String npin=pin.getText();
           String rpin=repin.getText();
           if(!npin.equals(rpin)){
               JOptionPane.showMessageDialog(null,"Pin does not match");
               return;
           }
           if(npin.equals("")){
               JOptionPane.showMessageDialog(null,"Enter new pin");
               return;
            }
           if(rpin.equals("")){
               JOptionPane.showMessageDialog(null,"Please Re-Enter new pin ");
               return;
           }
           Conn conn=new Conn();
           //updates pin 3 table.
            String query1="update bank set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
            String query2="update login set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
            String query3="update signupthree set pin = '"+rpin+"' where pin = '"+pinnumber+"'";
            //execute //dml coomand(executeupdate)
            conn.s.executeUpdate(query1);
            conn.s.executeUpdate(query2);
            conn.s.executeUpdate(query3);
            JOptionPane.showMessageDialog(null,"PIN changed successfully ! ");
            setVisible(false);
            new Transactions(rpin).setVisible(true);


        }catch (Exception e){
            System.out.println(e);
        }
    }else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(false);
        }
    }

}