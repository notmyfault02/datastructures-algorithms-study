package cc.yaboong.algorithms.sort;

import java.util.*;

/**
 * Created by yaboong on 2018. 3. 20..
 */
public class CountingSort {
    public static void main(String[] args) {
        Integer[] a = {1, 0, 3, 1, 3, 1};

        a = sort(a);

        System.out.println(Arrays.toString(a));
    }

    public static Integer[] sort(Integer[] a) {
        int max = Collections.max(Arrays.asList(a));
        Integer[] aux = new Integer[a.length];
        Integer[] c = new Integer[max+1];
        Arrays.fill(c, 0);

        // 각 원소 갯수 계산
        for (int i=0; i<a.length; i++) {
            c[a[i]] += 1;
        }

        // 누적합 계산
        for (int i=1; i<c.length; i++) {
            c[i] += c[i-1];
        }

        // 누적합을 이용해 정렬
        for (int i=a.length-1; i>=0; i--) {
            aux[--c[a[i]]] = a[i];
        }

        return aux;
    }
}
