package org.example.cracking_interview.linkedlist;

public class DivideLinkedList24 {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.append(3);
        linkedList.append(5);
        linkedList.append(8);
        linkedList.append(5);
        linkedList.append(10);
        linkedList.append(2);
        linkedList.append(1);

        linkedList.printList();
        Node newHead = divideLinkedList(linkedList.head, 5);//Вывод: 3->1->2->10->5->5->8
        System.out.println("==========");
        System.out.println(printLL(newHead));

    }

    static String printLL(Node head) {
        Node current = head;
        StringBuilder stringBuilder = new StringBuilder();
        while (current != null) {
            stringBuilder.append(current.data);
            stringBuilder.append(" -> ");
            current = current.next;
        }
        stringBuilder.append("null");

        return stringBuilder.toString();
    }

    static Node divideLinkedList(Node head, Integer x) {
        Node current = head;

        Node beforeStart = null;
        Node beforeEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
        Node equalStart = null;
        Node equalEnd = null;

        while (current != null) {
            Node next = current.next;
            current.next = null;
            if (current.data < x) {

                if (beforeStart == null) {
                    beforeStart = current;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = current; // докинули в хвост для списка
                    beforeEnd = current; // переделали ссылку на последний элемент
                }
            } else if (current.data > x){
                if (afterStart == null) {
                    afterStart = current;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = current; // докинули в хвост для списка
                    afterEnd = current; // переделали ссылку на последний элемент
                }
            } else {
                if (equalStart == null) {
                    equalStart = current;
                    equalEnd = equalStart;
                } else {
                    equalEnd.next = current;
                    equalEnd = current;
                }
            }
            current = next;
        }
        beforeEnd.next = equalStart;
        equalEnd.next = afterStart;

        return beforeStart;
    }

    // не работает
//    static Node divideLinkedList2(Node head, Integer x) {
//        Node current = head;
//        Node before = current;
//        Node after = current;
//        Node equal = null;
//
//        while (current != null) {
//            Node next = current.next;
//            if (current.data < x) {
//                current.next = before; // вставка в начало
//                before = current; // переносим ссылку на новое начало
//            } else if (current.data > x) {
//                current.next = after;
//                after = current;
//            } else {
//                if (equal == null) {
//
//                } else {
//                    equal.next = equal;
//                }
//                equal = current;
//            }
//            current = next;
//        }
//        return before;
//    }
}
