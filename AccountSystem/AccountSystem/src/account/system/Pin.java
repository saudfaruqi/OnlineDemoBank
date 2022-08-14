package account.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener {
    JPasswordField currentPinField, newPinField, rePinField;
    JButton saveBtn,backBtn;
    JLabel label1, label2, label3, label4;
    Account account;

    Pin(Account account) {
        this.account = account;

        label1 = new JLabel("Update Your PIN");
        label1.setFont(new Font("System", Font.BOLD, 35));
        label1.setForeground(new Color(Constants.text_color));
        label1.setBounds(220,130,800,60);
        add(label1);

        label2 = new JLabel("Current PIN:");
        label2.setFont(new Font("System", Font.BOLD, 22));
        label2.setForeground(new Color(Constants.text_color));
        label2.setBounds(100,240,250,35);
        add(label2);

        label3 = new JLabel("New PIN:");
        label3.setFont(new Font("System", Font.BOLD, 22));
        label3.setForeground(new Color(Constants.text_color));
        label3.setBounds(100,300,250,35);
        add(label3);

        label4 = new JLabel("Re-Enter New PIN:");
        label4.setFont(new Font("System", Font.BOLD, 22));
        label4.setForeground(new Color(Constants.text_color));
        label4.setBounds(100,360,250,35);
        add(label4);

        currentPinField = new JPasswordField();
        currentPinField.setFont(new Font("Raleway", Font.BOLD, 22));
        currentPinField.setBounds(360,240,330,40);
        add(currentPinField);

        newPinField = new JPasswordField();
        newPinField.setFont(new Font("Raleway", Font.BOLD, 22));
        newPinField.setBounds(360,300,330,40);
        add(newPinField);

        rePinField = new JPasswordField();
        rePinField.setFont(new Font("Raleway", Font.BOLD, 22));
        rePinField.setBounds(360,360,330,40);
        add(rePinField);


        saveBtn = new JButton("Save");
        saveBtn.setFont(new Font("System", Font.BOLD, 18));
        saveBtn.setBackground(new Color(Constants.btn_bg_color));
        saveBtn.setForeground(new Color(Constants.text_color));
        saveBtn.addActionListener(this);
        saveBtn.setBounds(220,460,160,50);
        saveBtn.setFocusable(false);
        add(saveBtn);

        backBtn = new JButton("Back");
        backBtn.setFont(new Font("System", Font.BOLD, 18));
        backBtn.setBackground(new Color(Constants.btn_bg_color));
        backBtn.setForeground(new Color(Constants.text_color));
        backBtn.addActionListener(this);
        backBtn.setBounds(400,460,160,50);
        backBtn.setFocusable(false);
        add(backBtn);

        setTitle("Pin Change");
        getContentPane().setBackground(new Color(Constants.background_color));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,800);
        setLocation(500,90);
        setLayout(null);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == backBtn) {
            new Services(account).setVisible(true);
            setVisible(false);
        } else {
            try {
                int currentPin = Integer.parseInt(String.valueOf(currentPinField.getPassword()));
                int newPin = Integer.parseInt(String.valueOf(newPinField.getPassword()));
                int reEnterPin = Integer.parseInt(String.valueOf(rePinField.getPassword()));
                if(account.getAccountInfo().get(account.getCardNo()).equals(String.valueOf(currentPin))) {
                    if(newPin == reEnterPin) {
                        account.getAccountInfo().put(String.valueOf(account.getCardNo()), String.valueOf(newPin));
                        JOptionPane.showMessageDialog(null, "Pin has been updated successfully", "Updated", JOptionPane.PLAIN_MESSAGE);
                        new Login(account).setVisible(true);
                        setVisible(false);
                    } else {
                        JOptionPane.showMessageDialog(null, "Pin codes must match", "Unmatched", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong PIN", "Incorrect", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter valid PIN", "Invalid", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
