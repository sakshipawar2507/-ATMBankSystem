package BankSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupTwo extends JFrame implements ActionListener {

        JTextField adharTextField, panTextField;
        JButton next;
        JRadioButton eyes, eno, syes, sno;
        JComboBox religion, category, occupation, income, educational;
        String formno; //act as primary key
        SignupTwo(String formno) {  //constrctor
            //random class for form no
            this.formno=formno;
            setLayout(null);
            setTitle("New Account Application Form-Page 2");
            JLabel additionalDetails = new JLabel("Page 2:Additional Details");
            additionalDetails.setFont(new Font("Railway", Font.BOLD, 25));
            additionalDetails.setBounds(250, 80, 600, 50);
            add(additionalDetails); //display text
//Name
            JLabel name = new JLabel("Religion:");
            name.setFont(new Font("Railway", Font.BOLD, 20));
            name.setBounds(100, 140, 100, 30);
            add(name);

            String valReligion[] = {"Hindu", "Muslim", "Sikh", "Other"};
            religion = new JComboBox(valReligion);
            religion.setBackground(Color.pink);
            religion.setBounds(300, 140, 300, 30);
            add(religion);

            //category
            JLabel fname = new JLabel("Category:");
            fname.setFont(new Font("Railway", Font.BOLD, 20));
            fname.setBounds(100, 180, 200, 30);
            add(fname);
            String valCategory[] = {"General", "OBC", "SC/ST", "Other"};
            category = new JComboBox(valCategory);
            category.setBounds(300, 180, 300, 30);
            category.setBackground(Color.pink);
            add(category);

            //Income
            JLabel sname = new JLabel("Income:");
            sname.setFont(new Font("Railway", Font.BOLD, 20));
            sname.setBounds(100, 220, 200, 30);
            add(sname);
            String IncomeVal[] = {"Null", "< 1,50,000", "< 3,50,000", "< 5,00,000", "up to 10,00,000"};
            income = new JComboBox(IncomeVal);
            income.setBackground(Color.pink);
            income.setBounds(300, 220, 300, 30);
            add(income);

            //Educational
            JLabel dob = new JLabel("Educational:");
            dob.setFont(new Font("Railway", Font.BOLD, 20));
            dob.setBounds(100, 260, 200, 30);
            add(dob);
            String EducationalVal[] = {"Under Graduate", "Graduate", "Post Graduate", "Doctrate", "Other"};
            educational = new JComboBox(EducationalVal);
            educational.setBackground(Color.pink);
            educational.setBounds(300, 260, 300, 30);
            add(educational);
            //Occupation
            JLabel email = new JLabel("Occupation:");
            email.setFont(new Font("Railway", Font.BOLD, 20));
            email.setBounds(100, 300, 200, 30);
            add(email);
            //
            String Occupationval[] = {"Salaried", "Self Employed", "Business", "Student", "Other"};
            occupation = new JComboBox(Occupationval);
            occupation.setBackground(Color.pink);
            occupation.setBounds(300, 300, 300, 30);
            add(occupation);
            //Maratial status
            JLabel Panno = new JLabel("PAN No:");
            Panno.setFont(new Font("Railway", Font.BOLD, 20));
            Panno.setBounds(100, 340, 200, 30);
            add(Panno);
            panTextField = new JTextField();
            panTextField.setBounds(300, 340, 300, 30);
            add(panTextField);

            //Adhar no
            JLabel adharno = new JLabel("Adhar No:");
            adharno.setFont(new Font("Railway", Font.BOLD, 20));
            adharno.setBounds(100, 380, 200, 30);
            add(adharno);
            adharTextField = new JTextField();
            adharTextField.setFont(new Font("Railway", Font.BOLD, 16));
            adharTextField.setBounds(300, 380, 300, 30);
            add(adharTextField);
            //senior Citizen
            JLabel scitizen = new JLabel("Senior Citizen:");
            scitizen.setFont(new Font("Railway", Font.BOLD, 20));
            scitizen.setBounds(100, 420, 200, 30);
            add(scitizen);
            syes = new JRadioButton("yes");
            syes.setBackground(Color.pink);
            syes.setBounds(300, 420, 100, 30);
            add(syes);
            sno = new JRadioButton("No");
            sno.setBackground(Color.pink);
            sno.setBounds(400, 420, 100, 30);
            add(sno);

            //Existing account
            JLabel state = new JLabel("Existing account:");
            state.setFont(new Font("Railway", Font.BOLD, 20));
            state.setBounds(100, 460, 200, 30);
            add(state);
            eyes = new JRadioButton("yes");
            eyes.setBackground(Color.pink);
            eyes.setBounds(300, 460, 100, 30);
            add(eyes);
            eno = new JRadioButton("No");
            eno.setBackground(Color.pink);
            eno.setBounds(400, 460, 100, 30);
            add(eno);


            //button
            next = new JButton("Next");
            next.setBackground(Color.black);
            next.setForeground(Color.white);
            next.setBounds(620, 550, 100, 40);
            next.addActionListener(this); //action for validation
            add(next);


            getContentPane().setBackground(Color.PINK);
            setSize(800, 750); //set frame size
            setLocation(300, 20); // Frame display location
            setVisible(true);

        }

        public void actionPerformed(ActionEvent ae) {
            //String formno = " " + random; //long value. convert into string
            String sreligion = (String) religion.getSelectedItem();
            String scategory = (String) category.getSelectedItem();
            String sincome = (String) income.getSelectedItem();
            String seducation = (String) educational.getSelectedItem();
            String soccupation = (String) occupation.getSelectedItem();
            String senior = null;
            if (syes.isSelected()) {
                senior = "Yes";
            } else if (sno.isSelected()) {
                senior = "No";
            }

            String existingaccount = null;
            if (eyes.isSelected()) {
                existingaccount = "Yes";
            } else if (eno.isSelected()) {
                existingaccount = "No";
            }

            String span = panTextField.getText();
            String sadhar = adharTextField.getText();

            if(ae.getSource()==next){
                setVisible(false);
                new SignupThree(formno).setVisible(true);

            }

            try {
                //object created of conn class
                Conn c = new Conn();
                //dml command ie insert to insert name
                String query = "insert into signuptwo values ('" + formno + "','" + sreligion + "','" + scategory + "','" + sincome + "','" + seducation + "','" + soccupation + "','" + span + "','" + sadhar + "','" + senior + "','" + existingaccount + "')";


                //execute query
               c.s.executeUpdate(query);
            //signup object

            } catch (Exception e) {
                System.out.println(e);
            }
        }

        public static void main(String args[]) {
            new SignupTwo(" ");
        }
    }
