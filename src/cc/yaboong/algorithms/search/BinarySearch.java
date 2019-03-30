package cc.yaboong.algorithms.search;

import java.util.Scanner;

/**
 * Created by yaboong on 2018. 1. 30..
 */
public class BinarySearch {
    static int binarySearch(int[] arr, int lo, int hi, int target) {
        if (hi >= lo) {
            int mid = lo + (hi - lo) / 2;

            if (arr[mid] == target) return mid;

            if (arr[mid] > target) return binarySearch(arr, lo, mid-1, target);
            else              return binarySearch(arr, mid + 1, hi, target);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 18, 21};
        Scanner s = new Scanner(System.in);
        int find = Integer.parseInt(s.next());
        int foundIdx = binarySearch(arr, 0, arr.length - 1, find);
        System.out.println(foundIdx);
    }
}
