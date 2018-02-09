package cc.yaboong.ds.heap;

import java.util.Arrays;

/**
 * Created by yaboong on 2018. 2. 9..
 */

@SuppressWarnings("unchecked")
public class MinHeap <T extends Comparable<T>> {
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity;
    private int size;
    private T[] items;


    public MinHeap() {
        capacity = DEFAULT_CAPACITY;
        items = (T[]) new Comparable[capacity];
        size = 0;
    }

    public MinHeap(T[] inputArray) {
        size = inputArray.length;
        capacity = size;
        items = Arrays.copyOf(inputArray, size);
        buildMinHeap();
    }

    private void buildMinHeap() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapifyDown(i);
        }
    }

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
        heapifyDown(0);
        return item;
    }

    public void add(T item) {
        ensureExtraCapacity();
        items[size++] = item;
        heapifyUp(size - 1);
    }

    private void heapifyUp(int index) {
        while (hasParent(index) && less(items[index], parent(index))) {
            int parentIndex = getParentIndex(index);
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private void heapifyDown(int index) {
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
            System.out.print(items[i].toString() + " ");
        }
        System.out.print("\n");
    }

    public static void main(String[] args) {
        Integer[] arrayOfInteger = {137440, 176640, 219000, 266110, 289000, 294730, 129000};
        MinHeap<Integer> minHeap = new MinHeap<>(arrayOfInteger);
        minHeap.print();

        class Product implements Comparable<Product> {
            String name;
            int price;

            public Product(String name, int price) {
                super();
                this.name = name;
                this.price= price;
            }

            @Override
            public int compareTo(Product obj) {
                if      (this.price < obj.price) return -1;
                else if (this.price > obj.price) return 1;
                else                                   return 0;
            }

            public String toString() {
                return "{" + this.name + ", " + this.price + "}";
            }
        }

        Product[] arrayOfProduct = {
                new Product("알파스캔 24형 AOC 2470", 137440),
                new Product("알파스캔 2481 IPS", 176640),
                new Product("알파스캔 광시야각 AOC 2779", 219000),
                new Product("알파스캔 27형 AOC 2777", 266110),
                new Product("알파스캔 광시야각 AOC 3288", 289000),
                new Product("알파스캔 게이밍 무결점 AOC G2460", 294730),
                new Product("알파스캔 프레스티지 2215", 129000)
        };
        MinHeap<Product> personMinHeap = new MinHeap<>(arrayOfProduct);
        personMinHeap.print();
    }
}
