package org.example.cracking_interview.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class KElementFromEnd22 {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);

        linkedList.printList();

        getKElementFromEndRecu(linkedList.head, 1); // 5

        getKElementFromEndRecu(linkedList.head, 2); // 4

    }

    private static int getKElementFromEnd(Node head, int k) {
        Node current = head;
        List<Node> array = new ArrayList<>();

        while (current != null) {
            array.add(current);
            current = current.next;
        }

        return array.get(array.size() - k).data;
    }


    private static int getKElementFromEnd2(Node head, int k) {
        Node current = head;
        int size = 0;
        while (current != null) {
            size++;
            current = current.next;
        }

        int searchIndex = size - k;
        current = head;
        int index = 0;
        while (index != searchIndex) {
            current = current.next;
            index++;
        }
        return current.data;
    }

    private static int getKElementFromEnd3(Node head, int k) {
        Node current = head;
        Node fast = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return -1; // защита
            }
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            current = current.next;
        }

        return current.data;
    }


    private static int getKElementFromEndRecu(Node head, int k) {
        if (head == null) {
            return 0;
        }
        int index = getKElementFromEndRecu(head.next, k) + 1;

        if (index == k) {
            System.out.println(head.data + "-------");
        }
        return index;
    }
}
