package thread_sort;

public class BubbleSort implements Runnable{
    private final Sorts sorts;

    public BubbleSort(Sorts sorts) {
        this.sorts = sorts;
    }

    @Override
    public void run() {
        sorts.bubbleSort(sorts.list, Sorts.ptr0, Sorts.ptr1);
    }
}
