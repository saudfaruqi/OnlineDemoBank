package account.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Services extends JFrame implements ActionListener {
    Account account;
    JLabel label1;
    JButton depositBtn, withdrawBtn, fastCashBtn, miniStatementBtn, pinChangeBtn, balanceEnquiryBtn, exitBtn;

    Services(Account account) {
        this.account = account;
        label1 = new JLabel("Select Services");
        label1.setForeground(new Color(Constants.text_color));
        label1.setFont(new Font("System", Font.BOLD, 38));
        label1.setBounds(230,100,700,40);
        add(label1);

        fastCashBtn = new JButton("Fast Cash");
        fastCashBtn.setFont(new Font("System", Font.BOLD, 18));
        fastCashBtn.setBackground(new Color(Constants.btn_bg_color));
        fastCashBtn.setForeground(new Color(Constants.text_color));
        fastCashBtn.addActionListener(this);
        fastCashBtn.setBounds(40,250,300,60);
        fastCashBtn.setFocusable(false);
        add(fastCashBtn);

        withdrawBtn = new JButton("Cash Withdrawal");
        withdrawBtn.setFont(new Font("System", Font.BOLD, 18));
        withdrawBtn.setBackground(new Color(Constants.btn_bg_color));
        withdrawBtn.setForeground(new Color(Constants.text_color));
        withdrawBtn.addActionListener(this);
        withdrawBtn.setBounds(440,250,300,60);
        withdrawBtn.setFocusable(false);
        add(withdrawBtn);


        depositBtn = new JButton("Deposit");
        depositBtn.setFont(new Font("System", Font.BOLD, 18));
        depositBtn.setBackground(new Color(Constants.btn_bg_color));
        depositBtn.setForeground(new Color(Constants.text_color));
        depositBtn.addActionListener(this);
        depositBtn.setBounds(40,360,300,60);
        depositBtn.setFocusable(false);
        add(depositBtn);


        miniStatementBtn = new JButton("Statement");
        miniStatementBtn.setFont(new Font("System", Font.BOLD, 18));
        miniStatementBtn.setBackground(new Color(Constants.btn_bg_color));
        miniStatementBtn.setForeground(new Color(Constants.text_color));
        miniStatementBtn.addActionListener(this);
        miniStatementBtn.setBounds(440,360,300,60);
        miniStatementBtn.setFocusable(false);
        add(miniStatementBtn);



        balanceEnquiryBtn = new JButton("Balance Enquiry");
        balanceEnquiryBtn.setFont(new Font("System", Font.BOLD, 18));
        balanceEnquiryBtn.setBackground(new Color(Constants.btn_bg_color));
        balanceEnquiryBtn.setForeground(new Color(Constants.text_color));
        balanceEnquiryBtn.addActionListener(this);
        balanceEnquiryBtn.setBounds(40,470,300,60);
        balanceEnquiryBtn.setFocusable(false);
        add(balanceEnquiryBtn);



        pinChangeBtn = new JButton("Pin Change");
        pinChangeBtn.setFont(new Font("System", Font.BOLD, 18));
        pinChangeBtn.setBackground(new Color(Constants.btn_bg_color));
        pinChangeBtn.setForeground(new Color(Constants.text_color));
        pinChangeBtn.addActionListener(this);
        pinChangeBtn.setBounds(440,470,300,60);
        pinChangeBtn.setFocusable(false);
        add(pinChangeBtn);


        exitBtn = new JButton("Exit");
        exitBtn.setFont(new Font("System", Font.BOLD, 18));
        exitBtn.setBackground(new Color(Constants.btn_bg_color));
        exitBtn.setForeground(new Color(Constants.text_color));
        exitBtn.addActionListener(this);
        exitBtn.setBounds(240,600,300,60);
        exitBtn.setFocusable(false);
        add(exitBtn);

        setTitle("Services");
        getContentPane().setBackground(new Color(Constants.background_color));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(780,800);
        setLocation(400,20);
        setLayout(null);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == fastCashBtn) {
            new FastCash(account).setVisible(true);
        } else if (ae.getSource() == withdrawBtn) {
            new CashWithdrawal(account).setVisible(true);
        } else if(ae.getSource() == depositBtn) {
            new Deposit(account).setVisible(true);
        } else if(ae.getSource() == balanceEnquiryBtn) {
            new BalanceEnquiry(account).setVisible(true);
        } else if(ae.getSource() == pinChangeBtn) {
            new Pin(account).setVisible(true);
        } else if(ae.getSource() == miniStatementBtn) {
            new Statement(account).setVisible(true);
        } else {
            System.exit(0);
        }
        setVisible(false);
    }
}
