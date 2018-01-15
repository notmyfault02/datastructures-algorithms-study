package cc.oyabun.sort;

/**
 * Created by yaboong on 2018. 1. 15..
 */
public class Insertion {

    public static void sort(Comparable[] a){
        int N = a.length;
        for(int i = 0; i < N; i++){
            for(int j = i; j > 0; j--){
                if(less(a[j],a[j-1])) exch(a, j, j-1);
                else break;
            }
        }
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static boolean isSorted(String[] array, int length) {
        boolean result=false;
        for(int i = 1; i < length; i++){
            if( (array[i-1].compareTo(array[i])) < 0 ) result = true;
            else result = false;
        }
        return result;
    }
}
