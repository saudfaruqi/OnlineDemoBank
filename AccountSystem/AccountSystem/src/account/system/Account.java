package account.system;

import javax.swing.*;
import java.util.HashMap;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Account {
    private HashMap<String, String> accountInfo = new HashMap<String, String>();
    private HashMap<String, JLabel> accountStatement = new HashMap<String, JLabel>();
    private int amount;

    Account(){
        accountInfo.put("dha","2022");
        this.amount = 00000;
    }

    protected HashMap<String, String> getAccountInfo() {
        return accountInfo;
    }

    protected HashMap<String, JLabel> getAccountStatement() {
        return accountStatement;
    }

    protected void setAccountStatement(String value) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        accountStatement.put(String.valueOf(accountStatement.size() + 1), new JLabel(dtf.format(now) + ", " + value + " Balance: " + getAmount()));
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Object getCardNo() {
        return accountInfo.keySet().toArray()[0];
    }
}
