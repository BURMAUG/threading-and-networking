package threadsync;

public class WithdrawTask implements Runnable{
    private final Account account;

    public WithdrawTask(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        while (true) {
            try {
                account.withdraw((int) (Math.random()* 10) + 1);
            } catch (InterruptedException e) {
                System.err.println(e.getLocalizedMessage());
            }
        }

    }
}
