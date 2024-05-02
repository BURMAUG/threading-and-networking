package threadsync;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private static final Lock lock = new ReentrantLock();
    private int balance = 0;
    private static final Condition newDeposit = lock.newCondition();

    public int getBalance() {
        return balance;
    }

    public  void deposit(int amount) throws InterruptedException {
        lock.lock();
        try {
            this.balance += amount;
            System.out.println("Deposited: " + amount + "\t\t\t" + getBalance());
            newDeposit.signalAll();
        }
        finally {
            lock.unlock();
        }
    }

    public void withdraw(int amount) throws InterruptedException {
        // If the amount is 0 or less throw an exception with a message accompanying that
        lock.lock();
        while (this.balance < amount) {
            System.out.println("\t\t\tWait for deposit.");
            newDeposit.await();
        }
        this.balance -= amount;
        System.out.println("Current Balance: " + getBalance() + " withdrawal amount: " + amount);
        lock.unlock();
    }
}
