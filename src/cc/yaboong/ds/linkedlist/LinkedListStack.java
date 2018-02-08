package cc.yaboong.ds.linkedlist;


/**
 * Created by yaboong on 2017. 7. 11..
 */
public class LinkedListStack<E extends Comparable<E>> {
    private Node head = null;

    private class Node {
        E item;
        Node next;
    }

    public boolean isEmpty(){
        return head==null;
    }

    public void push(E item) {
        Node oldFirst = head;
        head = new Node();
        head.item = item;
        head.next = oldFirst;
    }

    public E pop() {
        if(!isEmpty()){
            E item = head.item;
            head = head.next;
            return item;
        }
        else {
            System.out.println("Stack is empty.");
            return null;
        }
    }

    public void print(){
        Node iter = head;
        while(iter.next != null) {
            System.out.print(iter.item + "->");
            iter = iter.next;
        }
        System.out.println(iter.item);
    }

    public static void main(String[] args){
        LinkedListStack<Integer> stack = new LinkedListStack();

        stack.push(1);  // 1
        stack.push(2);  // 2 1
        stack.push(3);  // 3 2 1
        stack.print();

        stack.pop();          // 2 1
        stack.pop();          // 1
        stack.print();

        stack.push(10); // 10 1
        stack.push(11); // 11 10 1
        stack.push(12); // 12 11 10 1
        stack.push(13); // 13 12 11 10 1
        stack.push(14); // 14 13 12 11 10 1
        stack.pop();          // 13 12 11 10 1
        stack.pop();          // 12 11 10 1
        stack.pop();          // 11 10 1

        stack.print();
    }
}
