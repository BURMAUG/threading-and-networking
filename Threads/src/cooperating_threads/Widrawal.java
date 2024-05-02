package cooperating_threads;

import java.util.Random;

public class Widrawal implements Runnable{
    private Account account;

    public Widrawal(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        try {
            System.out.println("Withdrawal" + account.balance);
            account.withdrawal(new Random(2).nextInt(12)* 200);
            System.out.println("New balance" + account.balance);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
