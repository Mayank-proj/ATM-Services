
package bankmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener{
    
    
    JButton deposit,fastcash,balanceEnquiry,exit,withdrawl,pinchange,statement;
    String pinnumber;
    Transactions(String pinnumber){
            this.pinnumber=pinnumber;
        setTitle("AUTOMATED TELLER MACHINE");
        
         setLayout(null);
         
          getContentPane().setBackground(Color.WHITE);
    	ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        
        
        JLabel text=new JLabel("Please select your Transaction");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
      image.add(text);
        
        
         deposit=new JButton("Deposit");
        deposit.setBounds(170,415,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
         withdrawl=new JButton("Cash Withdrawl");
        withdrawl.setBounds(350,415,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        
         fastcash=new JButton("Fast Cash");
        fastcash.setBounds(170,450,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);
        
         statement=new JButton("Mini Statement");
        statement.setBounds(350,450,150,30);
        statement.addActionListener(this);
        image.add(statement);
        
        
         pinchange=new JButton("Pin change");
        pinchange.setBounds(170,490,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);
        
        
         balanceEnquiry=new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(350,490,150,30);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);
        
          
         exit=new JButton("EXIT");
        exit.setBounds(350,525,150,25);
        exit.addActionListener(this);
        image.add(exit);  
        
        
        
        
       setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
             
        
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==exit){
            System.exit(0);
        }else if(e.getSource()==deposit){
         setVisible(false);
         new Deposit(pinnumber).setVisible(true);
        }else if(e.getSource()==withdrawl){
          setVisible(false);
          new Withdraw(pinnumber).setVisible(true);
        }else if(e.getSource()==fastcash){
           setVisible(false);
           new FastCash(pinnumber).setVisible(true);
           
        }else if(e.getSource()==pinchange){
           setVisible(false);
           new PinChange(pinnumber).setVisible(true);
        }else if(e.getSource()==balanceEnquiry){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(e.getSource()==statement){
          
            new MiniStatement(pinnumber).setVisible(true);
        }
          
       }
    
    public static void main(String args[]){
       new Transactions(""); 
    }
}
  