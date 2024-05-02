package threadsync;

import static java.lang.Thread.sleep;

public class DepositTask implements Runnable{
    private  final Account account;

    public DepositTask(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        while (true) {
            try {
                account.deposit((int) (Math.random() * 10) + 1);
                sleep(1000);
            } catch (InterruptedException e) {
                System.err.println(e.getLocalizedMessage());
            }
        }
    }
}
