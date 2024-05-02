package cooperating_threads;

public class DepositPenny implements Runnable{
    private Account account;

    public DepositPenny(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        try {
            System.out.println("Deposit " + account.balance);
            account.deposit(20123213);
        } catch (InterruptedException _) {
        }
    }
}
