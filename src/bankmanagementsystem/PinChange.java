
package bankmanagementsystem;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class PinChange extends JFrame implements ActionListener {
    
       JButton change,back;
       JPasswordField pin,repin;
       String pinnumber;
    PinChange(String pinnumber){
        this.pinnumber=pinnumber;
         setLayout(null);
         
          getContentPane().setBackground(Color.WHITE);
    	ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        
        JLabel text=new JLabel("CHANGE YOUR PIN");
        text.setBounds(250,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
      image.add(text);
      
      
       
        JLabel pintext=new JLabel("NEW PIN:");
        pintext.setBounds(170,350,300,35);
        pintext.setForeground(Color.white);
        pintext.setFont(new Font("System",Font.BOLD,16));
      image.add(pintext);
      
        pin=new  JPasswordField();
        pin.setBounds(330,350,180,25);
         pin.setFont(new Font("Railway",Font.BOLD,25));
         image.add(pin);
        
       
        JLabel REpintext=new JLabel("RE-ENTER NEWPIN:");
        REpintext.setBounds(170,390,700,30);
        REpintext.setForeground(Color.white);
        REpintext.setFont(new Font("System",Font.BOLD,16));
      image.add(REpintext);
      
        repin=new JPasswordField();
        repin.setBounds(330,390,180,25);
         repin.setFont(new Font("Railway",Font.BOLD,25));
         image.add(repin);
         
         
         
       change=new JButton("CHANGE");
         change.setBounds(355,485,150,30);
         change.addActionListener(this);
         image.add(change);
         
           back=new JButton("BACK");
         back.setBounds(355,520,150,30);
         back.addActionListener(this);
         image.add(back);
         
        
        
         setSize(900,900);
        setLocation(300,0);
        
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==change){
       try{
           String npin =pin.getText();
           String rpin=repin.getText();
           
           if(!npin.equals(rpin)){
               JOptionPane.showMessageDialog(null,"Entered PIN DOES NOT MATCH");
               return;
               
           }if(npin.equals("")){
               JOptionPane.showMessageDialog(null,"PLEASE ENTER NEW PIN");
               return;
           }if(rpin.equals("")){
               JOptionPane.showMessageDialog(null,"PLEASE ENTER NEW RE-PIN");
               return;
           }
            Conn c=new Conn();
            String query2= "update login set pin_Number= '"+rpin+"' where pin_Number='"+pinnumber+"'"; 
           String query1= "update bank set pin_Number = '"+rpin+"' where pin_Number='"+pinnumber+"'"; 
       
           String query3= "update signupthree set pin_Number = '"+rpin+"' where pin_Number='"+pinnumber+"'"; 
          
           c.s.executeUpdate(query2);
           c.s.executeUpdate(query1);
           c.s.executeUpdate(query3);
           JOptionPane.showMessageDialog(null,"PIN CHANGE SUCCESSFULLY");
              
           setVisible(false);
           new Transactions(rpin).setVisible(true);
          }catch (Exception e)
       {
           System.out.print(e);
       }
    }else{
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
  }
    
    public static void main(String args[]){
     new PinChange("").setVisible(true);   
    }
}
