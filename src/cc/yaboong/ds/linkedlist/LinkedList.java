package cc.yaboong.ds.linkedlist;

/**
 * Created by yaboong on 2018. 2. 8..
 */
public class LinkedList {
    Node head;

    private class Node {
        Node next;
        int data;
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void append(int data) {
        Node appendNode = new Node(data);

        // 현재 head 가 null 이면 (아무것도 없으면) head 에 새롭게 append 할 node 를 붙여준다.
        if (head == null) {
            head = appendNode;
            return;
        }

        // 그렇지 않은 경우 현재 head 를 current 라는 변수로 받고 리스트의 가장 끝으로 간다.
        Node current = head;
        while (current.next != null) {  // current.next == null 이면 current 는 마지막 node 에 도착한 것이다
            current = current.next;     // current 를 마지막 node 로 옮겨간다.
        }
        current.next = appendNode;      // current.next = "추가할 노드" 지정해주면 끝이다
    }

    public void prepend(int data) {
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }

    public boolean deleteWithValue(int data) {
        Node current = head;

        if (head == null) return false;

        // head data 가 우리가 찾는 값이라면 아래 while 문만으로는 처리하지 못함
        if (current.data == data) {
            head = head.next;
            return true;
        }

        // current = head 부터 시작하므로 head 바로 다음 node 부터 data 비교함
        while (current.next != null) {
            if (current.next.data == data) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }

        return false;
    }

    public void print() {
        Node current = head;
        if (head == null) {
            System.out.println("empty.");
            return;
        }

        while (current.next != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.print(current.data + "\n");
    }

    void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(1);
        ll.append(2);
        ll.append(3);
        ll.append(4);
        ll.append(5);
        ll.append(6);
        ll.append(7);

        ll.print();

        ll.deleteWithValue(3);
        ll.deleteWithValue(2);
        ll.deleteWithValue(5);
        ll.deleteWithValue(7);
        ll.deleteWithValue(1);
        ll.deleteWithValue(4);
        System.out.println(ll.deleteWithValue(10));
        ll.print();

        ll.prepend(100);
        ll.print();

        System.out.println(ll.deleteWithValue(100));
        ll.print();

        System.out.println();
        System.out.println();
        LinkedList list2 = new LinkedList();
        list2.append(1);
        list2.append(2);
        list2.append(3);
        list2.append(4);
        list2.append(5);
        list2.append(6);
        list2.append(7);

        list2.reverse();
        list2.print();
    }
}
