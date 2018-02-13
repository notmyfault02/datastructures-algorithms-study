package cc.yaboong.algorithms.sort;

import java.util.Arrays;

/**
 * Created by yaboong on 2018. 2. 14..
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int temp = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j= 1 ; j < arr.length-i; j++) {
                if(arr[j]<arr[j-1]) {
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        bubbleSort(new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1});
    }
}
