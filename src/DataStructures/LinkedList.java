package DataStructures;

public class LinkedList<T> {

    private static class Node<T> {
        Node next;
        T data;

        public Node(T data) {
            this.data = data;
        }
    }

    Node head;
    public void append(T data) {
        if (head == null) {
            head = new Node(data);
            return;
        }
        Node current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = new Node(data);
    }

    public void prepend(T data) {
        Node newHead = new Node(data);
        newHead.next = head;
        head = newHead;
    }

    public void deleteWithValue(T data) {
        if (head == null) {
            return;
        }

        if (head.data == data) {
            head = head.next;
        }

        Node current = head;
        while (current.next != null) {
            if ((T)current.next.data == (T)data) {
                current.next = current.next.next;
            }
        }
    }

    public T get(int index) {
        Node n = this.head;
        for (int i = 0; i < index; i++) {
            if (n.next == null) throw new NullPointerException("Invalid index");
            n = n.next;
        }
        return (T) n.data;
    }
}
