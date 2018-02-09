package cc.yaboong.ds.heap;

import java.util.Arrays;

/**
 * Created by yaboong on 2018. 2. 9..
 */

@SuppressWarnings("unchecked")
public class MinHeap <T extends Comparable<T>> {
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity = DEFAULT_CAPACITY;
    private int size = 0;

    T[] items = (T[]) new Comparable[DEFAULT_CAPACITY];

    private int getLeftChildIndex(int parentIndex) { return 2 * parentIndex + 1; }
    private int getRightChildIndex(int parentIndex) { return 2 * parentIndex + 2; }
    private int getParentIndex(int childIndex) { return (childIndex - 1) / 2; }

    private boolean hasLeftChild(int index) { return getLeftChildIndex(index) < size; }
    private boolean hasRightChild(int index) { return getRightChildIndex(index) < size; }
    private boolean hasParent(int index) { return getParentIndex(index) >= 0; }

    private T leftChild(int index) { return items[getLeftChildIndex(index)]; }
    private T rightChild(int index) { return items[getRightChildIndex(index)]; }
    private T parent(int index) { return items[getParentIndex(index)]; }

    private void swap(int indexA, int indexB) {
        T temp = items[indexA];
        items[indexA] = items[indexB];
        items[indexB] = temp;
    }

    private void ensureExtraCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    public T peek() {
        if (size == 0) throw new IllegalStateException();
        return items[0];
    }

    public T poll() {
        if (size == 0) throw new IllegalStateException();
        T item = items[0];
        items[0] = items[--size];
        items[size] = null;
        heapifyDown();
        return item;
    }

    public void add(T item) {
        ensureExtraCapacity();
        items[size++] = item;
        heapifyUp();
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && less(items[index], parent(index))) {
            int parentIndex = getParentIndex(index);
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) { // left child 가 없으면 right child 도 없다
            int smallerChildIndex = getLeftChildIndex(index);
            if ( hasRightChild(index) && less( rightChild(index), leftChild(index) ) )
                smallerChildIndex = getRightChildIndex(index);

            if (less(items[index], items[smallerChildIndex]))
                break;
            else
                swap(index, smallerChildIndex);

            index = smallerChildIndex;
        }
    }

    public void print() {
        for (int i=0; i<size; i++) {
            System.out.print(items[i] + " ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        MinHeap<Integer> minHeap = new MinHeap<>();

        minHeap.add(13);
        minHeap.add(12);
        minHeap.add(11);
        minHeap.add(10);
        minHeap.add(9);
        minHeap.add(8);
        minHeap.add(7);
        minHeap.add(6);
        minHeap.add(5);
        minHeap.add(4);
        minHeap.add(3);
        minHeap.add(2);
        minHeap.add(1);
        minHeap.print();

        minHeap.poll();
        minHeap.print();
    }
}
