package cc.yaboong.algorithms.sort;

import java.util.Arrays;

/**
 * Created by yaboong on 2018. 1. 15..
 */
public class SelectionSort {
    public static void selectionSort(Comparable[] arr){
        int N = arr.length;
        for (int i = 0; i < N; i++){
            int min = i;
            for (int j = i+1; j < N; j++)
                if (less(arr[j], arr[min])) min = j;
            exch(arr, i, min);
        }
        System.out.println(Arrays.toString(arr));
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
        selectionSort(new Integer[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1});
    }
}
