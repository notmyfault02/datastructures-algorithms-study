package cc.oyabun.linkedlist;

/**
 * Created by yaboong on 2018. 1. 15..
 */
public class LinkedListQueue<E extends Comparable<E>> {
    private Node first, last;

    private class Node{
        E item;
        Node next;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void enqueue(E item){
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()) first = last;
        else oldlast.next = last;
    }

    public E dequeue(){
        if(isEmpty()){
            last = first;
            System.out.println("Queue is empty");
            return null;
        }
        else{
            E item = first.item;
            first = first.next;
            return item;
        }
    }

    public void print(){
        Node mover = first;
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
