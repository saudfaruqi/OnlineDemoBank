package account.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Statement extends JFrame implements ActionListener {
    JLabel label1, label2;
    JButton backBtn, printBtn;
    Account account;

    Statement(Account account) {
        this.account = account;
        for (Map.Entry<String, JLabel> statement : account.getAccountStatement().entrySet()) {
            JLabel label = statement.getValue();
            label.setFont(new Font("System", Font.PLAIN, 18));
            label.setBounds(50,80 + (Integer.parseInt(statement.getKey()) * 30),800,60);
            label.setForeground(new Color(Constants.text_color));
            add(label);
        }


        label1 = new JLabel("Account Statement");
        label1.setFont(new Font("System", Font.BOLD, 35));
        label1.setBounds(230,50,800,60);
        label1.setForeground(new Color(Constants.text_color));
        add(label1);

        printBtn = new JButton("Print");
        printBtn.setFont(new Font("System", Font.BOLD, 14));
        printBtn.setBackground(new Color(Constants.btn_bg_color));
        printBtn.setForeground(new Color(Constants.text_color));
        printBtn.addActionListener(this);
        printBtn.setFocusable(false);
        printBtn.setBounds(250,500,150,40);
        add(printBtn);

        backBtn = new JButton("Back");
        backBtn.setFont(new Font("System", Font.BOLD, 14));
        backBtn.setBackground(new Color(Constants.btn_bg_color));
        backBtn.setForeground(new Color(Constants.text_color));
        backBtn.addActionListener(this);
        backBtn.setFocusable(false);
        backBtn.setBounds(400,0,150,40);
        add(backBtn);

        setTitle("Statement");
        getContentPane().setBackground(new Color(Constants.background_color));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,00);
        setLocation(500,20);
        setLayout(null);
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == printBtn)  {
                FileWriter file = null;
                String text = "";
                String path = System.getProperty("os.name").contains("Linux") ? "statement.txt" : "F:\\statement.txt";
                try {
                    file = new FileWriter(path);
                    for (Map.Entry<String, JLabel> statement : account.getAccountStatement().entrySet()) {
                        JLabel label = statement.getValue();
                        text += statement.getKey() + ". " + label.getText() + " \n";
                    }
                    file.write(text);
                    file.close();
                    JOptionPane.showMessageDialog(null, "Statement file is saved at path " + path, "Statement Printed", JOptionPane.PLAIN_MESSAGE);
                } catch (IOException e) {
                    System.out.println(e);
                    throw new RuntimeException(e);
                }

        }
        new Services(account).setVisible(true);
        setVisible(false);
    }
}
