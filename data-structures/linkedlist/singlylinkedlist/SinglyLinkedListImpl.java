package singlylinkedlist;

import java.util.LinkedList;

public class SinglyLinkedListImpl {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirst(10);
        list.addFirst(20);
        list.addLast(30);
        System.out.println(list.removeFirst());
        System.out.println(list.first());
        System.out.println(list.last());
        System.out.println(list.size());
        System.out.println(list.isEmpty());

    }
}
