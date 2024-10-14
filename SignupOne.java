package BankSystem;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener
{
   Long random;
   JTextField nameTextField,FTextField,STextField,dobTextField,emailTextField,addTextField,cityTextField,stateTextField,pincodeTextField;
    JButton next;
    JRadioButton male,female ,yes,No;
    SignupOne(){  //constrctor
        //random class for form no
        setLayout(null);
        Random ran=new Random();
    random=Math.abs((ran.nextLong()%9000L)+1000L); //gives 4 digit no
        JLabel formno=new JLabel("Application Form No "+random);
        formno.setFont(new Font("Railway",Font.BOLD,30));
        formno.setBounds(190,20,600,40);
        add(formno); //display text
//personal details
        JLabel PersonalDetails=new JLabel("Page 1:Personal Details");
        PersonalDetails.setFont(new Font("Railway",Font.BOLD,25));
        PersonalDetails.setBounds(250,80,600,50);
        add(PersonalDetails); //display text
//Name
        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Railway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
         nameTextField=new JTextField();
        nameTextField.setFont(new Font("Railway",Font.BOLD,16));
        nameTextField.setBounds(300,140,300,30);
        add(nameTextField);

        //Fathers name
        JLabel fname=new JLabel("Fathers Name:");
        fname.setFont(new Font("Railway",Font.BOLD,20));
        fname.setBounds(100,180,200,30);
        add(fname);
        //textfield
         FTextField=new JTextField();
        FTextField.setFont(new Font("Railway",Font.BOLD,16));
        FTextField.setBounds(300,180,300,30);
        add(FTextField);
        //surname
        JLabel sname=new JLabel("SurName:");
        sname.setFont(new Font("Railway",Font.BOLD,20));
        sname.setBounds(100,220,200,30);
        add(sname);
       STextField=new JTextField();
        STextField.setFont(new Font("Railway",Font.BOLD,16));
        STextField.setBounds(300,220,300,30);
        add(STextField);
        //dob
        JLabel dob=new JLabel("Date of birth:");
        dob.setFont(new Font("Railway",Font.BOLD,20));
        dob.setBounds(100,260,200,30);
        add(dob);
        dobTextField=new JTextField();
        dobTextField.setFont(new Font("Railway",Font.BOLD,16));
        dobTextField.setBounds(300,260,300,30);
        add(dobTextField);
        //gender
        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Railway",Font.BOLD,20));
        gender.setBounds(100,300,200,30);
        add(gender);
       male= new JRadioButton("Male");
        male.setBounds(300,300,60,30);
        male.setBackground(Color.PINK);
        add(male);
         female=new JRadioButton("Female");
        female.setBounds(400,300,80,30);
        female.setBackground(Color.PINK);
        add(female);

        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        //email
        JLabel email=new JLabel("Email:");
        email.setFont(new Font("Railway",Font.BOLD,20));
        email.setBounds(100,340,200,30);
        add(email);
        emailTextField=new JTextField();
        emailTextField.setFont(new Font("Railway",Font.BOLD,16));
        emailTextField.setBounds(300,340,300,30);
        add(emailTextField);
        //Maratial status
        JLabel mstatus=new JLabel("Marital Status:");
        mstatus.setFont(new Font("Railway",Font.BOLD,20));
        mstatus.setBounds(100,380,200,30);
        add(mstatus);

         yes= new JRadioButton("Married");
        yes.setBounds(300,380,120,30);
        yes.setBackground(Color.PINK);
        add(yes);
         No=new JRadioButton("Unmarried");
        No.setBounds(420,380,100,30);
        No.setBackground(Color.PINK);
        add(No);
        ButtonGroup mastatus=new ButtonGroup();
        mastatus.add(yes);
        mastatus.add(No);

        //Address
        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Railway",Font.BOLD,20));
        address.setBounds(100,420,200,30);
        add(address);
        addTextField=new JTextField();
        addTextField.setFont(new Font("Railway",Font.BOLD,16));
        addTextField.setBounds(300,420,300,30);
        add(addTextField);
        //City
        JLabel city =new JLabel("City:");
        city.setFont(new Font("Railway",Font.BOLD,20));
        city.setBounds(100,460,200,30);
        add(city);
         cityTextField=new JTextField();
        cityTextField.setFont(new Font("Railway",Font.BOLD,16));
        cityTextField.setBounds(300,460,300,30);
        add(cityTextField);
        //state
        JLabel state =new JLabel("State:");
        state.setFont(new Font("Railway",Font.BOLD,20));
        state.setBounds(100,500,200,30);
        add(state);
        stateTextField=new JTextField();
        stateTextField.setFont(new Font("Railway",Font.BOLD,16));
        stateTextField.setBounds(300,500,300,30);
        add(stateTextField);
        //Pincode
        JLabel pincode =new JLabel("Pincode:");
        pincode.setFont(new Font("Railway",Font.BOLD,20));
        pincode.setBounds(100,540,200,30);
        add(pincode);
        pincodeTextField=new JTextField();
        pincodeTextField.setFont(new Font("Railway",Font.BOLD,16));
        pincodeTextField.setBounds(300,540,300,30);
        add(pincodeTextField);

        //button
         next=new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(620,600,100,40);
        next.addActionListener(this); //action for validation
        add(next);


        getContentPane().setBackground(Color.PINK);
        setSize(800,700); //set frame size
        setLocation(300,20); // Frame display location
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae) {
        String formno=" "+ random; //long value. convert into string
        String name=nameTextField.getText(); //used to getbvalue
        String fname= FTextField.getText();
        String sname=STextField.getText();
        String dob=dobTextField.getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }else if(female.isSelected()){
            gender="Female";
        }
        String email=emailTextField.getText();
        String mstatus=null;
        if(yes.isSelected()){
            mstatus="Marital";
        }else if(No.isSelected()){
            mstatus="Unmarital";
        }
        String address=addTextField.getText();
        String city=cityTextField.getText();
        String state=stateTextField.getText();
        String pincode=pincodeTextField.getText();
        try{
            if(name.equals("")){ //validation
                JOptionPane.showMessageDialog(null,"Name is Required");
            }else if(sname.equals(" ")){
                JOptionPane.showMessageDialog(null,"Surname is required");
            }else if(email.equals(" ")){
                JOptionPane.showMessageDialog(null,"Email is required");
            }
        else {
                //object created of conn class
                Conn c=new Conn();
                //dml command ie insert to insert name
                String query="insert into signup values ('"+formno+"','"+name+"','"+fname+"','"+sname+"','"+dob+"','"+gender+"','"+email+"','"+mstatus+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";

                //execute query
                c.s.executeUpdate(query);
                //
                setVisible(false);
               new SignupTwo(formno).setVisible(true);
            }

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String args[]){
        new SignupOne();
    }
}
