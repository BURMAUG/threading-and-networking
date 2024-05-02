package thread_sort;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Sorts {
    volatile int[] list = {21,23,3,1,5,12};
     static volatile int  ptr0 = 1;
     static volatile int  ptr1 = 0;

     Lock lock = new ReentrantLock();

    public void bubbleSort(int[] list, int i, int j){
        lock.lock();
        for (i = ptr0; i < list.length; i++){
            for (j = ptr1; j < list.length-1; j++){
                if (list[i] < list[j]){
                    int tmp = list[i];
                    list[i] = list[j];
                    list[j] = tmp;
                }
            }
        }
        lock.unlock();
    }

    public static void main(String[] args) {
        Sorts sort = new Sorts();
        System.out.println(Arrays.toString(sort.list));
        try (ExecutorService executorService = Executors.newFixedThreadPool(9)) {
            executorService.execute(new BubbleSort(sort));
        }
        System.out.println(Arrays.toString(sort.list));

    }
}
