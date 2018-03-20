package cc.yaboong.algorithms.sort;

import java.util.*;

/**
 * Created by yaboong on 2018. 3. 20..
 */
public class CountingSortBig {
    public static void main(String[] args) {
        Integer[] a = {Integer.MAX_VALUE - 1000, Integer.MAX_VALUE, Integer.MAX_VALUE-100};

        a = sort(a);

        System.out.println(Arrays.toString(a));
    }

    public static Integer[] sort(Integer[] a) {
        List<Integer> list = Arrays.asList(a);
        int min = Collections.min(list);            // 최소값도 구한다
        int max = Collections.max(list);
        Integer[] aux = new Integer[a.length];
        Integer[] c = new Integer[max-min+1];   // c 배열 생성
        Arrays.fill(c, 0);

        for (int i=0; i<a.length; i++) {
            c[a[i]-min] += 1;               // min 값을 빼준다
        }

        for (int i=1; i<c.length; i++) {
            c[i] += c[i-1];
        }

        for (int i=a.length-1; i>=0; i--) {
            aux[--c[a[i]-min]] = a[i];      // min 값을 빼준다
        }

        return aux;
    }
}
