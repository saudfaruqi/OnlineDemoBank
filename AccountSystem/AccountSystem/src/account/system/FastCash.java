package account.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FastCash extends JFrame implements ActionListener {
    JLabel label1;
    JButton b1, b2, b3, b4, b5, b6, exitBtn;
    Account account;

    FastCash(Account account) {
        this.account = account;
        label1 = new JLabel("Select From The Options");
        label1.setForeground(new Color(Constants.text_color));
        label1.setFont(new Font("System", Font.BOLD, 38));
        label1.setBounds(140, 100, 700, 40);
        add(label1);

        b1 = new JButton("Rs. 1000");
        b1.setFont(new Font("System", Font.BOLD, 18));
        b1.setBackground(new Color(Constants.btn_bg_color));
        b1.setForeground(new Color(Constants.text_color));
        b1.addActionListener(this);
        b1.setBounds(40, 250, 300, 60);
        b1.setFocusable(false);
        add(b1);

        b2 = new JButton("Rs. 2000");
        b2.setFont(new Font("System", Font.BOLD, 18));
        b2.setBackground(new Color(Constants.btn_bg_color));
        b2.setForeground(new Color(Constants.text_color));
        b2.addActionListener(this);
        b2.setBounds(440, 250, 300, 60);
        b2.setFocusable(false);
        add(b2);


        b3 = new JButton("Rs. 3000");
        b3.setFont(new Font("System", Font.BOLD, 18));
        b3.setBackground(new Color(Constants.btn_bg_color));
        b3.setForeground(new Color(Constants.text_color));
        b3.addActionListener(this);
        b3.setBounds(40, 360, 300, 60);
        b3.setFocusable(false);
        add(b3);


        b4 = new JButton("Rs. 4000");
        b4.setFont(new Font("System", Font.BOLD, 18));
        b4.setBackground(new Color(Constants.btn_bg_color));
        b4.setForeground(new Color(Constants.text_color));
        b4.addActionListener(this);
        b4.setBounds(440, 360, 300, 60);
        b4.setFocusable(false);
        add(b4);


        b5 = new JButton("Rs. 5000");
        b5.setFont(new Font("System", Font.BOLD, 18));
        b5.setBackground(new Color(Constants.btn_bg_color));
        b5.setForeground(new Color(Constants.text_color));
        b5.addActionListener(this);
        b5.setBounds(40, 470, 300, 60);
        b5.setFocusable(false);
        add(b5);


        b6 = new JButton("Rs. 10000");
        b6.setFont(new Font("System", Font.BOLD, 18));
        b6.setBackground(new Color(Constants.btn_bg_color));
        b6.setForeground(new Color(Constants.text_color));
        b6.addActionListener(this);
        b6.setBounds(440, 470, 300, 60);
        b6.setFocusable(false);
        add(b6);


        exitBtn = new JButton("Exit");
        exitBtn.setFont(new Font("System", Font.BOLD, 18));
        exitBtn.setBackground(new Color(Constants.btn_bg_color));
        exitBtn.setForeground(new Color(Constants.text_color));
        exitBtn.addActionListener(this);
        exitBtn.setBounds(240, 600, 300, 60);
        exitBtn.setFocusable(false);
        add(exitBtn);

        setTitle("Services");
        getContentPane().setBackground(new Color(Constants.background_color));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(780, 800);
        setLocation(400, 20);
        setLayout(null);
    }

    private void withdraw(int amount) {
        int balance = account.getAmount();
        if(amount > balance) {
            JOptionPane.showMessageDialog(null, "Insufficient funds to withdraw this amount", "Insufficient Balance", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Rs. "+amount+" has been debited successfully", "Success", JOptionPane.PLAIN_MESSAGE);
            account.setAmount(balance - amount);
            account.setAccountStatement("Withdraw: Rs. " + amount + " has been withdrawn.");
            setVisible(false);
            new Services(account).setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b1) {
            withdraw(1000);
        } else if(ae.getSource() == b2) {
            withdraw(2000);
        } else if(ae.getSource() == b3) {
            withdraw(3000);
        } else if(ae.getSource() == b4) {
            withdraw(4000);
        } else if(ae.getSource() == b5) {
            withdraw(5000);
        } else if(ae.getSource() == b6) {
            withdraw(10000);
        } else {
            System.exit(0);
        }
        System.out.println("Amount in FastCash " + account.getAmount());
    }
}