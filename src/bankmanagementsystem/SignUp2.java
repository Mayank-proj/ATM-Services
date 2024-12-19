
package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

  
public class SignUp2 extends JFrame implements ActionListener {
    
    JTextField pan,aadhar;
    JButton next,back;
    JComboBox religion,category,INCOME,qualification,occupation;
    JRadioButton syes,sno,eyes,eno;
      String formno;
    
    SignUp2(String formno){
      
         setLayout(null);
                this.formno = formno;
           setTitle("NEW ACCOUNT APPLICATION FORM -PAGE 2")  ;
           
        JLabel additionaldetails=new JLabel("Page 2 : Additonal Details");
       additionaldetails.setFont(new Font("Railway",Font.BOLD,22));
         additionaldetails.setBounds(290,40,600,30);
        add( additionaldetails);
        
        
        
         JLabel name=new JLabel("Religion:");
        name.setFont(new Font("Arial",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);
        
        String varReligion[]={"Hindu","Muslim","Sikh","Christian","Other"};
         religion=new JComboBox(varReligion);
        religion.setBackground(Color.white);
        religion.setBounds(300,140,400,30);
        add(religion);
        
       
        
         JLabel fname=new JLabel("Category:");
        fname.setFont(new Font("Arial",Font.BOLD,20));
        fname.setBounds(100,190,400,30);
        add(fname);
        
        String varCategory[]={"General","OBC","SC","ST","Other"};
       category=new JComboBox(varCategory);
        category.setBackground(Color.white);
        category.setBounds(300,190,400,30);
        add(category);
        
        
        
        
        JLabel dob=new JLabel("Income:");
        dob.setFont(new Font("Arial",Font.BOLD,20));
        dob.setBounds(100,240,400,30);
        add(dob);
        
         String varIncome[]={"Null","<1,50,000","<2,50,000","<5,50,000","UPTO 8,50,000"};
         INCOME=new JComboBox(varIncome);
        INCOME.setBackground(Color.white);
        INCOME.setBounds(300,240,400,30);
        add(INCOME);
        
        
        JLabel gender=new JLabel("Educational");
        gender.setFont(new Font("Arial",Font.BOLD,20));
        gender.setBounds(100,290,400,30);
        add(gender);
    
        JLabel email=new JLabel("Qualification:");
        email.setFont(new Font("Arial",Font.BOLD,20));
        email.setBounds(100,320,400,30);
        add(email);
        
        
          String varQualification[]={"10th","12th","UnGraduate","Graduate","Post-Graduate","Other"};
         qualification=new JComboBox(varQualification);
        qualification.setBackground(Color.white);
        qualification.setBounds(300,320,400,30);
        add(qualification);
        
        
       
        
        JLabel marital=new JLabel("Occupation:");
        marital.setFont(new Font("Arial",Font.BOLD,20));
        marital.setBounds(100,390,400,30);
        add(marital);
        
        
         String varOccupation[]={"Salaried","Self-Employed","Businessman","Student","Retired","Other"};
         occupation=new JComboBox(varOccupation);
        occupation.setBackground(Color.white);
        occupation.setBounds(300,390,400,30);
        add(occupation);
        
        
        
     
        
         JLabel address=new JLabel("Pan Number:");
        address.setFont(new Font("Arial",Font.BOLD,20));
        address.setBounds(100,440,400,30);
        add(address);
        
         pan=new JTextField();
        pan.setFont(new Font("Railway",Font.BOLD,15));
        pan.setBounds(300,440,400,30);
        add(pan);
        
          JLabel city=new JLabel("Aadhar Number:");
        city.setFont(new Font("Arial",Font.BOLD,20));
        city.setBounds(100,490,400,30);
        add(city);
        
         aadhar=new JTextField();
        aadhar.setFont(new Font("Railway",Font.BOLD,15));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);
        
        
         JLabel state=new JLabel("Senior Citizen:");
        state.setFont(new Font("Arial",Font.BOLD,20));
        state.setBounds(100,540,400,30);
        add(state);
        
         syes= new JRadioButton("YES");
        syes.setBounds(300,540,100,30);
       syes.setBackground(Color.white);
        add(syes);
        
            
        
         sno= new JRadioButton("NO");
         sno.setBounds(400,540,100,30);
         sno.setBackground(Color.white);
        add(sno);
        
         ButtonGroup maritalgroup=new ButtonGroup();
        maritalgroup.add(syes);
        maritalgroup.add(sno);
        
  
        
        
         JLabel pincode=new JLabel("Exisiting Account:");
        pincode.setFont(new Font("Arial",Font.BOLD,20));
        pincode.setBounds(100,590,400,30);
        add(pincode);
        
          
         eyes= new JRadioButton("YES");
        eyes.setBounds(300,590,100,30);
       eyes.setBackground(Color.white);
        add(eyes);
        
            
        
         eno= new JRadioButton("NO");
         eno.setBounds(400,590,100,30);
         eno.setBackground(Color.white);
        add(eno);
        
         ButtonGroup maritalgroup1=new ButtonGroup();
        maritalgroup1.add(eyes);
        maritalgroup1.add(eno);
        
       
        
        
         next=new JButton("Next");
        next.setFont(new Font("Railway",Font.BOLD,15));
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(620,640,100,30);
        next.addActionListener(this);
        add(next);
        
         back=new JButton("Back");
        back.setFont(new Font("Railway",Font.BOLD,15));
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(620,680,100,30);
        back.addActionListener(this);
        add(back);
        
        
        
         getContentPane().setBackground(Color.WHITE);
        setSize(800,800);
        setLocation(350,10);
        setVisible(true);
        
    }

    
    public void actionPerformed(ActionEvent e){
        
       
        String sreligion=(String)religion.getSelectedItem();
        String scategory=(String) category.getSelectedItem();
        String sIncome=(String) INCOME.getSelectedItem();
         String squalification=(String) qualification.getSelectedItem();
          String soccupation=(String) occupation.getSelectedItem();
          String panNumber=pan.getText();
          String aadharNumber=aadhar.getText();
        String seniorcitizen=null;
        if(syes.isSelected()){
            seniorcitizen="YES";
        }else if(sno.isSelected()){
            seniorcitizen="NO";
        }
    
        String existing=null;
        if(eyes.isSelected()){
           existing="YES";
        }else if(eno.isSelected()){
            existing="NO";
        }
         
         
         
         try{
           
              Conn c =new Conn();
                 String query1 = "insert into signupTwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sIncome+"','"+squalification+"','"+soccupation+"','"+panNumber+"','"+aadharNumber+"','"+seniorcitizen+"','"+existing+"')";       
                 c.s.executeUpdate(query1);
                 
                  setVisible(false);
                  new SignUpThree(formno).setVisible(true);
                 
             }catch(Exception ae){
            System.out.println(ae);   
         }
         if(e.getSource() == back){
          setVisible(false);
          new SignUpOne().setVisible(true);
         }
          
    }

    public static void main(String args[]){
        new SignUp2("");
    }
}



