package threadsync;

public class AddPennyTask implements Runnable{
   private final Account account;

    public AddPennyTask(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        try {
            account.deposit(1);
        } catch (InterruptedException e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
