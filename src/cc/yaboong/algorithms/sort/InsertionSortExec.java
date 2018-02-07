package cc.yaboong.algorithms.sort;

/**
 * Created by yaboong on 2018. 1. 15..
 */
public class InsertionSortExec {
    public static void main(String[] args) {
        String[] array = {"golf", "fox", "echo", "delta", "charlie", "bravo", "alpha"};

        for (String v: array) {
            System.out.print(v + " ");
        }

        Insertion.sort(array);
        System.out.print("\n");
        for (String v: array){
            System.out.print(v + " ");
        }
        assert Insertion.isSorted(array, array.length);
    }
}
