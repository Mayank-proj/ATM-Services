 
package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class SignUpOne extends JFrame implements ActionListener {
  
    JTextField nameText,fnameText,addressText,cityText,stateText,emailText,pinText;
    JButton next;
    JDateChooser dateChooser;
    JRadioButton male,female,status,status1,status2;
     long random;
    
    SignUpOne(){
             setLayout(null);
             
        Random ran=new Random();
         random = Math.abs((ran.nextLong() % 9000L)+1000L);
   
        
        
        
        JLabel formno=new JLabel("APPLICATION FORM NO."+ random);
        formno.setFont(new Font("Railway",Font.BOLD,35));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        
        JLabel personal=new JLabel("PAGE 1:PERSON DETAILS");
        personal.setFont(new Font("Arial",Font.BOLD,20));
        personal.setBounds(290,80,500,30);
        add(personal);
        
        
         JLabel name=new JLabel("NAME:");
        name.setFont(new Font("Arial",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        
         nameText=new JTextField();
        nameText.setFont(new Font("Railway",Font.BOLD,15));
        nameText.setBounds(300,140,400,30);
        add(nameText);
        
         JLabel fname=new JLabel("Father's Name:");
        fname.setFont(new Font("Arial",Font.BOLD,20));
        fname.setBounds(100,190,400,30);
        add(fname);
        
        
         fnameText=new JTextField();
        fnameText.setFont(new Font("Railway",Font.BOLD,15));
        fnameText.setBounds(300,190,400,30);
        add(fnameText);
        
        
        JLabel dob=new JLabel("DATE OF BIRTH:");
        dob.setFont(new Font("Arial",Font.BOLD,20));
        dob.setBounds(100,240,400,30);
        add(dob);
        
         dateChooser=new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(Color.black);
        add(dateChooser);
       
        
        JLabel gender=new JLabel("GENDER:");
        gender.setFont(new Font("Arial",Font.BOLD,20));
        gender.setBounds(100,290,400,30);
        add(gender);
        
         male= new JRadioButton("Male");
        male.setBounds(300,290,100,30);
        male.setBackground(Color.white);
        add(male);
        
            
        
        female= new JRadioButton("Female");
         female.setBounds(450,290,100,30);
         female.setBackground(Color.white);
        add(female);
        
        
         ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        
        JLabel email=new JLabel("Email Address:");
        email.setFont(new Font("Arial",Font.BOLD,20));
        email.setBounds(100,340,400,30);
        add(email);
        
        
         emailText=new JTextField();
        emailText.setFont(new Font("Railway",Font.BOLD,15));
        emailText.setBounds(300,340,400,30);
        add(emailText);
        
        
        JLabel marital=new JLabel("Marital Stauts:");
        marital.setFont(new Font("Arial",Font.BOLD,20));
        marital.setBounds(100,390,400,30);
        add(marital);
        
          status= new JRadioButton("Married");
        status.setBounds(300,390,100,30);
       status.setBackground(Color.white);
        add(status);
        
            
        
         status1= new JRadioButton("Unmarried");
         status1.setBounds(450,390,100,30);
         status1.setBackground(Color.white);
        add(status1);
        
          status2= new JRadioButton("Other");
         status2.setBounds(600,390,100,30);
         status2.setBackground(Color.white);
        add(status2);
        
        
         ButtonGroup maritalgroup=new ButtonGroup();
        maritalgroup.add(status);
        maritalgroup.add(status1);
        maritalgroup.add(status2);
        
        
         JLabel address=new JLabel("Address:");
        address.setFont(new Font("Arial",Font.BOLD,20));
        address.setBounds(100,440,400,30);
        add(address);
        
         addressText=new JTextField();
        addressText.setFont(new Font("Railway",Font.BOLD,15));
        addressText.setBounds(300,440,400,30);
        add(addressText);
        
          JLabel city=new JLabel("City:");
        city.setFont(new Font("Arial",Font.BOLD,20));
        city.setBounds(100,490,400,30);
        add(city);
        
         cityText=new JTextField();
        cityText.setFont(new Font("Railway",Font.BOLD,15));
        cityText.setBounds(300,490,400,30);
        add(cityText);
        
        
         JLabel state=new JLabel("State:");
        state.setFont(new Font("Arial",Font.BOLD,20));
        state.setBounds(100,540,400,30);
        add(state);
        
         stateText=new JTextField();
        stateText.setFont(new Font("Railway",Font.BOLD,15));
        stateText.setBounds(300,540,400,30);
        add(stateText);
        
        
         JLabel pincode=new JLabel("Pincode:");
        pincode.setFont(new Font("Arial",Font.BOLD,20));
        pincode.setBounds(100,590,400,30);
        add(pincode);
        
        
         pinText=new JTextField();
        pinText.setFont(new Font("Railway",Font.BOLD,15));
        pinText.setBounds(300,590,400,30);
        add(pinText);
        
        
         next=new JButton("Next");
        next.setFont(new Font("Railway",Font.BOLD,15));
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(620,640,100,30);
        next.addActionListener(this);
        add(next);
        
        
        
         getContentPane().setBackground(Color.WHITE);
        setSize(800,800);
        setLocation(350,10);
        setVisible(true);
        
    }

    
    public void actionPerformed(ActionEvent e){
        
        String formno =  "" + random;
        String name=nameText.getText();
        String fname=fnameText.getText();
        String dob=((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }else if(female.isSelected()){
            gender="Female";
        }
        String email=emailText.getText();
        String marital=null;
        if(status.isSelected()){
           marital="Married";
        }else if(status1.isSelected()){
            marital="Unmarreid";
        }else if(status2.isSelected()){
        marital="Other";
         }
         String address=addressText.getText();
         String city=cityText.getText();
         String state=stateText.getText();
         String pinCode=pinText.getText();
         
         try{
             if(name.equals("")){
                 JOptionPane.showMessageDialog(null,"Name is required");
             }else{
              Conn c =new Conn();
                 String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+email+"','"+gender+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pinCode+"')";       
                 c.s.executeUpdate(query);
                 setVisible(false);
                 new SignUp2(formno).setVisible(true);
             }
             }catch(Exception ae){
            System.out.println(ae);   
         }
          
    }

    public static void main(String args[]){
        new SignUpOne();
    }
}

