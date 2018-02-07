package cc.yaboong.ds.builtin;

import java.util.Stack;

/**
 * Created by yaboong on 2018. 1. 22..
 */
public class BuiltinStackExample {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        stack.pop();


        System.out.println(stack.peek());
        System.out.println(stack.toString());

    }
}
