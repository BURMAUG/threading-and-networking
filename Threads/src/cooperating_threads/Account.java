package cooperating_threads;

import java.util.Formatter;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Account {
    Lock lock  = new ReentrantLock();
    Condition condition = lock.newCondition();
    volatile int balance = 0;
    Formatter fmt = new Formatter();

    void deposit(int amount) throws InterruptedException {
        lock.lock();
        this.balance += amount;
         condition.await();
        lock.unlock();
    }

    int withdrawal(int amount) throws InterruptedException {
        lock.lock();
        Thread.sleep(2);
        if (this.balance > amount) {
            this.balance -= amount;
//            System.out.println(this.balance);
            condition.signalAll();
        }
        lock.unlock();
        return balance;
    }
}
