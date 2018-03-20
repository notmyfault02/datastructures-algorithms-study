package cc.yaboong.algorithms.sort;

import java.util.Arrays;
import java.util.Collections;

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
        Integer[] count = new Integer[max+1];
        Arrays.fill(count, 0);

        for (int i=0; i<a.length; i++) {
            count[a[i]] += 1;
        }

        for (int i=1; i<count.length; i++) {
            count[i] += count[i-1];
        }

        for (int i=a.length-1; i>=0; i--) {
            count[a[i]]--;
            aux[count[a[i]]] = a[i];
        }

        return aux;
    }
}
