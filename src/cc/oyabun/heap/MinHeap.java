package cc.oyabun.heap;

/**
 * Created by yaboong on 2017. 8. 6..
 */
@SuppressWarnings("unchecked")
public class MinHeap<E extends Comparable<E>> {

    /** TODO
     * Resize method: Doubles the heap when it's full, and reduce it to half when it's 1/4 full
     * Insert method
     * Delete method
     * Heapsort
     * Priority Queue
     */

    private static final int CAPACITY = 2;

    private int size;
    private E[] heap;

    public MinHeap() {
        size = 0;
        heap = (E[]) new Comparable[CAPACITY];
    }

    public MinHeap(Integer[] array) {
        size = array.length;
        heap = (E[]) new Comparable[array.length + 1];
        System.arraycopy(array, 0, heap, 1, array.length);
        buildMinHeap();
    }

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
            exch(k, min);
            minHeapify(min);
        }
    }

    private void exch(int i, int j) {
        E tmp = heap[i];
        heap[i] = heap[j];
        heap[j] = tmp;
    }

    public String toString() {
        String out = "";
        for(int k = 1; k <= size; k++) out += heap[k]+" ";
        return out;
    }

    public static void main(String[] args) {
        Integer[] input = {10,9,8,7,6,5,4,3,2,1};
        MinHeap<Integer> heap = new MinHeap<Integer>(input);

        System.out.println(heap.toString());
    }
}
