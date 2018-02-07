package cc.yaboong.algorithms.sort;

/**
 * Created by yaboong on 2018. 1. 15..
 */
public class SelectionSortExec {
    public static void main(String[] args) {
//        String[] array = {"golf", "fox", "echo", "delta", "charlie", "bravo", "alpha"};
        Integer[] array = {2, 3, 1, 4, 5, 6};

        for (Integer v: array) { System.out.print(v + " "); }

        Selection.sort(array);
        System.out.print("\n");

        for (Integer v: array) { System.out.print(v + " "); }
    }
}
