package cc.yaboong.ds.heap;

/**
 * Created by yaboong on 2017. 8. 6..
 */

@SuppressWarnings("unchecked")
public class MinHeap2<T extends Comparable<T>> {

    /** TODO
     * Heapsort
     * Priority Queue
     */

    private static final int INIT_CAPACITY = 2;

    private int size;
    private T[] heap;


    public MinHeap2() {
        size = 0;
        heap = (T[]) new Comparable[INIT_CAPACITY];
    }


    public MinHeap2(T[] array) {
        size = array.length;
        heap = (T[]) new Comparable[size + 1];
        System.arraycopy(array, 0, heap, 1, size);
        buildMinHeap();
    }

    public void insert(T item) {
        if (isFull()) { resize(heap.length * 2); }
        heap[++size] = item;
        swim(size);
    }

    public T deleteMin() throws RuntimeException {
        if (size == 0) throw new RuntimeException("Heap is empty");
        if (size == heap.length / 4) resize(heap.length / 2);
        T min = heap[1];
        heap[1] = heap[size];
        heap[size--] = null;
        minHeapify(1);
        return min;
    }

    /**
     * Starts from "k = size / 2" because half of the size is always the parent of the last node in the array if the heap doesn't use index 0.
     */
    private void buildMinHeap() {
        for (int k = size / 2; k > 0; k--) minHeapify(k);
    }

    private void minHeapify(int k) {
        int min = 0;
        int l = 2 * k;
        int r = 2 * k + 1;

        if (l <= size && heap[l].compareTo(heap[k]) < 0)
            min = l;
        else
            min = k;

        if (r <= size && heap[r].compareTo(heap[min]) < 0)
            min = r;

        if (min != k) {
            swap(k, min);
            minHeapify(min);
        }
    }

    private void swap(int i, int j) {
        T tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    private void resize(int newSize) {
        T[] old = heap;
        heap = (T []) new Comparable[newSize];
        System.arraycopy(old, 1, heap, 1, size);
    }

    private void swim(int k) {
        while (k > 1 && heap[k].compareTo(heap[k / 2]) < 0) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    private boolean isFull() {
        return size == heap.length - 1;
    }

    public String toString() {
        String out = "";
        for(int k = 1; k <= size; k++) out += heap[k]+" ";
        return out;
    }

    public static void main(String[] args) {
        Integer[] input = {12,24,58,20,29,38,93,48,39,20,19,38,49,39,29,38};
        MinHeap2<Integer> heap = new MinHeap2<>(input);

        System.out.println(heap.toString());
    }
}
