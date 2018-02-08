package cc.yaboong.ds.linkedlist;

/**
 * Created by yaboong on 2018. 1. 15..
 */
public class LinkedListQueue<E extends Comparable<E>> {
    private Node head, tail;

    private class Node{
        E item;
        Node next;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void enqueue(E item){
        Node oldlast = tail;
        tail = new Node();
        tail.item = item;
        tail.next = null;
        if(isEmpty()) head = tail;
        else oldlast.next = tail;
    }

    public E dequeue(){
        if(isEmpty()){
            tail = head;
            System.out.println("Queue is empty");
            return null;
        }
        else{
            E item = head.item;
            head = head.next;
            return item;
        }
    }

    public void print(){
        Node mover = head;
        while(mover != null){
            System.out.println(mover.item);
            mover = mover.next;
        }
    }

    public static void main(String[] args) {
        LinkedListQueue<String> queue = new LinkedListQueue<>();

        queue.enqueue("God ");
        queue.enqueue("Is ");
        queue.enqueue("Good ");
        queue.enqueue("All ");
        queue.enqueue("The ");
        queue.enqueue("Time ");

        System.out.println("<Enqueued Items>");
        queue.print();

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        System.out.println("\n<Items after being dequeued>");
        queue.print();
    }
}
