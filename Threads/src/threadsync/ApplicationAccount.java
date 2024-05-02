package threadsync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ApplicationAccount {
    static Account account;
    public static void main(String[] args) {
        account = new Account();
        try(ExecutorService ex = Executors.newFixedThreadPool(5)) {
            ex.execute(new DepositTask(account));
            ex.execute(new DepositTask(account));
            ex.execute(new DepositTask(account));
            ex.execute(new WithdrawTask(account));
            ex.execute(new WithdrawTask(account));
            ex.shutdown();
        }
    }
}
