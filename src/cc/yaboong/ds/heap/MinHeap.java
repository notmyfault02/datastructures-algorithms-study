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

    private int getLeftChildIndex(int parentIndex) { return (parentIndex << 1) + 1; }
    private int getRightChildIndex(int parentIndex) { return (parentIndex << 1) + 2; }
    private int getParentIndex(int childIndex) { return (childIndex - 1) >> 1; }

    // 자식 노드의 index 가 size 보다 작으면 자식노드가 존재하는 것.
    // 즉, 자식 노드의 index 를 구했는데 size 보다 크거나 같으면 자식노드가 없는 것이다. 그런 경우는 없어야 한다.
    // (그런 경우가 있다면 size 계산을 잘못 한 것이다) 배열로 구현했고 index 는 0 부터 시작했기 때문에 마지막 노드의 index 는 항상 size - 1 의 값을 가져야 하기 때문이다.
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
            items = Arrays.copyOf(items, capacity << 1);
            capacity = capacity << 1;
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

    private void buildMinHeap() {
        for (int i = (size >>> 1) - 1; i >= 0; i--) {
            heapifyDown(i);
        }
    }

    private void heapifyUp(int index) {                                     // 파라미터 index 의 값으로는 마지막 노드의 index 가 온다.
        while (hasParent(index) && less(items[index], parent(index))) {     // 재배치 하려는 노드의 부모노드가 존재하고, 재배치 하려는 노드가 부모노드 보다 작은 동안 반복
            int parentIndex = getParentIndex(index);                        // 부모노드의 index 가져와서
            swap(index, parentIndex);                                       // 부모노드와 자식노드의 위치 swap
            index = parentIndex;                                            // 반복
        }
    }

    private void heapifyDown(int index) {                                               // buildMinHeap() 에서 호출 될 때 이외에는 항상 index 0 이라는 값을 넘겨준다.
        while (hasLeftChild(index)) {                                                   // left child 가 없으면 right child 도 없다. 즉, child 가 있는 동안 반복.
            int smallerChildIndex = getLeftChildIndex(index);                           // 두 children 중 더 작은 노드를 찾는다. 일단은 left child 가 더 작다고 가정하고 시작
            if ( hasRightChild(index) && less( rightChild(index), leftChild(index) ) )  // right child 가 있고, right child 가 left child 보다 작으면
                smallerChildIndex = getRightChildIndex(index);                          // 더 작은 child 는 right child 로 지정

            if (less(items[index], items[smallerChildIndex]))                           // 재배치 하려는 노드가 자녀 노드보다 작으면 멈춤
                break;
            else                                                                        // 자녀 노드가 더 크거나 같으면
                swap(index, smallerChildIndex);                                         // swap

            index = smallerChildIndex;                                                  // 반복
        }
    }

    public void print() {
        for (int i=0; i<size; i++) {
            System.out.print(items[i].toString() + " ");
        }
        System.out.print("\n");
    }

    public T[] heapSort() {
        for (int i=size - 1; i >= 0; i--) {
            T max = poll();
            items[i] = max;
        }
        return items;
    }

    public static void main(String[] args) {
        Integer[] arrayOfInteger = {137440, 176640, 219000, 266110, 289000, 294730, 129000};
        MinHeap<Integer> integerMinHeap = new MinHeap<>(arrayOfInteger);
        integerMinHeap.print();

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
                else if (this.price > obj.price) return  1;
                else                             return  0;
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
        MinHeap<Product> productMinHeap = new MinHeap<>(arrayOfProduct);
        productMinHeap.print();
        Arrays.asList(productMinHeap.heapSort()).forEach(elem -> System.out.print(elem + " "));
        System.out.println();

        String[] arrayOfString = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P"};
        MinHeap<String> heap = new MinHeap<>(arrayOfString);
        String[] sortedIntArr = heap.heapSort();
        Arrays.asList(sortedIntArr).forEach(elem -> System.out.print(elem + " "));
    }
}
