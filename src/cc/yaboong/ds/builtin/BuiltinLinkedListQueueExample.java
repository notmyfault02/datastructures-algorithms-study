package cc.yaboong.ds.builtin;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yaboong on 2018. 1. 22..
 */
public class BuiltinLinkedListQueueExample {
    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        System.out.println(queue.remove());
        System.out.println(queue.toString());

    }
}
