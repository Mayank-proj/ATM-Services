
package bankmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Date;
import java.sql.*;

public class Withdraw extends JFrame implements ActionListener{
    JButton withdraw,back;
    JTextField amount;
    String pinnumber;
    Withdraw(String pinnumber){
         
         this.pinnumber= pinnumber;
        setLayout(null); 
          getContentPane().setBackground(Color.WHITE);
    	ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        
        JLabel text=new JLabel("Enter the amount You want to Withdraw");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(200,300,400,30);
        image.add(text);
        
        
         amount=new JTextField();
        amount.setFont(new Font("Railway",Font.BOLD,22));
        amount.setBounds(190,340,300,30);
        image.add(amount);
        
        
         withdraw=new JButton("Wihtdrawl");
        withdraw.setBounds(355,485,150,30);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
         back=new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
        
        
        
         setSize(900,900);
        setLocation(300,0);
        
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent e){
       if(e.getSource()==withdraw){
          String samount=amount.getText();
          Date date=new Date();
          
          if(samount.equals("")){
           JOptionPane.showMessageDialog(null,"Please Enter the amount that you want to withdraw");
          }else{
              try{
              
              Conn c=new Conn();
               ResultSet rs= c.s.executeQuery("Select * from bank where pin_Number='"+pinnumber+"'");
              //String query="insert into bank values('"+pinnumber+"','"+date+"','withdraw','"+samount+"')";
               int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    } else{
                        
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(e.getSource()!=back && balance < Integer.parseInt(samount) ){
                 JOptionPane.showMessageDialog(null,"Insufficient Balance");
                 return;
                }
                 String query="insert into bank values('"+pinnumber+"','"+date+"','withdraw','"+samount+"')";
             c.s.executeUpdate(query);
             JOptionPane.showMessageDialog(null,"Rs."+samount+"withdraw Successfully");
            
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
              
            }catch (Exception ae){
                 System.out.println(ae);   
              }
              }
       }  else if(e.getSource()==back){
           setVisible(false);
           new Transactions(pinnumber).setVisible(true);
           
       } 
    }
    public static void main(String args[]){
     new Withdraw("");    
    }
}

