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
        int min = Collections.min(list);
        int max = Collections.max(list);
        Integer[] aux = new Integer[a.length];
        Integer[] count = new Integer[max-min+1];
        Arrays.fill(count, 0);

        for (int i=0; i<a.length; i++) {
            count[a[i]-min] += 1;
        }

        for (int i=1; i<count.length; i++) {
            count[i] += count[i-1];
        }

        for (int i=a.length-1; i>=0; i--) {
            count[a[i]-min]--;
            aux[count[a[i]-min]] = a[i];
        }

        return aux;
    }
}
