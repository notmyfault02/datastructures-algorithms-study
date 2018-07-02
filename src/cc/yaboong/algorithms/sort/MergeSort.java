package cc.yaboong.algorithms.sort;

import java.util.Arrays;

/**
 * Created by yaboong on 2018. 2. 14..
 */
public class MergeSort {
    // 병합하면서 정렬한다
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){
        // lo 인덱스 부터 hi 인덱스까지 보조배열 aux 에 카피한다. hi-lo+1 은 length 를 의미한다.
        System.arraycopy(a, lo, aux, lo, hi-lo+1);

        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++){
            if (i > mid) {
                a[k] = aux[j++];
            }
            else if (j > hi) {
                a[k] = aux[i++];
            }
            else if (less(aux[j],aux[i])) {
                a[k] = aux[j++];
            }
            else {
                a[k] = aux[i++];
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void mergeSort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if(hi <= lo) return;            // 쪼갤 수 있는 범위를 벗어나면 return
        int mid = lo + (hi - lo)/2;     // 중간 인덱스
        mergeSort(a, aux, lo, mid);        // 왼쪽 반을 또 쪼갬
        mergeSort(a, aux, mid+1, hi);  // 오른쪽 반을 또 쪼갬
        merge(a, aux, lo, mid, hi);     // 병합
    }

    public static void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];        // 보조 배열 하나 생성. 재귀호출 밖에서 해줘야함.
        mergeSort(a, aux, 0, a.length-1);              // 재귀적으로 배열을 쪼갠다.
    }

    public static void main(String[] args) {
        Integer[] arr = {2, 3, 14, 10, 8, 1, 12, 9};
        System.out.println(Arrays.toString(arr));

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
