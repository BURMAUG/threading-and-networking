import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrintA  extends Thread{
    int i;
    char letter;

    public PrintA(char letter) {
        this.letter = letter;
    }

    public void run() {
        for (i = 0; i < 100; i++) {
            System.out.println(letter);
        }
    }

    public static void main(String[] args) {
        PrintA printA = new PrintA('a');
        PrintA printB = new PrintA('b');

        try (ExecutorService executorService = Executors.newCachedThreadPool()) {
            executorService.execute(printA);
            executorService.execute(printB);
            executorService.shutdown();
        }
    }
}
