

package bankmanagementsystem;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;
public class MiniStatement extends JFrame{
    
    String pinnumber;
    
    MiniStatement(String pinnumber){
        this.pinnumber = pinnumber;
        
         setLayout(null);
         setTitle("Mini Statement");
          /*getContentPane().setBackground(Color.WHITE);
    	ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);*/
        
          JLabel mini=new JLabel();
          add(mini);
          mini.setBounds(20,140,400,200);
          
        JLabel bank=new JLabel("CENTRAL BANK");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);
        
        JLabel bal=new JLabel();
            
            bal.setBounds(20,600,400,30);
            add(bal);
        
        try{
            Conn c=new Conn();
           ResultSet rs= c.s.executeQuery("select * from login where pin_Number='"+pinnumber+"'");
            while(rs.next()){
                card.setText("CARD NUMBER:"+rs.getString("card_Number").substring(0,4)+"XXXXXXXX"+rs.getString("card_Number").substring(12));
            }
            
        }catch(Exception e){
         System.out.println(e);
        }
        
         try{
            Conn c=new Conn();
            int balance = 0;
           ResultSet rs= c.s.executeQuery("select * from bank where pin_Number='"+pinnumber+"'");
            while(rs.next()){
                
                mini.setText(mini.getText()+"<html>" + rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;"+ rs.getString("amount")+ "<br><br><html>");
                
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    } else{
                        
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
            }
              bal.setText("Your current account balance is Rs." +balance);
            
        }catch(Exception e){
         System.out.println(e);
        }
         
        
          setSize(400,600);
        setLocation(300,200);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    public static void main(String args[]){
        
        new MiniStatement("");
    }
}
