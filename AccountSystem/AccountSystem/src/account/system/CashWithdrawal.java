package account.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CashWithdrawal extends JFrame implements ActionListener {

    JTextField textField;
    JButton withdrawBtn, backBtn, exitBtn;
    JLabel label1;
    Account account;
    
    CashWithdrawal(Account account) {
        this.account = account;
        label1 = new JLabel("Please Enter The Amount");
        label1.setFont(new Font("System", Font.BOLD, 35));
        label1.setBounds(150,150,800,60);
        label1.setForeground(new Color(Constants.text_color));
        add(label1);

        textField = new JTextField();
        textField.setFont(new Font("Raleway", Font.BOLD, 22));
        textField.setBounds(200,250,415,50);
        textField.setForeground(new Color(Constants.text_color));
        add(textField);



        withdrawBtn = new JButton("Withdraw");
        withdrawBtn.setFont(new Font("System", Font.BOLD, 18));
        withdrawBtn.setBackground(new Color(Constants.btn_bg_color));
        withdrawBtn.setForeground(new Color(Constants.text_color));
        withdrawBtn.addActionListener(this);
        withdrawBtn.setBounds(200,320,200,50);
        withdrawBtn.setFocusable(false);
        add(withdrawBtn);

        backBtn = new JButton("Back");
        backBtn.setFont(new Font("System", Font.BOLD, 18));
        backBtn.setBackground(new Color(Constants.btn_bg_color));
        backBtn.setForeground(new Color(Constants.text_color));
        backBtn.addActionListener(this);
        backBtn.setBounds(415,320,200,50);
        backBtn.setFocusable(false);
        add(backBtn);

        exitBtn = new JButton("Exit");
        exitBtn.setFont(new Font("System", Font.BOLD, 18));
        exitBtn.setBackground(new Color(Constants.btn_bg_color));
        exitBtn.setForeground(new Color(Constants.text_color));
        exitBtn.addActionListener(this);
        exitBtn.setFocusable(false);
        exitBtn.setBounds(310,390,200,50);
        add(exitBtn);


        setTitle("Cash Withdrawal");
        getContentPane().setBackground(new Color(Constants.background_color));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,800);
        setLocation(400,20);
        setLayout(null);
    }

    private void withdraw(int amount) {
        int balance = account.getAmount();
        if(amount > balance) {
            JOptionPane.showMessageDialog(null, "Insufficient funds to withdraw this amount", "Insufficient Balance", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Rs. "+amount+" has been debited successfully", "Success", JOptionPane.PLAIN_MESSAGE);
            textField.setText("");
            account.setAmount(balance - amount);
            account.setAccountStatement("Withdraw: Rs. " + amount + " has been withdrawn.");
            setVisible(false);
            new Services(account).setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int amount;
        if(ae.getSource() == backBtn){
            new Services(account).setVisible(true);
            setVisible(false);
        } else if (ae.getSource() == withdrawBtn) {
            try {
                amount = Integer.parseInt(textField.getText());
                withdraw(amount);
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter valid amount", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            System.exit(0);
        }
        System.out.println("Amount in  Cash Withdrawal " + account.getAmount());
    }
}
