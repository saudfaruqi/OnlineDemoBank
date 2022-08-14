package account.system;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
    private HashMap<String, String> accountInfo = new HashMap<String, String>();
    Account account;
    JLabel label1, label2, label3;
    JTextField cardInput;
    JPasswordField passwordInput;
    JButton signInBtn, clearBtn;

    Login(Account account) {
        this.account = account;
        this.accountInfo = account.getAccountInfo();
        // Display labels
        
        label1 = new JLabel("Please Enter The PIN");
        label1.setForeground(new Color(Constants.text_color));
        label1.setFont(new Font("Osward", Font.BOLD, 38));
        label1.setBounds(175, 50, 450, 200);
        add(label1);

        label2 = new JLabel("Card:");
        label2.setForeground(new Color(Constants.text_color));
        label2.setFont(new Font("Raleway", Font.BOLD, 28));
        label2.setBounds(125, 150, 375, 200);
        add(label2);

        label3 = new JLabel("PIN:");
        label3.setForeground(new Color(Constants.text_color));
        label3.setFont(new Font("Raleway", Font.BOLD, 28));
        label3.setBounds(125, 225, 375, 200);
        add(label3);

        // Display Card Input
        cardInput = new JTextField(15);
        cardInput.setBounds(300, 235, 230, 30);
        cardInput.setFont(new Font("Arial", Font.BOLD, 14));
        cardInput.setForeground(new Color(Constants.text_color));
        add(cardInput);

        // Display Password Input
        passwordInput = new JPasswordField(15);
        passwordInput.setFont(new Font("Arial", Font.BOLD, 14));
        passwordInput.setBounds(300, 310, 230, 30);
        passwordInput.setForeground(new Color(Constants.text_color));
        add(passwordInput);


        // Display Sign In Button
        signInBtn = new JButton("SIGN IN");
        signInBtn.setBackground(new Color(Constants.btn_bg_color));
        signInBtn.setForeground(new Color(Constants.text_color));
        signInBtn.setFont(new Font("Arial", Font.BOLD, 14));
        signInBtn.setBounds(300, 400, 100, 30);
        signInBtn.addActionListener(this);
        signInBtn.setFocusable(false);
        add(signInBtn);

        // Display Clear Button
        clearBtn = new JButton("CLEAR");
        clearBtn.setBackground(new Color(Constants.btn_bg_color));
        clearBtn.setForeground(new Color(Constants.text_color));
        clearBtn.setFont(new Font("Arial", Font.BOLD, 14));
        clearBtn.setBounds(430, 400, 100, 30);
        clearBtn.addActionListener(this);
        clearBtn.setFocusable(false);
        add(clearBtn);

        // Setting background color
        setTitle("Welcome to Online Banking");
        getContentPane().setBackground(new Color(Constants.background_color));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(750, 650);
        setLocation(400, 100);
        setLayout(null);
    }


    /**
     * Verifies the account credentials
     * @param cardNo card number of account
     * @param password pin of the card
     */
    public void verifyAccount(String cardNo, String password) {
        if(accountInfo.containsKey(cardNo)) {
            if(accountInfo.get(cardNo).equals(password)) {
                new Services(account).setVisible(true);
                setVisible(false);
            }
            else {
                JOptionPane.showMessageDialog(null, "Wrong PIN", "Incorrect", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Card not found", "404", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
            String card = cardInput.getText();
            String password = String.valueOf(passwordInput.getPassword());
            if(ae.getSource() == signInBtn) {
                verifyAccount(card, password);
            } else {
                cardInput.setText("");
                passwordInput.setText("");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error: " + e);
        }
    }


}