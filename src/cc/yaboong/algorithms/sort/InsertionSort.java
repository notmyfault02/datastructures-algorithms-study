package cc.yaboong.algorithms.sort;

import java.util.Arrays;

/**
 * Created by yaboong on 2018. 1. 15..
 */
public class InsertionSort {
    public static void insertionSort(Comparable[] arr){
        int N = arr.length;
        for(int i = 0; i < N; i++){
            for(int j = i; j > 0; j--){
                if(less(arr[j], arr[j-1])) exch(arr, j, j-1);
                else break;
            }
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

    public static boolean isSorted(Comparable[] array, int length) {
        boolean result=false;
        for(int i = 1; i < length; i++){
            if( (array[i-1].compareTo(array[i])) < 0 ) result = true;
            else result = false;
        }
        return result;
    }

    public static void main(String[] args) {
        insertionSort(new String[]{"G", "F", "E", "D", "C", "B", "A"});
    }
}
