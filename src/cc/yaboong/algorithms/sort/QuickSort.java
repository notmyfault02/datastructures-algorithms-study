package cc.yaboong.algorithms.sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by yaboong on 2018. 2. 18..
 */
public class QuickSort {
    public static void sort(Comparable[] a) {
        Collections.shuffle(Arrays.asList(a));
        sort(a, 0, a.length -1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int pivot = partition(a, lo, hi);
        sort(a, lo, pivot - 1);
        sort(a, pivot + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;     // lo 를 pivot 으로 사용

        while(true) {
            while (less(a[++i], a[lo])) // i 가 pivot 보다 작은 동안 i 스캔
                if (i == hi) break;     // 배열의 끝까지 갔으면 멈춤

            while (less(a[lo], a[--j])) // j 가 pivot 보다 큰 동안 j 스캔
                if (j == lo) break;     // 배열의 처음까지 갔으면 멈춤

            if (i >= j) break;          // 바깥 while 문 종료 조건. 이 조건이 여기 있지 않으면 서로 i 와 j 가 교차 되었을 때도 exch 를 해버리게 된다.

            // pivot 보다 큰 요소인데 왼쪽에 있는 것과, pivot 보다 작은데 오른쪽에 있는 것의 위치를 바꿈
            exch(a, i, j);
        }

        // pivot 을 기준으로 partition 이 끝나면 맨 왼쪽에 있던 pivot 을 파티션의 기준이 되는 자리로 보내줌
        // j 는 pivot 보다 작은 요소들의 마지막 위치를 가리키게 되기 때문에,
        // 파티션의 기준이 되는 자리는 j
        exch(a, lo, j);
        return j;
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    private static void exch(Comparable[] arr, int i, int j) {
        Comparable tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        Integer[] arr = {11, 18, 1, 20, 5, 12, 5, 16, 21, 9, 13, 17, 3, 24, 15, 19};
        System.out.println(Arrays.toString(arr));

        sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
