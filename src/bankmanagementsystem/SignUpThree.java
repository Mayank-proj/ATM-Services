
package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class SignUpThree extends JFrame implements ActionListener{
    
    JRadioButton  r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton cancel,submit;
    String formno;
    
    SignUpThree(String formno){
        
        this.formno=formno;
        
        
        setLayout(null);
        
        
         JLabel additionaldetails=new JLabel("Page 3 : Account Details");
       additionaldetails.setFont(new Font("Railway",Font.BOLD,22));
         additionaldetails.setBounds(280,40,600,40);
        add( additionaldetails);
        
        JLabel type=new JLabel("Account Type:");
        type.setBounds(100,140,200,30);
        type.setFont(new Font("Railway",Font.BOLD,25));
        add(type);
        
        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Railway",Font.BOLD,16));
        r1.setBackground(Color.white);
        r1.setBounds(100,180,150,20);
        add(r1);
        
         r2=new JRadioButton("Current Account");
        r2.setFont(new Font("Railway",Font.BOLD,16));
        r2.setBackground(Color.white);
        r2.setBounds(300,180,250,20);
        add(r2);
        
        
         r3=new JRadioButton("Fixed Account");
        r3.setFont(new Font("Railway",Font.BOLD,16));
        r3.setBackground(Color.white);
        r3.setBounds(100,220,150,20);
        add(r3);
        
         r4=new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Railway",Font.BOLD,16));
        r4.setBackground(Color.white);
        r4.setBounds(300,220,350,20);
        add(r4);
        
        ButtonGroup b1=new ButtonGroup();
        b1.add(r1);
         b1.add(r2);
          b1.add(r3);
           b1.add(r4);
        
        
        JLabel card=new JLabel("Card Number:");
        card.setBounds(100,280,200,30);
        card.setFont(new Font("Railway",Font.BOLD,25));
        add(card);
       
        
         JLabel number=new JLabel("XXXX-XXXX-XXXX-8765");
        number.setBounds(350,280,600,30);
        number.setFont(new Font("Railway",Font.BOLD,25));
        add(number);
        
        
        JLabel cardn=new JLabel("Your 16 Digit Card Number");
        cardn.setBounds(100,310,600,25);
        cardn.setFont(new Font("Railway",Font.BOLD,12));
        add(cardn);
        
         JLabel Pin=new JLabel("Pin:");
        Pin.setBounds(100,340,200,30);
        Pin.setFont(new Font("Railway",Font.BOLD,25));
        add(Pin);
        
         JLabel pnum=new JLabel("XXXX");
        pnum.setBounds(350,340,600,30);
        pnum.setFont(new Font("Railway",Font.BOLD,25));
        add(pnum);
        
        JLabel pinn=new JLabel("Your 4 Digit Pin");
        pinn.setBounds(100,370,600,25);
        pinn.setFont(new Font("Railway",Font.BOLD,12));
        add(pinn);
        
        JLabel services=new JLabel("Services Requried:");
        services.setBounds(100,420,600,30);
         services.setFont(new Font("Railway",Font.BOLD,22));
        add(services);
        
         c1=new JCheckBox("ATM CARD");
         c1.setBackground(Color.white);
         c1.setBounds(100, 470,200, 30);
         c1.setFont(new Font("Railway",Font.BOLD,16));
         add(c1);
         
          c2=new JCheckBox("INTERNET BANKING");
         c2.setBackground(Color.white);
         c2.setBounds(350, 470,200, 30);
         c2.setFont(new Font("Railway",Font.BOLD,16));
         add(c2);
         
          c3=new JCheckBox("MOBILE BANKING");
         c3.setBackground(Color.white);
         c3.setBounds(100, 510,200, 30);
         c3.setFont(new Font("Railway",Font.BOLD,16));
         add(c3);
         
          c4=new JCheckBox("EMAIL ALERTS & SMS ALERT");
         c4.setBackground(Color.white);
         c4.setBounds(350, 510,600, 30);
         c4.setFont(new Font("Railway",Font.BOLD,16));
         add(c4);
         
          c5=new JCheckBox("CHEQUEBOOK");
         c5.setBackground(Color.white);
         c5.setBounds(100, 550,200, 30);
         c5.setFont(new Font("Railway",Font.BOLD,16));
         add(c5);
         
         c6=new JCheckBox("E-STATEMENT");
         c6.setBackground(Color.white);
         c6.setBounds(350, 550,200, 30);
         c6.setFont(new Font("Railway",Font.BOLD,16));
         add(c6);
         
         c7=new JCheckBox("I HEREBY DECLARES THAT THE ABOVE ENTERED INFORMATION ARE CORRECT TO THE BEST OF MY KNOWLEDGE ");
         c7.setBackground(Color.white);
         c7.setBounds(100, 590,1000, 30);
         c7.setFont(new Font("Railway",Font.BOLD,12));
         add(c7);
         
         submit=new JButton("SUBMIT");
          submit.setBackground(Color.black);
          submit.setForeground(Color.white);
         submit.setBounds(200, 650,100, 30);
         submit.setFont(new Font("Railway",Font.BOLD,15));
         submit.addActionListener(this);
         add(submit);
   
         
          cancel=new JButton("CANCEL");
          cancel.setBackground(Color.black);
          cancel.setForeground(Color.white);
         cancel.setBounds(350, 650,100, 30);
         cancel.setFont(new Font("Railway",Font.BOLD,15));
         cancel.addActionListener(this);
         add(cancel);
         
         
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,820);
        setLocation(350,10);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent e){
        
        
        if(e.getSource()==submit){
          
            String accountType=null;
            if(r1.isSelected()){
              accountType="SAVING ACCOUNT" ;  
            }else if(r2.isSelected()){
              accountType ="CURRENT ACCOUNT";
            }else if(r3.isSelected()){
              accountType ="FIXED ACCOUNT";
            }else if(r4.isSelected()){
              accountType ="RECURRING DEPOSIT ACCOUNT";
            }  
            
            Random random=new Random ();
            String cardNumber=""+ Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pinnumber=""+ Math.abs((random.nextLong() % 9000L) + 1000L);
              
            
            String facility="     ";
            if(c1.isSelected()){
               facility=facility +"ATM CARD";
            }else if(c2.isSelected()){
                facility=facility + "Internet Banking";
            }else if(c3.isSelected()){
                facility=facility + "Mobile Banking";
            }else if(c4.isSelected()){
                facility=facility + "Cheque Book"; 
            }else if(c5.isSelected()){
                facility=facility + "Email & SMS Alert";
            }else if(c6.isSelected()){
                facility=facility + "E-StateMent";
            }
           
            
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account type is reqiured");
                }else{
                    Conn conn=new Conn();
                    String query1="insert into signupthree values('"+formno+"','"+accountType+"','"+cardNumber+"','"+pinnumber+"','"+facility+"')";
                     String query2="insert into login values('"+formno+"','"+cardNumber+"','"+pinnumber+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    
                     JOptionPane.showMessageDialog(null,"Card Number: "+cardNumber+"\n"+"Pin Number: "+pinnumber);
                }
                setVisible(false);
                new Deposit(pinnumber).setVisible(true);
                }catch (Exception ae){
                System.out.println(ae);
                }    
        }else if(e.getSource()==cancel){
           setVisible(false);
           new Login().setVisible(true);
        }
    }
      public static void main(String args[]){
          new SignUpThree("");
      }   
}
