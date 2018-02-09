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
        Node oldHead = head;   // 기존의 head 를 잠시 다른 녀석으로 가리키게 해 두고
        head = new Node();     // 새로운 head 를 만든다
        head.item = item;
        head.next = oldHead;   // 새로운 head 가 기존의 head 를 가리키게 한다
    }

    public E pop() {
        if(!isEmpty()){         // stack 이 비어있지 않으면
            E item = head.item; // 현재 head 의 item 을 반환하고
            head = head.next;   // head 다음 node 를 head 로 만들어 준다
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
