package singlylinkedlist;

public class SinglyLinkedList<E> {
    // Create Node Class
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public E setElement(E e) {
            return this.element = e;
        }

        public Node<E> getNext() {
            return this.next;
        }

        public void setNext(Node<E> n) {
            this.next = n;
        }
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() {

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e) {
        this.head = new Node<>(e, head);
        if (isEmpty()) {
            this.tail = this.head;
        }
        this.size++;
    }

    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()) {
            this.head = newest;
        } else {
            this.tail.setNext(newest);
        }
        this.tail = newest;
        this.size++;
    }

    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E answer = this.head.getElement();
        this.head = this.head.getNext();
        this.size--;
        if (size == 0) {
            this.tail = null;
        }
        return answer;
    }

}
