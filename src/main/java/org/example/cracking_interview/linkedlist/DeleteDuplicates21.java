package org.example.cracking_interview.linkedlist;

import java.util.HashSet;
import java.util.Set;

class DeleteDuplicates21 {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);

        linkedList.printList();
        deleteDuplicate2(linkedList.head);
        System.out.println("==========");

        linkedList.printList();


    }

    private static void deleteDuplicate(Node head) {
        Node current = head;

        while (current != null) {
            Node fast = current.next;
            Node prevFast = current;

            while (fast != null) {
                if (current.data == fast.data) {
                    prevFast.next = fast.next;
                } else {
                    prevFast = fast;
                }
                fast = fast.next;
            }
            current = current.next;
        }
    }

    private static void deleteDuplicate2(Node head) {
        Node current = head;
        Node prev = null;

        Set<Integer> set = new HashSet<>();
        while (current != null) {
            if (!set.contains(current.data)) {
                set.add(current.data);
                prev = current;
            } else {
                prev.next = current.next;
            }
            current = current.next;
        }
    }


}
