package account.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JLabel label1, label2;
    JButton backBtn;
    Account account;
    BalanceEnquiry(Account account) {
        this.account = account;

        label1 = new JLabel("Please Review The Amount");
        label1.setFont(new Font("System", Font.BOLD, 35));
        label1.setBounds(150,150,800,60);
        label1.setForeground(new Color(Constants.text_color));
        add(label1);


        label2 = new JLabel("Available Balance: Rs. " + account.getAmount());
        label2.setFont(new Font("System", Font.BOLD, 18));
        label2.setForeground(new Color(Constants.text_color));
        label2.setBounds(270,250,600,50);
        add(label2);

        backBtn = new JButton("Back");
        backBtn.setFont(new Font("System", Font.BOLD, 14));
        backBtn.setBackground(new Color(Constants.btn_bg_color));
        backBtn.setForeground(new Color(Constants.text_color));
        backBtn.addActionListener(this);
        backBtn.setFocusable(false);
        backBtn.setBounds(345,350,150,40);
        add(backBtn);

        setTitle("Balance Enquiry");
        getContentPane().setBackground(new Color(Constants.background_color));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,800);
        setLocation(400,20);
        setLayout(null);
    }


    // Run on Click
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == backBtn){
            new Services(account).setVisible(true);
            setVisible(false);
        }
    }
}
