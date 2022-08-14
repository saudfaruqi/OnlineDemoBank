package account.system;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        new Login(account).setVisible(true);
    }
}
