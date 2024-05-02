package cooperating_threads;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CoopApplication {
    private static final Account account = new Account();
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        int i = 0;
        while (i < 300){
            service.submit(new DepositPenny(account));
            service.submit(new Widrawal(account));
            i++;
        }
        service.shutdown();

        while (!service.isTerminated()){
        }

        System.out.println(account.balance);
    }
}
